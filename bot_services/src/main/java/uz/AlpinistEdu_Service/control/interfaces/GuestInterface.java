package uz.AlpinistEdu_Service.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import uz.AlpinistEdu_Service.utils.BotUtil;
import java.util.List;
import static uz.AlpinistEdu_Service.utils.guestUtills.GuestBotButtonsConstantsUtill.*;

public class GuestInterface implements BaseInterface {
    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
        return BotUtil.replyKeyboardMarkup(GUEST_MAIN_MENU_BUTTONS, 2);
    }

    @Override
    public ReplyKeyboard replyKeyboardSecondInnerMenu(String buttonName, Long chatId) {
        List<String> buttons = SECOND_MENU_OPTIONS.get(buttonName);
        if (buttons != null) {
            return BotUtil.replyKeyboardMarkup(buttons, 2);
        }
        return null;
    }
    @Override
    public SendMessage sendMessage(String buttonName, Long chatId) {
        SendMessage sendMessage = new SendMessage();
        String responseText = getInfo(buttonName);
        sendMessage.setChatId(chatId);
        sendMessage.setText(responseText);
        return sendMessage;
    }
}