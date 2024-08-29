package uz.AlpinistEdu_Bot.factory;

import uz.AlpinistEdu_Service.enums.UserState;
import uz.AlpinistEdu_Service.enums.UserType;
import uz.AlpinistEdu_Service.model.User;

import java.util.UUID;

public class UserFactory {

    public User createUser(Long chatId, String name,String username, String phoneNumber) {
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