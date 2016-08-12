package org.xiaxiang.xiaxiang.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.xiaxiang.xiaxiang.R;

/**
 * Created by gz on 2016/8/11.
 */
public class ImageText extends RelativeLayout {

    private ImageView tabImage;
    private TextView tabText;
    private ImageView tabTip;

    private Drawable tab_drawable;
    private String tab_text;
    private boolean tab_tip_enable;
    private int tab_text_color;

    public ImageText(Context context) {
        super(context);
    }

    public ImageText(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bottom_panel_item, this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageText);

        tab_drawable = typedArray.getDrawable(R.styleable.ImageText_tab_image);
        tab_text = typedArray.getString(R.styleable.ImageText_tab_text);
        tab_tip_enable = typedArray.getBoolean(R.styleable.ImageText_tab_tip, false);
        tab_text_color = typedArray.getColor(R.styleable.ImageText_tab_text_color, Color.BLACK);

        init();
    }

    private void init() {
        tabImage = (ImageView)findViewById(R.id.tab_image);
        tabText = (TextView)findViewById(R.id.tab_text);
        tabTip = (ImageView)findViewById(R.id.tab_tip);

        setTabImage(tab_drawable);
        setTabText(tab_text);
        setTabTip(tab_tip_enable);
        setTabTextColor(tab_text_color);
    }

    public void setTabImage(Drawable drawable) {
        tabImage.setImageDrawable(drawable);
    }

    public void setTabText(String string) {
        tabText.setText(string);
    }

    public void setTabTip(boolean enable) {
        if ( enable ) {
            tabTip.setVisibility(VISIBLE);
        } else {
            tabTip.setVisibility(INVISIBLE);
        }
    }

    public void setTabTextColor(int color) {
        tabText.setTextColor(color);
    }
}
