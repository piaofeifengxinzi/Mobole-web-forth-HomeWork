package com.example.shangji4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class CharacterFragment extends Fragment {
    private TextView title;
    private TextView name;
    private ImageView picture;
    private TextView jiemu;
    private Character mCharacter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View v = inflater.inflate(R.layout.characterlayout, container, false);
        title = (TextView)v.findViewById(R.id.title);
        name = (TextView)v.findViewById(R.id.name);
        picture = (ImageView)v.findViewById(R.id.picture);
        jiemu = (TextView)v.findViewById(R.id.jiemu);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        UUID id = (UUID)getActivity().getIntent().getSerializableExtra(CharacterListActivity.IntentID);
        mCharacter = CharacterLab.get(getActivity()).getCharacter(id);
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        title.setText(mCharacter.getmName());
        name.setText(mCharacter.getmNickName());
        picture.setImageResource(mCharacter.getmProgramPicId());
        jiemu.setText(mCharacter.getmProgramName());
    }
}
