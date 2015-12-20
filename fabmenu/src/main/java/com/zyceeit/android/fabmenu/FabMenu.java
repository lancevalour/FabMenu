package com.zyceeit.android.fabmenu;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangY on 12/17/2015.
 */
public class FabMenu extends RelativeLayout {

  /*  List<FloatingActionButton> fabList;*/

    Context context;

    // private Button button;
    private FloatingActionButton fab;
    private FloatingActionButton fab_sub1, fab_sub2, fab_sub3;


    public FabMenu(Context context) {
        super(context);
        this.context = context;
        initiateViews();
        //fabList = new ArrayList<>();
    }


    public FabMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initiateViews();
    }

    public FabMenu(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs);
        this.context = context;
        initiateViews();
    }

    private void initiateViews() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        fab = (FloatingActionButton) findViewById(R.id.fab);

        //textView = (TextView) findViewById(R.id.textView);
    }



/*public void addFab(FloatingActionButton fab) {
        this.fabList.add(fab);
    }

    public void removeFab(FloatingActionButton fab) {
        this.fabList.remove(fab);
    }

    public void removeFab(int index) {
        this.fabList.remove(index);
    }
*/


}
