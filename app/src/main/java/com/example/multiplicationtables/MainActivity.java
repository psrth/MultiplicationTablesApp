package com.example.multiplicationtables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView myListView;
    ArrayList<String> multTable;

    public void updateListView (int i)
    {


        multTable.add(Integer.toString(i*1));
        multTable.add(Integer.toString(i*2));
        multTable.add(Integer.toString(i*3));
        multTable.add(Integer.toString(i*4));
        multTable.add(Integer.toString(i*5));
        multTable.add(Integer.toString(i*6));
        multTable.add(Integer.toString(i*7));
        multTable.add(Integer.toString(i*8));
        multTable.add(Integer.toString(i*9));
        multTable.add(Integer.toString(i*10));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, multTable);
        myListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar numberSeekBar = (SeekBar) findViewById(R.id.seekBar);
        numberSeekBar.setMax(10);

        myListView = (ListView) findViewById(R.id.listView);
        multTable = new ArrayList<String>();

        numberSeekBar.setProgress(2);
        updateListView(2);


        numberSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                multTable.clear();
                updateListView(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }
}
