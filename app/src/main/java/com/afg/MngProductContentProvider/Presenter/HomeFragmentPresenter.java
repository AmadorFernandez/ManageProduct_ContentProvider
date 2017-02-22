package com.afg.MngProductContentProvider.Presenter;

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

import android.app.Activity;
import android.app.LoaderManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;


import com.afg.MngProductContentProvider.Fragments.Home_Fragment;
import com.afg.MngProductContentProvider.Home_Activity;
import com.afg.MngProductContentProvider.R;
import com.afg.MngProductContentProvider.database.DataBaseContract;
import com.afg.MngProductContentProvider.interfaces.IInvoicePresenter;
import com.afg.MngProductContentProvider.provider.ManageProductContract;

/**
 * Created by amador on 22/02/17.
 */

public class HomeFragmentPresenter implements IInvoicePresenter, LoaderManager.LoaderCallbacks<Cursor> {

    public static final int INVOICE = 4;

    private IInvoicePresenter.View view;


    public HomeFragmentPresenter(IInvoicePresenter.View view){

        this.view = view;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        int x = 0;
        return new CursorLoader(view.getContext(), ContentUris.withAppendedId(ManageProductContract.Invoice.CONTENT_URI, 1),
                ManageProductContract.Invoice.PROJECTIONS, DataBaseContract.InvoiceEntry.IN_PHARMACY_JOIN_PHARMACY, null,
                DataBaseContract.InvoiceEntry.DEFAULT_SORT);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if(cursor.getCount() > 0){

            throwNotification(cursor.getCount());
        }

        view.setCursorCategory(cursor);
        cursor.setNotificationUri(view.getContext().getContentResolver(), ManageProductContract.Invoice.CONTENT_URI);
    }

    private void throwNotification(int count) {


        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(view.getContext())
                        .setSmallIcon(android.R.drawable.btn_dialog)
                        .setLargeIcon((((BitmapDrawable)view.getContext()
                                .getDrawable(android.R.drawable.stat_notify_more)).getBitmap()))
                        .setContentTitle("Aviso QUILLOOO!")
                        .setContentText("Hay "+String.valueOf(count)+" pedidos que llevan más de dos días sin ser entregados")
                        .setTicker("Mirameeeeee");

        Intent intent = new Intent(view.getContext(), Home_Activity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(view.getContext(),0, intent,0 );
        mBuilder.setContentIntent(pendingIntent);
        ((NotificationManager)view.getContext().getSystemService(Context.NOTIFICATION_SERVICE)).notify(0, mBuilder.build());
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        view.setCursorCategory(null);
    }

    @Override
    public void getAllInvoices() {

        ((Activity)view.getContext()).getLoaderManager().initLoader(INVOICE, null, this);
    }
}
