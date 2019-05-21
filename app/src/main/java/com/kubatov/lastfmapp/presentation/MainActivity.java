package com.kubatov.lastfmapp.presentation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.kubatov.lastfmapp.App;
import com.kubatov.lastfmapp.R;
import com.kubatov.lastfmapp.presentation.topArtist.ITopArtistContract;
import com.kubatov.lastfmapp.presentation.topArtist.TopArtistPresenter;
import com.kubatov.lastfmapp.presentation.topArtist.TopArtistsFragment;
import com.kubatov.lastfmapp.presentation.topTracks.ITopTracksContract;
import com.kubatov.lastfmapp.presentation.topTracks.TopTracksFragment;
import com.kubatov.lastfmapp.presentation.topTracks.TopTracksPresenter;

public class MainActivity extends AppCompatActivity {
    //private static int NUM_ITEMS = 2;
    private ITopArtistContract.Presenter artistPresenter;
    private ITopTracksContract.Presenter tracksPresenter;
    private TopArtistsFragment artistsFragment;
    private TopTracksFragment tracksFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artistPresenter = new TopArtistPresenter(App.artistRepository);
        tracksPresenter = new TopTracksPresenter(App.trackRepository);
        artistsFragment = TopArtistsFragment.newInstance();
        tracksFragment = TopTracksFragment.newInstance();

        artistPresenter.attachView(artistsFragment);
        tracksPresenter.attachView(tracksFragment);

        ViewPager viewPager = findViewById(R.id.view_pager);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(MainActivity.this,
                getSupportFragmentManager(),
                new Fragment[]{
                        artistsFragment,
                        tracksFragment}
        );
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private Context context;
        private Fragment[] fragments;
        private String tabTitles[] = new String[]{"Top tracks", "Top artists"};

        public SectionsPagerAdapter(Context context, FragmentManager fm, Fragment[] fragments) {
            super(fm);
            this.context = context;
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }
}