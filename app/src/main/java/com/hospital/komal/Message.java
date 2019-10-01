package com.hospital.komal;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by komal on 28-Sep-2019.
 */
public class Message {
    public static void message(Context context,String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
