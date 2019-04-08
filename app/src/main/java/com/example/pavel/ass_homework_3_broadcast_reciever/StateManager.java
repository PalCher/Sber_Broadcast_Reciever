package com.example.pavel.ass_homework_3_broadcast_reciever;

public class StateManager {
    private static final StateManager ourInstance = new StateManager();

    public static StateManager getInstance() {
        return ourInstance;
    }


    private enum State {
        A, B, C, D, E
    }

    private String currentState;

    private StateManager() {
        currentState = "";
    }

    public String getCurrentState() {
        return currentState;
    }

    public void changeState(){
        switch (currentState){
            case "": currentState = State.A.toString();
            break;
            case "A": currentState = State.B.toString();
                break;
            case "B": currentState = State.C.toString();
                break;
            case "C": currentState = State.D.toString();
                break;
            case "D": currentState = State.E.toString();
                break;
            case "E": currentState = State.A.toString();
                break;
        }
    }


}
