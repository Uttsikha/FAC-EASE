package com.example.android.facease;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.facease.entry.helper;

import java.util.ArrayList;

import static com.example.android.facease.entry.pentry.feeentry.FS_NAME;
import static com.example.android.facease.entry.pentry.feeentry.FS_QTY;
import static com.example.android.facease.entry.pentry.feeentry.FS_TABLE;
import static com.example.android.facease.entry.pentry.feeentry.FS_UNIT;
import static com.example.android.facease.entry.pentry.proentry.PS_NAME;
import static com.example.android.facease.entry.pentry.proentry.PS_QTY;
import static com.example.android.facease.entry.pentry.proentry.PS_TABLE;
import static com.example.android.facease.entry.pentry.proentry.PS_UNIT;

public class Storehouse extends AppCompatActivity {
    private helper mdhelper1;
    ArrayList<String> NAME_ArrayList = new ArrayList<String>();
    ArrayList<String> QTY_ArrayList = new ArrayList<String>();
    ArrayList<String> Unit_ArrayList = new ArrayList<String>();
    ListView LISTVIEW;

    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    listview22 ListAdapter1 ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storehouse);
        LISTVIEW = (ListView) findViewById(R.id.listView4);

        mdhelper1 = new helper(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        display();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }
    private void ShowSQLiteDBdata() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);
        return true;
    }
    private void display() {
        SQLITEDATABASE = mdhelper1.getWritableDatabase();

        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM "+PS_TABLE, null);

        NAME_ArrayList.clear();
        QTY_ArrayList.clear();
        Unit_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {

                NAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(PS_NAME)));

                QTY_ArrayList.add(cursor.getString(cursor.getColumnIndex(PS_QTY)));

                Unit_ArrayList.add(cursor.getString(cursor.getColumnIndex(PS_UNIT)));

            } while (cursor.moveToNext());
        }


        ListAdapter1 = new listview22(Storehouse.this,

                NAME_ArrayList,
                QTY_ArrayList,
                Unit_ArrayList

        );

        LISTVIEW.setAdapter(ListAdapter1);

        cursor.close();


    }

}
