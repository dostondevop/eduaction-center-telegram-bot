package uz.AlpinistEdu_Service.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class ParentInterface implements BaseInterface {
    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
        return null;
    }

    @Override
    public ReplyKeyboard replyKeyboardSecondInnerMenu(String buttonName) {
        return null;
    }

    @Override
    public SendMessage sendMessage(String buttonName, Long chatId) {
        return null;
    }
}