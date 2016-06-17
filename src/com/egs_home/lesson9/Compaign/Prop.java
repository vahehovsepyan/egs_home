package com.egs_home.lesson9.Compaign;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Prop {
    private String text;
    public static String language;
    Properties props = new Properties();


    // выбираем нужный язык
    public String languageCheck(String instructions){
        String instruct="";
        if (language.equals(Instructions.EN.getInstField())){
            instruct= readEn(instructions);
        }else if (language.equals(Instructions.RUS.getInstField())){
            instruct =readRu(instructions);
        }
        return instruct;
    }

    //чтение английского Properties
    public String readEn(String instructions){
        try {
            props.load(new FileInputStream(new File("/home/vahe/IdeaProjects/EGS_HOME/src/com/egs_home/lesson9/res/en.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        text= props.getProperty(instructions);
        return text;
    }

    //чтение русского Properties
    public String readRu(String instructions){
        try {
            props.load(new FileInputStream(new File("/home/vahe/IdeaProjects/EGS_HOME/src/com/egs_home/lesson9/res/ru.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        text= props.getProperty(instructions);
        return text;
    }

}
