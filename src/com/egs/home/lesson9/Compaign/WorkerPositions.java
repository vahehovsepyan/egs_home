package com.egs.home.lesson9.Compaign;

import java.util.HashMap;

public enum  WorkerPositions {
    BOSS("boss",0),
    TEAM_LEADER("leader",1),
    SENIOR_DEVELOPER("senior",2),
    JUNIOR_DEVELOPER("junior",3),
    INTERN("intern",4);

    private String position;
    private int priorityOfWork;
    private static HashMap<String,Integer> workerpositions= new HashMap<>();
    
    static {
        for (WorkerPositions workers :
                values()) {
            workerpositions.put(workers.getPosition(),workers.getPriorityOfWork());
        }
    }

    public static int getByWorkerPriority(String position){
        return workerpositions.get(position);
    }


    WorkerPositions(String position,int i) {
        this.position=position;
        this.priorityOfWork=i;
    }

    public int getPriorityOfWork() {
        return priorityOfWork;
    }

    public String getPosition() {
        return position;
    }


}
