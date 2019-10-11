package com.example.shangji4;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class CharacterListActivity extends MainActivity {

    //全局静态量
    public static final String IntentID = "com.example.shangji4.intentid";
    @Override
    protected Fragment createFragment() {
        return new CharacterListFragment();
    }

    public static Intent newIntent(Context packageContext, UUID id){
        Intent intent = new Intent(packageContext, CharacterActivity.class);
        intent.putExtra(IntentID, id);
        return intent;
    }
}
