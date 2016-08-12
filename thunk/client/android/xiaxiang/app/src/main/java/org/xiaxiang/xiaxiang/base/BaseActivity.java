package org.xiaxiang.xiaxiang.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by gz on 2016/8/4.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static void setColor(Activity activity, int color) {
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT ) {
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            View statusView = createStatusView(activity, color);
            ViewGroup decorView = (ViewGroup)activity.getWindow().getDecorView();
            decorView.addView(statusView);

            ViewGroup rootView = (ViewGroup)((ViewGroup)activity.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }
    }

    public static void setTranslucent(Activity activity) {
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT ) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup rootView = (ViewGroup)((ViewGroup)activity.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }
    }

    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int color) {
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT ) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            View statusView = createStatusView(activity, color);
            ViewGroup contentLayout = (ViewGroup)drawerLayout.getChildAt(0);
            contentLayout.addView(statusView, 0);

            if ( !(contentLayout instanceof LinearLayout) && contentLayout.getChildAt(1) != null ) {
                int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
                int statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
                contentLayout.getChildAt(1).setPadding(0, statusBarHeight, 0, 0);
            }

            ViewGroup drawer = (ViewGroup)drawerLayout.getChildAt(1);
            drawerLayout.setFitsSystemWindows(false);
            contentLayout.setFitsSystemWindows(false);
            contentLayout.setClipToPadding(true);
            drawer.setFitsSystemWindows(false);
        }
    }

    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT ) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup contentLayout = (ViewGroup)drawerLayout.getChildAt(0);
            contentLayout.setFitsSystemWindows(true);
            contentLayout.setClipToPadding(true);

            ViewGroup vg = (ViewGroup)drawerLayout.getChildAt(1);
            vg.setFitsSystemWindows(false);
            drawerLayout.setFitsSystemWindows(false);
        }
    }

    private static View createStatusView(Activity activity, int color) {
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);

        View statusView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);
        return statusView;
    }
}
