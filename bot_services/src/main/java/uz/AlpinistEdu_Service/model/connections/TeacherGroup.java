package uz.AlpinistEdu_Service.model.connections;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherGroup {
    private UUID id;
    private UUID groupId;
    private UUID teacherId;
}