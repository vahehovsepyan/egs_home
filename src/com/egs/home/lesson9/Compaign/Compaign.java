package com.egs.home.lesson9.Compaign;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Compaign {
    public static final  Logger logger = Logger.getLogger(Compaign.class.getName());

    private String firstName;
    private String lastName;
    private String postion;
    public static LinkedList<Employer> employers = new LinkedList<>();
    ReaderWriter readerWriter = new ReaderWriter();
    Search search = new Search();


    Prop languageProps;
    Instructions ins;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args)  {
        //тут говорим , чтобы не писал в консоле
        logger.setUseParentHandlers(false);
        FileHandler fh;
        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("/home/vahe/IdeaProjects/EGS_HOME/src/com/egs/home/lesson9/res/log.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File inputFile = new File("/home/vahe/IdeaProjects/EGS_HOME/src/com/egs/home/lesson9/res/logsConfig.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            ConfReader userhandler = new ConfReader();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Compaign compaign = new Compaign();
        compaign.languageChoose();
        logger.info("был запуск программы");
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
        logger.info("открыт главное меню ");
        String instruction;
        System.out.println(languageProps.languageCheck(Instructions.ADD_EMPLOYER.getInstField())+ Instructions.ADD_EMPLOYER.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.ALL_EMPLOYERS.getInstField())+ Instructions.ALL_EMPLOYERS.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.SEARCH_EMPLOYER.getInstField())+ Instructions.SEARCH_EMPLOYER.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.COMPAIR.getInstField())+Instructions.COMPAIR.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.CLEAR.getInstField())+Instructions.CLEAR.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.SAVE.getInstField())+Instructions.SAVE.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.OPEN.getInstField())+Instructions.OPEN.getInstField());
        System.out.println(languageProps.languageCheck(Instructions.EXIT.getInstField())+ Instructions.EXIT.getInstField());
        while (true){
            instruction=sc.nextLine();
            ins= Instructions.getByInstructionName(instruction);
            switch (ins){
                case ADD_EMPLOYER:addEmployer(); break;
                case ALL_EMPLOYERS:allEmployers();break;
                case SEARCH_EMPLOYER:search.search();break;
                case COMPAIR:compairByPosition();break;
                case SAVE:{readerWriter.writeEmployers();go();};break;
                case OPEN:{readerWriter.readEmployers();go();}break;
              //  case CLEAR:{clear();go();}break;
                case EXIT:break;
                default:System.out.println(languageProps.languageCheck(Instructions.INPUT.toString()));
            }
        }
    }
    public void compairByPosition(){
        Collections.sort(employers,integerComparator);
        allEmployers();
        logger.info("была сортировка сотрудников");
    }

    Comparator<Employer> integerComparator = new Comparator<Employer>() {
        @Override
        public int compare(Employer o1, Employer o2) {
            return o1.getpositonNumber()-o2.getpositonNumber();
        }
    };

    //список всех сотрудников
    private void allEmployers(){
        for (Employer emp :
                Compaign.employers) {
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
            System.out.println("");
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
            if (ConfReader.info){
                logger.info("был добавлен новый сотрудник");
            }
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