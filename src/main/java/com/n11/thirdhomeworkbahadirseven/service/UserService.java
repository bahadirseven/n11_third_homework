package com.n11.thirdhomeworkbahadirseven.service;

import com.n11.thirdhomeworkbahadirseven.dto.UserDTO;
import com.n11.thirdhomeworkbahadirseven.entity.User;
import com.n11.thirdhomeworkbahadirseven.exception.NoEntityFoundException;
import com.n11.thirdhomeworkbahadirseven.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public UserDTO saveUser(UserDTO userDTO) {
        Long nextId = sequenceGeneratorService.getSequenceNumber("users");
        User user = UserDTO.fromUserDTO(nextId,userDTO);
        User savedUser = userRepository.save(user);
        return UserDTO.fromUser(savedUser);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("User not found."));
        return UserDTO.fromUser(user);
    }

    public List<UserDTO> findAllUser(){
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserDTO::fromUser).collect(Collectors.toList());
    }
}
