package uz.AlpinistEdu_Service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseModel {
    private String brand;
    private String model;
    private double price;
    private String description;
    private String imageUrl;
    private int quantity;
}