package com.egs.home.lesson9.Compaign;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Prop {
    public static String EN_FILE_NAME= "/home/vahe/IdeaProjects/EGS_HOME/src/com/egs/home/lesson9/res/en.properties";
    public static String RU_FILE_NAME ="/home/vahe/IdeaProjects/EGS_HOME/src/com/egs/home/lesson9/res/ru.properties";
    private static String text;
    public static String language;
    static Properties props = new Properties();


    // выбираем нужный язык
    public static String languageCheck(String instructions){
        String instruct="";
        if (language.equals(Instructions.EN.getInstField())){
            instruct= readEn(instructions);
        }else if (language.equals(Instructions.RUS.getInstField())){
            instruct =readRu(instructions);
        }
        return instruct;
    }

    //чтение английского Properties
    private static String readEn(String instructions){
        try {
            props.load(new FileInputStream(new File(EN_FILE_NAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        text= props.getProperty(instructions);
        return text;
    }

    //чтение русского Properties
    private static String readRu(String instructions){
        try {
            props.load(new FileInputStream(new File(RU_FILE_NAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        text= props.getProperty(instructions);
        return text;
    }

}
