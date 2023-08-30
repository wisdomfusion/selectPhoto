package com.common.photo.models.ad;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.FrameLayout;

import com.common.photo.R;

/**
 * 广告viewolder
 */
public class AdViewHolder extends RecyclerView.ViewHolder {
    public FrameLayout adFrame;

    public AdViewHolder(View itemView) {
        super(itemView);
        adFrame = (FrameLayout) itemView.findViewById(R.id.ad_frame_easy_photos);
    }
}
