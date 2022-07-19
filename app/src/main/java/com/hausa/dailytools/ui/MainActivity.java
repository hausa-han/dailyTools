package com.hausa.dailytools.ui;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hausa.dailytools.R;
import com.hausa.dailytools.ui.tools.Base64Activity;
import com.hausa.dailytools.ui.tools.MakeQrActivity;

public class MainActivity extends AppCompatActivity {

    // Three Nav
    private LinearLayout recordeLinearLayout;
    private LinearLayout toolsLinearLayout;
    private LinearLayout aboutLinearLayout;

    // In Main Nav


    // In Tools Nav
    private TextView base64Textview;
    private TextView scanQrTextview;
    private TextView makeQrTextview;

    // In About Nav



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

        switch (activityId){
            case R.layout.activity_main_records:
                initMainNav();
                break;
            case R.layout.activity_main_tools:
                initToolsNav();
                break;
            case R.layout.activity_main_about:
                initAboutNav();
                break;
            default:
                break;
        }


    }

    private void initMainNav() {


    }

    private void initToolsNav() {
        base64Textview = findViewById(R.id.tool_base64_button);
        scanQrTextview = findViewById(R.id.scan_qr_button);
        makeQrTextview = findViewById(R.id.make_qr_button);

        base64Textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Base64Activity.class);
                startActivity(intent);
            }
        });
        scanQrTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        makeQrTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MakeQrActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initAboutNav() {

    }



}