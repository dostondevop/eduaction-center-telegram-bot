package uz.AlpinistEdu_Bot.Factory;

import uz.AlpinistEdu_Bot.enums.UserState;
import uz.AlpinistEdu_Bot.enums.UserType;
import uz.AlpinistEdu_Bot.model.User;

import java.util.UUID;

public class UserFactory {

    public User createDefaultUser(Long chatId, String name,String username, String phoneNumber) {
        return User.builder()
                .id(UUID.randomUUID())
                .chatId(chatId)
                .name(name)
                .userName(username)
                .contact(phoneNumber)
                .userType(UserType.GUEST)
                .userState(UserState.SHOW_MAIN_MENU)
                .build();
    }
}