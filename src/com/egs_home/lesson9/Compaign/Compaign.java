package com.egs_home.lesson9.Compaign;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Compaign  {
    String firstName;
    String lastName;
    String postion;
    LinkedList<Employer> employers = new LinkedList<>();
    Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        Compaign compaign = new Compaign();
        compaign.go();


    }

    //
    public void go(){
        String instruction;
        System.out.println("добавление сотрудника: "+ Instructions.ADD_EMPLOYER.getInstField());
        System.out.println("список всех сотрудников: "+ Instructions.ALL_EMPLOYERS.getInstField());
        System.out.println("поиск сотрудника: "+ Instructions.SEARCH_EMPLOYER.getInstField());
        System.out.println("сортировка по должности: "+Instructions.COMPAIR.getInstField());
        System.out.println("выход из программы: "+ Instructions.EXIT.getInstField());
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
            }else System.out.println("Введите корректные комманды!!!");


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
        System.out.println("Для поиска по имени вводите: "+Instructions.SEARCH_BY_NAME.getInstField());
        System.out.println("Для поиска по фамилии вводите: "+Instructions.SEARCH_BY_FAMILY.getInstField());
        System.out.println("Для поиска по должности вводите: "+Instructions.SEARCH_BY_POSITION.getInstField());
        System.out.println("Для выхода из отдела нажмите: "+Instructions.EXIT.getInstField());

        while (true){

            text=sc.nextLine();
            if (text.equals(Instructions.EXIT.getInstField())){go();}
            else if (text.equals(Instructions.SEARCH_BY_NAME.getInstField())){
                System.out.println("Введите имю для поиска: ");
                firstName=sc.nextLine();
                searchByName(firstName);
            }else if (text.equals(Instructions.SEARCH_BY_FAMILY.getInstField())){
                System.out.println("Введите фамилию для поиска: ");
                lastName= sc.nextLine();
                searchByFamily(lastName);
            }else if (text.equals(Instructions.SEARCH_BY_POSITION.getInstField())){
                System.out.println("Введите должность для поиска: ");
                postion= sc.nextLine();
                searchByPosition(postion);
            }else System.out.println("Ничего не найдено :(");

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
        System.out.println("Для выхода введите: exit");
        while (true){
            firstName="";
            System.out.println("Введите имя сотрудника: ");
            firstName = sc.nextLine();
            if (firstName.equals(Instructions.EXIT.getInstField())){go();}
            if (firstName.isEmpty()){
                continue;
            }

            System.out.println("Введите фамилию сотрудника: ");
            lastName = sc.nextLine();
            if (lastName.equals(Instructions.EXIT.getInstField())){go();}
            if (lastName.isEmpty()){
                continue;
            }


            System.out.println();

            System.out.print("Должности в компании: ");
            WorkerPositions[] arr = WorkerPositions.values();
            for (int i = 0; i <arr.length; i++) {
                System.out.print(WorkerPositions.values()[i].getPosition()+", ");
            }
            System.out.println();
            System.out.println();
            System.out.println("Введите должность сотрудника: ");
            postion = sc.nextLine();
            if (postion.equals(Instructions.EXIT.getInstField())){go();}
            if (!checkPosition(postion)){
                System.out.println("Вы ввели НЕкорректный должность!");
                continue;
            }

            System.out.println("Введите зарплату сотрудника: ");

                try {
                   salary = sc.nextDouble();
                }catch (Exception e){
                    System.out.println("Введите корректное число");
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


}
