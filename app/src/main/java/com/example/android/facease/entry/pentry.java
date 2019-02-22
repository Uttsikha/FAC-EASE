package com.example.android.facease.entry;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by uttsikha on 11/28/2017.
 */

public final class pentry {


        private pentry() {
        }
    public static final String CONTENT_AUTHORITY = "com.example.android.facease";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_DATA = "feedstock";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_DATA);
    /**
     * The MIME type of the {@link #CONTENT_URI} for a list of pets.
     */
    public static final String CONTENT_LIST_TYPE =
            ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DATA;

    /**
     * The MIME type of the {@link #CONTENT_URI} for a single pet.
     */
    public static final String CONTENT_ITEM_TYPE =
            ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DATA;



    public static final String CONTENT_AUTHORITY1 = "com.example.android.facease";
    public static final Uri BASE_CONTENT_URI1 = Uri.parse("content://" + CONTENT_AUTHORITY1);

    public static final String PATH_DATA1 = "product";

    public static final Uri CONTENT_URI1 = Uri.withAppendedPath(BASE_CONTENT_URI1, PATH_DATA1);
    /**
     * The MIME type of the {@link #CONTENT_URI} for a list of pets.
     */
    public static final String CONTENT_LIST_TYPE1 =
            ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY1 + "/" + PATH_DATA1;

    /**
     * The MIME type of the {@link #CONTENT_URI} for a single pet.
     */
    public static final String CONTENT_ITEM_TYPE1 =
            ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY1 + "/" + PATH_DATA1;

    public static final class feeentry implements BaseColumns {
            public final static String FS_TABLE = "feedstock";
            public final static String FS_NAME = "feedstock_name";
            public final static String FS_QTY = "f_quantity";
            public final static String FS_UNIT = "f_unit";
            public final static String FS_ID = BaseColumns._ID;
            public final static String FS_FID = "feedstock_id";
            public final static String FS_AQTY = "f_alert_qty";
        }

        public static final class proentry implements BaseColumns {
            public final static String PS_TABLE = "product";
            public final static String PS_NAME = "product_name";
            public final static String PS_QTY = "p_quantity";
            public final static String PS_UNIT = "p_unit";
            public final static String PS_ID = BaseColumns._ID;
            public final static String PS_PID = "product_id";
            public final static String PS_AQTY = "p_alert_qty";

        }

    }


