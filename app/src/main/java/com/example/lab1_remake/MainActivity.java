package com.example.lab1_remake;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLoad;
    private ImageView img1;
    private TextView tvMes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoad = (Button) findViewById(R.id.btnLoad);
        img1 = (ImageView) findViewById(R.id.picLoad);
        tvMes = (TextView) findViewById(R.id.textView);
        btnLoad.setOnClickListener(this);
    }

    private Bitmap loadImgaeFromNetwork(String link){
        URL url;
        Bitmap bitmap = null;
        try {
            url = new URL(link);
            bitmap = BitmapFactory.decodeStream((url.openConnection().getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    public void onClick(View v) {
        final Thread mythread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap btp = loadImgaeFromNetwork("https://upload.wikimedia.org/wikipedia/commons/2/20/FPT_Polytechnic.png");
                img1.post(new Runnable() {
                    @Override
                    public void run() {
                        tvMes.setText("Image Downloaded");
                        img1.setImageBitmap(btp);
                    }
                });
            }
        });
        mythread.start();
    }
}