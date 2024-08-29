package uz.AlpinistEdu_Bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import uz.AlpinistEdu_Bot.enums.UserState;
import uz.AlpinistEdu_Bot.enums.UserType;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseModel {
    private Long chatId;
    private String userName;
    private String contact;
    private UserType userType;
    private UserState userState;
    private int coins;
}