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
public class GroupTimeTable {
    private UUID id;
    private UUID groupId;
    private UUID timeTableId;
}