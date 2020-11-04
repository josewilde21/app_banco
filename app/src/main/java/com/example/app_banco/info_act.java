package com.example.app_banco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class info_act extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);


        videoView = (VideoView)findViewById(R.id.vd);




        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        // Control de navegación

        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
    }
    public void maps (View v)
    {
        Intent i = new Intent(this, maps_act.class);
        startActivity(i);


    }



}