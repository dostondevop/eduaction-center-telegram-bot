package uz.AlpinistEdu_Bot.model.connections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParentStudent {
    private UUID id;
    private UUID parentId;
    private UUID studentId;
}