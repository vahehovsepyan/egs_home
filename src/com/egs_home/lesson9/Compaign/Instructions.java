package com.egs_home.lesson9.Compaign;

import java.util.HashMap;


/**
 * Created by vahe on 15.06.16.
 */
public enum Instructions {

    EXIT("exit"),
    ADD_EMPLOYER("add"),
    COMPAIR("compair"),
    ALL_EMPLOYERS("all"),

    //поиск
    SEARCH_EMPLOYER("search"),
    SEARCH_BY_NAME("name"),
    SEARCH_BY_FAMILY("family"),
    SEARCH_BY_POSITION("position"),

    //языки
    EN("en"),
    RUS("ru"),
    ARM("arm");


    private static final HashMap<String ,Instructions> instructions = new HashMap<String, Instructions>();

    static {
        for (Instructions co:values()){
            instructions.put(co.getInstField(),co);
        }
    }

    private String instField;

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
