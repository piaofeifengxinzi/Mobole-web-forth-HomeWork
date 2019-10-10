package com.example.shangji4;

import androidx.fragment.app.Fragment;

public class CharacterListActivity extends MainActivity {
    @Override
    protected Fragment createFragment() {
        return new CharacterListFragment();
    }
}
