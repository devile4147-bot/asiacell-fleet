package com.asiacell.fleet;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setGravity(Gravity.CENTER);
        page.setPadding(32, 32, 32, 32);
        page.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        TextView title = new TextView(this);
        title.setText("نظام موافقات أسطول آسيا سيل");
        title.setTextSize(24);
        title.setGravity(Gravity.CENTER);
        page.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("النسخة الأولية للتطبيق");
        subtitle.setTextSize(16);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams subParams =
            new LinearLayout.LayoutParams(-1, -2);
        subParams.topMargin = 20;
        page.addView(subtitle, subParams);

        EditText phone = new EditText(this);
        phone.setHint("أدخل رقم الهاتف");
        phone.setInputType(3);
        LinearLayout.LayoutParams phoneParams =
            new LinearLayout.LayoutParams(-1, -2);
        phoneParams.topMargin = 32;
        page.addView(phone, phoneParams);

        Button next = new Button(this);
        next.setText("متابعة");
        LinearLayout.LayoutParams buttonParams =
            new LinearLayout.LayoutParams(-1, -2);
        buttonParams.topMargin = 16;
        page.addView(next, buttonParams);

        next.setOnClickListener(v ->
            Toast.makeText(this, "راح نضيف تسجيل الدخول بالمرحلة القادمة",
                Toast.LENGTH_LONG).show()
        );

        setContentView(page);
    }
}
