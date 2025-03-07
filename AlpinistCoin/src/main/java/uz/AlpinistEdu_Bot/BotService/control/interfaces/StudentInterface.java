package uz.AlpinistEdu_Bot.botService.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import uz.AlpinistEdu_Service.utils.BotUtil;

import java.util.List;

public class StudentInterface implements BaseInterface {
    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
        List<String> buttons = List.of("Coins", "Market", "Teachers", "Courses");
        return BotUtil.replyKeyboardMarkup(buttons, 2);
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