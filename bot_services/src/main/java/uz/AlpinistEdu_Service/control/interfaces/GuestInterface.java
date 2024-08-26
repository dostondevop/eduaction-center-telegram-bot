package uz.AlpinistEdu_Service.control.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import uz.AlpinistEdu_Service.utils.BotUtil;
import java.util.*;

public class GuestInterface implements BaseInterface {

    private static final List<String> MAIN_MENU_BUTTONS = List.of(
            "Markaz haqida",
            "Kurslarimiz",
            "Filiallarimiz",
            "Mutaxassis bilan aloqa",
            "Imtihonga ro'yxatdan o'tish",
            "\uD83D\uDD19Orqaga"
    );

    private static final Map<String, List<String>> SECOND_MENU_OPTIONS = Map.of(
            "Markaz haqida", List.of(
                    "Umumiy ma'lumotlar",
                    "Afzalliklar",
                    "Yutuqlar",
                    "\uD83D\uDD19Orqaga"
            ),
            "Kurslarimiz", List.of(
                    "Ingliz Tili",
                    "Matematika",
                    "Rus tili",
                    "Mental Arifmetika",
                    "Tarix",
                    "Ona tili",
                    "Biologiya",
                    "Kimyo",
                    "Huquq"
            ),
            "Filiallarimiz", List.of(
                    "Sergeli",
                    "Olmazor",
                    "Uchtepa",
                    "Chilonzor",
                    "Yunusobod",
                    "Yakkasaroy",
                    "\uD83D\uDD19Orqaga"
            ),
            "Mutaxassis bilan aloqa", List.of(
                    "Tel:",
                    "Gmail:",
                    "\uD83D\uDD19Orqaga"
            ),
            "Imtihonga ro'yxatdan o'tish", List.of(
                    "Ro'yxatdan o'tish"
            )
    );

    @Override
    public ReplyKeyboard replyKeyboardStartMenu() {
        return BotUtil.replyKeyboardMarkup(MAIN_MENU_BUTTONS, 2);
    }

    @Override
    public ReplyKeyboard replyKeyboardSecondInnerMenu(String buttonName) {
        List<String> buttons = SECOND_MENU_OPTIONS.get(buttonName);
        if (buttons != null) {
            int columns = buttonName.equals("Kurslarimiz") ? 3 : 2;
            return BotUtil.replyKeyboardMarkup(buttons, columns);
        }
        return null;
    }

    public SendMessage sendMessage(String buttonName, String chatId) {
        return replyMessageThirdInnerMenu(buttonName);
    }

    public SendMessage replyMessageThirdInnerMenu(String buttonName) {
        String responseText = switch (buttonName) {
            case "Ingliz Tili" -> "Ingliz tili haqida ma'lumot...";
            case "Matematika" -> "Matematika haqida ma'lumot...";
            case "Rus tili" -> "Rus tili haqida ma'lumot...";
            case "Mental Arifmetika" -> "Mental arifmetika haqida ma'lumot...";
            case "Tarix" -> "Tarix haqida ma'lumot...";
            case "Ona tili" -> "Ona tili haqida ma'lumot...";
            case "Biologiya" -> "Biologiya haqida ma'lumot...";
            case "Kimyo" -> "Kimyo haqida ma'lumot...";
            case "Huquq" -> "Huquq haqida ma'lumot...";
            case "Umumiy ma'lumotlar" -> "Markaz haqida umumiy ma'lumotlar...";
            case "Afzalliklar" -> "Markazimizning afzalliklari...";
            case "Yutuqlar" -> "Markazimizning yutuqlari...";

            // Filial options
            case "Sergeli" -> "Sergeli filialimiz haqida ma'lumot...";
            case "Olmazor" -> "Olmazor filialimiz haqida ma'lumot...";
            case "Uchtepa" -> "Uchtepa filialimiz haqida ma'lumot...";
            case "Chilonzor" -> "Chilonzor filialimiz haqida ma'lumot...";
            case "Yunusobod" -> "Yunusobod filialimiz haqida ma'lumot...";
            case "Yakkasaroy" -> "Yakkasaroy filialimiz haqida ma'lumot...";

            // Contact options
            case "Tel:" -> "Bizning telefon raqamimiz: +998 XXX XXX XXX";
            case "Gmail:" -> "Bizning Gmail manzilimiz: example@gmail.com";
            case "Ro'yxatdan o'tish" ->
                    "Imtihonga ro'yxatdan o'tish uchun quyidagi linkni bosing: [Ro'yxatdan o'tish](https://example.com)";
            default -> "Tanlangan bo'lim uchun ma'lumot mavjud emas.";
        };
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(responseText);
        return sendMessage;
    }
}