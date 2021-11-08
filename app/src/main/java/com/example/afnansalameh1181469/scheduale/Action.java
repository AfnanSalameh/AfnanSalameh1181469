package com.example.afnansalameh1181469.scheduale;

public class Action {
    String descrpition;

    public Action() {
    }

    public Action(String descrpition) {
        this.descrpition = descrpition;
    }

    public String getDescrpition() {
        return descrpition;
    }

    public void setDescrpition(String descrpition) {
        this.descrpition = descrpition;
    }


    @Override
    public String toString() {
        return descrpition;

    }
}
