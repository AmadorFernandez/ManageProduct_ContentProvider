package com.jsw.MngProductDatabase.database;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * Created by usuario on 20/01/17.
 */

public final class DataBaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ManageProduct.db";
    private Context context;
    private static volatile DataBaseHelper instance;

    public synchronized static DataBaseHelper getInstance(Context context){

            if(instance == null){

                instance = new DataBaseHelper(context
                        .getApplicationContext());
            }

        return instance;
    }


    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;


    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if(!db.isReadOnly()){

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){

                db.setForeignKeyConstraintsEnabled(true);

            }else {

                db.execSQL("PRAGMA foreign_keys = ON");
            }

        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(ManageProductContract.CategoryEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(ManageProductContract.ProductEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(ManageProductContract.PharmacyEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(ManageProductContract.StatusEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(ManageProductContract.InvoiceEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(ManageProductContract.InvoiceLineEntry.SQL_CREATE_ENTRIES);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, newVersion, oldVersion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(ManageProductContract.CategoryEntry.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(ManageProductContract.ProductEntry.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(ManageProductContract.PharmacyEntry.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(ManageProductContract.StatusEntry.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(ManageProductContract.InvoiceEntry.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(ManageProductContract.InvoiceLineEntry.SQL_DELETE_ENTRIES);
    }

    public SQLiteDatabase open(){

        return getWritableDatabase();
    }
}
