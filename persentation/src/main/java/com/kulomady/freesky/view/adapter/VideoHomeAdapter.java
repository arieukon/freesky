package com.kulomady.freesky.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kulomady.freesky.R;
import com.kulomady.freesky.model.ProductModel;
import com.kulomady.freesky.model.home.MusicModel;
import com.kulomady.freesky.view.utils.ViewUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by macaris on 6/15/16.
 */
public class VideoHomeAdapter extends RecyclerView.Adapter<VideoHomeAdapter.ViewHolder> {

    private static ClickListener clickListener;

    private Context mContext;
    public List<MusicModel> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @BindView(R.id.tv_title)
        public TextView mTvTitle;
        @BindView(R.id.tv_artist)
        public TextView mTvArtist;
        @BindView(R.id.img_cover)
        public ImageView mImgCover;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public VideoHomeAdapter(Context context, List<MusicModel> myDataset) {
        mContext = context;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public VideoHomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_video_home, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        int screenWidth = ViewUtils.getScreenWidth(mContext);
        int paddingTotal = 20;

        int imageWidth = (screenWidth / 2) - paddingTotal;
        int imageHeight = imageWidth / 2;

        holder.mImgCover.getLayoutParams().width = imageWidth;
        holder.mImgCover.getLayoutParams().height = imageHeight;

        Picasso.with(mContext)
                .load(mDataset.get(position).getCoverImage())
                .placeholder(R.drawable.bg_white)
                .error(R.drawable.bg_white)
                .into(holder.mImgCover);

        String videoInfo = mDataset.get(position).getArtist() + " - " + mDataset.get(position).getTitle();
        holder.mTvTitle.setText(videoInfo);
        holder.mTvArtist.setText(mDataset.get(position).getArtist());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        VideoHomeAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
