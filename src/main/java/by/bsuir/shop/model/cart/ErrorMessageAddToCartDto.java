package by.bsuir.shop.model.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessageAddToCartDto {
    private Long phoneId;
    private String message;
}