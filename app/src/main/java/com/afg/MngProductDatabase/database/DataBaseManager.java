package com.afg.MngProductDatabase.database;


import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.afg.MngProductDatabase.Model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 23/01/17.
 */

public class DataBaseManager {


    private static DataBaseManager instance;


    public static DataBaseManager getInstance(){

        if(instance == null){

            instance = new DataBaseManager();
        }

        return instance;
    }

    private DataBaseManager(){


    }

    public void updateProduct(Product product){

        

    }

    public boolean add(Product p){

        boolean result = false;
        ContentValues params = new ContentValues();
        SQLiteDatabase database = DataBaseHelper.getInstance().getWritableDatabase();
        params.put(ManageProductContract.ProductEntry.COLUMN_NAME, p.getName());
        params.put(ManageProductContract.ProductEntry.COLUMN_BRAND, p.getBrand());
        params.put(ManageProductContract.ProductEntry.COLUMN_CATEGORY, p.getIdCategory());
        params.put(ManageProductContract.ProductEntry.COLUMN_DESCRIPTION, p.getDescription());
        params.put(ManageProductContract.ProductEntry.COLUMN_DOSAGE, p.getDosage());
        params.put(ManageProductContract.ProductEntry.COLUMN_IMAGE, p.getImage());
        params.put(ManageProductContract.ProductEntry.COLUMN_PRICE, p.getPrice());
        params.put(ManageProductContract.ProductEntry.COLUMN_STOCK, p.getStock());
        long id = database.insert(ManageProductContract.ProductEntry.TABLE_NAME,null, params);

        if(id != -1){

            p.setID(id);
            result = true;
        }

        DataBaseHelper.getInstance().closeDataBase();
        return result;
    }

    public List<Product> getProducts(){
        return null;
    }

    public  void deleteProduct(Product product){

    }
}
