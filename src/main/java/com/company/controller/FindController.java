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
    public String submitFindForm(@ModelAttribute UserInfo userInfoFromForm) {
        boolean userWasFound = readFile.find(userInfoFromForm);
        if (!userWasFound) {
            return "redirect:/showUserNotFound";
        }

        return "successful-find";
    }

    @GetMapping("/showUserNotFound")
    public String showUserNotFound() {
        return "userNotFound";
    }

}
