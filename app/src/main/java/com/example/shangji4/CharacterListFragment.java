package com.example.shangji4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


    private class CharacterHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public CharacterHolder(View itemView){
            super(itemView);
            //这里绑定控件，还有设置监听
            name = (TextView)itemView;
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
            //这里加多余的控件代码
            holder.name.setText(ch.getmName());
        }

        @Override
        public int getItemCount(){
            return mCharacters.size();
        }
    }
}
