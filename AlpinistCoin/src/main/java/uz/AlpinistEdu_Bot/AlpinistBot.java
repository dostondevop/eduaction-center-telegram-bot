package uz.AlpinistEdu_Bot;

import lombok.SneakyThrows;
import org.apache.commons.codec.binary.StringUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.AlpinistEdu_Bot.botService.MenuBotService;
import uz.AlpinistEdu_Bot.botService.UserBotService;
import uz.AlpinistEdu_Bot.factory.UserFactory;
import uz.AlpinistEdu_Service.enums.UserState;
import uz.AlpinistEdu_Service.enums.UserType;
import uz.AlpinistEdu_Service.model.User;
import uz.AlpinistEdu_Service.utils.BotButtonsUtill;
import uz.AlpinistEdu_Service.utils.BotConstanta;
import uz.AlpinistEdu_Service.utils.BotUtil;

import java.util.List;

public class AlpinistBot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "https://t.me/alpinistCoin_bot";
    private static final String BOT_TOKEN = "7426033702:AAH0bCrGW_pcEANFr5YnqVbROAuzSTHqKOs";
    private static UserBotService userBotService = new UserBotService();
    private static MenuBotService menuBotService = new MenuBotService();
    private static UserFactory userFactory = new UserFactory();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            User user = userBotService.getUserByChatId(chatId);

            if (StringUtils.equals(BotConstanta.START, message.getText())) {
                sendPhoneNumberRequest(message.getChatId());
            } else if (user.getUserState().equals(UserState.GET_CONTACT) & message.hasContact()) {
                String phoneNumber = message.getContact().getPhoneNumber();
                String name = (message.getChat().getFirstName() != null ? message.getChat().getFirstName() : "") + " " + (message.getChat().getLastName() != null ? message.getChat().getLastName() : "");
                String username = message.getChat().getUserName();
                user = userFactory.createUser(chatId, name, username, phoneNumber);
                userBotService.add(user);

                sendMessage(chatId, BotConstanta.HELLO + user.getName() + BotConstanta.REGISTERED_AS_GUEST);

                execute(chatId, BotConstanta.SELECT_FROM_MENU, menuBotService.getMainMenu(chatId));
            } else if (user.getUserType().equals(UserType.GUEST)) {
                guestOperationsForMessage(update, user);
            } else if (user.getUserType().equals(UserType.ADMIN)) {
                adminOperationsForMessage(update);
            } else if (user.getUserType().equals(UserType.STUDENT)) {
                studentOperationsForMessage(update);
            } else if (user.getUserType().equals(UserType.TEACHER)) {
                teacherOperationsForMessage(update, user);
            }
        } else if (update.hasCallbackQuery()) {
            Long chatId = update.getCallbackQuery().getMessage().getChatId();
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

    private void guestOperationsForMessage(Update update, User user) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        String text = message.getText();
        if (user.getUserState().equals(UserState.SHOW_MAIN_MENU) & BotButtonsUtill.GUEST_MAIN_MENU_BUTTONS.contains(text)) {
            execute(chatId, BotConstanta.SELECT_FROM_MENU, menuBotService.getSecondInnerMenu(chatId, text));
            user.setUserState(UserState.SHOW_SECOND_MENU);
            userBotService.updateUserState(user);
        } else if (user.getUserState().equals(UserState.SHOW_SECOND_MENU) & BotButtonsUtill.GUEST_ALL_SECOND_MENU_BUTTONS.contains(text)) {
            try {
                execute(menuBotService.getSendMessage(chatId, text));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (BotConstanta.BACK_BUTTON.equals(text)) {
            if (user.getUserState() == UserState.SHOW_SECOND_MENU) {
                user.setUserState(UserState.SHOW_MAIN_MENU);
                userBotService.updateUserState(user);
                execute(chatId, BotConstanta.SELECT_FROM_MENU, menuBotService.getMainMenu(chatId));
            }
        } else if (user.getUserState() == UserState.SHOW_MAIN_MENU) {
            execute(chatId, BotConstanta.SELECT_FROM_MENU, menuBotService.getMainMenu(chatId));
        }
    }

    private void adminOperationsForMessage(Update update) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        String messageText = message.getText();
        User user = userBotService.getUserByChatId(chatId);

        ReplyKeyboard replyKeyboard1 = menuBotService.getMainMenu(chatId);

        if (user.getUserState().equals(UserState.SHOW_MAIN_MENU) & BotButtonsUtill.ADMIN_MAIN_MENU_BUTTONS.contains(messageText)) {
            execute(chatId, BotConstanta.SELECT_FROM_MENU, menuBotService.getSecondInnerMenu(chatId, messageText));

        } else if (user.getUserState().equals(UserState.SHOW_MAIN_MENU) & StringUtils.equals(BotConstanta.TEACHERS_BUTTON, messageText)) {

        }
        else if (user.getUserState().equals(UserState.SHOW_MAIN_MENU)) {
            execute(chatId, BotConstanta.SELECT_FROM_MENU, replyKeyboard1);
        }
    }

    private void studentOperationsForMessage(Update update) {
        //TODO MIRZAAHMAD
    }

    private void teacherOperationsForMessage(Update update, User user) {
        String text = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        //TODO
        if (user.getUserState().equals(UserState.SHOW_MAIN_MENU) & StringUtils.equals(text, BotConstanta.GRADING_STUDENTS_BUTTON)) {
            ReplyKeyboard replyKeyboard = menuBotService.getSecondInnerMenu(chatId, text);
            execute(chatId, BotConstanta.SELECT_GROUP, replyKeyboard);
            user.setUserState(UserState.GRADING_STUDENTS);
            userBotService.updateUserState(user);
        }  else if (BotConstanta.BACK_BUTTON.equals(text)) {
            if (user.getUserState() == UserState.SHOW_SECOND_MENU) {
                user.setUserState(UserState.SHOW_MAIN_MENU);
                userBotService.updateUserState(user);
                execute(chatId, BotConstanta.SELECT_FROM_MENU, menuBotService.getMainMenu(chatId));
            }
        } else if (user.getUserState().equals(UserState.SHOW_MAIN_MENU)) {
            execute(chatId, BotConstanta.SELECT_FROM_MENU, menuBotService.getMainMenu(chatId));
        }
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