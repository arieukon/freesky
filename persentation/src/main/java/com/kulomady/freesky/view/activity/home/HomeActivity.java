package com.kulomady.freesky.view.activity.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.kulomady.freesky.R;
import com.kulomady.freesky.view.activity.BaseActivity;
import com.kulomady.freesky.view.activity.BaseDrawerActivity;
import com.kulomady.freesky.view.adapter.HomePagerAdapter;
import com.kulomady.freesky.view.fragment.app.AppFragment;
import com.kulomady.freesky.view.fragment.deal.DealFragment;
import com.kulomady.freesky.view.fragment.home.HomeFragment;
import com.kulomady.freesky.view.fragment.video.VideoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeView {

    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    String[] mTabs =  new String[] {"HOME", "DEALS", "APPS", "VIDEOS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
    }

    @Override
    public void initView() {
        //Setup ViewPager
        setupViewPager();

        //Listen to tab position change
        setViewpagerPageChangeListener();

        //Setup Tab View with viewpager
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(mTabs.length - 1);

    }

    @Override
    public void setupViewPager() {

        final int TAB_HOME = 0;
        final int TAB_DEALS = 1;
        final int TAB_APPS = 2;
        final int TAB_VIDEOS = 3;

        Fragment fragment;
        Bundle bundle;
        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager());

        for(int tabPosition = 0; tabPosition < mTabs.length; tabPosition++){
            //Setup Tab Title
            if(tabPosition==TAB_HOME){
                fragment = new HomeFragment();
            } else if(tabPosition==TAB_DEALS){
                fragment = new DealFragment();
            } else if(tabPosition==TAB_APPS){
                fragment = new AppFragment();
            } else if(tabPosition==TAB_VIDEOS){
                fragment = new VideoFragment();
            } else {
                fragment = new HomeFragment();
            }

            bundle = new Bundle();
            fragment.setArguments(bundle);
            adapter.addFragment(fragment, mTabs[tabPosition]);
        }

        //SetFragment to View Pager Adapter
        mViewPager.setAdapter(adapter);

    }

    @Override
    public void setViewpagerPageChangeListener() {
        //Listen to tab position change
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.setting:
                //Action Menu
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
