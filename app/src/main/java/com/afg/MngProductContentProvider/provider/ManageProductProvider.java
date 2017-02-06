package com.afg.MngProductContentProvider.provider;

/*
 * Copyright (c) 2017 José Luis del Pino Gallardo.
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

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by usuario on 6/02/17.
 */

public class ManageProductProvider extends ContentProvider {

    private static final int PRODUCT = 1;
    private static final int PRODUCT_ID = 2;
    private static final int PHARMACY = 3;
    private static final int PHARMACY_ID = 4;
    private static final int INVOICE = 5;
    private static final int INVOICE_ID = 6;
    private static final int CATEGORY = 7;
    private static final int CATEGORY_ID = 8;
    private static final int INVOICELINE = 9;
    private static final int INVOICELINE_ID = 10;
    private static final int STATUS = 11;
    private static final int STATUS_ID = 12;

    private static final UriMatcher uriMacher = new UriMatcher(UriMatcher.NO_MATCH);

    static {

        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.Product.CONTENT_PATH, PRODUCT);
        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.Product.CONTENT_PATH+"/#", PRODUCT_ID);
        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.Pharmacy.CONTENT_PATH, PHARMACY);
        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.Pharmacy.CONTENT_PATH+"/#", PHARMACY_ID);
        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.Invoice.CONTENT_PATH, INVOICE);
        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.Invoice.CONTENT_PATH+"/#", INVOICE_ID);
        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.Category.CONTENT_PATH, CATEGORY);
        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.Category.CONTENT_PATH+"/#", CATEGORY_ID);
        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.InvoiceLine.CONTENT_PATH, INVOICELINE);
        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.InvoiceLine.CONTENT_PATH+"/#", INVOICELINE_ID);
        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.Status.CONTENT_PATH, STATUS);
        uriMacher.addURI(ManageProductContract.AUTHORITY, ManageProductContract.Status.CONTENT_PATH+"/#", STATUS_ID);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
