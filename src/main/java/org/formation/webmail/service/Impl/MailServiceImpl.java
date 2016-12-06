package org.formation.webmail.service.Impl;

import java.util.List;

import org.formation.webmail.dao.MailDao;
import org.formation.webmail.model.Mail;
import org.formation.webmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    private MailDao maildao;
    //CRUD: Create Read Update Delete
    //Create Mail
    public void create(Mail mail)
    {
        //il faut récuperer l id_sender
       // maildao.create(mail);
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

    //update Mail
    // public User update(int id);

    //delete Mail
    public void delete(int id){
        maildao.delete(id);
    }
}
