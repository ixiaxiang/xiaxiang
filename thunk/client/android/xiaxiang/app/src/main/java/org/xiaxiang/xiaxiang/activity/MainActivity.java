package org.xiaxiang.xiaxiang.activity;

import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.xiaxiang.xiaxiang.R;
import org.xiaxiang.xiaxiang.base.BaseActivity;
import org.xiaxiang.xiaxiang.utils.GlobalStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        initLeftMenu();
        initToolbar();
    }

    private void initLeftMenu() {
        initDrawerLayout();
        initLeftMenuList();
    }

    private void initDrawerLayout() {
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_menu_layout);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        });
    }

    private void initLeftMenuList() {
        listView = (ListView)findViewById(R.id.left_menu_list);
        List<Map<String, Object>> leftMenuList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < GlobalStrings.DrawerLayoutMenuListImageId.length; i++ ) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("menu_icon", GlobalStrings.DrawerLayoutMenuListImageId[i]);
            map.put("menu_text", GlobalStrings.DrawerLayoutMenuListTitle[i]);
            leftMenuList.add(map);
        }

        SimpleAdapter leftMenuAdapter = new SimpleAdapter(this, leftMenuList, R.layout.drawer_menu_item,
                new String[] {"menu_icon", "menu_text"},
                new int[] {R.id.menu_icon, R.id.menu_text});
        listView.setAdapter(leftMenuAdapter);
    }

    private void initToolbar() {
        toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
    }
}
