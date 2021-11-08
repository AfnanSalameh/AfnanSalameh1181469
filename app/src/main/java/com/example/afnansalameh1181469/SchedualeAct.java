package com.example.afnansalameh1181469;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.afnansalameh1181469.scheduale.*;


import java.util.List;

public class SchedualeAct extends AppCompatActivity {
    ArrayAdapter<Action> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduale);
        listView=findViewById(R.id.list);


        ActionFactory factory=new ActionFactory();
        IActionDa acti=factory.getModel();
        List<Action> actions=acti.getActions();


        adapter=new ArrayAdapter<Action>(this,
                android.R.layout.simple_list_item_1,
                actions);



        listView.setAdapter(adapter);





    }
}