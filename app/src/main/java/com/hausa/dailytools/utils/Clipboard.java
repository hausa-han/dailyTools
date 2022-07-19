package com.hausa.dailytools.utils;

import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

public class Clipboard {

    private static ClipboardManager clipboardManager;

    public static void copy2Clipboard(Context context, String s){
        clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        clipboardManager.setText(s);
        Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show();
    }

}
