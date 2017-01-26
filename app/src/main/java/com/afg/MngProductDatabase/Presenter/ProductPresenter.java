package com.afg.MngProductDatabase.Presenter;

/*
 * Copyright (c) 2016 José Luis del Pino Gallardo.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  jose.gallardo994@gmail.com
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;

import com.afg.MngProductDatabase.Model.Product;
import com.afg.MngProductDatabase.database.DataBaseManager;
import com.afg.MngProductDatabase.interfaces.IProductPresenter;

import static com.afg.MngProductDatabase.ManageProductApplications.context;

/**
 * Created by usuario on 9/12/16.
 */

public class ProductPresenter implements IProductPresenter{

    View view;

    public ProductPresenter(IProductPresenter.View Vista){
        this.view = Vista;
    }

    /*

    @Override
    public void loadProducts() {
        if(DataBaseManager.getInstance().getProducts().isEmpty())
            view.showEmptyState(true);
        else
            view.showProduct();
    }

    */

    public void loadProducts(){
       new AsyncSqlite().execute();
    }

    @Override
    public Product getProduct(int id) {
        return DataBaseManager.getInstance().getProducts().get(id);
    }

    @Override
    public void deleteProduct(Product product) {
        DataBaseManager.getInstance().deleteProduct(product);
        //Vuelve a cargar los productos y actualiza los productos.
        view.showMessage("Product Delete", product);
        loadProducts();
    }



    public void addProduct(Product product){
        DataBaseManager.getInstance().add(product);
        view.showProduct();
    }

    public void updateProduct(Product newProduct){

        DataBaseManager.getInstance().updateProduct(newProduct);
        view.showProduct();
       // this.addProduct(newProduct);
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

  public  class AsyncSqlite extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            if(!isCancelled()) {

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (DataBaseManager.getInstance().getProducts().isEmpty())
                    view.showEmptyState(true);
                else
                    view.showProduct();
            }

            return null;
        }




    }
}
