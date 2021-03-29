package com.yeck.refrigerator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.yeck.refrigerator.ui.dashboard.DashboardFragment;
import com.yeck.refrigerator.ui.home.HomeFragment;
import com.yeck.refrigerator.ui.mine.Navigation_mine;
import com.yeck.refrigerator.ui.notifications.NotificationsFragment;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class Main2Activity extends AppCompatActivity implements NotificationsFragment.talkBack, HomeFragment.backTalk2, DashboardFragment.dashboard, Navigation_mine.mineBack {
    Intent inIntent;
    TextView HelloText;
    String name;
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
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_mine)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        inIntent = getIntent();
        name = inIntent.getStringExtra("username");
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onStart() {
        super.onStart();

    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void change(final Fragment frag) {
        VerticalTabLayout tabLayout = findViewById(R.id.tablayoutV);
        assert tabLayout != null;
        tabLayout.setTabAdapter(new TabAdapter() {
            List<String> titles;

            {
                titles = new ArrayList<>();
                titles.add("自动");
                titles.add("饮食");
                titles.add("母婴");
                titles.add("美食");
                titles.add("健康");
                titles.add("时令");
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
                        .setTextColor(Color.parseColor("#1296db"), Color.BLACK)
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });

        WebView webView = findViewById(R.id.webviewRecommand);
        WebSettings settings = webView.getSettings();
        assert settings != null;
        settings.setJavaScriptEnabled(true);    //支持javascript
        settings.setUseWideViewPort(true);    //设置webview推荐使用的窗口，使html界面自适应屏幕
        settings.setLoadWithOverviewMode(true);     //缩放至屏幕的大小
        settings.setAllowFileAccess(true);      //设置可以访问文件
//        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);    //设置中等像素密度，medium=160dpi
        settings.setSupportZoom(true);    //设置支持缩放
        settings.setLoadsImagesAutomatically(true);    //设置自动加载图片
//        settings.setBlockNetworkImage(true);    //设置网页在加载的时候暂时不加载图片
//        settings.setAppCachePath("");   //设置缓存路径
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);   //设置缓存模式
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });

        webView.loadUrl("file:///android_asset/html/recommend/recommend.html");

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void changeName() {
//        HelloText = findViewById(R.id.HelloText);
//        assert HelloText != null;
//        HelloText.setText(name + "，欢迎使用慧冰智能冰箱。");
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void setHomeWebview(final Fragment frag) {
        WebView webView = findViewById(R.id.webViewHome);
        WebSettings settings = webView.getSettings();
        assert settings != null;
        settings.setJavaScriptEnabled(true);    //支持javascript
        settings.setUseWideViewPort(true);    //设置webview推荐使用的窗口，使html界面自适应屏幕
        settings.setLoadWithOverviewMode(true);     //缩放至屏幕的大小
        settings.setAllowFileAccess(true);      //设置可以访问文件
//        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);    //设置中等像素密度，medium=160dpi
        settings.setSupportZoom(true);    //设置支持缩放
        settings.setLoadsImagesAutomatically(true);    //设置自动加载图片
//        settings.setBlockNetworkImage(true);    //设置网页在加载的时候暂时不加载图片
//        settings.setAppCachePath("");   //设置缓存路径
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);   //设置缓存模式
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                //底部导航栏跳转，frag是接口回调的参数
                if (url.equals("file:///android_asset/html/home/change.html")) {
                    NavHostFragment
                            .findNavController(frag)
                            .navigate(R.id.navigation_dashboard);
                } else if (url.equals("file:///android_asset/html/home/change2.html")) {
                    NavHostFragment
                            .findNavController(frag)
                            .navigate(R.id.navigation_notifications);
                } else {
                    view.loadUrl(url);
                }
                return true;
            }

        });

        webView.loadUrl("file:///android_asset/html/home/home.html");
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void changePadding() {
        WebView webView = findViewById(R.id.webViewControl);
        WebSettings settings = webView.getSettings();
        assert settings != null;
        settings.setJavaScriptEnabled(true);    //支持javascript
        settings.setUseWideViewPort(true);    //设置webview推荐使用的窗口，使html界面自适应屏幕
        settings.setLoadWithOverviewMode(true);     //缩放至屏幕的大小
        settings.setAllowFileAccess(true);      //设置可以访问文件
//        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);    //设置中等像素密度，medium=160dpi
        settings.setSupportZoom(true);    //设置支持缩放
        settings.setLoadsImagesAutomatically(true);    //设置自动加载图片
//        settings.setBlockNetworkImage(true);    //设置网页在加载的时候暂时不加载图片
//        settings.setAppCachePath("");   //设置缓存路径
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);   //设置缓存模式
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });

        webView.loadUrl("file:///android_asset/html/control/control.html");
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void setWebView() {
        WebView webView = findViewById(R.id.webview1);
        WebSettings settings = webView.getSettings();
        assert settings != null;
        settings.setJavaScriptEnabled(true);    //支持javascript
        settings.setUseWideViewPort(true);    //设置webview推荐使用的窗口，使html界面自适应屏幕
        settings.setLoadWithOverviewMode(true);     //缩放至屏幕的大小
        settings.setAllowFileAccess(true);      //设置可以访问文件
//        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);    //设置中等像素密度，medium=160dpi
        settings.setSupportZoom(true);    //设置支持缩放
        settings.setLoadsImagesAutomatically(true);    //设置自动加载图片
//        settings.setBlockNetworkImage(true);    //设置网页在加载的时候暂时不加载图片
//        settings.setAppCachePath("");   //设置缓存路径
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);   //设置缓存模式
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("file:///android_asset/html/mine/page1.html");


        final ProgressBar progressBar = findViewById(R.id.progressBar);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //显示进度条
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    //加载完毕隐藏进度条
                    progressBar.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
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



