package uz.AlpinistEdu_Service.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import uz.AlpinistEdu_Service.utils.BotUtil;

import java.util.List;

public class TeacherInterface implements BaseInterface {
    private static final List<String> buttons = List.of("Grading students ", " Absence", "Timetable");

    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
      return BotUtil.replyKeyboardMarkup(buttons,2);

    }

    @Override
    public ReplyKeyboard replyKeyboardSecondInnerMenu(String buttonName, Long chatId) {
     return replyKeyboardStartMenu();
    }

    @Override
    public SendMessage sendMessage(String buttonName, Long chatId) {
        return null;
    }

}