package com.example.shangji4;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public abstract class MainActivity extends FragmentActivity {
    //抽象方法，子类中实现
   protected  abstract Fragment createFragment();
   private MediaPlayer mediaPlayer;

   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.tmnt_theme);
       FragmentManager fm = getSupportFragmentManager();
       Fragment fragment = fm.findFragmentById(R.id.fragment_container);

       if(fragment == null){
           fragment = createFragment();
           fm.beginTransaction()
                   .add(R.id.fragment_container,fragment)
                   .commit();
       }
   }

   @Override
    public void onResume(){
       super.onResume();
       if(mediaPlayer != null){
           mediaPlayer.setLooping(true);
           mediaPlayer.start();
       }
   }

    @Override
    public void onPause(){
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mediaPlayer.release();
    }
}
