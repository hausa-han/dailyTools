package com.hausa.dailytools.ui;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.hausa.dailytools.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout recordeLinearLayout;
    private LinearLayout toolsLinearLayout;
    private LinearLayout aboutLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(R.layout.activity_main_records);
    }

    private void initView(@LayoutRes Integer activityId) {
        setContentView(activityId);
        recordeLinearLayout = findViewById(R.id.records_nav);
        toolsLinearLayout = findViewById(R.id.tools_nav);
        aboutLinearLayout = findViewById(R.id.about_nav);

        // Make nav turn to white while clicked
        {
            recordeLinearLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    view.setBackground(Drawable.createFromPath("#FFFFFF"));
                    return false;
                }
            });
            toolsLinearLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    view.setBackground(Drawable.createFromPath("#FFFFFF"));
                    return false;
                }
            });
            aboutLinearLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    view.setBackground(Drawable.createFromPath("#FFFFFF"));
                    return false;
                }
            });
        }
        // Realize the change between different navbar
        {
            recordeLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setBackground(Drawable.createFromPath("#DEFCFA"));
                    initView(R.layout.activity_main_records);
                }
            });
            toolsLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setBackground(Drawable.createFromPath("#DEFCFA"));
                    initView(R.layout.activity_main_tools);
                }
            });
            aboutLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setBackground(Drawable.createFromPath("#DEFCFA"));
                    initView(R.layout.activity_main_about);
                }
            });
        }
    }

}