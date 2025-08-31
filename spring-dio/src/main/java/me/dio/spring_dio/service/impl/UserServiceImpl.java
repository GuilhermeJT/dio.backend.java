package me.dio.spring_dio.service.impl;

import me.dio.spring_dio.model.User;
import me.dio.spring_dio.repository.UserRepository;
import me.dio.spring_dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {

        if(user.getId() != null && userRepository.existsById(user.getId())){
            throw new IllegalStateException("User already exists!");
        }
        return userRepository.save(user);
    }
}
