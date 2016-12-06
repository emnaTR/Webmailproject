package org.formation.webmail.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.formation.webmail.dao.UserDao;
import org.formation.webmail.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(User user) {
        entityManager.merge(user);
    }

    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
    public User getByMail(String mail) {
		User user ;
		user= (User)entityManager.createQuery("select id from User utilisateur where user.mail like :mail").setParameter("mail",mail).getSingleResult();
		return user;
	}
    public List<User> getAll() {
        List<User> users;
        String query= "SELECT user FROM users user";
        users= (List<User>)entityManager.createQuery(query).getResultList();
        return users;
    }

    public void delete(int id) {
        User attached=entityManager.find(User.class,id);
        entityManager.remove(attached);
    }

}
