package com.example.afnansalameh1181469.scheduale;
import java.util.ArrayList;
import java.util.List;

public class ActionDa implements IActionDa{
    private ArrayList<Action> actions=new ArrayList<>();

    public ActionDa(){

        actions.add(new Action("Wakeup at 6Am"));
        actions.add(new Action("Take a run at 6:30-7:00 AM"));
        actions.add(new Action("Eat luch at 2:00 PM"));
        actions.add(new Action("Go to gym at 7:00 PM"));
        actions.add(new Action("Eat a meal full after the gym"));







    }


    public List<Action> getActions(){


        return actions;

    }


}
