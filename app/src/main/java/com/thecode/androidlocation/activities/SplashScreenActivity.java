package com.thecode.androidlocation.activities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


import com.thecode.androidlocation.R;

public class SplashScreenActivity extends AppCompatActivity {


    private Context mContext;
    ImageView img;
    int SPLASH_TIME_OUT = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        img = findViewById(R.id.ic_logo);


        mContext = SplashScreenActivity.this;

        setAnimation();




        new Handler().postDelayed(() -> {

                Intent intent = new Intent(mContext, MapsActivity.class);
                // Animatoo.animateSlideLeft(mContext);
                startActivity(intent);
                finish();

        }, SPLASH_TIME_OUT);
    }


    private void setAnimation() {

        View imageView = findViewById(R.id.ic_logo);
        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(imageView, "scaleX", 5.0F, 1.0F);
        scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleXAnimation.setDuration(900);
        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(imageView, "scaleY", 5.0F, 1.0F);
        scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleYAnimation.setDuration(900);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(imageView, "alpha", 0.0F, 1.0F);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(900);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
        animatorSet.setStartDelay(900);
        animatorSet.start();

        imageView.setAlpha(1.0F);
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.animate_fade);
        anim1.setDuration(2000);
        imageView.startAnimation(anim1);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
