package uz.AlpinistEdu_Bot.BotService;

import uz.AlpinistEdu_Bot.model.User;
import uz.AlpinistEdu_Bot.utils.ObjectUtils;

import java.util.List;

public class UserBotService {

    public void add(User user) {
        ObjectUtils.userService.add(user);
    }

    public User getUserByChatId(Long chatId) {
        return ObjectUtils.userService.getUserByChatId(chatId);
    }

    public List<User> getList() {
        return ObjectUtils.userService.getList();
    }
}