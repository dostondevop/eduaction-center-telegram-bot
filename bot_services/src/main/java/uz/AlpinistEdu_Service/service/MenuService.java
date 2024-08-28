package uz.AlpinistEdu_Service.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import uz.AlpinistEdu_Service.model.User;
import uz.AlpinistEdu_Service.enums.UserType;
import uz.AlpinistEdu_Service.utils.ObjectUtils;
import uz.AlpinistEdu_Service.control.interfaces.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import java.util.HashMap;
import java.util.Map;

import static uz.AlpinistEdu_Service.utils.ObjectUtils.userService;

public class MenuService {
    private static final Map<UserType, BaseInterface> UI_STRATEGY_MAP = new HashMap<>();

    static {
        UI_STRATEGY_MAP.put(UserType.ADMIN, new AdminInterface());
        UI_STRATEGY_MAP.put(UserType.GUEST, new GuestInterface());
        UI_STRATEGY_MAP.put(UserType.TEACHER, new TeacherInterface());
        UI_STRATEGY_MAP.put(UserType.STUDENT, new StudentInterface());
    }

    public ReplyKeyboard getMainMenu(Long chatId) {
        User currentUser = userService.getUserByChatId(chatId);
        return UI_STRATEGY_MAP.get(currentUser != null ? currentUser.getUserType() : null).replyKeyboardStartMenu();
    }

    public ReplyKeyboard getSecondInnerMenu(Long chatId, String buttonName) {
        User currentUser = userService.getUserByChatId(chatId);
        return UI_STRATEGY_MAP.get(currentUser != null ? currentUser.getUserType() : null).replyKeyboardSecondInnerMenu(buttonName, chatId);
    }
    public SendMessage getReplyMessageThirdInnerMenu(Long chatId, String buttonName) {
        User currentUser = userService.getUserByChatId(chatId);
        return UI_STRATEGY_MAP.get(currentUser != null? currentUser.getUserType() : null).sendMessage(buttonName, chatId);
    }

    public SendMessage getSendMessage(Long chatId, String buttonName) {
        User currentUser = userService.getUserByChatId(chatId);
        return UI_STRATEGY_MAP.get(currentUser != null ? currentUser.getUserType() : null).sendMessage(buttonName, chatId);
    }

    public SendMessage sendMessage(String buttonName, Long chatId) {
        User currentUser = userService.getUserByChatId(chatId);
        return UI_STRATEGY_MAP.get(currentUser!= null? currentUser.getUserType() : null).sendMessage(buttonName, chatId);
    }
}