package com.afg.MngProductContentProvider.Adapter;

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

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.afg.MngProductContentProvider.Model.Product;
import com.afg.MngProductContentProvider.Presenter.ProductPresenter;
import com.afg.MngProductContentProvider.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by usuario on 18/11/16.
 */

public class ProductAdapter extends CursorAdapter {


    public ProductAdapter(Context context) {
        super(context, null, 0);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        View rootView = LayoutInflater.from(context).inflate(R.layout.item_product, null);



        return rootView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }


    class ProductHolder{
        ImageView img;
        TextView name;
        TextView stock;
        TextView precio;
    }
}
