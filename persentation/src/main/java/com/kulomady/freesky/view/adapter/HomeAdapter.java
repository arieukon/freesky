package com.kulomady.freesky.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kulomady.freesky.R;

/**
 *
 * Created by kulomady on 6/13/16.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private static final int BANNER = 0;
    private static final int MUSIC = 1;
    private static final int DEALS = 2;
    private static final int MOVIE = 3;
    private static final int APPS = 4;
    private static final int GAME = 5;
    private static final int VIDEO = 6;
    private static final int PAYMENT = 7;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class BannerViewHolder extends ViewHolder {
        TextView temp;

        public BannerViewHolder(View v) {
            super(v);
            this.temp = (TextView) v.findViewById(R.id.tv_grosir);
        }
    }

    public class MusicViewHolder extends ViewHolder {
        TextView score;

        public MusicViewHolder(View v) {
            super(v);
            this.score = (TextView) v.findViewById(R.id.tv_grosir);
        }
    }

    public class DealViewHolder extends ViewHolder {
        TextView headline;

        public DealViewHolder(View v) {
            super(v);
            this.headline = (TextView) v.findViewById(R.id.tv_grosir);
        }
    }

    public class MovieViewHolder extends ViewHolder {
        TextView headline;

        public MovieViewHolder(View v) {
            super(v);
            this.headline = (TextView) v.findViewById(R.id.tv_grosir);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
