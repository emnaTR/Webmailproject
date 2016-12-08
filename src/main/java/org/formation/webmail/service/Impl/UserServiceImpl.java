package org.formation.webmail.service.Impl;

import java.util.List;

import org.formation.webmail.dao.UserDao;
import org.formation.webmail.model.User;
import org.formation.webmail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao;
    //CRUD: Create Read Update Delete
    //Create User
    public void create(User user)
    {
        userdao.create(user);
    }
    //Read User
    public User getById(int id)
    {
        return userdao.getById(id);
    }
    public User login(User user)
    {
    	User u = userdao.getByMail(user.getEmail());
    	if(u.getPassword().equals(user.getPassword())) {
    		return u;
    	} 
    	return null;
    }
    public List<User> getAll()
    {
        return userdao.getAll();
    }

    //update User
    // public User update(int id);

    //delete User
    public void delete(int id){
        userdao.delete(id);
    }
}
