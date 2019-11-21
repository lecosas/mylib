package com.fiap18mob.mylib;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CustomToast {

    public static final int INFO = 0;
    public static final int WARNING = 1;
    public static final int ERROR = 2;
    public static final int SUCCESS = 3;

    @IntDef({INFO, WARNING, ERROR, SUCCESS})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TypeMessage {
    }

    public void showToast(Context context, String message, @TypeMessage int typeMessage) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View customToastRoot = inflater.inflate(R.layout.custom_toast, null);

        Toast customToast = new Toast(context);

        customToast.setView(customToastRoot);
        TextView textView = customToastRoot.findViewById(R.id.textView1);
        textView.setText(message);

        ImageView imageView = customToastRoot.findViewById(R.id.imageView1);

        switch (typeMessage) {
            case INFO:
                imageView.setImageResource(R.mipmap.icon_information);
                break;
            case WARNING:
                imageView.setImageResource(R.mipmap.icon_warning);
                break;
            case ERROR:
                imageView.setImageResource(R.mipmap.icon_error);
                break;
            case SUCCESS:
                imageView.setImageResource(R.mipmap.icon_success);
                break;
            default:
                imageView.setImageResource(R.mipmap.ic_launcher);
        }

        customToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 0);
        customToast.setDuration(Toast.LENGTH_LONG);
        customToast.show();
    }
}
