package uz.AlpinistEdu_Bot.botService.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import uz.AlpinistEdu_Service.utils.BotButtonsUtill;
import uz.AlpinistEdu_Service.utils.BotUtil;
import uz.AlpinistEdu_Service.utils.ObjectUtils;

import java.util.List;

public class TeacherInterface implements BaseInterface {

    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
      return BotUtil.replyKeyboardMarkup(BotButtonsUtill.TEACHER_MAIN_MENU_BUTTONS,2);
    }

    @Override
    public ReplyKeyboard replyKeyboardSecondInnerMenu(String buttonName, Long chatId) {
     return BotUtil.replyKeyboardMarkup(ObjectUtils.teacherGroupService.getGroupNamesByTeacherId(chatId), 1);
    }

    @Override
    public SendMessage sendMessage(String buttonName, Long chatId) {
        return null;
    }
}