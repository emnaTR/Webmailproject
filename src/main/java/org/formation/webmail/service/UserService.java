package org.formation.webmail.service;


import java.util.List;

import org.formation.webmail.model.User;

public interface UserService {
    //CRUD: Create Read Update Delete
    //Create User
    public void create(User user);
    //Read User
    public User getById(int id);
    public List<User> getAll();

    //update User
    // public User update(int id);

    //delete User
    public void delete(int id);
}
