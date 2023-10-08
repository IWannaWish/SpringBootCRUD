package ru.pestrikov.springcourse.SpringBootCRUD.dao;


import ru.pestrikov.springcourse.SpringBootCRUD.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    User show(int id);
    void save(User user);
    void delete(int id);
    void update(int id,User user);

}
