package uz.AlpinistEdu_Bot.BotService;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.w3c.dom.stylesheets.LinkStyle;
import uz.AlpinistEdu_Bot.BotService.control.interfaces.*;
import uz.AlpinistEdu_Bot.model.User;
import uz.AlpinistEdu_Bot.enums.UserType;
import uz.AlpinistEdu_Bot.utils.ObjectUtils;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuBotService {
    private static final Map<UserType, BaseInterface> UI_STRATEGY_MAP = new HashMap<>();

    static {
        UI_STRATEGY_MAP.put(UserType.ADMIN, new AdminInterface());
        UI_STRATEGY_MAP.put(UserType.GUEST, new GuestInterface());
        UI_STRATEGY_MAP.put(UserType.TEACHER, new TeacherInterface());
        UI_STRATEGY_MAP.put(UserType.STUDENT, new StudentInterface());
    }

    public ReplyKeyboard getMainMenu(Long chatId) {
        User currentUser = ObjectUtils.userService.getUserByChatId(chatId);
        return UI_STRATEGY_MAP.get(currentUser != null ? currentUser.getUserType() : null).replyKeyboardStartMenu();
    }

    public ReplyKeyboard getSecondInnerMenu(List<String> buttons, Long chatId) {
        User currentUser = ObjectUtils.userService.getUserByChatId(chatId);
        return UI_STRATEGY_MAP.get(currentUser != null ? currentUser.getUserType() : null).replyKeyboardSecondInnerMenu(buttons, chatId);
    }

    public SendMessage getSendMessage(Long chatId, String buttonName) {
        User currentUser = ObjectUtils.userService.getUserByChatId(chatId);
        return UI_STRATEGY_MAP.get(currentUser != null ? currentUser.getUserType() : null).sendMessage(buttonName, chatId);
    }
}