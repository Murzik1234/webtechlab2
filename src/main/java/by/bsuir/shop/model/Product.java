package by.bsuir.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Entity implements Serializable {
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private String imageUrl;
    private int weight;
    private String country;
}