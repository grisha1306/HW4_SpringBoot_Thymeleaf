package com.company.controller;

import com.company.model.FindUser;
import com.company.model.UserInfo;
import com.company.readfile.ReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class FindController {

    @Autowired
    private ReadFile readFile;

    @GetMapping("/getForm")
    public String findUserForm(Model model) {
        model.addAttribute("findUser", new FindUser());
        return "findForm";
    }

    @PostMapping("/getForm")
    public String submitFindForm(@ModelAttribute FindUser findUser) {
        UserInfo userInfo = readFile.find(findUser);
//        model.addAttribute("userInfo" , userInfo);
        if (userInfo != null) {
            return "successful-find";
        }

        return "userNotFound";
    }

}
