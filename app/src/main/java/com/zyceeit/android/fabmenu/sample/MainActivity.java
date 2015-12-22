package com.zyceeit.android.fabmenu.sample;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.zyceeit.android.fabmenu.FabMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangY on 12/18/2015.
 */
public class MainActivity extends Activity {

    FabMenu fabMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiateComponents();
        setComponentControl();

    }

    private void initiateComponents() {
        fabMenu = (FabMenu) findViewById(R.id.fabMenu);
        fabMenu.addFab();
        fabMenu.addFab();
        fabMenu.addFab();
        fabMenu.addFab();

        fabMenu.setFabMenuBackgroundColor(Color.YELLOW);
        fabMenu.setFabMenuBackgroundDrawable(new IconicsDrawable(this.getBaseContext()).icon(GoogleMaterial.Icon.gmd_settings)
                .color(getResources().getColor(R.color.cardview_light_background)).sizeDp(6));

        fabMenu.setSubFabBackgroundColor(Color.BLUE);

        List<Drawable> drawableList = new ArrayList<>();
        drawableList.add(new IconicsDrawable(this.getBaseContext()).icon(GoogleMaterial.Icon.gmd_settings)
                .color(getResources().getColor(R.color.cardview_light_background)).sizeDp(6));
        drawableList.add(new IconicsDrawable(this.getBaseContext()).icon(GoogleMaterial.Icon.gmd_check)
                .color(getResources().getColor(R.color.cardview_light_background)).sizeDp(6));
        drawableList.add(new IconicsDrawable(this.getBaseContext()).icon(GoogleMaterial.Icon.gmd_search)
                .color(getResources().getColor(R.color.cardview_light_background)).sizeDp(6));
        drawableList.add(new IconicsDrawable(this.getBaseContext()).icon(GoogleMaterial.Icon.gmd_dashboard)
                .color(getResources().getColor(R.color.cardview_light_background)).sizeDp(6));


        fabMenu.setSubFabBackgroundDrawable(drawableList);


        // fabMenu.openMenu();

    }

    private void setComponentControl() {
        List<View.OnClickListener> onClickListenerList = new ArrayList<>();

        onClickListenerList.add(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "sub 1", Toast.LENGTH_SHORT).show();
                fabMenu.closeMenu();
            }
        });

        onClickListenerList.add(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "sub 2", Toast.LENGTH_SHORT).show();
                fabMenu.closeMenu();
            }
        });

        onClickListenerList.add(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "sub 3", Toast.LENGTH_SHORT).show();
                fabMenu.closeMenu();
            }
        });

   /*     onClickListenerList.add(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "sub 4", Toast.LENGTH_SHORT).show();
            }
        });
        onClickListenerList.add(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "sub 5", Toast.LENGTH_SHORT).show();
            }
        });
*/
        fabMenu.setSubFabOnClickListener(onClickListenerList);
    }


}