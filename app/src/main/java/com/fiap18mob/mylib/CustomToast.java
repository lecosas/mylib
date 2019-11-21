package com.fiap18mob.mylib;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast {

    public void showToast(Context context, String message) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View customToastRoot = inflater.inflate(R.layout.custom_toast, null);

        Toast customToast = new Toast(context);

        customToast.setView(customToastRoot);
        TextView textView = (TextView) customToastRoot.findViewById(R.id.textView1);
        textView.setText(message);
        customToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 0);
        customToast.setDuration(Toast.LENGTH_LONG);
        customToast.show();
    }
}
