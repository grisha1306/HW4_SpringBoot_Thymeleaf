package com.company.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SendMailModel {

    @NotEmpty
    @Pattern(regexp = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,}" , message = "Не формат почты")
    private String email;

    private String subject;

    @NotEmpty
    private String message;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
