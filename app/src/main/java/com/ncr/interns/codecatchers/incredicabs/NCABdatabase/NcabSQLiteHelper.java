package com.ncr.interns.codecatchers.incredicabs.NCABdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by gs250365 on 3/12/2018.
 */

public class NcabSQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "NCABDatabase";
    private static final int DB_VERSION = 4;
    Context ctx;
    SQLiteDatabase sqLiteDatabase;
    private static final String TAG = "NcabSQLiteHelper";
    private final String CREATE_EMPLOYEE_TABLE_QUERY = "CREATE TABLE "+EmployeeContract.DB_TABLE+
            " ("+EmployeeContract._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            EmployeeContract.COLUMN_EMP_QLID+" TEXT NOT NULL,"+
            EmployeeContract.COLUMN_FIRST_NAME+" TEXT NOT NULL,"+
            EmployeeContract.COLUMN_MIDDLE_NAME+" TEXT,"+
            EmployeeContract.COLUMN_LAST_NAME+" TEXT,"+
            EmployeeContract.COLUMN_CONTACT_NUMBER+" TEXT NOT NULL,"+
            EmployeeContract.COLUMN_EMERGENCY_CONTACT_NUMBER+" TEXT NOT NULL,"+
            EmployeeContract.COLUMN_HOME_ADDRESS+" TEXT NOT NULL,"+
            EmployeeContract.COLUMN_OFFICE_ADDRESS+" TEXT NOT NULL,"+
            EmployeeContract.COLUMN_LEVEL_1_MANAGER+" TEXT NOT NULL,"+
            EmployeeContract.COLUMN_LEVEL_1_MANAGER_NAME+" TEXT NOT NULL,"+
            EmployeeContract.COLUMN_LEVEL_2_MANAGER_NAME+" TEXT NOT NULL,"+
            EmployeeContract.COLUMN_LEVEL_2_MANAGER+" TEXT NOT NULL,"+
            EmployeeContract.COLUMN_EMP_ROLE+" INTEGER NOT NULL,"+
            EmployeeContract.COLUMN_EMP_REFERESHED_TOKEN+" TEXT);";


    private final String CREATE_CABMATE_TABLE_QUERY = "CREATE TABLE "+CabMatesContract.DB_TABLE+" ("+
            CabMatesContract._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            CabMatesContract.COLUMN_CABMATE_QLID+" TEXT,"+
            CabMatesContract.COLUMN_CABMATE_NAME+" TEXT,"+
            CabMatesContract.COLUMN_CABMATE_CONTACT_NUMBER+" TEXT,"+
            CabMatesContract.COLUMN_CABMATE_PICKUPTIME+" TEXT ,"+
            CabMatesContract.COLUMN_CABMATE_ROUTE_NUMBER+" TEXT,"+
            CabMatesContract.COLUMN_CABMATE_CAB_NUMBER+" TEXT,"+
            CabMatesContract.COLUMN_CABMATE_ROASTER_Id+ " TEXT,"+
            CabMatesContract.COLUMN_CABMATE_SHIFT_ID+" TEXT,"+
            CabMatesContract.COLUMN_CABMATE_ADDRESS+" TEXT);";

    private static final String CREATE_SHIFT_TABLE_QUERY = "CREATE TABLE "+ShiftContract.DB_TABLE+" ("+
            ShiftContract._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            ShiftContract.COLUMN_SHIFT_ID+" INTEGER ,"+
            ShiftContract.COLUMN_SHIFT_NAME+" TEXT ,"+
            ShiftContract.COLUMN_START_TIME+" TEXT ,"+
            ShiftContract.COLUMN_END_TIME+" TEXT );";

    private static final String CREATE_TABLE_CONTACTS_QUERTY = "CREATE TABLE "+ContactsContract.DB_TABLE+" ("+
            ContactsContract._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            ContactsContract.COLUMN_CONTACT_ID+" TEXT NOT NULL,"+
            ContactsContract.COLUMN_CONTACT_NAME+" TEXT NOT NULL,"+
            ContactsContract.COLUMN_CONTACT_SOS+" TEXT NOT NULL,"+
            ContactsContract.COLUMN_CONTACT_NUMBER+" TEXT NOT NULL,"+
            ContactsContract.COLUMN_CONTACT_SOS_PRIORITY+" TEXT NOT NULL,"+
            ContactsContract.COLUMN_CONTACT_ROLE+" TEXT NOT NULL);";


    public NcabSQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Employee Table in SQlite Database
        db.execSQL(CREATE_EMPLOYEE_TABLE_QUERY);
        db.execSQL(CREATE_CABMATE_TABLE_QUERY);
        db.execSQL(CREATE_SHIFT_TABLE_QUERY);
        db.execSQL(CREATE_TABLE_CONTACTS_QUERTY);

        Log.i(TAG, "onCreate: Table Created ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+EmployeeContract.DB_TABLE);
    }
}
