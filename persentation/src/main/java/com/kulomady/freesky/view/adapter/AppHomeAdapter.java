package com.kulomady.freesky.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kulomady.freesky.R;
import com.kulomady.freesky.model.home.MusicModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by macaris on 6/15/16.
 */
public class AppHomeAdapter extends RecyclerView.Adapter<AppHomeAdapter.ViewHolder> {

    private Context mContext;
    public List<MusicModel> mDataset;
    public boolean mIsHome;

    private static ClickListener clickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AppHomeAdapter(Context context, List<MusicModel> myDataset, boolean isHome) {
        mContext = context;
        mDataset = myDataset;
        mIsHome = isHome;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AppHomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_app_home, parent, false);
        if (!mIsHome) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_app_grid, parent, false);
        }
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Picasso.with(mContext)
                .load(mDataset.get(position).getCoverImage())
                .placeholder(R.drawable.bg_white)
                .error(R.drawable.bg_white)
                .into(holder.mImgCover);

        holder.mTvTitle.setText(mDataset.get(position).getTitle());
        holder.mTvArtist.setText(mDataset.get(position).getArtist());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        AppHomeAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
