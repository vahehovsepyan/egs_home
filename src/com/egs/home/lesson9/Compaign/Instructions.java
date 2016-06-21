package com.egs.home.lesson9.Compaign;

import java.util.HashMap;


/**
 * Created by vahe on 15.06.16.
 */
public enum Instructions {

    EXIT("exit"),
    ADD_EMPLOYER("add"),
    COMPAIR("compair"),
    ALL_EMPLOYERS("all"),
    OUT("out"),
    CLEAR("clear"),
    SAVE("save"),
    OPEN("open"),

    //поиск
    SEARCH_EMPLOYER("search"),
    SEARCH_BY_NAME("name"),
    SEARCH_BY_FAMILY("family"),
    SEARCH_BY_POSITION("position"),

    //языки
    EN("en"),
    RUS("ru"),
    ARM("arm"),

    //properties keys
    NOTHING_FIND,
    INPUT,
    INPUT_NAME,
    INPUT_FAMILY,
    INPUT_POSITION,
    INPUT_SALARY,
    POSITIONS_IN_COMPANY;

    private static final HashMap<String ,Instructions> instructions = new HashMap<String, Instructions>();

    static {
        for (Instructions co:values()){
            instructions.put(co.getInstField(),co);
        }
    }

    private String instField;


    Instructions() {

    }

    public String getInstField() {
        return instField;
    }

    Instructions(String instField) {
        this.instField = instField;
    }

    public static Instructions getByInstructionName(String instructionName) {

        return instructions.get(instructionName);

    }


}
