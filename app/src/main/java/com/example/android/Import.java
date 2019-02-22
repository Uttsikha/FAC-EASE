package com.example.android;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.facease.R;
import com.example.android.facease.entry.helper;

import static com.example.android.facease.entry.pentry.feeentry.FS_NAME;
import static com.example.android.facease.entry.pentry.feeentry.FS_QTY;
import static com.example.android.facease.entry.pentry.feeentry.FS_TABLE;

public class Import extends AppCompatActivity {

    SQLiteDatabase SQLITEDATABASE;

    Cursor cursor;
    private helper mdhelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import);

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        mdhelper2 = new helper(this);

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        Button bi = (Button) findViewById(R.id.PA);
        bi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                import123();
            }

        });
    }

    private void import123() {
        ContentValues import1 = new ContentValues();

        EditText in1 = (EditText) findViewById(R.id.IN);
        EditText in3 = (EditText) findViewById(R.id.PQ);
        String iname = in1.getText().toString().trim();
        String iq = in3.getText().toString().trim();
        int in2 = Integer.parseInt(iq);


        SQLITEDATABASE = mdhelper2.getWritableDatabase();
        cursor = SQLITEDATABASE.rawQuery("SELECT feedstock_name FROM " + FS_TABLE, null);
           // if (cursor.getString(j).equals(iname)) {
/*                if (cursor.moveToFirst()) {
                    do {


                        Toast.makeText(this, "editor_insert_pet_failed",
                                Toast.LENGTH_SHORT).show();
                    }  while (cursor.moveToNext());

            }

      else {
                // Otherwise, the insertion was successful and we can display a toast.
                Toast.makeText(this, "Feedstock does not exist",
                        Toast.LENGTH_SHORT).show();
            }
*/


//        import1.put(FS_QTY, iq);


        }
    }



