package com.tencent.googleplay;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.astuetz.PagerSlidingTabStripExtend;
import com.tencent.googleplay.FragmentFactory.FragmentFactory;
import com.tencent.googleplay.utils.StringUtils;
import com.tencent.googleplay.utils.UIUtils;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    private ViewPager mViewPager;
    private PagerSlidingTabStripExtend mTabs;
    private String[] mMainTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActionBar();
        initView();
        initActionbarDrawerToggle();
        initData();
    }



    private void initView() {
        //找到抽屉布局
        mDrawerlayout = (DrawerLayout) findViewById(R.id.main_drawerLayout);
        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        mTabs = (PagerSlidingTabStripExtend) findViewById(R.id.main_tabs);
    }

    private void initActionbarDrawerToggle() {
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.open, R.string.close);
        mToggle.syncState();
        //设置drawerLayout的监听 --> DrawerLayout拖动的时候,toggle可以跟着改变ui
        mDrawerlayout.setDrawerListener(mToggle);

    }

    private void initActionBar() {
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("GooglePlay");
        supportActionBar.setIcon(R.drawable.ic_launcher);
        supportActionBar.setLogo(R.drawable.arrow_down);

        //显示logo/icon(图标)
        supportActionBar.setDisplayShowHomeEnabled(false);//默认是false,默认是隐藏图标

        //修改icon和logo显示的优先级
        supportActionBar.setDisplayUseLogoEnabled(true);//默认是false,默认是没用logo,用的icon

        //显示回退部分
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //点击toggle 可以改变菜单是打开还是关闭
                mToggle.onOptionsItemSelected(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 设置适配器,以及数据
     */
    private void initData() {
        mMainTitles = UIUtils.getStrings(R.array.main_titles);
        mMianpagerAdepter adepter = new mMianpagerAdepter(getSupportFragmentManager());
        mViewPager.setAdapter(adepter);

        //绑定tab
        //pager.setOnPageChangeListener(pageListener);已经设置过监听了,所以不能再设置了.
        //再次的设置会从新复制,之前的会覆盖掉
        mTabs.setViewPager(mViewPager);
    }

    class mMianpagerAdepter extends FragmentStatePagerAdapter {

        public mMianpagerAdepter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        @Override
        public int getCount() {
            if (mMainTitles != null) {
                return mMainTitles.length;
            }
            return 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return  mMainTitles[position];
        }
    }
}
