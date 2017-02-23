package com.afg.MngProductContentProvider.Services;

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

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.afg.MngProductContentProvider.Fragments.Home_Fragment;
import com.afg.MngProductContentProvider.Presenter.HomeFragmentPresenter;
import com.afg.MngProductContentProvider.Presenter.InvoicePresenter;
import com.afg.MngProductContentProvider.interfaces.IInvoicePresenter;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class InvoiceService extends IntentService {



    public InvoiceService() {
        super("service");
        ;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Home_Fragment.getPresenter().getAllInvoices();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {

        int x = 0;

        super.onDestroy();

    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
