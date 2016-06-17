package com.egs_home.lesson9.Compaign;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Compaign {
    private String firstName;
    private String lastName;
    private String postion;
    private LinkedList<Employer> employers = new LinkedList<>();
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
        System.out.println(languageProps.languageCheck(Instructions.ADD_EMPLOYER.getInstField())+ Instructions.ADD_EMPLOYER.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.ALL_EMPLOYERS.getInstField())+ Instructions.ALL_EMPLOYERS.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.SEARCH_EMPLOYER.getInstField())+ Instructions.SEARCH_EMPLOYER.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.COMPAIR.getInstField())+Instructions.COMPAIR.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.EXIT.getInstField())+ Instructions.EXIT.getInstField());
        while (true){
            instruction=sc.nextLine();

            if (instruction.equals(Instructions.ADD_EMPLOYER.getInstField())){
                addEmployer();
            }else if (instruction.equals(Instructions.ALL_EMPLOYERS.getInstField())){
                allEmployers();
            }else if (instruction.equals(Instructions.SEARCH_EMPLOYER.getInstField())){
                search();
            }else if (instruction.equals(Instructions.EXIT.getInstField())){
                break;
            }else if (instruction.equals(Instructions.COMPAIR.getInstField())){
                compairByPosition();
            }else System.out.println(languageProps.languageCheck(Instructions.INPUT.toString()));


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
            if (text.equals(Instructions.EXIT.getInstField())){go();}
            else if (text.equals(Instructions.SEARCH_BY_NAME.getInstField())){
                System.out.println(languageProps.languageCheck(Instructions.SEARCH_BY_NAME.toString()));
                firstName=sc.nextLine();
                searchByName(firstName);
            }else if (text.equals(Instructions.SEARCH_BY_FAMILY.getInstField())){
                System.out.println(languageProps.languageCheck(Instructions.SEARCH_BY_FAMILY.toString()));
                lastName= sc.nextLine();
                searchByFamily(lastName);
            }else if (text.equals(lastName)){
                System.out.println(languageProps.languageCheck(Instructions.SEARCH_BY_POSITION.toString()));
                postion= sc.nextLine();
                searchByPosition(postion);
            }else System.out.println(languageProps.languageCheck(Instructions.NOTHING_FIND.toString()));

        }
    }


    //поиск сотрудников по имени
    private void searchByName(String text){
        for (Employer emp :
                employers) {
            if (emp.getFirstName().equals(text)){
                System.out.println(" "+emp.getFirstName()+"" +
                        " "+emp.getLastName()+"" +
                        " "+WorkerPositions.values()[emp.getpositonNumber()]+" "+emp.getSalary()+"$");
            }
        }
    }

    //поиск сотрудников по фамилии
    private void searchByFamily(String text){
        for (Employer emp :
                employers) {
            if (emp.getLastName().equals(text)){
                System.out.println(" "+emp.getFirstName()+"" +
                        " "+emp.getLastName()+"" +
                        " "+WorkerPositions.values()[emp.getpositonNumber()]+"" +
                        " "+emp.getSalary()+"$");
            }
        }
    }

    //поиск сотрудников по должности
    private void searchByPosition(String text){
        for (Employer emp :
                employers) {
            if (emp.getpositonNumber()==WorkerPositions.getByWorkerPriority(text)){
                System.out.println(" "+emp.getFirstName()+"" +
                                   " "+emp.getLastName()+"" +
                                " "+WorkerPositions.getByWorkerPriority(text)+"" +
                                  " "+emp.getSalary()+"$");
            }
        }
    }

    //список всех сотрудников
    private void allEmployers(){
        for (Employer emp :
                employers) {
            System.out.println(" "+emp.getFirstName()+"" +
                    " "+emp.getLastName()+"" +
                    " "+WorkerPositions.values()[emp.getpositonNumber()].getPosition()+"" +
                    " "+emp.getSalary()+"$");
        }
        System.out.println();
        go();
    }


    //добавление сотрудников
    private void addEmployer(){
        Double salary ;
        System.out.println(languageProps.languageCheck(Instructions.OUT.getInstField())+" "+Instructions.EXIT.getInstField());
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
            employers.add(new Employer(firstName,lastName,WorkerPositions.getByWorkerPriority(postion),salary));
        }

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

    private void loadEmployers(){
        try(FileInputStream fileInputStream = new FileInputStream(new File("res/employers.txt"));){

        }catch (Exception e){

        }
    }


}
