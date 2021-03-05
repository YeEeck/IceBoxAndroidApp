package com.yeck.refrigerator;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.yeck.refrigerator.ui.dashboard.DashboardFragment;
import com.yeck.refrigerator.ui.home.HomeFragment;
import com.yeck.refrigerator.ui.notifications.NotificationsFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class Main2Activity extends AppCompatActivity implements NotificationsFragment.talkBack, HomeFragment.backTalk2, DashboardFragment.dashboard {
    Intent inIntent;
    TextView HelloText;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        inIntent = getIntent();

    }

    @Override
    protected void onStart() {
        super.onStart();
        HelloText = findViewById(R.id.HelloText);
        HelloText.setText(inIntent.getStringExtra("username") + "，欢迎使用慧冰智能冰箱。");

    }

    @Override
    public void change() {
        VerticalTabLayout tabLayout = findViewById(R.id.tablayoutV);
        assert tabLayout != null;
        tabLayout.setTabAdapter(new TabAdapter() {
            List<String> titles;

            {
                titles = new ArrayList<>();
                titles.add("自动");
                titles.add("饮食");
                titles.add("食材");
                titles.add("美食");
                titles.add("健康");
                titles.add("精选");
                Collections.addAll(titles);
            }

            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public TabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public QTabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public QTabView.TabTitle getTitle(int position) {
                return new QTabView.TabTitle.Builder()
                        .setContent(titles.get(position))
                        .setTextColor(Color.parseColor("#3b6978"), Color.BLACK)
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });

    }

    @Override
    public void changeName() {
        HelloText = findViewById(R.id.HelloText);
        HelloText.setText(inIntent.getStringExtra("username") + "，欢迎使用慧冰智能冰箱。");
    }

    @Override
    public void changePadding() {

    }
}


//    @Override
//    public void change(){
//        try {
//            HelloText.setText(inIntent.getStringExtra("username") + "，欢迎使用慧冰智能冰箱。");
//        } catch (Exception e){
//            System.out.println(e.toString());
//        }
//



