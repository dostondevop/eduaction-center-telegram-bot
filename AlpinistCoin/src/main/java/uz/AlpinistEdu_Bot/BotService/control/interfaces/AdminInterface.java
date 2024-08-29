package uz.AlpinistEdu_Bot.BotService.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import uz.AlpinistEdu_Bot.enums.UserState;
import uz.AlpinistEdu_Bot.model.User;
import uz.AlpinistEdu_Bot.utils.BotConstanta;
import uz.AlpinistEdu_Bot.utils.BotUtil;
import uz.AlpinistEdu_Bot.utils.ObjectUtils;

import java.util.List;

public class AdminInterface implements BaseInterface {

    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
        return BotUtil.replyKeyboardMarkup(BotConstanta.ADMIN_MAIN_MENU_BUTTONS, 2);
    }

    @Override
    public ReplyKeyboard replyKeyboardSecondInnerMenu(List<String> buttons, Long chatId) {
        return BotUtil.replyKeyboardMarkup(buttons, 2);
    }

    @Override
    public SendMessage sendMessage(String buttonName, Long chatId) {
        if (sendMessageForGuests(buttonName) != null) {
            return sendMessageForGuests(buttonName);
        }
        return null;
    }

    public SendMessage sendMessageForGuests(String buttonName){
        SendMessage sendMessage = new SendMessage();
        if ("List of guests".equalsIgnoreCase(buttonName)) {
            String listOfGuests = ObjectUtils.userService.listOfAllGuests();
            sendMessage.setText(listOfGuests);
        } else if (buttonName.equalsIgnoreCase("Send message to all users")) {
            sendMessage.setText("Please forward the message you want to notify your users or start your message with #to_guests");
        } else if (buttonName.equalsIgnoreCase("⬅️Back")) {

        }
        return sendMessage;
    }

    public SendMessage sendMessageForTeachers(String button, Long chatId) {
        SendMessage sendMessage = new SendMessage();
        User user = ObjectUtils.userService.getUserByChatId(chatId);
        if ("Add teacher".equalsIgnoreCase(button)) {
            sendMessage.setText("Enter the contact of the user");
            user.setUserState(UserState.ADMIN_ADD_TEACHER);
        } else if ("Delete".equalsIgnoreCase(button)) {

        }
        return sendMessage;
    }
}