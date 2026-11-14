
package com.asiacell.fleet;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    int red = Color.rgb(220, 25, 45);
    int white = Color.WHITE;
    int gray = Color.rgb(170, 175, 185);
    int dark = Color.rgb(15, 17, 23);

    int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    GradientDrawable shape(int color, int radius) {
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(color);
        bg.setCornerRadius(dp(radius));
        return bg;
    }

    TextView text(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setGravity(Gravity.CENTER);
        t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(dark);
        getWindow().setNavigationBarColor(dark);

        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setGravity(Gravity.CENTER);
        page.setPadding(dp(25), dp(20), dp(25), dp(20));
        page.setBackground(new GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            new int[]{Color.rgb(28, 20, 27), dark, dark}
        ));

        TextView brand = text("ASIACELL", 15, red);
        brand.setLetterSpacing(0.25f);
        page.addView(brand);

        TextView title = text("Asiacell Cars", 30, white);
        LinearLayout.LayoutParams titleParams =
            new LinearLayout.LayoutParams(-1, -2);
        titleParams.topMargin = dp(8);
        page.addView(title, titleParams);

        TextView subtitle = text("إدارة سيارات آسياسيل", 17, gray);
        LinearLayout.LayoutParams subTitleParams =
            new LinearLayout.LayoutParams(-1, -2);
        subTitleParams.topMargin = dp(8);
        page.addView(subtitle, subTitleParams);

        LinearLayout carCard = new LinearLayout(this);
        carCard.setGravity(Gravity.CENTER);
        carCard.setOrientation(LinearLayout.VERTICAL);
        carCard.setBackground(shape(Color.rgb(35, 35, 44), 24));
        LinearLayout.LayoutParams cardParams =
            new LinearLayout.LayoutParams(-1, dp(175));
        cardParams.topMargin = dp(35);
        page.addView(carCard, cardParams);

        TextView car = text("🚘", 76, white);
        carCard.addView(car);

        TranslateAnimation move = new TranslateAnimation(
            -dp(8), dp(8), 0, 0
        );
        move.setDuration(1800);
        move.setRepeatCount(AlphaAnimation.INFINITE);
        move.setRepeatMode(AlphaAnimation.REVERSE);
        car.startAnimation(move);

        TextView welcome = text("مرحباً بك", 23, white);
        LinearLayout.LayoutParams welcomeParams =
            new LinearLayout.LayoutParams(-1, -2);
        welcomeParams.topMargin = dp(30);
        page.addView(welcome, welcomeParams);

        TextView instruction = text(
            "سجّل الدخول باستخدام رقم هاتفك", 14, gray
        );
        LinearLayout.LayoutParams instructionParams =
            new LinearLayout.LayoutParams(-1, -2);
        instructionParams.topMargin = dp(10);
        page.addView(instruction, instructionParams);

        EditText phone = new EditText(this);
        phone.setSingleLine(true);
        phone.setHint("أدخل رقم الهاتف");
        phone.setHintTextColor(gray);
        phone.setTextColor(white);
        phone.setTextSize(17);
        phone.setGravity(Gravity.CENTER);
        phone.setInputType(3);
        phone.setPadding(dp(15), dp(12), dp(15), dp(12));
        phone.setBackground(shape(Color.rgb(42, 43, 52), 14));

        LinearLayout.LayoutParams phoneParams =
            new LinearLayout.LayoutParams(-1, dp(58));
        phoneParams.topMargin = dp(22);
        page.addView(phone, phoneParams);

        Button next = new Button(this);
        next.setText("متابعة");
        next.setTextSize(17);
        next.setTextColor(white);
        next.setAllCaps(false);
        next.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        next.setBackground(shape(red, 14));

        LinearLayout.LayoutParams buttonParams =
            new LinearLayout.LayoutParams(-1, dp(56));
        buttonParams.topMargin = dp(16);
        page.addView(next, buttonParams);

        next.setOnClickListener(v -> {
            String number = phone.getText().toString().trim();

            if (number.isEmpty()) {
                phone.setError("يرجى إدخال رقم الهاتف");
                return;
            }

            Toast.makeText(
                this,
                "تسجيل الدخول الفعلي سنضيفه بالمرحلة القادمة",
                Toast.LENGTH_LONG
            ).show();
        });

        TextView footer = text(
            "ASIACELL CARS  •  VERSION 1.0", 11, gray
        );
        LinearLayout.LayoutParams footerParams =
            new LinearLayout.LayoutParams(-1, -2);
        footerParams.topMargin = dp(35);
        page.addView(footer, footerParams);

        page.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        AlphaAnimation fade = new AlphaAnimation(0f, 1f);
        fade.setDuration(900);
        page.startAnimation(fade);

        setContentView(page);
    }
}
