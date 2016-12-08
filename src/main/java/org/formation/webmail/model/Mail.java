package org.formation.webmail.model;



import javax.persistence.*;
import java.util.Date;
import java.util.List;
/*** Created by formation on 05/12/2016. */

@Table(name="mails")
@Entity
public class Mail {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    @Column(name="object")
    private String object;
    @Column(name="content")
    private String content;
    //@Column(name="date")
    @Transient
    private Date date;
    @Column(name="pj1")
    private byte[] pj1;
    @Column(name="pj2")
    private byte[] pj2;

    @ManyToOne
    private User userSender;

    //@Transient
    @ManyToMany( fetch=FetchType.EAGER)// uniquement si relation bidirectionnelle
    @JoinTable(name="mailtodest", 
    joinColumns=@JoinColumn(name="mail_id", referencedColumnName="id"),
    inverseJoinColumns=@JoinColumn(name="id_receiver", referencedColumnName="id"))
    private List<User> usersReceiver;

//getters et setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public List<User> getUsersReceiver() {
        return usersReceiver;
    }

    public void setUsersReceiver(List<User> usersReceiver) {
        this.usersReceiver = usersReceiver;
    }

    public byte[] getPj1() {
        return pj1;
    }

    public void setPj1(byte[] pj1) {
        this.pj1 = pj1;
    }

    public byte[] getPj2() {
        return pj2;
    }

    public void setPj2(byte[] pj2) {
        this.pj2 = pj2;
    }
}
