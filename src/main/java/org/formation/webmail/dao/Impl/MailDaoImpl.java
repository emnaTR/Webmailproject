package org.formation.webmail.dao.Impl;


import org.formation.webmail.dao.MailDao;
import org.formation.webmail.model.Mail;
import org.formation.webmail.model.User;
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
    public List<Mail> getByUserId(Integer UserId) {
        String query= "SELECT m FROM Mail m where m.userSender.id = :UserId";
        List<Mail> mails= entityManager.createQuery(query, Mail.class).setParameter("UserId", UserId).getResultList();
        return mails;
    }
    public List<Mail> getAll() {
        String query= "SELECT mail FROM Mail mail";
        List<Mail> mails= entityManager.createQuery(query, Mail.class).getResultList();
        return mails;
    }

    public void delete(int id) {
        Mail attached= entityManager.find(Mail.class, id);
        entityManager.remove(attached);
    }

	public List<Mail> LoadReception(Integer userId) {
		String Sqlquery= "SELECT m from Mail m inner join m.usersReceiver u where u.id =:id ";
		List<Mail> mails= entityManager.createQuery(Sqlquery, Mail.class).setParameter("id", userId).getResultList();
		return mails;
	}
}
