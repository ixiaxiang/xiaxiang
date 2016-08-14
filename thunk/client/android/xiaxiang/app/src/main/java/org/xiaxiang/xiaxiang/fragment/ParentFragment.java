package org.xiaxiang.xiaxiang.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.jivesoftware.smack.XMPPConnection;

import org.xiaxiang.xiaxiang.base.BaseActivity;
import org.xiaxiang.xiaxiang.data.DataWarehouse;


public class ParentFragment extends Fragment
{
    protected XMPPConnection mXMPPConnection;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mXMPPConnection = DataWarehouse.getXMPPConnection();
    }
}
