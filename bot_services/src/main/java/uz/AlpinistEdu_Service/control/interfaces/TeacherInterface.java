package uz.AlpinistEdu_Service.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.AlpinistEdu_Service.utils.BotUtil;

import java.util.ArrayList;
import java.util.List;

public class TeacherInterface implements BaseInterface {
    private static final List<String> buttons = List.of("Student Grading", "Timetable", "Student Absence Tracking");
    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
       return BotUtil.replyKeyboardMarkup(buttons, 2);
    }

    @Override
    public ReplyKeyboard replyKeyboardSecondInnerMenu(String buttonName) {
        ReplyKeyboardMarkup replyKeyboaardMarkup = new ReplyKeyboardMarkup();
        replyKeyboaardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
//   //Grading , absence,timetable
        if ("Choose Group".equals(buttonName)) {
            row.add("View My Groups");
        }
        return null;
    }





    @Override
    public SendMessage sendMessage(String buttonName, String chatId) {
        return null;
    }
}