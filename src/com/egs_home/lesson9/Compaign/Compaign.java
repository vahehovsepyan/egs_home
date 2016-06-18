package com.egs_home.lesson9.Compaign;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Compaign {
    private String firstName;
    private String lastName;
    private String postion;
    private LinkedList<Employer> employers = new LinkedList<>();
    private Instructions ins;
    private String fileName="src/com/egs_home/lesson9/res/employers.txt";
    InputStreamReader fileInputStream ;
    FileOutputStream fileOutputStream ;
    Prop languageProps;
    Scanner sc = new Scanner(System.in);


    public static void main(String[] args)  {
        Compaign compaign = new Compaign();
        compaign.languageChoose();
    }

    public void languageChoose(){
        languageProps=new Prop();
        System.out.println("для выбора русского языка введите: "+Instructions.RUS.getInstField());
        System.out.println("for english enter: "+Instructions.EN.getInstField());
        Prop.language=sc.nextLine();
        go();

    }

    //
    public void go()  {
        String instruction;
        System.out.println(coding(Instructions.ADD_EMPLOYER.getInstField())+ Instructions.ADD_EMPLOYER.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.ALL_EMPLOYERS.getInstField())+ Instructions.ALL_EMPLOYERS.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.SEARCH_EMPLOYER.getInstField())+ Instructions.SEARCH_EMPLOYER.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.COMPAIR.getInstField())+Instructions.COMPAIR.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.CLEAR.getInstField())+Instructions.CLEAR.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.EXIT.getInstField())+ Instructions.EXIT.getInstField());
        while (true){
            instruction=sc.nextLine();
             ins= Instructions.getByInstructionName(instruction);
             switch (ins){
                case ADD_EMPLOYER:addEmployer(); break;
                case ALL_EMPLOYERS:allEmployers();break;
                case SEARCH_EMPLOYER:search();break;
                case COMPAIR:compairByPosition();break;
                 case CLEAR:{clear();go();}break;
                case EXIT:break;
                default:System.out.println(languageProps.languageCheck(Instructions.INPUT.toString()));
            }
        }
    }

    public void compairByPosition(){
        Collections.sort(employers,integerComparator);
        allEmployers();
    }

    Comparator<Employer> integerComparator = new Comparator<Employer>() {
        @Override
        public int compare(Employer o1, Employer o2) {
            return o1.getpositonNumber()-o2.getpositonNumber();
        }
    };


    //очистка всех данных
    private void clear(){
        try {
            fileOutputStream = new FileOutputStream(new File(fileName));
            fileOutputStream.write("".getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //поиск сотрудников
    public void search(){
        String text;
        System.out.println();
        System.out.println(languageProps.languageCheck(Instructions.SEARCH_BY_NAME.toString())+" "+Instructions.SEARCH_BY_NAME.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.SEARCH_BY_FAMILY.toString())+" "+Instructions.SEARCH_BY_FAMILY.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.SEARCH_BY_POSITION.toString())+" "+Instructions.SEARCH_BY_POSITION.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.OUT.getInstField())+Instructions.OUT.getInstField());

        while (true){
            text=sc.nextLine();

            ins = Instructions.getByInstructionName(text);
            switch (ins){
                case EXIT:go();break;
                case SEARCH_BY_NAME:{
                    System.out.println(languageProps.languageCheck(Instructions.SEARCH_BY_NAME.toString()));
                    firstName=sc.nextLine();
                    searchByName(firstName);
                    break;
                }
                case SEARCH_BY_FAMILY:{
                    System.out.println(languageProps.languageCheck(Instructions.SEARCH_BY_FAMILY.toString()));
                    lastName= sc.nextLine();
                    searchByFamily(lastName);
                    break;
                }
                case SEARCH_BY_POSITION:{
                    System.out.println(languageProps.languageCheck(Instructions.SEARCH_BY_POSITION.toString()));
                    postion= sc.nextLine();
                    searchByPosition(postion);
                    break;
                }
                default:System.out.println(languageProps.languageCheck(Instructions.NOTHING_FIND.toString()));
            }


        }
    }


    //поиск сотрудников по имени
    private void searchByName(String text){
        String emplyer;
        String[] employerArray ;
        try{
            fileInputStream = new InputStreamReader(new FileInputStream(new File(fileName)));
            BufferedReader br = new BufferedReader(fileInputStream);
            while (br.ready()){
                emplyer = br.readLine();
                employerArray=emplyer.split(" ");
                if (employerArray[0].equals(text)) {
                    System.out.println(employerArray[0] + " " +
                            employerArray[1] + " " +
                            employerArray[2] + " " +
                            employerArray[3]);
                }
            }
            fileInputStream.close();
            br.close();

        }catch (Exception e){

        }
    }

    //поиск сотрудников по фамилии
    private void searchByFamily(String text){
        String emplyer;
        String[] employerArray ;
        try{
            fileInputStream = new InputStreamReader(new FileInputStream(new File(fileName)));
            BufferedReader br = new BufferedReader(fileInputStream);
            while (br.ready()){
                emplyer = br.readLine();
                employerArray=emplyer.split(" ");
                if (employerArray[1].equals(text)) {
                    System.out.println(employerArray[0] + " " +
                            employerArray[1] + " " +
                            employerArray[2] + " " +
                            employerArray[3]);
                }
            }
            fileInputStream.close();
            br.close();

        }catch (Exception e){

        }
    }

    //поиск сотрудников по должности
    private void searchByPosition(String text){
        String emplyer;
        String[] employerArray ;
        try{
            fileInputStream = new InputStreamReader(new FileInputStream(new File(fileName)));
            BufferedReader br = new BufferedReader(fileInputStream);
            while (br.ready()){
                emplyer = br.readLine();
                employerArray=emplyer.split(" ");
                if (employerArray[2].equals(text)) {
                    System.out.println(employerArray[0] + " " +
                            employerArray[1] + " " +
                            employerArray[2] + " " +
                            employerArray[3]);
                }
            }
            fileInputStream.close();
            br.close();

        }catch (Exception e){

        }
    }

    //список всех сотрудников
    private void allEmployers(){
        String emplyer;
        String[] employerArray ;
        try{
            fileInputStream = new InputStreamReader(new FileInputStream(new File(fileName)));
            BufferedReader br = new BufferedReader(fileInputStream);
            while (br.ready()){
                emplyer = br.readLine();
                employerArray=emplyer.split(" ");
                System.out.println(employerArray[0]+" " +
                        employerArray[1]+" " +
                        employerArray[2]+" " +
                        employerArray[3]);
            }
            fileInputStream.close();
            br.close();

        }catch (Exception e){

        }
    }


    //добавление сотрудников
    private void addEmployer(){
        String employer1 = " ";
        Double salary ;
        System.out.println(languageProps.languageCheck(Instructions.OUT.getInstField())+" "+Instructions.EXIT.getInstField());

        try{
            while (true){
                System.out.println(languageProps.languageCheck(Instructions.INPUT_NAME.toString()));
                firstName = sc.nextLine();
                if (firstName.equals(Instructions.EXIT.getInstField())){go();}
                if (firstName.isEmpty()){
                    continue;
                }

                System.out.println(languageProps.languageCheck(Instructions.INPUT_FAMILY.toString()));
                lastName = sc.nextLine();
                if (lastName.equals(Instructions.EXIT.getInstField())){go();}
                if (lastName.isEmpty()){
                    continue;
                }


                System.out.println();

                System.out.print(languageProps.languageCheck(Instructions.POSITIONS_IN_COMPANY.toString())+" ");
                WorkerPositions[] arr = WorkerPositions.values();
                for (int i = 0; i <arr.length; i++) {
                    System.out.print(languageProps.languageCheck(WorkerPositions.values()[i].toString())+" ");
                }
                System.out.println();
                System.out.println();
                System.out.println(languageProps.languageCheck(Instructions.INPUT_POSITION.toString()));
                postion = sc.nextLine();
                if (postion.equals(Instructions.EXIT.getInstField())){go();}
                if (!checkPosition(postion)){
                    System.out.println(languageProps.languageCheck(Instructions.INPUT.toString()));
                    continue;
                }

                System.out.println(languageProps.languageCheck(Instructions.INPUT_SALARY.toString()));
                try {
                    salary = sc.nextDouble();
                }catch (Exception e){
                    System.out.println(languageProps.languageCheck(Instructions.INPUT.toString()));
                    System.out.println();
                    continue;
                }

                //пишем в файл
                employer1= firstName+" "+lastName+" "+postion+" "+salary+"\n";

                fileInputStream = new InputStreamReader(new FileInputStream(new File(fileName)));
                if (fileInputStream.ready()){
                    update(employer1);
                }else {
                    fileOutputStream= new FileOutputStream(new File(fileName));
                    byte[]b = employer1.getBytes();
                    fileOutputStream.write(b);
                    fileOutputStream.flush();
                    fileOutputStream.close();

                }


            }


        }catch (Exception e){
            System.out.println("проблемы с написанием в файл");
        }


        System.out.println("Написано в файл");

    }


    //проверяем правильно ли ввели должность
    public boolean checkPosition(String postion){
        boolean check=false;
        if (!postion.isEmpty()){
            WorkerPositions[] workerPositionses = WorkerPositions.values();
            for (int i = 0; i < workerPositionses.length; i++) {
                if (workerPositionses[i].getPosition().equals(postion)){
                    check=true;
                }
            }
        }
        return check;
    }

    //если файл не пустой , то обновляем его , добавляя новые данные
    public  void update( String newEmployer) {
        String oldFile="";
        StringBuilder sb = new StringBuilder();
        try{
            fileInputStream = new InputStreamReader(new FileInputStream(new File(fileName)));
            BufferedReader br = new BufferedReader(fileInputStream);
            while (br.ready()){
                oldFile = br.readLine()+"\n";
                sb.append(oldFile);
            }
            fileInputStream.close();
            br.close();

        }catch (Exception e){
        }
        sb.append(newEmployer);
        byte[] b = sb.toString().getBytes();
        try {
            fileOutputStream = new FileOutputStream(new File(fileName));
            fileOutputStream.write(b);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String coding(String instructions){
        String utf8 = languageProps.languageCheck(instructions);

        byte[] buffer = utf8.getBytes();
        String s = new String(buffer);


        return s;
    }


}
