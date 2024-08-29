package uz.AlpinistEdu_Bot.model;


import lombok.*;
import lombok.experimental.SuperBuilder;
import uz.AlpinistEdu_Bot.enums.Subjects;

import java.util.Date;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Group extends BaseModel {
    private UUID teacherId;
    private Subjects subjectName;
    private Date startedDate;
}