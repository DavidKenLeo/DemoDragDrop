package com.dkl.auser.demodragdrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private float y,x;
    private int  mx,my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.imageView);

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        x = motionEvent.getX();
                        y = motionEvent.getY();
Log.d("down","yes");


                    case MotionEvent.ACTION_MOVE:

                        mx = (int)(motionEvent.getRawX()-x);
                         my = (int)(motionEvent.getRawY()-getContentViewTop()-y);
                        view.layout(mx,my,mx+view.getWidth(),my+view.getHeight());
                    break;
                }
                Log.d("down2","yes2");



                return true;
            }
        });
    }

    public int getContentViewTop() {
        View contentview = getWindow().findViewById(android.R.id.content);
        int[] coordintes = new int[2];
        contentview.getLocationOnScreen(coordintes);
        return coordintes[1];



    }
}
