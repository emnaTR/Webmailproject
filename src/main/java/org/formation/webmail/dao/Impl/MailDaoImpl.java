package org.formation.webmail.dao.Impl;


import org.formation.webmail.dao.MailDao;
import org.formation.webmail.model.Mail;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component("mailDao")
@Transactional
public class MailDaoImpl  implements MailDao{

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Mail mail) {
        entityManager.merge(mail);
    }

    public Mail getById(int id) {
        return entityManager.find(Mail.class, id);
    }
    public List<Mail> getByUserId(int UserId) {
        String query= "SELECT m FROM mails m Where m.id_sender=UserId";
        List<Mail> mails= (List<Mail>)entityManager.createQuery(query).getResultList();
        return mails;
    }
    public List<Mail> getAll() {
        String query= "SELECT mail FROM mails mail";
        List<Mail> mails= (List<Mail>)entityManager.createQuery(query).getResultList();
        return mails;
    }

    public void delete(int id) {
        Mail attached= entityManager.find(Mail.class, id);
        entityManager.remove(attached);
    }
}
