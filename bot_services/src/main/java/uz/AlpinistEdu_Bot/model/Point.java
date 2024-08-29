package uz.AlpinistEdu_Bot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    private UUID id;
    private UUID teacherId;
    private UUID studentId;
    private UUID groupId;
    private int point;
    private LocalDateTime givenDate;
}