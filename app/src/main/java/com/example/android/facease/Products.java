
package com.example.android.facease;

        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.support.v4.view.MenuItemCompat;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.SearchView;
        import android.support.v7.widget.Toolbar;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;

        import com.example.android.facease.entry.helper;

        import java.util.ArrayList;

        import static com.example.android.facease.entry.pentry.CONTENT_URI;
        import static com.example.android.facease.entry.pentry.feeentry.FS_AQTY;
        import static com.example.android.facease.entry.pentry.feeentry.FS_FID;
        import static com.example.android.facease.entry.pentry.feeentry.FS_ID;
        import static com.example.android.facease.entry.pentry.feeentry.FS_NAME;
        import static com.example.android.facease.entry.pentry.feeentry.FS_QTY;
        import static com.example.android.facease.entry.pentry.feeentry.FS_TABLE;
        import static com.example.android.facease.entry.pentry.feeentry.FS_UNIT;
        import static com.example.android.facease.entry.pentry.proentry.PS_AQTY;
        import static com.example.android.facease.entry.pentry.proentry.PS_ID;
        import static com.example.android.facease.entry.pentry.proentry.PS_NAME;
        import static com.example.android.facease.entry.pentry.proentry.PS_QTY;
        import static com.example.android.facease.entry.pentry.proentry.PS_TABLE;
        import static com.example.android.facease.entry.pentry.proentry.PS_UNIT;

public class Products extends AppCompatActivity {
    private helper mdhelper2;
    ArrayList<String> ID_ArrayList = new ArrayList<String>();
    ArrayList<String> NAME_ArrayList = new ArrayList<String>();
    ArrayList<String> QTY_ArrayList = new ArrayList<String>();
    ArrayList<String> Unit_ArrayList = new ArrayList<String>();
    ArrayList<String> Alt_ArrayList = new ArrayList<String>();
    ListView LISTVIEW;

    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    listview ListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        LISTVIEW = (ListView) findViewById(R.id.listView2);

        mdhelper2 = new helper(this);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        display2();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }

    private void ShowSQLiteDBdata() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);

        // Configure the search info and add any event listeners...

        return super.onCreateOptionsMenu(menu);
    }

    void add(MenuItem item) {
        Intent a2 = new Intent(this, pentry.class);
        startActivity(a2);
    }
     private void display2(){
         SQLITEDATABASE = mdhelper2.getWritableDatabase();

         cursor = SQLITEDATABASE.rawQuery("SELECT * FROM "+PS_TABLE, null);

    if (cursor.moveToFirst()) {
             do {
       /*
                 NAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(PS_NAME)));

                 QTY_ArrayList.add(cursor.getString(cursor.getColumnIndex(PS_QTY)));


*/                 Unit_ArrayList.add(cursor.getString(cursor.getColumnIndex(PS_UNIT)));
                 Alt_ArrayList.add(cursor.getString(cursor.getColumnIndex(PS_AQTY)));
                 ID_ArrayList.add(cursor.getString(cursor.getColumnIndex(PS_ID)));


                 NAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(PS_NAME)));

                 QTY_ArrayList.add(cursor.getString(cursor.getColumnIndex(PS_QTY)));

                 Unit_ArrayList.add(cursor.getString(cursor.getColumnIndex(PS_UNIT)));

             } while (cursor.moveToNext());
         }

         ListAdapter = new listview(Products.this,
                ID_ArrayList,
                 NAME_ArrayList,
                 QTY_ArrayList,
                 Unit_ArrayList,
                 Alt_ArrayList

         );

         LISTVIEW.setAdapter(ListAdapter);
         cursor.close();


     }
}
