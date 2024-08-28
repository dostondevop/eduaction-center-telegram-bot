package uz.AlpinistEdu_Service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.AlpinistEdu_Service.BotService.MenuBotService;
import uz.AlpinistEdu_Service.BotService.UserBotService;
import uz.AlpinistEdu_Service.Factory.UserFactory;
import uz.AlpinistEdu_Service.control.interfaces.BaseInterface;
import uz.AlpinistEdu_Service.enums.*;
import uz.AlpinistEdu_Service.model.User;
import uz.AlpinistEdu_Service.utils.*;

import java.util.List;
import java.util.UUID;

public class AlpinistBot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "https://t.me/shaddmiBot";
    private static final String BOT_TOKEN = "7406146515:AAH09_dX15_Jf_8WpOE2T1IKmiswRHUacxA";
    private static UserBotService userBotService = new UserBotService();
    private static MenuBotService menuBotService = new MenuBotService();
    private static UserFactory userFactory = new UserFactory();
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            User user = userBotService.getUserByChatId(chatId);

            if (BotConstanta.START.equalsIgnoreCase(message.getText())) {
                sendPhoneNumberRequest(message.getChatId());
            } else if (user.getUserState() == UserState.GET_CONTACT & message.hasContact()) {
                String phoneNumber = message.getContact().getPhoneNumber();
                String name = (message.getChat().getFirstName() != null ? message.getChat().getFirstName() : "") + " " + (message.getChat().getLastName() != null ? message.getChat().getLastName() : "");
                String username = message.getChat().getUserName();
                user = userFactory.createDefaultUser(chatId, name, username, phoneNumber);
                userBotService.add(user);
                sendMessage(chatId, BotConstanta.HELLO + user.getName() + BotConstanta.REGISTERED_AS_GUEST);
                ReplyKeyboard replyKeyboardMarkup = menuBotService.getMainMenu(chatId);
                execute(chatId,BotConstanta.SELECT_FROM_MENU, replyKeyboardMarkup);
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
            User user = userBotService.getUserByChatId(chatId);

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
        Integer messageId = update.getMessage().getMessageId();
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        String messageText = message.getText();
        User user = userBotService.getUserByChatId(chatId);

        ReplyKeyboard replyKeyboard1 = menuBotService.getMainMenu(chatId);
        ReplyKeyboard replyKeyboard2 = menuBotService.getSecondInnerMenu(chatId, messageText);
        SendMessage sendMessage = menuBotService.getSendMessage(chatId, messageText);

        if (user.getUserState().equals(UserState.SHOW_MAIN_MENU)) {
            execute(chatId, BotConstanta.SELECT_FROM_MENU, replyKeyboard1);
        } else if (replyKeyboard2 != null) {
            execute(chatId, BotConstanta.SELECT_FROM_MENU, replyKeyboard2);
        }
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
        message.setText(BotConstanta.PLEASE_SHARE_PHONE_NUMBER);

        message.setReplyMarkup(BotUtil.getRequestPhoneNumberKeyboard());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void forwardMessageToAllUsers(Long chatId, Integer messageId) {
        List<User> users = userBotService.getList();
        for (User user : users) {
            try {
                ForwardMessage forwardMessage = new ForwardMessage();
                forwardMessage.setChatId(user.getChatId().toString());
                forwardMessage.setFromChatId(chatId.toString());
                forwardMessage.setMessageId(messageId);
                execute(forwardMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
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