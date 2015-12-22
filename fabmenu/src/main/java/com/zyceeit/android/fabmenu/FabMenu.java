package com.zyceeit.android.fabmenu;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangY on 12/17/2015.
 */
public class FabMenu extends RelativeLayout {

    RelativeLayout fab_layout;

    List<FloatingActionButton> subFabList;

    boolean isSubFabVisible = false;

    Context context;

    private FloatingActionButton fab;

    int fabSizeInDP = 56;
    int subFabSizeInDP = 46;
    int radiusInDP = 80;
    int fabMarginInDP = 20;

    int fabSize;
    int subFabSize;
    int radius;
    int fabMargin;


    public FabMenu(Context context) {
        super(context);
        this.context = context;
        initiateViews();
        subFabList = new ArrayList<>();
    }


    public FabMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initiateViews();
        subFabList = new ArrayList<>();
    }

    public FabMenu(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs);
        this.context = context;
        initiateViews();
        subFabList = new ArrayList<>();
    }

    private void initiateViews() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        fab_layout = (RelativeLayout) findViewById(R.id.fab_layout);
        System.out.println("num of views " + fab_layout.getChildCount());

        fab = (FloatingActionButton) findViewById(R.id.fab);

        subFabSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, subFabSizeInDP, getResources().getDisplayMetrics());

        radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, radiusInDP, getResources().getDisplayMetrics());

        fabMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, fabMarginInDP, getResources().getDisplayMetrics());

        fabSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, fabSizeInDP, getResources().getDisplayMetrics());


        LayoutParams params = new LayoutParams(
                fabSize,
                fabSize
        );

        params.setMargins(0, 0, fabMargin, fabMargin);
        params.addRule(RelativeLayout.ALIGN_PARENT_END);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        fab.setLayoutParams(params);
        setFabMenuControl();
    }


    public void openMenu() {
        isSubFabVisible = true;
        setSubFabVisible(isSubFabVisible);


        //setAnimation();
    }

    public void closeMenu() {
        isSubFabVisible = false;
        setSubFabVisible(isSubFabVisible);

    }

    private void setSubFabVisible(boolean isSubFabVisible) {
        if (isSubFabVisible) {
            for (FloatingActionButton subFab : subFabList) {
                //  subFab.animate().translationX(-100);
                subFab.show();
            }
        } else {
            for (FloatingActionButton subFab : subFabList) {
                //  subFab.animate().translationX(100);
                subFab.hide();
            }
        }
    }

    private void setFabMenuControl() {
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSubFabVisible) {
                    closeMenu();
                } else {
                    openMenu();
                }
            }
        });
    }

    public void setSubFabOnClickListener(List<OnClickListener> onClickListenerList) {
        for (int i = 0; i < onClickListenerList.size(); i++) {
            subFabList.get(i).setOnClickListener(onClickListenerList.get(i));
        }
    }


    public void addFab() {
        int numOfSubFabs = this.fab_layout.getChildCount() - 1;

        if (numOfSubFabs == 0) {
            LayoutParams params = new LayoutParams(
                    subFabSize,
                    subFabSize
            );

            params.setMargins(0, 0, radius + fabMargin, fabMargin);
            params.addRule(RelativeLayout.ALIGN_PARENT_END);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

            FloatingActionButton subFab = new FloatingActionButton(getContext());
            subFab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.cardview_light_background)));
            this.fab_layout.addView(subFab, 1, params);
            this.subFabList.add(0, subFab);

        } else if (numOfSubFabs == 1) {
            LayoutParams params = new LayoutParams(
                    subFabSize,
                    subFabSize
            );

            params.setMargins(0, 0, fabMargin, radius + fabMargin);
            params.addRule(RelativeLayout.ALIGN_PARENT_END);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

            FloatingActionButton subFab = new FloatingActionButton(getContext());
            subFab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.cardview_light_background)));
            this.fab_layout.addView(subFab, 2, params);
            this.subFabList.add(1, subFab);

        } else {
            float degInterval = 90 / numOfSubFabs;

            for (int i = 0; i < numOfSubFabs - 2; i++) {
                this.fab_layout.removeViewAt(-i + numOfSubFabs);
                this.subFabList.remove(-i + numOfSubFabs - 1);
            }

            for (int i = 0; i < numOfSubFabs - 1; i++) {
                int marginX = (int) (radius * Math.cos(Math.toRadians(degInterval * (i + 1))));
                int marginY = (int) (radius * Math.sin(Math.toRadians(degInterval * (i + 1))));

                System.out.println(marginX);
                System.out.println(marginY);

                LayoutParams params = new LayoutParams(
                        subFabSize,
                        subFabSize
                );

                params.setMargins(0, 0, marginX + fabMargin, marginY + fabMargin);
                params.addRule(RelativeLayout.ALIGN_PARENT_END);
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

                FloatingActionButton subFab = new FloatingActionButton(getContext());
                subFab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.cardview_dark_background)));
                this.fab_layout.addView(subFab, i + 3, params);
                this.subFabList.add(i + 2, subFab);
            }
        }
        // closeMenu();
    }

    public void removeFab(FloatingActionButton fab) {
        this.subFabList.remove(fab);
    }

    public void removeFab(int index) {
        this.subFabList.remove(index);
    }

    public void setFabMenuBackgroundColor(int color) {
        fab.setBackgroundTintList(ColorStateList.valueOf(color));
    }

    public void setFabMenuBackgroundDrawable(Drawable drawable) {
        fab.setImageDrawable(drawable);
    }

    public void setSubFabBackgroundColor(int color) {
        for (FloatingActionButton subFab : subFabList) {
            subFab.setBackgroundTintList(ColorStateList.valueOf(color));
        }
    }

    public void setSubFabBackgroundDrawable(List<Drawable> drawableList) {
        for (int i = 0; i < drawableList.size(); i++) {
            subFabList.get(i).setImageDrawable(drawableList.get(i));
        }
    }

}
