package uz.AlpinistEdu_Bot.botService;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import uz.AlpinistEdu_Service.utils.ObjectUtils;

public class MenuBotService {
    public ReplyKeyboard getMainMenu(Long chatId) {
       return ObjectUtils.menuService.getMainMenu(chatId);
    }

    public ReplyKeyboard getSecondInnerMenu(Long chatId, String buttonName) {
        return ObjectUtils.menuService.getSecondInnerMenu(chatId,buttonName);
    }

    public SendMessage getSendMessage(Long chatId, String buttonName) {
       return ObjectUtils.menuService.getSendMessage(chatId,buttonName);
    }


}
