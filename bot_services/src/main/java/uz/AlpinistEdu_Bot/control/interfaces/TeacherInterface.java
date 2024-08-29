package uz.AlpinistEdu_Bot.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import uz.AlpinistEdu_Bot.utils.BotUtil;

import java.util.List;

public class TeacherInterface implements BaseInterface {
    private static final List<String> buttons = List.of("Grading students ", " Marking students absences", "Timetable");

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