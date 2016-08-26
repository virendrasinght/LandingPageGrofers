package com.example.viren.landingpagegrofers;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Viren on 8/26/2016.
 */
public class NavigationDrawerFragment extends Fragment {
    private ActionBarDrawerToggle mdrawerToggle;
    private DrawerLayout mdrawer_layout;
    private View containerView;
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }


    public void setup(int fragmentid, DrawerLayout drawerLayout, final android.support.v7.widget.Toolbar toolbar) {
        mdrawer_layout = drawerLayout;

        containerView = getActivity().findViewById(fragmentid);
        mdrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.open, R.string.close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if (slideOffset < 0.6) {
                    toolbar.setAlpha(1 - slideOffset);
                }
                super.onDrawerSlide(drawerView, slideOffset);
            }

        };

        mdrawer_layout.setDrawerListener(mdrawerToggle);
        mdrawer_layout.post(new Runnable() {

            @Override
            public void run() {
                mdrawerToggle.syncState();
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mdrawerToggle.onConfigurationChanged(newConfig);
    }
}
