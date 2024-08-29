package uz.AlpinistEdu_Bot.botService;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import uz.AlpinistEdu_Bot.botService.control.interfaces.*;
import uz.AlpinistEdu_Service.enums.UserType;
import uz.AlpinistEdu_Service.model.User;

import java.util.HashMap;
import java.util.Map;

public class MenuBotService {

    private final UserBotService userBotService = new UserBotService();

    private static final Map<UserType, BaseInterface> UI_STRATEGY_MAP = new HashMap<>();

    static {
        UI_STRATEGY_MAP.put(UserType.ADMIN, new AdminInterface());
        UI_STRATEGY_MAP.put(UserType.GUEST, new GuestInterface());
        UI_STRATEGY_MAP.put(UserType.TEACHER, new TeacherInterface());
        UI_STRATEGY_MAP.put(UserType.STUDENT, new StudentInterface());
    }

    public ReplyKeyboard getMainMenu(Long chatId) {
        User currentUser = userBotService.getUserByChatId(chatId);
        return UI_STRATEGY_MAP.get(currentUser != null ? currentUser.getUserType() : null).replyKeyboardStartMenu();
    }

    public ReplyKeyboard getSecondInnerMenu(Long chatId, String buttonName) {
        User currentUser = userBotService.getUserByChatId(chatId);
        return UI_STRATEGY_MAP.get(currentUser != null ? currentUser.getUserType() : null).replyKeyboardSecondInnerMenu(buttonName, chatId);
    }

    public SendMessage getSendMessage(Long chatId, String buttonName) {
        User currentUser = userBotService.getUserByChatId(chatId);
        return UI_STRATEGY_MAP.get(currentUser != null ? currentUser.getUserType() : null).sendMessage(buttonName, chatId);
    }
}