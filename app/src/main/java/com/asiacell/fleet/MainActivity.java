
package com.asiacell.fleet;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private final int RED = Color.rgb(220, 25, 45);
    private final int WHITE = Color.WHITE;
    private final int GRAY = Color.rgb(175, 180, 190);
    private final int DARK = Color.rgb(15, 17, 23);

    private int dp(float value) {
        return (int) (value * getResources()
                .getDisplayMetrics().density);
    }

    private GradientDrawable shape(int color, int radius) {
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(color);
        bg.setCornerRadius(dp(radius));
        return bg;
    }

    private TextView makeText(String value, int size, int color) {
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

        getWindow().setStatusBarColor(DARK);
        getWindow().setNavigationBarColor(DARK);

        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setGravity(Gravity.CENTER);
        page.setPadding(dp(25), dp(20), dp(25), dp(20));
        page.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        GradientDrawable background = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{
                        Color.rgb(45, 18, 29),
                        Color.rgb(23, 20, 27),
                        DARK
                }
        );
        page.setBackground(background);

        TextView brand = makeText("ASIACELL", 15, RED);
        page.addView(brand);

        TextView title = makeText("Asiacell Cars", 30, WHITE);
        LinearLayout.LayoutParams titleParams =
                new LinearLayout.LayoutParams(-1, -2);
        titleParams.topMargin = dp(8);
        page.addView(title, titleParams);

        TextView subtitle = makeText(
                "إدارة سيارات آسياسيل", 17, GRAY);

        LinearLayout.LayoutParams subParams =
                new LinearLayout.LayoutParams(-1, -2);
        subParams.topMargin = dp(8);
        page.addView(subtitle, subParams);

        LinearLayout carCard = new LinearLayout(this);
        carCard.setGravity(Gravity.CENTER);
        carCard.setOrientation(LinearLayout.VERTICAL);
        carCard.setBackground(shape(
                Color.rgb(39, 38, 48), 24));

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(-1, dp(175));
        cardParams.topMargin = dp(35);
        page.addView(carCard, cardParams);

        TextView car = makeText("🚘", 76, WHITE);
        carCard.addView(car);

        TranslateAnimation move = new TranslateAnimation(
                -dp(9), dp(9), 0, 0);

        move.setDuration(1800);
        move.setRepeatCount(Animation.INFINITE);
        move.setRepeatMode(Animation.REVERSE);
        car.startAnimation(move);

        TextView welcome = makeText("مرحباً بك", 23, WHITE);

        LinearLayout.LayoutParams welcomeParams =
                new LinearLayout.LayoutParams(-1, -2);
        welcomeParams.topMargin = dp(28);
        page.addView(welcome, welcomeParams);

        TextView instruction = makeText(
                "سجّل الدخول باستخدام رقم هاتفك", 14, GRAY);

        LinearLayout.LayoutParams instructionParams =
                new LinearLayout.LayoutParams(-1, -2);
        instructionParams.topMargin = dp(10);
        page.addView(instruction, instructionParams);

        EditText phone = new EditText(this);
        phone.setSingleLine(true);
        phone.setHint("أدخل رقم الهاتف");
        phone.setHintTextColor(GRAY);
        phone.setTextColor(WHITE);
        phone.setTextSize(17);
        phone.setGravity(Gravity.CENTER);
        phone.setInputType(3);
        phone.setPadding(dp(15), dp(12), dp(15), dp(12));
        phone.setBackground(shape(
                Color.rgb(43, 44, 54), 14));

        LinearLayout.LayoutParams phoneParams =
                new LinearLayout.LayoutParams(-1, dp(58));
        phoneParams.topMargin = dp(22);
        page.addView(phone, phoneParams);

        Button next = new Button(this);
        next.setText("متابعة");
        next.setTextSize(17);
        next.setTextColor(WHITE);
        next.setAllCaps(false);
        next.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        next.setBackground(shape(RED, 14));

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

        TextView footer = makeText(
                "ASIACELL CARS  •  VERSION 1.0", 11, GRAY);

        LinearLayout.LayoutParams footerParams =
                new LinearLayout.LayoutParams(-1, -2);
        footerParams.topMargin = dp(30);
        page.addView(footer, footerParams);

        AlphaAnimation fade = new AlphaAnimation(0f, 1f);
        fade.setDuration(900);
        page.startAnimation(fade);

        setContentView(page);
    }
}
