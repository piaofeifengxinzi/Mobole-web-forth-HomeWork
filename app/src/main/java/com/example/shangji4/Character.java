package com.example.shangji4;

import java.util.UUID;


//这个类是用来存储模型的数据的，主要是get和set函数
public class Character {
    public UUID getmId() {
        return mId;
    }

    public int getmCharacterPicId() {
        return mCharacterPicId;
    }

    public void setmCharacterPicId(int mCharacterPicId) {
        this.mCharacterPicId = mCharacterPicId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNickName() {
        return mNickName;
    }

    public void setmNickName(String mNickName) {
        this.mNickName = mNickName;
    }

    public int getmProgramPicId() {
        return mProgramPicId;
    }

    public void setmProgramPicId(int mProgramPicId) {
        this.mProgramPicId = mProgramPicId;
    }

    public String getmProgramName() {
        return mProgramName;
    }

    public void setmProgramName(String mProgramName) {
        this.mProgramName = mProgramName;
    }

    private UUID mId;
    private int mCharacterPicId;
    private String mName;
    private String mNickName;
    private int mProgramPicId;
    private String mProgramName;

    //构造函数是在生成对象时生成唯一的标识符
    public Character(){
        this.mId = UUID.randomUUID();
    }
}
