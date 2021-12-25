package com.company.readfile;

import com.company.controller.FindController;
import com.company.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ReadFile {

    private final File file = new File("./src/main/resources/templates/users.txt");

    public boolean find(UserInfo userInfoFromForm) {
        String nameUser = userInfoFromForm.getName();
        String surnameUser = userInfoFromForm.getSurname();
//        UserInfo userInfo = new UserInfo();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null ) {
                String[] array = line.split("/");
                if (array[0].equals(nameUser) && array[1].equals(surnameUser)) {
//                    userInfo.setName(array[0]);
//                    userInfo.setSurname(array[1]);
                    userInfoFromForm.setPatronymic(array[2]);
                    userInfoFromForm.setAge(Integer.parseInt(array[3]));
                    userInfoFromForm.setSalary(Integer.parseInt(array[4]));
                    userInfoFromForm.setMail(array[5]);
                    userInfoFromForm.setWorkPlace(array[6]);
                    return true;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
