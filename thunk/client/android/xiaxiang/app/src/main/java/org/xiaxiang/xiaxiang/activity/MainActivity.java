package org.xiaxiang.xiaxiang.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.xiaxiang.xiaxiang.R;
import org.xiaxiang.xiaxiang.base.BaseActivity;
import org.xiaxiang.xiaxiang.fragment.ContactsFragment;
import org.xiaxiang.xiaxiang.fragment.FriendFragment;
import org.xiaxiang.xiaxiang.fragment.MessageFragment;
import org.xiaxiang.xiaxiang.fragment.PlayFragment;
import org.xiaxiang.xiaxiang.ui.ImageText;
import org.xiaxiang.xiaxiang.utils.GlobalStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private int tabIndex = 0;
    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private FriendFragment friendFragment;
    private PlayFragment playFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private ImageText messageButton;
    private ImageText contactsButton;
    private ImageText friendButton;
    private ImageText playButton;

    private DrawerLayout drawerLayout;
    private ListView listView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, messageFragment);
        fragmentTransaction.commit();
        setTabSelectedImage(0);
    }

    private void initUI() {
        initFragment();
        initBottomButton();
        initLeftMenu();
        initToolbar();
    }

    // 初始化fragment
    private void initFragment() {
        messageFragment = new MessageFragment();
        contactsFragment = new ContactsFragment();
        friendFragment = new FriendFragment();
        playFragment = new PlayFragment();
    }

    private void initBottomButton() {
        messageButton = (ImageText) findViewById(R.id.button_messgae);
        contactsButton = (ImageText) findViewById(R.id.button_contacts);
        friendButton = (ImageText) findViewById(R.id.button_friends);
        playButton = (ImageText) findViewById(R.id.button_play);

        messageButton.setOnClickListener(new ButtonClickListener(0));
        contactsButton.setOnClickListener(new ButtonClickListener(1));
        friendButton.setOnClickListener(new ButtonClickListener(2));
        playButton.setOnClickListener(new ButtonClickListener(3));
    }


    // 初始化菜单栏
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

    // 初始化工具栏
    private void initToolbar() {
        toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
    }


    class ButtonClickListener implements View.OnClickListener {
        int index;
        public ButtonClickListener(int index) {
            this.index = index;
        }

        @Override
        public void onClick(View view) {
            fragmentTransaction = fragmentManager.beginTransaction();
            switch ( view.getId() ) {
                case R.id.button_messgae:
                    fragmentTransaction.replace(R.id.fragment_content, messageFragment);
                    break;
                case R.id.button_contacts:
                    fragmentTransaction.replace(R.id.fragment_content, contactsFragment);
                    break;
                case R.id.button_friends:
                    fragmentTransaction.replace(R.id.fragment_content, friendFragment);
                    break;
                case R.id.button_play:
                    fragmentTransaction.replace(R.id.fragment_content, playFragment);
                    break;
                default:
                    break;
            }

            if ( tabIndex != index ) {
                setTabSelectedImage(index);
                setTabUnselectedImage(tabIndex);
                fragmentTransaction.commit();
            }

            tabIndex = index;
        }
    }

    public void setTabSelectedImage(int index) {
        switch (index) {
            case 0:
                messageButton.setTabImage(ResourcesCompat.getDrawable(getResources(), GlobalStrings.BottomPanelSelectedImageID[0], null));
                messageButton.setTabTextColor(R.color.bottom_panel_green);
                break;
            case 1:
                contactsButton.setTabImage(ResourcesCompat.getDrawable(getResources(), GlobalStrings.BottomPanelSelectedImageID[1], null));
                contactsButton.setTabTextColor(R.color.bottom_panel_green);
                break;
            case 2:
                friendButton.setTabImage(ResourcesCompat.getDrawable(getResources(), GlobalStrings.BottomPanelSelectedImageID[2], null));
                friendButton.setTabTextColor(R.color.bottom_panel_green);
                break;
            case 3:
                playButton.setTabImage(ResourcesCompat.getDrawable(getResources(), GlobalStrings.BottomPanelSelectedImageID[3], null));
                playButton.setTabTextColor(R.color.bottom_panel_green);
                break;
            default:
                break;
        }
    }

    public void setTabUnselectedImage(int index) {
        switch (index) {
            case 0:
                messageButton.setTabImage(ResourcesCompat.getDrawable(getResources(), GlobalStrings.BottomPanelUnselectedImageID[0], null));
                messageButton.setTabTextColor(R.color.grey);
                break;
            case 1:
                contactsButton.setTabImage(ResourcesCompat.getDrawable(getResources(), GlobalStrings.BottomPanelUnselectedImageID[1], null));
                contactsButton.setTabTextColor(R.color.grey);
                break;
            case 2:
                friendButton.setTabImage(ResourcesCompat.getDrawable(getResources(), GlobalStrings.BottomPanelUnselectedImageID[2], null));
                friendButton.setTabTextColor(R.color.grey);
                break;
            case 3:
                playButton.setTabImage(ResourcesCompat.getDrawable(getResources(), GlobalStrings.BottomPanelUnselectedImageID[3], null));
                playButton.setTabTextColor(R.color.grey);
                break;
            default:
                break;
        }
    }

}
