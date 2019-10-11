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
        mCharacterRecyclerView = (RecyclerView)view.findViewById(R.id.listview);
        mCharacterRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI(){
        CharacterLab characterLab = CharacterLab.get(getActivity());
        List<Character> characters = characterLab.getmCharacters();
        mAdapter = new CharacterAdapter(characters);
        mCharacterRecyclerView.setAdapter(mAdapter);
    }


    //extends 继承   implements 接口这里继承的是点击的监听接口
    private class CharacterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView proName;
        public ImageView imageView;
        private Character mCharacter;


        public CharacterHolder(View itemView){
            super(itemView);
            //这一句是接口的必须要用到的
            itemView.setOnClickListener(this);
            //这里绑定控件，还有设置监听
            name = (TextView)itemView.findViewById(R.id.textView);
            proName = (TextView)itemView.findViewById(R.id.textView2);
            imageView = (ImageView)itemView.findViewById(R.id.imageView2);
        }

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
            //这里跳转到新的继承方法
            Intent intent = CharacterListActivity.newIntent(getActivity(), mCharacter.getmId());
            startActivity(intent);
        }

    }

    private class CharacterAdapter extends RecyclerView.Adapter<CharacterHolder>{
        private List<Character> mCharacters;

        public CharacterAdapter(List<Character> characters){
            mCharacters = characters;
        }
        @Override
        public CharacterHolder onCreateViewHolder(ViewGroup parent, int viewtype){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item,parent,false);
            return new CharacterHolder(view);
        }

        @Override
        public void onBindViewHolder(CharacterHolder holder, int position){
            Character ch = mCharacters.get(position);
            holder.setBind(ch);
        }

        @Override
        public int getItemCount(){
            return mCharacters.size();
        }
    }
}
