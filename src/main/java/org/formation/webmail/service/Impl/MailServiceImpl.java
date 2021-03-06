package org.formation.webmail.service.Impl;

import java.util.Date;
import java.util.List;

import org.formation.webmail.dao.MailDao;
import org.formation.webmail.model.Mail;
import org.formation.webmail.model.User;
import org.formation.webmail.service.MailService;
import org.formation.webmail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    private MailDao maildao;
    
    @Autowired
    private UserService userService;
    //CRUD: Create Read Update Delete
    //Create Mail
    public void create(Mail mail, Integer id)
    {
    	 User user=userService.getById(id);
    	 Date d=new Date();
    	 mail.setDate(d);
    	 mail.setUserSender(user);
         maildao.create(mail);
    } 
    //Read Mail
    public Mail getById(int id)
    {
       return maildao.getById(id);
    }
    public List<Mail> getAll()
    {
       return maildao.getAll();
    }

    
    //delete Mail
    public void delete(int id){
        maildao.delete(id);
    }
	public List<Mail> getByUserId(Integer UserId) {
		return maildao.getByUserId(UserId);
	}
	public List<Mail> LoadReception(Integer userId) {
		return maildao.LoadReception(userId);
	}
    
}
