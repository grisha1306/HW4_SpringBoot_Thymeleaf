package com.company.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
public class UserInfo {

    @NotEmpty
    @Pattern(regexp = "([\\D]*)", message = "Не должно быть чисел")
    @Size(max=20)
    private String name;

    @NotEmpty
    @Pattern(regexp = "([\\D]*)", message = "Не должно быть чисел")
    @Size(max=20)
    private String surname;

    @NotEmpty
    @Pattern(regexp = "([\\D]*)", message = "Не должно быть чисел")
    @Size(max=20)
    private String patronymic;

    @Min(18)
    private int age;

    @Min(1)
    private int salary;

    @NotEmpty
    @Pattern(regexp = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,}" , message = "Не формат почты")
    private String mail;

    @NotEmpty
    private String workPlace;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }
}
