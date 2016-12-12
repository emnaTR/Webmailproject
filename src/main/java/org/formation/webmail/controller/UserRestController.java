package org.formation.webmail.controller;

import org.formation.webmail.model.Mail;
import org.formation.webmail.model.User;
import org.formation.webmail.service.MailService;
import org.formation.webmail.service.UserService;
import org.hibernate.ejb.criteria.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private MailService mailService;

    @RequestMapping(method=RequestMethod.GET)
    public List<User> listUsers()
    {
        return userService.getAll();
    }
    //sauvegarder un user
    @RequestMapping(method= RequestMethod.POST)
    public void createUser(@RequestBody User user)
    {
        userService.create(user);
    }
    //////////////////////////////////////////////////////////////////
    //supprimer un user
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Integer id)
    {
        userService.delete(id);
    }
    //mettre à jour password user
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public void UpdateUser(@PathVariable("id") Integer id, @RequestBody User user)
    {
    	 user.setId(id);
		 userService.create(user);
  
    }
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public User getUserId(@PathVariable("id") Integer id )
    {
      return userService.getById(id);
    }
    //////////////////////////////////////////////////////////////////
    //marche pas
    
    @RequestMapping(value="/login", method= RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user)
    {
      User account= userService.login(user); 
   
      if (account == null)
          return new ResponseEntity<User> (HttpStatus.NOT_FOUND);
      else
          return new ResponseEntity<User> (account, HttpStatus.OK);
    }
    //////////////////////////////////////////////////////////////////

    //envoyer un email
    @RequestMapping(value="/{id}/sendMail", method= RequestMethod.POST)
    public void sendMail(@PathVariable("id") Integer id, @RequestBody Mail mail)
    {
    	 mailService.create(mail, id);
    }
    //récupérer la liste des mails envoyé 
    @RequestMapping(value="/{id}/MailsSent", method= RequestMethod.GET)
    public List<Mail> MailsSent(@PathVariable("id") Integer id)
    {
    	//List<Mail> mails=userService.getById(id).getMailsSent();
    	//return mails;
    	 return mailService.getByUserId(id);
    }
    //récupérer la liste des mails reçus
    @RequestMapping(value="/{id}/MailsRec", method= RequestMethod.GET)
    public List<Mail> MailsReceived(@PathVariable("id") Integer id)
    {
    	List<Mail> mails=mailService.LoadReception(id);
    	return mails;
    }
}
