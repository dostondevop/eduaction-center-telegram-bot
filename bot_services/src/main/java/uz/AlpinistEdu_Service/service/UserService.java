package uz.AlpinistEdu_Service.service;

import com.fasterxml.jackson.core.type.TypeReference;
import uz.AlpinistEdu_Service.enums.*;
import uz.AlpinistEdu_Service.model.User;
import uz.AlpinistEdu_Service.utils.DataUtils;

import java.util.*;

public class UserService implements BaseService<User>{

    public static final String PATH = "bot_services/src/main/resources/json_files/users.json";

    @Override
    public User add(User user) {
        List<User> users = read();
        if (has(user, users)) {
            throw new RuntimeException("User already exists");
        }
        users.add(user);
        write(users);
        return user;
    }

    @Override
    public User get(UUID user) {
        List<User> users = read();
        return users.stream()
                .filter(u -> Objects.equals(u.getId(), user))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public boolean has(User user, List<User> list) {
        return list.stream().anyMatch(u -> u.getChatId().equals(user.getChatId()));
    }

    @Override
    public User getById(UUID id) {
        List<User> users = read();
        return users.stream()
                .filter(u -> Objects.equals(u.getId(), id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<User> getList() {
        return read();
    }

    @Override
    public List<User> read() {
        return DataUtils.read(PATH, new TypeReference<>() {
        });
    }

    @Override
    public void write(List<User> users) {
        DataUtils.write(PATH, users);
    }

    public User getUserByChatId(Long chatId) {
        List<User> users = read();
        return users.stream()
                .filter(user -> user.getChatId().equals(chatId))
                .findFirst()
                .orElseGet(() -> {
            User newUser = new User();
            newUser.setUserState(UserState.GET_CONTACT);
            newUser.setUserType(UserType.GUEST);
            return newUser;
        });
    }
}