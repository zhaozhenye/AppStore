package com.dingzhu.appstore.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dingzhu.appstore.R;
import com.dingzhu.appstore.di.component.AppComponent;
import com.dingzhu.appstore.ui.adapter.ViewPagerAdapter;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawerlayout_view)
    DrawerLayout mDrawerlayoutView;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        initDrawerlayout();
        initTabLayout();
    }

    @Override
    public void setupActivityCompontent(AppComponent appComponent) {

    }

    private void initTabLayout() {
        PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initDrawerlayout() {
        headerView = mNavigationView.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "侧滑菜单", Toast.LENGTH_SHORT).show();
            }
        });
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.item_setting:
                        Toast.makeText(MainActivity.this, "应用更新", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_message:
                        Toast.makeText(MainActivity.this, "消息中心", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_search:
                        Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        mToolBar.inflateMenu(R.menu.menu_toolbar);
        ActionBarDrawerToggle barDrawerToggle = new ActionBarDrawerToggle(this, mDrawerlayoutView, mToolBar, R.string.open, R.string.close);
        barDrawerToggle.syncState();//同步状态
        mDrawerlayoutView.addDrawerListener(barDrawerToggle);
    }
}
