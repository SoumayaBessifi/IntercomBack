package com.intercom.webapp.webapplication.controller;

import javax.validation.ValidationException;

import com.intercom.webapp.webapplication.mail.MailConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intercom.webapp.webapplication.Entities.Reclamation;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    private JavaMailSenderImpl mailSender=new JavaMailSenderImpl();

    @Autowired
    private MailConfiguration  MailConfiguration;


    public FeedBackController(com.intercom.webapp.webapplication.mail.MailConfiguration mailConfiguration) {
        super();
        this.MailConfiguration = mailConfiguration;
    }


    //bouton envoyer rec
	/*@PostMapping                                          //check that the model is valid
	public void senFeedBack(@RequestBody FeedBack feedback,BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			throw new ValidationException("non valide ") ;

		//creer un mail sender

		mailSender.setHost(this.MailConfiguration.getHost());
		mailSender.setPassword(this.MailConfiguration.getPwd());
		mailSender.setPort(this.MailConfiguration.getPort());
		mailSender.setUsername(this.MailConfiguration.getUsername());


		//creer une instance du mail
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom(feedback.getEmail());
		mailMessage.setTo("karouisafinaz1997@gmail.com");
		mailMessage.setSubject("un nouv mail de "+feedback.getNom());
		mailMessage.setText(feedback.getDescription());
		mailMessage.setSentDate(feedback.getDate_creation());


		//envoyer le mail

		//mailSender.send(mailMessage);
		mailSender.send(mailMessage);

	}*/
    @PostMapping                                          //check that the model is valid
    public void senFeedBack(@RequestBody Reclamation Reclamation,BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ValidationException("non valide ") ;

        //creer un mail sender

        mailSender.setHost(this.MailConfiguration.getHost());
        mailSender.setPassword(this.MailConfiguration.getPwd());
        mailSender.setPort(this.MailConfiguration.getPort());
        mailSender.setUsername(this.MailConfiguration.getUsername());


        //creer une instance du mail
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        //mailMessage.setFrom(Reclamation.getUser().getMail());
        mailMessage.setTo("karouisafinaz1997@gmail.com");
        //	mailMessage.setSubject("un nouv mail de "+Reclamation.getUser().getName());
        mailMessage.setText(Reclamation.getDescription()+"  Etat:"+Reclamation.getEtat()+" Urgence :"+Reclamation.getUrgence()+" date"+Reclamation.getDate_creation());
        mailMessage.setSentDate(Reclamation.getDate_creation());


        //envoyer le mail

        //mailSender.send(mailMessage);
        mailSender.send(mailMessage);

    }

}
