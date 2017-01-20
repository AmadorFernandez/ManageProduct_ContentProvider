package com.jsw.MngProductDatabase;


import android.app.Application;

import com.jsw.MngProductDatabase.database.DataBaseHelper;

/**
 * Created by usuario on 20/01/17.
 */

public class ManageProductApplications extends Application {




    @Override
    public void onCreate() {
        super.onCreate();
        DataBaseHelper.getInstance(this).open();

    }
}
