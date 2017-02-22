package com.theironyard.androidmanagecontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    EditText editTextual;
    EditText edyText;
    Button butone;
    ListView listly;
    ArrayAdapter<String> stuffs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextual = (EditText) findViewById(R.id.textName);
        edyText = (EditText) findViewById(R.id.textPhone);
        butone = (Button) findViewById(R.id.button);
        listly = (ListView) findViewById(R.id.listViewable);

        stuffs = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listly.setAdapter(stuffs);

        butone.setOnClickListener(this);
        listly.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String oldStuff = stuffs.getItem(position);
        stuffs.remove(oldStuff);
        return true;
    }

    @Override
    public void onClick(View scenery) {
        String newStuff = String.format("%s, %s", editTextual.getText().toString() , edyText.getText().toString());
        editTextual.setText("");
        edyText.setText("");

        stuffs.add(newStuff);
    }
}
