package uz.AlpinistEdu_Bot.botService;

import uz.AlpinistEdu_Service.model.User;
import uz.AlpinistEdu_Service.utils.ObjectUtils;

import java.util.List;

public class UserBotService {

    public void add(User user) {
        ObjectUtils.userService.add(user);
    }

    public User getUserByChatId(Long chatId) {
        return ObjectUtils.userService.getUserByChatId(chatId);
    }

    public void update(User user) {
        ObjectUtils.userService.updateUserState(user);
    }

    public void updateUserState(User user) {
        ObjectUtils.userService.updateUserState(user);
    }

    public List<User> getList() {
        return ObjectUtils.userService.getList();
    }
}