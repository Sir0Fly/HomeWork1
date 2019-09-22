package com.example.yaoyufei.homework1.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.yaoyufei.homework1.R;

public class ClassesFragment extends Fragment implements View.OnClickListener {
    private View view;
    private RecyclerView mFragmentRecyc;
    /**
     * 播放
     */
    private Button mBt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classes, null);
        initView(view);
        return view;
    }

    private void initView(View view) {

        mBt = (Button) view.findViewById(R.id.bt);
        mBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                Uri parse = Uri.parse("https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/classfile/0/从技术走向管理/001.从技术到管理_第1节_从技术到管理的内外部因素.mp4");
                playInVideoView(parse);
                break;
        }
    }
    /*
     * 系统播放器
     * */
    private void playVideoBySystemPlayer(Uri uri){

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri,"video/*");
        getActivity().startActivity(intent);
    }
    /*
     * 完整播放器，MediaController媒体控制器
     * */
    public void playInVideoView(Uri uri) {
        VideoView videoView = getActivity().findViewById(R.id.video);
        MediaController controller = new MediaController(getContext()); // 必须传有Window的Context，比如Activity
        videoView.setMediaController(controller);
        controller.setAnchorView(videoView);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
