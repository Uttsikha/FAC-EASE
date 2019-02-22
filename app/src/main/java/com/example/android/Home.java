package com.example.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.example.android.facease.Details;
import com.example.android.facease.R;
import com.example.android.facease.Reports;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notify, menu);
        return true;
    }



    void D(View view){
        Intent i3=new Intent(this, Details.class);
        startActivity(i3);
    }


    void R(View view){
        Intent i4=new Intent(this, Reports.class);
        startActivity(i4);}

    void I(View view){
        Intent i5=new Intent(this, Import.class);
        startActivity(i5);}
    void E(View view){
        Intent i6=new Intent(this, Export.class);
        startActivity(i6);}

}
