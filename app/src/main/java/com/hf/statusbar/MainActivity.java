package com.hf.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lightDark = (Button) findViewById(R.id.light_dark);
        Button moji = (Button) findViewById(R.id.moji);

        lightDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchStatusBarLightDark();
            }
        });

        moji.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                }
                switchStatusBarLightDark();
            }
        });
    }

    private void switchStatusBarLightDark() {
        int flags = getWindow().getDecorView().getSystemUiVisibility();
        if ((flags & View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) == 0) {
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        } else {
            flags &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }

        getWindow().getDecorView().setSystemUiVisibility(flags);
    }
}
