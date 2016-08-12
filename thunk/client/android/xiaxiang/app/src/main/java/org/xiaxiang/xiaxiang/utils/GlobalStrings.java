package org.xiaxiang.xiaxiang.utils;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.content.res.ResourcesCompat;

import org.xiaxiang.xiaxiang.R;
/**
 * Created by gz on 2016/8/5.
 */
public class GlobalStrings {

    public static final String[] DrawerLayoutMenuListTitle = {
            "主页",
            "我的招募",
            "我的收藏",
            "我的兴趣",
            "主题风格",
            "推荐内容"
    };

    public static final int[] DrawerLayoutMenuListImageId = {
            R.mipmap.menu_home,
            R.mipmap.menu_box,
            R.mipmap.menu_collect,
            R.mipmap.menu_hobby,
            R.mipmap.menu_theme,
            R.mipmap.menu_share
    };

    public static final int[] BottomPanelSelectedImageID = {
            R.mipmap.message_selected,
            R.mipmap.contacts_selected,
            R.mipmap.play_selected,
            R.mipmap.play_selected
    };

    public static final int[] BottomPanelUnselectedImageID = {
            R.mipmap.message_unselected,
            R.mipmap.contacts_unselected,
            R.mipmap.play_unselected,
            R.mipmap.play_unselected
    };
}
