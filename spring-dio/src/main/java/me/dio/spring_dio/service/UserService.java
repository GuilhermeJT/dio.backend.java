package me.dio.spring_dio.service;

import me.dio.spring_dio.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);

}
