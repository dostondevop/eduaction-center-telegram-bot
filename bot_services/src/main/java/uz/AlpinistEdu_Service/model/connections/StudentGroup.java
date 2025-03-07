package uz.AlpinistEdu_Service.model.connections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroup {
    private UUID id;
    private UUID studentId;
    private UUID groupId;
}