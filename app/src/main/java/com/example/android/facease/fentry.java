package com.example.android.facease;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.facease.entry.helper;

import static android.app.ProgressDialog.show;
import static com.example.android.facease.entry.pentry.CONTENT_URI;
import static com.example.android.facease.entry.pentry.CONTENT_URI1;
import static com.example.android.facease.entry.pentry.feeentry.FS_AQTY;
import static com.example.android.facease.entry.pentry.feeentry.FS_FID;
import static com.example.android.facease.entry.pentry.feeentry.FS_ID;
import static com.example.android.facease.entry.pentry.feeentry.FS_NAME;
import static com.example.android.facease.entry.pentry.feeentry.FS_QTY;
import static com.example.android.facease.entry.pentry.feeentry.FS_TABLE;
import static com.example.android.facease.entry.pentry.feeentry.FS_UNIT;

public class fentry extends AppCompatActivity {
    private helper mhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fentry);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        Button b1=(Button) findViewById(R.id.FA);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert();


            }

});
    }

    private void insert() {
       // mhelper = new helper(this);
     //   SQLiteDatabase db = mhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        EditText fn1 = (EditText) findViewById(R.id.FN);
        EditText fn2 = (EditText) findViewById(R.id.FI);
        EditText fn3 = (EditText) findViewById(R.id.FQ);
        EditText fn4 = (EditText) findViewById(R.id.FU);
        EditText fn5 = (EditText) findViewById(R.id.FU2);
        String fname = fn1.getText().toString().trim();
        String fid = fn2.getText().toString().trim();
        int an1 = Integer.parseInt(fid);
        String fqty = fn3.getText().toString().trim();
        int an2 = Integer.parseInt(fqty);
        String qunit = fn4.getText().toString().trim();
        String faltqty = fn5.getText().toString().trim();
        int an3 = Integer.parseInt(faltqty);
        values.put(FS_NAME, fname);
        values.put(FS_QTY, an2);
        values.put(FS_UNIT, qunit);
        values.put(FS_FID, an1);

        values.put(FS_AQTY, an3);



      //  long newrowid = db.insert(FS_TABLE, null, values);
        Uri newUri = getContentResolver().insert(CONTENT_URI, values);
       if (newUri == null) {
            // If the new content URI is null, then there was an error with insertion.
            Toast.makeText(this, "editor_insert_pet_failed",
                    Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast.
            Toast.makeText(this, "editor_insert_pet_successful",
                    Toast.LENGTH_SHORT).show();
        }


       // Toast.makeText(this, "New feedstock added with id :"+ newrowid, Toast.LENGTH_SHORT).show();


    }
}