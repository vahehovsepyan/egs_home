package com.egs.home.lesson9.Compaign;

import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaderWriter {
    private static String fileName="src/com/egs/home/lesson9/res/employers.txt";

   // InputStreamReader fileInputStream ;



    //пишем в файл
     void writeEmployers(){
        String info="";
         byte[] bytes;
        try(FileOutputStream fileOutStream = new FileOutputStream(new File(fileName));            ){
            for (Employer emp :
                    Compaign.employers) {
                info = emp.getFirstName() + "" +
                        " " + emp.getLastName() + "" +
                        " " + emp.getpositonNumber() + "" +
                        " " + emp.getSalary() + "\n";
                fileOutStream.write(info.getBytes());
            }

        }catch (Exception e){
        }
         Compaign.logger.info("список сотрудников был сохранен в файл");
    }

    //читаем из файла
    public void readEmployers(){
        try(FileReader inputStream = new FileReader(new File(fileName));
            BufferedReader br = new BufferedReader(inputStream)) {
            String text ="";
            String positions[];
            while (inputStream.ready()) //пока остались непрочитанные байты
            {
                text=br.readLine();
                positions=text.split(" ");
                Compaign.employers.add(new Employer(positions[0],positions[1],Integer.parseInt(positions[2]),Double.parseDouble(positions[3])));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Compaign.logger.info("список сотрудников считали из файла ");

    }
}
