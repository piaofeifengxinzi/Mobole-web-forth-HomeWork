package com.example.shangji4;

import androidx.fragment.app.Fragment;

public class CharacterActivity extends MainActivity {
    //重写方法，与CharacterListActivty相似
    @Override
    protected Fragment createFragment(){
        return new CharacterFragment();
    }
}
