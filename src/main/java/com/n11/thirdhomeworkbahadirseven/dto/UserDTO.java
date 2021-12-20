package com.n11.thirdhomeworkbahadirseven.dto;

import com.n11.thirdhomeworkbahadirseven.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String username;

    public static UserDTO fromUser(User user){
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPhone(),
                user.getUsername());
    }

    public static User fromUserDTO(Long nextId, UserDTO userDTO){
        return new User(
                nextId,
                userDTO.getName(),
                userDTO.getSurname(),
                userDTO.getEmail(),
                userDTO.getPhone(),
                userDTO.getUsername());
    }
}
