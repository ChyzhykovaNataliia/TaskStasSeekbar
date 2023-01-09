package com.example.taskstasseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity{
    SeekBar sb1;
    SeekBar sb2;
    View viewSpaceLeft;
    View viewSpaceRight;
    FrameLayout viewOut;
    View viewInner;

    private int maxMarginPx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb1 = (SeekBar) findViewById(R.id.sb1);
        sb1.setOnSeekBarChangeListener(sb1ChangeListener);
        sb2 = (SeekBar) findViewById(R.id.sb2);
        sb2.setOnSeekBarChangeListener(sb2ChangeListener);

        viewSpaceLeft = (View) findViewById(R.id.view_without1);
        viewSpaceRight = (View) findViewById(R.id.view_without2);
        viewInner = (View) findViewById(R.id.layout_orange);

        viewOut = (FrameLayout) findViewById(R.id.layout_green);

        maxMarginPx = getResources().getDimensionPixelSize(R.dimen.margin_orange);

        sb2ChangeListener.onProgressChanged(sb2, sb2.getProgress(), false);
    }

    private final SeekBar.OnSeekBarChangeListener sb1ChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            LinearLayout.LayoutParams lpLeft = (LinearLayout.LayoutParams) viewSpaceLeft.getLayoutParams();
            LinearLayout.LayoutParams lpRight = (LinearLayout.LayoutParams) viewSpaceRight.getLayoutParams();

            lpLeft.weight = progress;
            lpRight.weight = seekBar.getMax() - progress;

            viewSpaceLeft.setLayoutParams(lpLeft);
            viewSpaceRight.setLayoutParams(lpRight);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private final SeekBar.OnSeekBarChangeListener sb2ChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

            int p = progress * maxMarginPx / seekBar.getMax();
            viewOut.setPadding(p, p, p, p);

            // Another implementation using margins
            //FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) viewInner.getLayoutParams();
            //lp.setMargins(margin, margin, margin, margin);
            //viewInner.setLayoutParams(lp);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}