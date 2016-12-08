package org.formation.webmail.dao;



import java.util.List;

import org.formation.webmail.model.Mail;

public interface MailDao {
    //CRUD: Create Read Update Delete
    //Create Mail
    public void create(Mail mail);
    //Read Mail
    public Mail getById(int id);
    public List<Mail> getAll();
    public List<Mail> getByUserId(Integer UserId);
    public List<Mail> LoadReception(Integer UserId);
    //update Mail
    // public User update(int id);

    //delete Mail
    public void delete(int id);
}
