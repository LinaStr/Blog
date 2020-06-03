package lt.codeacademy.Blogas.services;

import lt.codeacademy.Blogas.entities.User;
import lt.codeacademy.Blogas.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveOrUpdateUser(User user){
        return userRepository.save(user);
    }
}
