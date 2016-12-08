package org.formation.webmail.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.formation.webmail.dao.UserDao;
import org.formation.webmail.model.Mail;
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
		user= (User)entityManager.createQuery("select u from User u where u.email like :mail").setParameter("mail",mail).getSingleResult();
		//user= (User)entityManager.createNativeQuery("select * from users where email like :mail").setParameter("mail",mail).getSingleResult();
		return user;
	}
    public List<User> getAll() {
        List<User> users;
        //JPQL
        //String query= "SELECT u FROM users u";
        //users= (List<User>)entityManager.createQuery(query).getResultList();
        String sqlquery= "SELECT * FROM users u";
        users= (List<User>)entityManager.createNativeQuery(sqlquery).getResultList();
        return users;
    }

    public void delete(int id) {
        User attached=entityManager.find(User.class,id);
        entityManager.remove(attached);
    }


	

}
