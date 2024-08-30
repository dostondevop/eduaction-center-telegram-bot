package uz.AlpinistEdu_Service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.AlpinistEdu_Service.BotService.*;
import uz.AlpinistEdu_Service.Factory.UserFactory;
import uz.AlpinistEdu_Service.enums.*;
import uz.AlpinistEdu_Service.model.User;
import uz.AlpinistEdu_Service.utils.*;

import java.io.File;
import java.util.*;
import static uz.AlpinistEdu_Service.enums.UserState.*;
import static uz.AlpinistEdu_Service.utils.guestUtills.GuestOperationButtonsConstantsUtill.*;
import static uz.AlpinistEdu_Service.utils.ObjectUtils.*;

public class AlpinistBot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "https://t.me/Muhammadamin571_bot";
    private static final String BOT_TOKEN = "7531670880:AAHsCDKmhsnKDTjmzkzimBXfmPeIgR1U5rg";
    private static UserBotService userBotService = new UserBotService();
    private static MenuBotService menuBotService = new MenuBotService();
    private static UserFactory userFactory = new UserFactory();
    private static String PATH = "bot_services/src/main/resources/photos/photo_2024-08-29_16-38-29.jpg";

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
                guestOperationsForMessage(update, user);
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

    @SneakyThrows
    private void guestOperationsForMessage(Update update, User user) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        String text = message.getText();
        if (ABOUT_CENTER.equals(text)) {
            execute(chatId, text, menuService.getSecondInnerMenu(chatId, text));
            user.setUserState(SHOW_SECOND_MENU);
            userBotService.update(user);
        } else if (OUR_TEACHERS.equals(text)) {
            execute(chatId, text, menuService.getSecondInnerMenu(chatId, text));
            user.setUserState(SHOW_SECOND_MENU);
            userBotService.update(user);
        } else if (OUR_COURSES.equals(text)) {
            execute(chatId, text, menuService.getSecondInnerMenu(chatId, text));
            user.setUserState(SHOW_SECOND_MENU);
            userBotService.update(user);
        } else if (OUR_BRANCHES.equals(text)) {
            execute(chatId, text, menuService.getSecondInnerMenu(chatId, text));
            user.setUserState(SHOW_SECOND_MENU);
            userBotService.update(user);
        } else if (CONTACT_WITH_SPECIALISTS.equals(text)) {
            execute(chatId, text, menuService.getSecondInnerMenu(chatId, text));
            user.setUserState(SHOW_SECOND_MENU);
            userBotService.update(user);
        } else if (REGISTRATION_TO_TEST.equals(text)) {
            execute(chatId, text, menuService.getSecondInnerMenu(chatId, text));
            user.setUserState(SHOW_SECOND_MENU);
            userBotService.update(user);
        } else if (BACK_BUTTON.equals(text)) {
            if (user.getUserState() == SHOW_SECOND_MENU) {
                user.setUserState(SHOW_MAIN_MENU);
                userBotService.update(user);
                execute(chatId, MENU, menuService.getMainMenu(chatId));
            }
        } else if (ENGLISH.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (RUSSIAN.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (MATH.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (MENTAL_ARITHMETIC.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (ABOUT_ALPINIST_CENTER.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (ADVANTAGES_OF_ALPINIST.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (ACHIEVEMENTS_OF_ALPINIST.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (MR_FAZLIDDIN.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            sendPhotoWithText(chatId,text,PATH);
        } else if (MR_SUNNAT.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (MS_LILIYA.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (MS_AZIZA.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (MR_JAVOXIR.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (MR_MIRZAAHMAD.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (CONTACT_US_WITH_TEL.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (CONTACT_US_WITH_EMAIL.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (REGISTRATION.equals(text) & user.getUserState() == SHOW_SECOND_MENU) {
            try {
                execute(guestInterface.sendMessage(text, chatId));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void adminOperationsForMessage(Update update) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        String messageText = message.getText();
        User user = userBotService.getUserByChatId(chatId);

        ReplyKeyboard replyKeyboard1 = menuBotService.getMainMenu(chatId);
        ReplyKeyboard replyKeyboard2 = menuBotService.getSecondInnerMenu(chatId, messageText);

        if (user.getUserState().equals(SHOW_MAIN_MENU)) {
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

    private void sendPhotoWithText(Long chatId, String text, String Path) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setCaption(text);
        sendPhoto.setPhoto(new InputFile(new File(PATH)));
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
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