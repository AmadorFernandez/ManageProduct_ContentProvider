package com.afg.MngProductContentProvider.Fragments;


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

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.afg.MngProductContentProvider.Adapter.ListInvoiceAdapter;
import com.afg.MngProductContentProvider.Presenter.HomeFragmentPresenter;
import com.afg.MngProductContentProvider.Presenter.InvoicePresenter;
import com.afg.MngProductContentProvider.R;
import com.afg.MngProductContentProvider.interfaces.IInvoicePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment implements IInvoicePresenter.View
{

    private HomeFragmentPresenter presenter;
    private ListView listView;
    private ListInvoiceAdapter adapter;

    public Home_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        listView = (ListView)rootView.findViewById(R.id.listInvoiceActive);
        presenter = new HomeFragmentPresenter(this);
        adapter = new ListInvoiceAdapter(getContext());
        listView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getAllInvoices();
    }

    @Override
    public void setCursorCategory(Cursor cursor) {

        adapter.swapCursor(cursor);
    }
}
