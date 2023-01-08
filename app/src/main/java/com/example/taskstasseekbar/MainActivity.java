package com.example.taskstasseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity{
    SeekBar sb1;
    SeekBar sb2;
    View view1_without;
    View view2_without;
    View view_orange;
    FrameLayout ll_green;

    LinearLayout.LayoutParams lParams_view1_without;
    LinearLayout.LayoutParams lParams_view2_without;
    FrameLayout.LayoutParams lParams_orange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb1 = (SeekBar) findViewById(R.id.sb1);
        sb1.setOnSeekBarChangeListener(sb1_listener);
        sb2 = (SeekBar) findViewById(R.id.sb2);
        sb2.setOnSeekBarChangeListener(sb2_listener);

        view1_without = (View) findViewById(R.id.view_without1);
        view2_without = (View) findViewById(R.id.view_without2);
        view_orange = (View) findViewById(R.id.layout_orange);

        ll_green = (FrameLayout) findViewById(R.id.layout_green);

        lParams_view1_without = (LinearLayout.LayoutParams) view1_without.getLayoutParams();
        lParams_view2_without = (LinearLayout.LayoutParams) view2_without.getLayoutParams();

        lParams_orange = (FrameLayout.LayoutParams) view_orange.getLayoutParams();
    }

    SeekBar.OnSeekBarChangeListener sb1_listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            int leftValue = i;
            int rightValue = seekBar.getMax() - leftValue;

            lParams_view1_without.weight = leftValue;
            lParams_view2_without.weight = rightValue;

            view1_without.setLayoutParams(lParams_view1_without);
            view2_without.setLayoutParams(lParams_view2_without);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    SeekBar.OnSeekBarChangeListener sb2_listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            int rightValueOrange = (seekBar.getProgress() * 100)/R.dimen.margin_orange;
            lParams_orange.setMargins(rightValueOrange, rightValueOrange, rightValueOrange, rightValueOrange);
            view_orange.setLayoutParams(lParams_orange);

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}