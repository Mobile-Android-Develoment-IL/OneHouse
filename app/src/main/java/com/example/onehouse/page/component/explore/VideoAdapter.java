package com.example.onehouse.page.component.explore;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onehouse.R;


import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.myviewholder> {
    ArrayList<VidioItem> videos;

    public VideoAdapter(ArrayList<VidioItem> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_explore, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.setData(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        VideoView videoView;
        TextView txtTitle, txtDesc;
        ProgressBar videoProgressBar;
        boolean isPlaying = true;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            videoProgressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        void setData(VidioItem obj) {
            videoView.setVideoPath(obj.getVideoUrl());
            txtTitle.setText(obj.getVideoTitle());
            txtDesc.setText(obj.getVideoDesc());

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    videoProgressBar.setVisibility(View.GONE);
                    mp.start();
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
            videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    videoProgressBar.setVisibility(View.GONE);
                    return true;
                }
            });
            videoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isPlaying) {
                        videoView.pause();
                    } else {
                        videoView.start();
                    }
                    isPlaying = !isPlaying;
                }
            });
        }
    }
}
