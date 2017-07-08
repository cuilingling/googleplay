package com.tencent.googleplay;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActionBar();
        initView();
        initActionbarDrawerToggle();
    }

    private void initView() {
        mDrawerlayout = (DrawerLayout) findViewById(R.id.main_drawerLayout);
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
                Toast.makeText(this, "点击了home按钮", Toast.LENGTH_SHORT).show();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
