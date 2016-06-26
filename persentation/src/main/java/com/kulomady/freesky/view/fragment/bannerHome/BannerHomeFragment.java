package com.kulomady.freesky.view.fragment.bannerHome;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kulomady.freesky.R;
import com.kulomady.freesky.model.home.BannerModel;
import com.kulomady.freesky.view.fragment.home.HomeFragment;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BannerHomeFragment extends Fragment implements BannerHomeView {
    private Unbinder unbinder;

    @BindView(R.id.img_banner)
    ImageView mImgBanner;

    BannerHomePresenterImpl mPresenter;

    public BannerHomeFragment() {
        // Required empty public constructor
        mPresenter = new BannerHomePresenterImpl(getActivity(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_banner_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        String bannerDataJSON = getArguments().getString(HomeFragment.KEY_BANNER_DATA);
        int tabPosition = getArguments().getInt(HomeFragment.KEY_TAB_POSITION);
        if ((bannerDataJSON != null) && (!bannerDataJSON.equals(""))) {
            mPresenter.receiveBannerData(bannerDataJSON, tabPosition);
        }
        return view;
    }

    @OnClick(R.id.img_banner)
    void bannerClicked(){
        String url = "http://www.joox.com/#/single?id=04QFsLwKPHc_ujQskVm_lw==";
        gotoWebPage(url);
    }

    @Override
    public void displayBannerData(BannerModel bannerModel) {
        Picasso.with(getActivity())
                .load(bannerModel.getImage())
                .placeholder(R.drawable.bg_white)
                .error(R.drawable.bg_white)
                .into(mImgBanner);
        Log.d("Banner Image", bannerModel.getImage());
    }

    @Override
    public void gotoWebPage(String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        getActivity().startActivity(browserIntent);
    }
}
