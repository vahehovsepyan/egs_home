package com.egs.home.lesson9.Compaign;

import java.util.Scanner;

public class Search {
    private String firstName;
    private String lastName;
    private String postion;
    Scanner sc = new Scanner(System.in);
    Instructions ins;
    Prop languageProps;
    //поиск сотрудников
    public void search(){

        Compaign.logger.info("блок поиска сотрудников");
        String text;
        System.out.println();
        System.out.println(Prop.languageCheck(Instructions.SEARCH_BY_NAME.toString())+" "+Instructions.SEARCH_BY_NAME.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.SEARCH_BY_FAMILY.toString())+" "+Instructions.SEARCH_BY_FAMILY.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.SEARCH_BY_POSITION.toString())+" "+Instructions.SEARCH_BY_POSITION.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.OUT.getInstField())+Instructions.OUT.getInstField());

        while (true){
            text=sc.nextLine();

            ins = Instructions.getByInstructionName(text);
            switch (ins){
                case EXIT:break;
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
        for (Employer emp :
                Compaign.employers) {
            if (emp.getFirstName().equals(text)){
                System.out.println(" "+emp.getFirstName()+"" +
                        " "+emp.getLastName()+"" +
                        " "+WorkerPositions.values()[emp.getpositonNumber()]+" "+emp.getSalary()+"$");
            }
        }
        search();
    }
    //поиск сотрудников по фамилии
    private void searchByFamily(String text){
        for (Employer emp :
                Compaign.employers) {
            if (emp.getLastName().equals(text)){
                System.out.println(" "+emp.getFirstName()+"" +
                        " "+emp.getLastName()+"" +
                        " "+WorkerPositions.values()[emp.getpositonNumber()]+"" +
                        " "+emp.getSalary()+"$");
            }
        }
        search();
    }
    //поиск сотрудников по должности
    private void searchByPosition(String text){
        for (Employer emp :
                Compaign.employers) {
            if (emp.getpositonNumber()==WorkerPositions.getByWorkerPriority(text)){
                System.out.println(" "+emp.getFirstName()+"" +
                        " "+emp.getLastName()+"" +
                        " "+WorkerPositions.getByWorkerPriority(text)+"" +
                        " "+emp.getSalary()+"$");
            }
        }
        search();
    }
}
