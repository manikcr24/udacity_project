package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.models.User;
import com.udacity.jwdnd.course1.cloudstorage.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final HashService hashService;

    public UserService(UserRepository userMapper, HashService hashService) {
        this.userRepository = userMapper;
        this.hashService = hashService;
    }

    public boolean isUsernameAvailable(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public int createUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[2];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        if(encodedSalt.length() > 16)
            encodedSalt = encodedSalt.substring(0, 15);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
//        User userToSave = new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstName(), user.getLastName());

        User userToSave = User.builder()
                .password(hashedPassword)
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .salt(encodedSalt)
                .build();
        User save = userRepository.save(userToSave);

        if(save != null) return 1;
        return 0;
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

}
