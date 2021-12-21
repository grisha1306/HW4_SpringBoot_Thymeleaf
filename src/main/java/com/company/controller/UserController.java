package com.company.controller;

import com.company.filewrite.WriteInFile;
import com.company.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private WriteInFile writeInFile;

    @GetMapping("/userForm")
    public String userForm(Model model) {
        model.addAttribute("userInfo", new UserInfo());
        return "userForm";
    }

    @PostMapping("/userForm")
    public String userSubmit(@ModelAttribute @Valid UserInfo userInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        writeInFile.write(userInfo);
        return "result";
    }

}
