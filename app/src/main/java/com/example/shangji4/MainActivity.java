package com.example.shangji4;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;


//抽象类，其中只有一个抽象方法需要在子类中重写
public abstract class MainActivity extends FragmentActivity {
    //抽象方法，子类中实现，当不同的fragment加载时减少了代码的编写
   protected  abstract Fragment createFragment();
   //媒体播放器，用于播放背景音乐，生命流程写在活动的重写方法中，与活动的生命周期相同
   private MediaPlayer mediaPlayer;

   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       //创建媒体播放器，并加载资源
       mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.tmnt_theme);
       System.out.println("这屋里执行");
       //fragment的管理，用于代码的复用
       FragmentManager fm = getSupportFragmentManager();
       Fragment fragment = fm.findFragmentById(R.id.fragment_container);

       if(fragment == null){
           //这里是用于代码的复用，这里调用了子类中重写的方法
           fragment = createFragment();
           fm.beginTransaction()
                   .add(R.id.fragment_container,fragment)
                   .commit();
       }
   }



   //下面三个都是用于管理音乐播放器的
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
        System.out.println("销毁");
        mediaPlayer.release();
    }
}
