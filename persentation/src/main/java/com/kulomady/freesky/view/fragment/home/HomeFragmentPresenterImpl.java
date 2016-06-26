package com.kulomady.freesky.view.fragment.home;

import android.content.Context;

import com.kulomady.freesky.model.home.BannerModel;
import com.kulomady.freesky.model.home.MovieModel;
import com.kulomady.freesky.model.home.MusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshari Furqan on 6/22/2016.
 */
public class HomeFragmentPresenterImpl implements HomeFragmentPresenter {
    Context mContext;
    HomeFragmentView mView;

    public HomeFragmentPresenterImpl(Context mContext, HomeFragmentView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void loadBanner() {
        mView.displayBannerData(getBannerDataList());
    }

    @Override
    public void loadDeal() {
        mView.displayDealData(getDealDataList());
    }

    @Override
    public void loadVideo() {
        mView.displayVideoData(getVideoDataList());
    }

    @Override
    public void loadMovie() {
        mView.displayMovieData(getMovieDataList());
    }

    @Override
    public void loadMusic() {
        mView.displayMusicData(getMusicDataList());
    }

    @Override
    public void loadApp() {
        mView.displayAppData(getAppDataList());
    }

    @Override
    public List<BannerModel> getBannerDataList() {
        List<BannerModel> bannerList = new ArrayList();

        String[] images = new String[]{
                "http://imgcache.wechat.com/music/joox/photo_id_en/focus_1000/4/a/e478370e5a703a4a.jpg",
                "http://imgcache.wechat.com/music/joox/photo_id_en/focus_1000/3/9/7466692b36b4fe39.jpg",
                "http://imgcache.wechat.com/music/joox/photo_id_en/focus_1000/4/5/90258137c3d0bb45.jpg",
                "http://imgcache.wechat.com/music/joox/photo_id_en/focus_1000/6/4/474de5a259949e64.jpg",
                "http://imgcache.wechat.com/music/joox/photo_id_en/focus_1000/d/c/a8067d89645e07dc.jpg"
        };
        String[] urls = new String[]{
                "http://www.joox.com",
                "http://www.joox.com",
                "http://www.joox.com",
                "http://www.joox.com",
                "http://www.joox.com"
        };

        for (int i = 0; i < images.length; i++) {
            BannerModel bannerModel = new BannerModel();
            bannerModel.setImage(images[i]);
            bannerModel.setUrl(urls[i]);
            bannerList.add(bannerModel);
        }
        return bannerList;
    }

    @Override
    public List<MusicModel> getDealDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] titles = new String[]{
                "Beats Audio",
                "Navy Sweater",
                "iPhone SE",
                "Samsung Galaxy S7",
                "Yonex Voltric"
        };
        String[] artists = new String[]{
                "Rp 1.500.000",
                "Rp 245.000",
                "Rp 8.999.100",
                "Rp 9.000.000",
                "Rp 2.300.00"
        };
        String[] covers = new String[]{
                "http://tinyurl.com/hwspj46",
                "http://tinyurl.com/zd4epj6",
                "http://tinyurl.com/gmoxe2l",
                "http://tinyurl.com/gl32zdq",
                "http://tinyurl.com/hx69gjw"
        };

        for (int i = 0; i < artists.length; i++) {
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage(covers[i]);
            musicList.add(musicModel);
        }
        return musicList;
    }

    @Override
    public List<MusicModel> getVideoDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] artists = new String[]{
                "Raisa",
                "Taylor Swift",
                "Justin Bieber",
                "Linkin Park"};
        String[] titles = new String[]{
                "Mantan Terindah",
                "Wildest Dreams",
                "What Do You Mean",
                "Waiting for The End"};
        String[] covers = new String[]{
                "http://tinyurl.com/h26667n",
                "https://i.ytimg.com/vi/IdneKLhsWOQ/maxresdefault.jpg",
                "http://tinyurl.com/z2zxxfe",
                "http://tinyurl.com/zndb7ah"};

        for (int i = 0; i < artists.length; i++) {
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage(covers[i]);
            musicList.add(musicModel);
        }
        return musicList;
    }

    @Override
    public List<MovieModel> getMovieDataList() {
        List<MovieModel> movieList = new ArrayList();

        String[] titles = new String[]{
                "The Revenant",
                "Room",
                "Bridge of Spies",
                "Spotlight",
                "The Danish Girl"
        };
        String[] prices = new String[]{
                "Rp 25.000",
                "Rp 28.000",
                "Rp 35.000",
                "Rp 45.000",
                "Rp 20.000"
        };
        String[] covers = new String[]{
                "http://blog.bullz-eye.com/wp-content/uploads/2015/12/the_revenant.jpg",
                "http://www.thetweenandme.com/wp-content/uploads/2015/10/roomcover_highres.jpg",
                "http://images.mymovies.net/images/film/cin/350x522/fid15010.jpg",
                "http://www.catholic.org/files/images/ins_news/20151110351.jpg",
                "http://megafilmesonline.net/wp-content/uploads/2016/05/A-Garota-Dinamarquesa.jpg"
        };
        String[] synopsis = new String[]{
                "A frontiersman on a fur trading expedition in the 1820s fights for survival after being " +
                        "mauled by a bear and left for dead by members of his own hunting team. ",
                "A frontiersman on a fur trading expedition in the 1820s fights for survival after being " +
                        "mauled by a bear and left for dead by members of his own hunting team. ",
                "A frontiersman on a fur trading expedition in the 1820s fights for survival after being " +
                        "mauled by a bear and left for dead by members of his own hunting team. ",
                "A frontiersman on a fur trading expedition in the 1820s fights for survival after being " +
                        "mauled by a bear and left for dead by members of his own hunting team. ",
                "A frontiersman on a fur trading expedition in the 1820s fights for survival after being " +
                        "mauled by a bear and left for dead by members of his own hunting team. "
        };

        for (int i = 0; i < titles.length; i++) {
            MovieModel movieModel = new MovieModel();
            movieModel.setTitle(titles[i]);
            movieModel.setPrice(prices[i]);
            movieModel.setCover(covers[i]);
            movieModel.setSynopsis(synopsis[i]);
            movieList.add(movieModel);
        }
        return movieList;
    }

    @Override
    public List<MusicModel> getMusicDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] titles = new String[]{
                "New Romantic",
                "Love is Not A Bad Things",
                "Kali Kedua",
                "When We Were Young",
                "Dangerous Woman"
        };
        String[] artists = new String[]{
                "Taylor Swift",
                "Michael Jacksons",
                "Ran",
                "Adele",
                "Ariana Grande"
        };
        String[] covers = new String[]{
                "http://tinyurl.com/huat3aw",
                "http://www.michaeljacksonsightings.com/resources/Xscpe.jpg",
                "https://rannersjakarta.files.wordpress.com/2014/11/gambar-ran-19.jpg",
                "http://104.131.185.116/wp-content/uploads/2011/03/rollinginthedeep.jpg",
                "http://static.spin.com/files/2015/10/ariana-grande-focus.jpg"
        };

        for (int i = 0; i < artists.length; i++) {
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage(covers[i]);
            musicList.add(musicModel);
        }
        return musicList;
    }

    @Override
    public List<MusicModel> getAppDataList() {
        List<MusicModel> musicList = new ArrayList();

        String[] artists = new String[]{
                "Instagram",
                "Kaskus",
                "Blibli Commerce",
                "Twitter",
                "Path"};

        String[] titles = new String[]{
                "Instagram",
                "Kaskus",
                "Blibli Commerce",
                "Twitter",
                "Path"};

        String[] logos = new String[]{
                "http://tinyurl.com/zqzk2lq",
                "http://logodatabases.com/wp-content/uploads/2012/04/logo-kaskus.png",
                "https://icon.apkdot.com/blibli.mobile.commerce.png",
                "https://g.twimg.com/Twitter_logo_blue.png",
                "http://icons.iconarchive.com/icons/martz90/circle/512/path-icon.png"
        };

        String[] urls = new String[]{
                "https://play.google.com/store/apps/details?id=com.instagram.android&hl=en",
                "https://play.google.com/store/apps/details?id=com.kaskus.android&hl=en",
                "https://play.google.com/store/apps/details?id=blibli.mobile.commerce&hl=en",
                "https://play.google.com/store/apps/details?id=com.twitter.android&hl=en",
                "https://play.google.com/store/apps/details?id=com.path&hl=en"};

        for (int i = 0; i < artists.length; i++) {
            MusicModel musicModel = new MusicModel();
            musicModel.setTitle(titles[i]);
            musicModel.setArtist(artists[i]);
            musicModel.setCoverImage(logos[i]);
            musicModel.setUrl(urls[i]);
            musicList.add(musicModel);
        }
        return musicList;
    }
}
