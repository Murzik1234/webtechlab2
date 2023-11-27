package by.bsuir.shop.model.user;

import by.bsuir.shop.model.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Entity {
    private String login;
    private String hashPassword;
    private UserRole role;
    private double discount;
    private UserStatus status;
}
