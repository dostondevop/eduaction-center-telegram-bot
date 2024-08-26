package uz.AlpinistEdu_Service.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import uz.AlpinistEdu_Service.utils.BotUtil;

import java.util.List;

public class AdminInterface implements BaseInterface {
    private static List<String> buttons = List.of("Guests", "Teachers", "Students", "Groups", "Rooms", "TimeTables");
    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
        return BotUtil.replyKeyboardMarkup(buttons, 2);
    }

    @Override
    public ReplyKeyboard replyKeyboardSecondInnerMenu(String buttonName) {
        if ("Guests".equals(buttonName)) {
            List<String> buttonsInner = List.of("Show all users", "⬅️Back");
            return BotUtil.replyKeyboardMarkup(buttonsInner, 2);
        }
        return null;
    }

    @Override
    public SendMessage sendMessage(String buttonName, String chatId) {
        return null;
    }
}