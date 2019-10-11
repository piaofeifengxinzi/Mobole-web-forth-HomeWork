package com.example.shangji4;

import androidx.fragment.app.Fragment;

public class CharacterActivity extends MainActivity {
    @Override
    protected Fragment createFragment(){
        return new CharacterFragment();
    }
}
