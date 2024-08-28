package uz.AlpinistEdu_Service.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public interface BaseInterface {

    ReplyKeyboard replyKeyboardStartMenu();
    ReplyKeyboard replyKeyboardSecondInnerMenu(String buttonName);
    SendMessage sendMessage(String buttonName, Long chatId);
}