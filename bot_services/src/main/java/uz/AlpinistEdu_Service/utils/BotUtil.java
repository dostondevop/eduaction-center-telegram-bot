package uz.AlpinistEdu_Service.utils;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import uz.AlpinistEdu_Service.model.*;
import lombok.experimental.UtilityClass;
import uz.AlpinistEdu_Service.model.connections.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

@UtilityClass
public class BotUtil {

    public static ReplyKeyboardMarkup replyKeyboardMarkup(List<String> data, int n) {
        List<KeyboardRow> keyboardRows = makeReplyKeyboardRow(data, n);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }

    private static List<KeyboardRow> makeReplyKeyboardRow(List<String> data, int n) {
        return IntStream.range(0, (data.size() + n - 1) / n)
                .mapToObj(i -> {
                    KeyboardRow row = new KeyboardRow();
                    data.stream()
                            .skip((long) i * n)
                            .limit(n)
                            .map(KeyboardButton::new)
                            .forEach(row::add);
                    return row;
                })
                .collect(Collectors.toList());
    }

    public static <T> InlineKeyboardMarkup inlineKeyboardMarkup(List<T> models, int n) {
        if (models.isEmpty()) {
            return new InlineKeyboardMarkup();
        }

        List<List<InlineKeyboardButton>> keyboardRows = makeInlineKeyboardRows(models, n);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboardRows);
        return inlineKeyboardMarkup;
    }

    private static <T> List<List<InlineKeyboardButton>> makeInlineKeyboardRows(List<T> models, int n) {
        return IntStream.range(0, (models.size() + n - 1) / n)
                .mapToObj(i -> models.stream()
                        .skip((long) i * n)
                        .limit(n)
                        .map(BotUtil::createInlineKeyboardButton)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private static <T> InlineKeyboardButton createInlineKeyboardButton(T model) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        String callbackData = "";

        if (model instanceof Product product) {
            button.setText(product.getName());
            callbackData = CallBackUtils.PRODUCT + product.getId();
        } else if (model instanceof Group group) {
            button.setText("Group " + group.getName());
            callbackData = CallBackUtils.GROUP + group.getId();
        } else if (model instanceof User user) {
            button.setText(user.getUserName());
            callbackData = CallBackUtils.USER + user.getChatId();
        } else if (model instanceof Point point) {
            button.setText("Point " + point.getId());
            callbackData = CallBackUtils.POINT + point.getId();
        } else if (model instanceof TimeTable timeTable) {
            button.setText("TimeTable " + timeTable.getId());
            callbackData = CallBackUtils.TIME_TABLE + timeTable.getId();
        } else if (model instanceof TeacherGroup teacherGroup) {
            button.setText("Teacher Group " + teacherGroup.getId());
            callbackData = CallBackUtils.TEACHER_GROUP + teacherGroup.getId();
        } else if (model instanceof StudentGroup studentGroup) {
            button.setText("Student Group " + studentGroup.getId());
            callbackData = CallBackUtils.STUDENT_GROUP + studentGroup.getId();
        } else if (model instanceof ParentStudent parentStudent) {
            button.setText("Parent Student " + parentStudent.getId());
            callbackData = CallBackUtils.PARENT_STUDENT + parentStudent.getId();
        } else if (model instanceof GroupTimeTable groupTimeTable) {
            button.setText("Group TimeTable " + groupTimeTable.getId());
            callbackData = CallBackUtils.GROUP_TIME_TABLE + groupTimeTable.getId();
        } else if (model instanceof String) {
            button.setText(model.toString());
            callbackData = model.toString();
        }
        button.setCallbackData(callbackData);
        return button;
    }

    public static ReplyKeyboardMarkup getRequestPhoneNumberKeyboard() {
        KeyboardButton button = new KeyboardButton("Share your phone number");
        button.setRequestContact(true);

        KeyboardRow row = new KeyboardRow();
        row.add(button);

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(row);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setKeyboard(keyboardRows);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);

        return keyboardMarkup;
    }
}