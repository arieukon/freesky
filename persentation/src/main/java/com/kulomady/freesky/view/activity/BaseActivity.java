package com.kulomady.freesky.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.kulomady.freesky.AndroidApplication;
import com.kulomady.freesky.Navigation.Navigator;
import com.kulomady.freesky.R;
import com.kulomady.freesky.internal.di.components.ApplicationComponent;
import com.kulomady.freesky.internal.di.modules.ActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by kulomady on 5/6/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    Navigator navigator;
    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Nullable
    @BindView(R.id.topedLogo)
    TextView tokopediaLogoTextView;

    private MenuItem cartMenuItem;
    private MenuItem searchMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        bindViews();
    }

    protected void bindViews() {
        ButterKnife.bind(this);
        setupToolbar();
    }

    public void setContentViewWithoutInject(int layoutResId) {
        super.setContentView(layoutResId);
    }

    protected void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.mipmap.freesky_logo_text);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        setSearchMenuItem(menu);
        initActivityForSupportSearchable(menu);
        return true;
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    protected ApplicationComponent getApplicationComponent() {

        return ((AndroidApplication)getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }


    private void setSearchMenuItem(Menu menu) {
        searchMenuItem = menu.findItem(R.id.menu_search);

    }


    private void initActivityForSupportSearchable(Menu menu) {
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
    }


    @Nullable
    public Toolbar getToolbar() {
        return toolbar;
    }


    public MenuItem getSearchMenuItem() {
        return searchMenuItem;
    }

    @Nullable
    public TextView getTokopediaLogoTextView() {
        return tokopediaLogoTextView;
    }


}
