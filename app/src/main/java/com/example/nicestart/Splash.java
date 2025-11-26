package com.example.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        ImageView mSea = findViewById(R.id.ivBackView);
//        ImageView ivLogo = findViewById(R.id.ivLogo);

        Glide.with(this)
                .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.orange)))
//                .circleCrop()
                .into(mSea);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.blink_translation_rotation);
//        ivLogo.startAnimation(myanim);


        // Para cambiar X e Y:
        // view.setPivotX(1f)
        // view.setPivotY(1f)

        // Pulse: pulso suave desde 0,0
        // Shake: temblor horizontal
        // Swing: balanceo como un péndulo desde arriba
        // Tada: aplauso o "éxito" con rotación y escala rápida
        // Pulse: pulso suave desde 0,0
        // Wobble: tambaleo juguetón con rotación irregular
        // Bounce: rebote simple desde abajo
        // Flash: parpadeo rápido (alpha on/off)
        // RubberBand: estiramiento elástico horizontal
        // BounceIn: entrada con rebote desde el centro
        // FadeIn: desvanecimiento de entrada suave (de transparente a opaco)
        // FlipInX: volteo entrada horizontal (como una página girando)
        // RotateIn: rotación entrada completa (360° suave)
        // SlideInLeft: deslizamiento entrada desde la izquierda
        // ZoomIn: zoom entrada desde pequeño a normal
        // FadeOut: desvanecimiento salida (a transparente)
        // SlideOutRight: deslizamiento salida hacia la derecha
        // BounceInDown: rebote entrada desde arriba
        // FlipOutY: volteo salida vertical
        // ZoomOut: zoom salida a pequeño
        // Hinge: bisagra (rotación dramática como puerta abriéndose)
        YoYo.with(Techniques.Tada)
                .duration(1000)
                .repeat(1)
                .playOn(findViewById(R.id.tvAppName));

        openApp();
    }

    private void openApp(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 4000);
    }
}