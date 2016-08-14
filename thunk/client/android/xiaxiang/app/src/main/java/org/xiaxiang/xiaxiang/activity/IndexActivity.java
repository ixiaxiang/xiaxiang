package org.xiaxiang.xiaxiang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import org.xiaxiang.xiaxiang.R;
import org.xiaxiang.xiaxiang.base.BaseActivity;

/**
 * Created by cgz on 2016/8/6.
 */
public class IndexActivity extends BaseActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        setTranslucent(this);
        startIndex();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void startIndex() {
        Handler mStart = new Handler();
        mStart.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IndexActivity.this, LoginActivity.class);
                //Intent intent = new Intent(IndexActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
