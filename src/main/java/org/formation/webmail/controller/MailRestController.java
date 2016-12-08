package org.formation.webmail.controller;

import java.util.List;

import org.formation.webmail.model.Mail;
import org.formation.webmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mail")
public class MailRestController {

    @Autowired
    private MailService mailService;

    //récuperer la liste des mails
    @RequestMapping(method=RequestMethod.GET)
    public List<Mail> listmails()
    {
        return mailService.getAll();
    }
    //sauvegarder un mail
 /*   @RequestMapping(method= RequestMethod.POST)
    public void createmail(@PathVariable("id") Integer id,@RequestBody Mail mail)
    {
        mailService.create(mail, id);
    }*/

  

}
