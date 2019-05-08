package com.example.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class ControlMusicFragment extends Fragment {

    private View mView;
    private ImageView mImageDisk ;
    private ImageView mPlayPause;
    private Intent mIntent;

    private boolean mIsPlay = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_control_music,container,false);
        mapping();
        openPlaySong();
        controlSongs();
        return mView;
    }

    private void controlSongs()
    {
        mPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mIsPlay) {
                    mPlayPause.setImageResource(R.drawable.ic_play);
                    mIsPlay = true;
                }
                else
                {
                    mPlayPause.setImageResource(R.drawable.ic_stop);
                    mIsPlay = false;
                }
            }
        });
    }

    private void openPlaySong()
    {
        mImageDisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(getActivity(),PlaySongsActivity.class);
                startActivity(mIntent);
            }
        });
    }

    private void mapping()
    {
        mImageDisk = mView.findViewById(R.id.disk);
        mPlayPause = mView.findViewById(R.id.button_stop_play);
    }
}
