package org.formation.webmail.dao;



import org.formation.webmail.model.User;
import java.util.List;

public interface UserDao {

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
