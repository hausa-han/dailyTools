package com.hausa.dailytools.ui.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hausa.dailytools.R;
import com.hausa.dailytools.utils.Clipboard;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Activity extends AppCompatActivity {

    private EditText inputEdittext;
    private TextView encodeTextview;
    private TextView decodeTextview;
    private TextView resultTextview;
    private TextView copyTextview;
    private TextView reverseTextview;
    private TextView clearTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base64);

        inputEdittext = findViewById(R.id.base64_before_edittext);
        encodeTextview = findViewById(R.id.encode_button);
        decodeTextview = findViewById(R.id.decode_button);
        resultTextview = findViewById(R.id.base64_after_textview);
        copyTextview = findViewById(R.id.copy_button);
        reverseTextview = findViewById(R.id.reverse_button);
        clearTextview  = findViewById(R.id.clear_button);

        encodeTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String origin = inputEdittext.getText().toString();
                String result = "";
                Base64.Encoder encoder = Base64.getEncoder();
                if (!"".equals(origin)){
                    result = encoder.encodeToString(origin.getBytes(StandardCharsets.UTF_8));
                }
                resultTextview.setText(result);
            }
        });
        decodeTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String origin = inputEdittext.getText().toString();
                String result = "";
                Base64.Decoder decoder = Base64.getDecoder();
                if (!"".equals(origin)){
                    result = new String(decoder.decode(origin.getBytes(StandardCharsets.UTF_8)));
                }
                resultTextview.setText(result);
            }
        });
        resultTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clipboard.copy2Clipboard(Base64Activity.this, resultTextview.getText().toString());
            }
        });
        copyTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clipboard.copy2Clipboard(Base64Activity.this, resultTextview.getText().toString());
            }
        });
        reverseTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = inputEdittext.getText().toString();
                inputEdittext.setText(resultTextview.getText().toString());
                resultTextview.setText(temp);
            }
        });
        clearTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputEdittext.setText("");
                resultTextview.setText("");
            }
        });

    }
}