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
import com.kulomady.freesky.model.home.PaymentModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by macaris on 6/15/16.
 */
public class PaymentHomeAdapter extends RecyclerView.Adapter<PaymentHomeAdapter.ViewHolder> {
    private Context mContext;
    private List<PaymentModel> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @BindView(R.id.tv_title)
        public TextView mTvTitle;
        @BindView(R.id.img_cover)
        public ImageView mImgCover;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PaymentHomeAdapter(Context context, List<PaymentModel> myDataset) {
        mContext = context;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PaymentHomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_payment_home, parent, false);
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
                .load(mDataset.get(position).getLogo())
                .placeholder(R.drawable.bg_white)
                .error(R.mipmap.ic_launcher)
                .into(holder.mImgCover);

        holder.mTvTitle.setText(mDataset.get(position).getPaymentName());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
