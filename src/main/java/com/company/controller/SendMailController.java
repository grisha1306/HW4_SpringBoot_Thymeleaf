package com.company.controller;

import com.company.model.SendMailModel;
import com.company.sendmessage.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SendMailController {

    @Autowired
    MailService mailService;

    @GetMapping("/sendMail")
    public String sendMailGetForm (Model model) {
        model.addAttribute("sendMail", new SendMailModel());
        return "mailForm";
    }

    @PostMapping ("/sendMail")
    public String sendMailPost (@ModelAttribute @Valid SendMailModel sendMailModel) {
        mailService.send(sendMailModel.getEmail(),sendMailModel.getSubject(), sendMailModel.getMessage());

        return "success-send";
    }
}
