package com.konstantin_romashenko.fisherhandbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


import androidx.annotation.Nullable;

public class LogoActivity extends Activity implements Runnable
{
    private Animation logoAnim, buttonLogoAnim;
    private Button bAnim;
    private ImageView logoImage;
    private Thread trd;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        ImageView img = findViewById(R.id.imageView2);
        img.requestLayout();
        img.setImageResource(R.drawable.fisherman_handbook);
        init();
    }

    public void onClickStart(View view)
    {


    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        finish();
    }

    public void init()
    {
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_anim);
        //buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_anim);

        logoImage = findViewById(R.id.imageView2);
        //bAnim = findViewById(R.id.button);
        //Запускаем анимацию
        logoImage.startAnimation(logoAnim);
        //bAnim.startAnimation(buttonLogoAnim);


        trd = new Thread(this);
        trd.start();
    }

    private void startMainActivity()
    {

    }

    public void run()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException exc)
        {
            exc.printStackTrace();
        }
        Intent intent = new Intent(LogoActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
