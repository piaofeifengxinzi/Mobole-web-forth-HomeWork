package com.example.shangji4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CharacterListFragment extends Fragment {
    private RecyclerView mCharacterRecyclerView;
    private CharacterAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.listlayout,container,false);
        //列表控件的绑定
        mCharacterRecyclerView = (RecyclerView)view.findViewById(R.id.listview);
        //设置布局管理器，直接声明一个线性布局管理器，并传入当前活动的上下文
        mCharacterRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI(){
        //这里使用了单例，简单来说，内存中独一份，整个应用共享，方便数据的修改与传递
        CharacterLab characterLab = CharacterLab.get(getActivity());
        List<Character> characters = characterLab.getmCharacters();
        //如果由别的活动返回到这个活动就需要在这里添加数据更新判断，并且更新数据
        mAdapter = new CharacterAdapter(characters);
        mCharacterRecyclerView.setAdapter(mAdapter);
    }


    //以下就是对listview的适配器的重写，算是内部类，不过外部不会调用
    //extends 继承   implements 接口这里继承的是点击的监听接口
    private class CharacterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView proName;
        public ImageView imageView;
        private Character mCharacter;


        //这里传入View在fragment的onCreateView中
        public CharacterHolder(View itemView){
            super(itemView);
            //这一句是接口的必须要用到的，相当与在这里注册
            itemView.setOnClickListener(this);
            //这里绑定控件，还有设置监听
            name = (TextView)itemView.findViewById(R.id.textView);
            proName = (TextView)itemView.findViewById(R.id.textView2);
            imageView = (ImageView)itemView.findViewById(R.id.imageView2);
        }

        //掉用这个方法会将数据显示在相应的控件
        public void setBind(Character ch){
            //这里将对象传入了类
            mCharacter = ch;
            //这里加多余的控件代码
            name.setText(ch.getmName());
            proName.setText(ch.getmProgramName());
            imageView.setImageResource(ch.getmProgramPicId());
        }

        //要继承接口必须重写方法
        @Override
        public void onClick(View v){
            //这里用到了封装，将方法简化了
            Intent intent = CharacterListActivity.newIntent(getActivity(), mCharacter.getmId());
            startActivity(intent);
        }

    }

    private class CharacterAdapter extends RecyclerView.Adapter<CharacterHolder>{
        private List<Character> mCharacters;

        //传入的数据列表
        public CharacterAdapter(List<Character> characters){
            //这里没有用this是因为变量名不同
            mCharacters = characters;
        }

        //这里的返回只应该是与模板编程有关
        @Override
        public CharacterHolder onCreateViewHolder(ViewGroup parent, int viewtype){
            //固定用法
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            //将列表项的子布局加载，可以这样理解
            View view = layoutInflater.inflate(R.layout.list_item,parent,false);
            return new CharacterHolder(view);
        }


        //这里调用数据的绑定
        @Override
        public void onBindViewHolder(CharacterHolder holder, int position){
            Character ch = mCharacters.get(position);
            holder.setBind(ch);
        }

        @Override
        public int getItemCount(){
            //返回列表项的长度
            return mCharacters.size();
        }
    }
}
