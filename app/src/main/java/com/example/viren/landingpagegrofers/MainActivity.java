package com.example.viren.landingpagegrofers;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.viren.landingpagegrofers.adapter.ExpandableGvAdapter;
import com.example.viren.landingpagegrofers.adapter.NavigationDrawerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
private static ViewPager pager;
    int[] IMAGES = {
            R.drawable.jaipur,
            R.drawable.goa,
            R.drawable.rishikesh,
            R.drawable.dharmshala
    };
    ListView mdrawerlist;
NavigationDrawerFragment drawerFragment;
Button handler1;
    ArrayList<Integer> ImageArray=new ArrayList<>();
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    ExpandableHeightGridView gridView;
    ExpandableHeightGridView1 gridview1;
    public static int[] productImg = {R.drawable.jaipur, R.drawable.rishikesh, R.drawable.goa, R.drawable.dharmshala, R.drawable.jaipur, R.drawable.goa};
    String[] productName = {"Soap", "Detergent", "Silk", "Food", "Fridge", "TV"};
    ArrayList<String> array_sort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler1 = (Button) findViewById(R.id.handler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mdrawerlist=(ListView) findViewById(R.id.list_id);
        array_sort = new ArrayList<String>(Arrays.asList(productName));

        //Navigation Drawer starts=================================
        drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setup(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawerlayout), toolbar);

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header2 = (ViewGroup) inflater.inflate(R.layout.header, mdrawerlist, false);
        mdrawerlist.addHeaderView(header2, null, false);

        mdrawerlist.setAdapter(new NavigationDrawerAdapter(this,array_sort));


//Image Slider Section Start======================================
        for (int i = 0; i < IMAGES.length; i++)
            ImageArray.add(IMAGES[i]);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new SlidingImage_Adapter(MainActivity.this, ImageArray));
        pager.setClipToPadding(false);
        pager.setPadding(40,0,40,0);
        pager.setPageMargin(20);
        NUM_PAGES = IMAGES.length;
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);
//Image Slider Section End=======================================

        //Expandable Gridview Section Start================================
        gridView=(ExpandableHeightGridView) findViewById(R.id.spotsView);
        gridview1=(ExpandableHeightGridView1) findViewById(R.id.spotsView1);
        gridView.setExpanded(true);
        gridView.setAdapter(new ExpandableGvAdapter(this,productImg));
        gridview1.setVisibility(View.GONE);
gridview1.setAdapter(new ExpandableGvAdapter(this,productImg));
        // handler button click event====================================================
        handler1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gridview1.getVisibility() == View.VISIBLE) {
                    gridview1.setVisibility(View.GONE);
                    handler1.setText("More Categories");
                } else {
                    gridview1.setVisibility(View.VISIBLE);
                    gridview1.setExpanded(true);
                    handler1.setText("Less Categories");
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_actions_menu, menu);
    return true;
    }
}
