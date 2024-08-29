package uz.AlpinistEdu_Bot.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class GuestInterface implements BaseInterface {
    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
        return null;
    }

    @Override
    public ReplyKeyboard replyKeyboardSecondInnerMenu(String buttonName, Long chatId) {
        return null;
    }

    @Override
    public SendMessage sendMessage(String buttonName, Long chatId) {
        return null;
    }
}