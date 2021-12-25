package com.company.filewrite;

import com.company.model.UserInfo;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class WriteInFile {

    private BufferedWriter bufferedWriter;
    private File file = new File("./src/main/resources/templates/users.txt");
    private String lineSeparator = System.getProperty("line.separator");

    public void write(UserInfo userInfo) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            bufferedWriter.write(userInfo.getName());
            bufferedWriter.write("/");
            bufferedWriter.write(userInfo.getSurname());
            bufferedWriter.write("/");
            bufferedWriter.write(userInfo.getPatronymic());
            bufferedWriter.write("/");
            int age = userInfo.getAge();
            bufferedWriter.write(String.valueOf(age));
            bufferedWriter.write("/");
            int salary = userInfo.getSalary();
            bufferedWriter.write(String.valueOf(salary));
            bufferedWriter.write("/");
            bufferedWriter.write(userInfo.getMail());
            bufferedWriter.write("/");
            bufferedWriter.write(userInfo.getWorkPlace() + lineSeparator);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
