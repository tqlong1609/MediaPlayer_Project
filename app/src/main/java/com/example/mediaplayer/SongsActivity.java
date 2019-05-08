package com.example.mediaplayer;

import android.media.MediaMetadataRetriever;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mediaplayer.ClassLayer.Songs;
import com.example.mediaplayer.ClassLayer.SongsAdapter;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private ListView mListSong;
    private ArrayList<Songs> mArraySongs;
    private SongsAdapter mSongAdapter;
    private MediaMetadataRetriever mMediaMeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        openFragment();
        mListSong = findViewById(R.id.list_songs);
        addSongs();
        mSongAdapter = new SongsAdapter(this,R.layout.songs,mArraySongs);
        mListSong.setAdapter(mSongAdapter);
    }

    private void addSongs()
    {
        mArraySongs = new ArrayList<>();
        mArraySongs.add(new Songs("Ngồi hát đở buồn","Trúc Nhân","NhacCuaTui",R.raw.ngoihatdobuon));
        mArraySongs.add(new Songs("Về bên anh","Jack","NhacCuaTui",R.raw.vebenanh));
        mArraySongs.add(new Songs("Lớn rồi còn khóc nhè","Trúc Nhân","NhacCuaTui",R.raw.lonroiconkhocnhe));
        mArraySongs.add(new Songs("Thương em là điều anh không thể","Noo Phước Thịnh","NhacCuaTui"
                ,R.raw.thuongemladieuanhkhongthe));
    }
    // open fragment
    private void openFragment()
    {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.frame_music_contains_ver2,new ControlMusicFragment());
        mFragmentTransaction.commit();
    }
}
