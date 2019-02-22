package com.example.android.facease.entry;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import static com.example.android.facease.entry.pentry.feeentry.FS_AQTY;
import static com.example.android.facease.entry.pentry.feeentry.FS_ID;
import static com.example.android.facease.entry.pentry.feeentry.FS_NAME;
import static com.example.android.facease.entry.pentry.feeentry.FS_QTY;
import static com.example.android.facease.entry.pentry.feeentry.FS_TABLE;
import static com.example.android.facease.entry.pentry.proentry.PS_AQTY;
import static com.example.android.facease.entry.pentry.proentry.PS_ID;
import static com.example.android.facease.entry.pentry.proentry.PS_NAME;
import static com.example.android.facease.entry.pentry.proentry.PS_QTY;
import static com.example.android.facease.entry.pentry.proentry.PS_TABLE;

/**
 * Created by uttsikha on 1/27/2018.
 */

public class Provider1 extends ContentProvider {

    /** Tag for the log messages */
    public static final String LOG_TAG1 = Provider.class.getSimpleName();
    private helper  helperr1;
    private static final int DATA1 = 100;

    /** URI matcher code for the content URI for a single pet in the pets table */
    private static final int DATA_ID1= 101;

    /**
     * UriMatcher object to match a content URI to a corresponding code.
     * The input passed into the constructor represents the code to return for the root URI.
     * It's common to use NO_MATCH as the input for this case.
     */
    private static final UriMatcher sUriMatcher1 = new UriMatcher(UriMatcher.NO_MATCH);

    // Static initializer. This is run the first time anything is called from this class.
    static {
        // The calls to addURI() go here, for all of the content URI patterns that the provider
        // should recognize. All paths added to the UriMatcher have a corresponding code to return
        // when a match is found.
        sUriMatcher1.addURI(pentry.CONTENT_AUTHORITY1,pentry.PATH_DATA1,DATA1);
        sUriMatcher1.addURI(pentry.CONTENT_AUTHORITY1,pentry.PATH_DATA1+"/#",DATA_ID1);
    }       /* Initialize the provider and the database helper object*/
    @Override
    public boolean onCreate() {
        helperr1=new helper(getContext());
        // Make sure the variable is a global variable, so it can be referenced from other
        // ContentProvider methods.
        return true;
    }

    /**
     * Perform the query for the given URI. Use the given projection, selection, selection arguments, and sort order.
     */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        SQLiteDatabase database = helperr1.getReadableDatabase();
        // This cursor will hold the result of the query
        Cursor cursor1;

        // Figure out if the URI matcher can match the URI to a specific code
        int match = sUriMatcher1.match(uri);
        switch (match) {
            case DATA1:
                // For the PETS code, query the pets table directly with the given
                // projection, selection, selection arguments, and sort order. The cursor
                // could contain multiple rows of the pets table.
                cursor1 = database.query(PS_TABLE, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            case DATA_ID1:
                // For the PET_ID code, extract out the ID from the URI.
                // For an example URI such as "content://com.example.android.pets/pets/3",
                // the selection will be "_id=?" and the selection argument will be a
                // String array containing the actual ID of 3 in this case.
                //
                // For every "?" in the selection, we need to have an element in the selection
                // arguments that will fill in the "?". Since we have 1 question mark in the
                // selection, we have 1 String in the selection arguments' String array.
                selection = PS_ID +"=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };

                // This will perform a query on the pets table where the _id equals 3 to return a
                // Cursor containing that row of the table.
                cursor1 = database.query(PS_TABLE, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        return cursor1;
    }

    /**
     * Insert new data into the provider with the given ContentValues.
     */
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final int match = sUriMatcher1.match(uri);
        switch (match) {
            case DATA1:
                return insertData(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }
    /**
     * Insert a pet into the database with the given content values. Return the new content URI
     * for that specific row in the database.
     */
    private Uri insertData(Uri uri, ContentValues values) {
        String name = values.getAsString(PS_NAME);
        if (name == null) {
            throw new IllegalArgumentException("Product requires a name");
        }
        Integer qtty = values.getAsInteger(PS_QTY);
        if (qtty != null && qtty < 0) {
            throw new IllegalArgumentException("Product requires valid qty");
        }
        Integer qtty1 = values.getAsInteger(PS_AQTY);
        if (qtty1 != null && qtty1 < 0) {
            throw new IllegalArgumentException("Product requires valid aqty");
        }

        SQLiteDatabase database = helperr1.getWritableDatabase();

        // Insert the new pet with the given values
        long id = database.insert(PS_TABLE, null, values);
        // If the ID is -1, then the insertion failed. Log an error and return null.
        if (id == -1) {
            Log.e(LOG_TAG1, "Failed to insert row for " + uri);
            return null;
        }       // Once we know the ID of the new row in the table,
        // return the new URI with the ID appended to the end of it
        return ContentUris.withAppendedId(uri,id);
    }
    /**
     * Updates the data at the given selection and selection arguments, with the new ContentValues.
     */
    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {

        final int match = sUriMatcher1.match(uri);
        switch (match) {
            case DATA1:
                return updateData(uri, contentValues, selection, selectionArgs);
            case DATA_ID1:
                // For the PET_ID code, extract out the ID from the URI,
                // so we know which row to update. Selection will be "_id=?" and selection
                // arguments will be a String array containing the actual ID.
                selection = PS_ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return updateData(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Update is not supported for " + uri);
        }
    }
    private int updateData(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (values.containsKey(PS_NAME)) {
            String name = values.getAsString(PS_NAME);
            if (name == null) {
                throw new IllegalArgumentException("Product requires a name");
            }

        }
        // If the {@link PetEntry#COLUMN_PET_GENDER} key is present,
        // check that the gender value is valid.
        if (values.containsKey(PS_AQTY)) {
            Integer aaqt = values.getAsInteger(PS_AQTY);
            if (aaqt == null) {
                throw new IllegalArgumentException("Product requires valid AQTY");
            }
        }

        // If the {@link PetEntry#COLUMN_PET_WEIGHT} key is present,
        // check that the weight value is valid.
        if (values.containsKey(PS_QTY)) {
            // Check that the weight is greater than or equal to 0 kg
            Integer qt = values.getAsInteger(PS_QTY);
            if (qt != null && qt < 0) {
                throw new IllegalArgumentException("Product requires valid QTY");
            }
        }

        // No need to check the breed, any value is valid (including null).

        // If there are no values to update, then don't try to update the database
        if (values.size() == 0) {
            return 0;
        }

        // Otherwise, get writeable database to update the data
        SQLiteDatabase database = helperr1.getWritableDatabase();

        // Returns the number of database rows affected by the update statement
        return database.update(PS_TABLE, values, selection, selectionArgs);


    }
    /**
     * Delete the data at the given selection and selection arguments.
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Get writeable database
        SQLiteDatabase database = helperr1.getWritableDatabase();

        final int match = sUriMatcher1.match(uri);
        switch (match) {
            case DATA1:
                // Delete all rows that match the selection and selection args
                return database.delete(PS_TABLE, selection, selectionArgs);
            case DATA_ID1:
                // Delete a single row given by the ID in the URI
                selection = PS_ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                return database.delete(PS_TABLE, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Deletion is not supported for " + uri);
        }
    }
    /**
     * Returns the MIME type of data for the content URI.
     */
    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher1.match(uri);
        switch (match) {
            case DATA1:
                return pentry.CONTENT_LIST_TYPE1;
            case DATA_ID1:
                return pentry.CONTENT_ITEM_TYPE1;
            default:
                throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }

}
