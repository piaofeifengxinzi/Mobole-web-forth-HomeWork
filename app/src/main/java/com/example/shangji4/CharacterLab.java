package com.example.shangji4;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CharacterLab {
    private static CharacterLab mCharacterLab;

    private List<Character> mCharacters;
    public static CharacterLab get(Context context){
        if(mCharacterLab == null){
            mCharacterLab = new CharacterLab(context);
        }
        return mCharacterLab;
    }

    public CharacterLab(Context context){
        mCharacters = new ArrayList<>();
        for(int i=0; i<100; i++){
            Character ch = new Character();
            ch.setmName("my name num is "+ i);
            ch.setmNickName("my nickname is " + i);
            ch.setmProgramName("节目" + i);
            ch.setmProgramPicId(R.drawable.tmntdon);
            mCharacters.add(ch);
        }
    }

    public List<Character> getmCharacters(){
        return mCharacters;
    }

    public Character getCharacter(UUID id){
        for(Character character : mCharacters){
            if(character.getmId().equals(id)){
                return character;
            }
        }
        return null;
    }
}
