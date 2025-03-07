package uz.AlpinistEdu_Service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import uz.AlpinistEdu_Service.enums.UserState;
import uz.AlpinistEdu_Service.enums.UserType;

import java.util.List;


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
    private List<User> students;
    private List<Point> points;
    private int index;
}