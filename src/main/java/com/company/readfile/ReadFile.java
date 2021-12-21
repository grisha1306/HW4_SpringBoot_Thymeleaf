package com.company.readfile;

import com.company.model.FindUser;
import com.company.model.UserInfo;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ReadFile {

    private File file = new File("./src/main/resources/templates/users.txt");

    public UserInfo find(FindUser findUser) {
        String nameUser = findUser.getName();
        String surnameUser = findUser.getSurname();
        UserInfo userInfo = new UserInfo();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null ) {
                String[] array = line.split("/");
                if ( array[0].equals(nameUser) && array[1].equals(surnameUser) ) {
                    userInfo.setName(array[0]);
                    userInfo.setSurname(array[1]);
                    userInfo.setPatronymic(array[2]);
                    userInfo.setAge(Integer.parseInt(array[3]));
                    userInfo.setSalary(Integer.parseInt(array[4]));
                    userInfo.setMail(array[5]);
                    userInfo.setWorkPlace(array[6]);
                    return userInfo;
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
