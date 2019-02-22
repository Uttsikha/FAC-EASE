package com.example.android.facease.entry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by uttsikha on 11/28/2017.
 */
    public class helper extends SQLiteOpenHelper {
        public static final String DB_NAME="Fease.db";
        public static final int DB_VERSION=1;
        public helper(Context context)
        {
            super(context, DB_NAME,null,DB_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String SQL_CREATE_ENTRIES =
                    "CREATE TABLE " + pentry.feeentry.FS_TABLE + " (" +
                            pentry.feeentry.FS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                            pentry.feeentry.FS_FID + " INTEGER NOT NULL," +
                            pentry.feeentry.FS_NAME + " TEXT," +
                            pentry.feeentry.FS_QTY + " INTEGER NOT NULL DEFAULT 0," +
                            pentry.feeentry.FS_AQTY + " INTEGER," +
                            pentry.feeentry.FS_UNIT + " TEXT)";

            String SQL_CREATE_ENTRIES1 =
                    "CREATE TABLE " + pentry.proentry.PS_TABLE + " (" +
                            pentry.proentry.PS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                            pentry.proentry.PS_PID + " INTEGER NOT NULL," +
                            pentry.proentry.PS_NAME + " TEXT," +
                            pentry.proentry.PS_QTY + " INTEGER NOT NULL DEFAULT 0," +
                            pentry.proentry.PS_AQTY + " INTEGER," +
                            pentry.proentry.PS_UNIT + " TEXT)";
            db.execSQL(SQL_CREATE_ENTRIES);
            db.execSQL(SQL_CREATE_ENTRIES1);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

