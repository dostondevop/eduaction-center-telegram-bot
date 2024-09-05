package uz.AlpinistEdu_Service.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import uz.AlpinistEdu_Service.utils.BotUtil;

import java.util.List;

import static uz.AlpinistEdu_Service.utils.guestUtills.GuestBotButtonsConstantsUtill.getInfo;
import static uz.AlpinistEdu_Service.utils.studentUtill.StudentBotButtonsConstantsUtill.*;

public class StudentInterface implements BaseInterface {
    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
        return BotUtil.replyKeyboardMarkup(STUDENT_MAIN_MENU_BUTTONS, 2);
    }
    
    @Override
    public ReplyKeyboard replyKeyboardSecondInnerMenu(String buttonName, Long chatId) {
        List<String> buttons = STUDENT_SECOND_MENU_OPTIONS.get(buttonName);
        if (buttons!= null) {
            return BotUtil.replyKeyboardMarkup(buttons, 2);
        }
        return null;
    }

    @Override
    public SendMessage sendMessage(String buttonName, Long chatId) {
        SendMessage sendMessage = new SendMessage();
        String responseText = getInfoStudent(buttonName);
        sendMessage.setChatId(chatId);
        sendMessage.setText(responseText);
        return sendMessage;
    }
}