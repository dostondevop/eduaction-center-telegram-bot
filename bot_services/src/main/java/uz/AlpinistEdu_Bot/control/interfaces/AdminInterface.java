package uz.AlpinistEdu_Bot.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import uz.AlpinistEdu_Bot.enums.UserState;
import uz.AlpinistEdu_Bot.model.User;
import uz.AlpinistEdu_Bot.utils.BotUtil;
import uz.AlpinistEdu_Bot.utils.ObjectUtils;

import java.util.List;


public class AdminInterface implements BaseInterface {
    private static List<String> buttons = List.of("Guests", "Teachers", "Students", "Products", "Groups", "Parents", "TimeTables");

    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
        return BotUtil.replyKeyboardMarkup(buttons, 2);
    }

    @Override
    public ReplyKeyboard replyKeyboardSecondInnerMenu(String buttonName, Long chatId) {
        User user = ObjectUtils.userService.getUserByChatId(chatId);
        if ("Guests".equalsIgnoreCase(buttonName)) {
            List<String> buttonsInner = List.of("List of guests", "Send message to all users", "⬅️Back");
            user.setUserState(UserState.ADMIN_GUESTS_MENU);
            return BotUtil.replyKeyboardMarkup(buttonsInner, 2);
        } else if (("Teachers".equalsIgnoreCase(buttonName))) {
            List<String> buttonsInner = List.of("Add teacher", "Delete", "List", "⬅️Back");
            return BotUtil.replyKeyboardMarkup(buttonsInner, 2);
        } else if (("Students".equalsIgnoreCase(buttonName))) {
            List<String> buttonsInner = List.of("Add Student", "Delete", "List", "⬅️Back");
            return BotUtil.replyKeyboardMarkup(buttonsInner, 2);
        } else if (("Products".equalsIgnoreCase(buttonName))) {
            List<String> buttonsInner = List.of("Add Product", "Delete Product", "List of available products", "⬅️Back");
            return BotUtil.replyKeyboardMarkup(buttonsInner, 2);
        } else if (("Groups".equalsIgnoreCase(buttonName))) {
            List<String> buttonsInner = List.of("Add Group", "Delete Group", "List of available Groups", "⬅️Back");
            return BotUtil.replyKeyboardMarkup(buttonsInner, 2);
        } else if (("Parents".equalsIgnoreCase(buttonName))) {
            List<String> buttonsInner = List.of("Add Parent", "Delete Parent", "List of available Parents", "⬅️Back");
            return BotUtil.replyKeyboardMarkup(buttonsInner, 2);
        } else if ("Time-Table".equalsIgnoreCase(buttonName)) {
            List<String> buttonsInner = List.of("Add Time-table", "Delete Time-table", "List of available Time-table", "⬅️Back");
            return BotUtil.replyKeyboardMarkup(buttonsInner, 2);
        }
        return null;
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