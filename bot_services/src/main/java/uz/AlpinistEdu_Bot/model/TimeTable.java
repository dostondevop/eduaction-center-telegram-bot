package uz.AlpinistEdu_Bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import uz.AlpinistEdu_Bot.enums.Subjects;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TimeTable extends BaseModel {
    private Subjects subject;
    private String day;
    private String startTime;
    private String endTime;
}