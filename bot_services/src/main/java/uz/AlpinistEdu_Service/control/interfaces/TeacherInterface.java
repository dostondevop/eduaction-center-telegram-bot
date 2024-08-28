package uz.AlpinistEdu_Service.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public class TeacherInterface implements BaseInterface {
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