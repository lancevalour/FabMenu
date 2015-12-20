package com.zyceeit.android.fabmenu.sample;

import android.app.Activity;
import android.os.Bundle;

import com.zyceeit.android.fabmenu.FabMenu;

/**
 * Created by ZhangY on 12/18/2015.
 */
public class MainActivity extends Activity{

    FabMenu fabMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiateComponents();
        setComponentControl();

    }

    private void initiateComponents(){
        fabMenu = (FabMenu) findViewById(R.id.fabMenu);

    }

    private void setComponentControl(){

    }



}
