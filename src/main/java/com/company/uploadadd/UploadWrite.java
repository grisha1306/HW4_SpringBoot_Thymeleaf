package com.company.uploadadd;

import com.company.filewrite.WriteInFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class UploadWrite {

    private BufferedWriter bufferedWriter;
    private File file = new File("./src/main/resources/templates/users.txt");
    private String lineSeparator = System.getProperty("line.separator");

    private String readUploadFile (MultipartFile file) {
        String content = null;
        try {
            content = new String(file.getBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public void writeUploadFile (MultipartFile multipartFile) {
        String content = readUploadFile(multipartFile);
        String[] words = content.split("\\s+");
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(this.file,true));
            for ( int i = 0; i < words.length; i ++) {
                if ( (i + 1) % 7 == 0 && i != 0) {
                    bufferedWriter.write(words[i] + lineSeparator);
                    continue;
                }
                bufferedWriter.write(words[i]);
                bufferedWriter.write("/");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
