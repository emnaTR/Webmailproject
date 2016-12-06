package org.formation.webmail.controller;

import org.formation.webmail.model.User;
import org.formation.webmail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(method=RequestMethod.GET)
    public List<User> listUsers()
    {
        return userService.getAll();
    }
    //sauvegarder un user
    @RequestMapping(method= RequestMethod.POST)
    public void createUser(@RequestBody User user)
    {
        //user.setPhoto(Base64.decodeBase64(user.getsPhoto()));
        userService.create(user);
    }
    
    @RequestMapping(value="/{mail}", method= RequestMethod.GET)
    public User getUser(@PathVariable("mail") String mail )
    {
      return userService.getByMail(mail);
    }

}
