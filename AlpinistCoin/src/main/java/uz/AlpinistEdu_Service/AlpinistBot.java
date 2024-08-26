package uz.AlpinistEdu_Service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.AlpinistEdu_Service.enums.*;
import uz.AlpinistEdu_Service.model.User;
import uz.AlpinistEdu_Service.utils.*;

import java.util.UUID;

public class AlpinistBot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "https://t.me/alpinistCoin_bot";
    private static final String BOT_TOKEN = "7426033702:AAH0bCrGW_pcEANFr5YnqVbROAuzSTHqKOs";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            User user = ObjectUtils.userService.getUserByChatId(chatId);

            if (("/start").equalsIgnoreCase(message.getText())) {
                sendPhoneNumberRequest(message.getChatId());
                user.setUserState(UserState.GET_CONTACT);
            } else if (user.getUserState() == UserState.GET_CONTACT & message.hasContact()) {
                String phoneNumber = message.getContact().getPhoneNumber();
                user = User.builder()
                        .id(UUID.randomUUID())
                        .chatId(chatId)
                        .name((message.getChat().getFirstName() != null ? message.getChat().getFirstName() : "") + " " + (message.getChat().getLastName() != null ? message.getChat().getLastName() : ""))
                        .userName(message.getChat().getUserName())
                        .contact(phoneNumber)
                        .userType(UserType.GUEST)
                        .userState(UserState.SHOW_MAIN_MENU)
                        .build();
                System.out.println(user);
                ObjectUtils.userService.add(user);
                sendMessage(chatId, "Hello " + user.getName() + "! You have been registered as a guest.");
                ReplyKeyboard replyKeyboardMarkup = ObjectUtils.menuService.getMainMenu(chatId);
                execute(chatId, "Select from the menu!", replyKeyboardMarkup);
            } else if (user.getUserType().equals(UserType.GUEST)) {
                guestOperationsForMessage(update);
            } else if (user.getUserType().equals(UserType.ADMIN)) {
                adminOperationsForMessage(update);
            } else if (user.getUserType().equals(UserType.STUDENT)) {
                studentOperationsForMessage(update);
            } else if (user.getUserType().equals(UserType.TEACHER)) {
                teacherOperationsForMessage(update);
            }
        } else if (update.hasCallbackQuery()) {
            Long chatId = update.getMessage().getChatId();
            User user = ObjectUtils.userService.getUserByChatId(chatId);

            if (user.getUserType().equals(UserType.GUEST)) {
                guestOperationsForCallbackQuery(update);
            } else if (user.getUserType().equals(UserType.ADMIN)) {
                adminOperationsForCallbackQuery(update);
            } else if (user.getUserType().equals(UserType.STUDENT)) {
                studentOperationsForCallbackQuery(update);
            } else if (user.getUserType().equals(UserType.TEACHER)) {
                teacherOperationsForCallbackQuery(update);
            }
        }
    }

    private void guestOperationsForMessage(Update update) {
     //TODO MUHAMMADAMIN
    }

    private void adminOperationsForMessage(Update update) {
        //TODO MIRZAAHMAD
    }

    private void studentOperationsForMessage(Update update) {
        //TODO MIRZAAHMAD
    }

    private void teacherOperationsForMessage(Update update) {
        //TODO
    }

    private void adminOperationsForCallbackQuery(Update update) {
        //TODO MIRZAAHMAD
    }

    private void teacherOperationsForCallbackQuery(Update update) {
        //TODO
    }

    private void guestOperationsForCallbackQuery(Update update) {
        //TODO MUHAMMADAMIN
    }

    private void studentOperationsForCallbackQuery(Update update) {
        //TODO MIRZAAHMAD
    }

    @SneakyThrows
    private void execute(long chatId, String text, ReplyKeyboard replyKeyboard) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setReplyMarkup(replyKeyboard);
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        execute(sendMessage);
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendPhoneNumberRequest(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Please share your phone number:");

        message.setReplyMarkup(BotUtil.getRequestPhoneNumberKeyboard());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}