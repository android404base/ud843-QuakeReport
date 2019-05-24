/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_list);

        ArrayList<Earthquake> earthquakeArrayList = new ArrayList<Earthquake>();

        earthquakeArrayList.add(new Earthquake("8.2","Los Angeles","Aug 19, 2012"));
        earthquakeArrayList.add(new Earthquake("5.2","Bursa","Jun 11, 2014"));
        earthquakeArrayList.add(new Earthquake("6.5","California","May 03, 2010"));
        earthquakeArrayList.add(new Earthquake("7.1","Amsterdam","Apr 19, 2013"));
        earthquakeArrayList.add(new Earthquake("9.0","Lüksemburg","Jan 14, 2015"));
        earthquakeArrayList.add(new Earthquake("4.8","San Diago","Feb 11, 2011"));

        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this,R.layout.list_item,earthquakeArrayList,
                R.color.colorAccent);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(earthquakeAdapter);

    }
}
