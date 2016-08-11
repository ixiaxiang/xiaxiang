package org.xiaxiang.xiaxiang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

import org.jivesoftware.smack.XMPPConnection;
import org.xiaxiang.xiaxiang.R;
import org.xiaxiang.xiaxiang.common.XMPPUtil;
import org.xiaxiang.xiaxiang.data.DataWarehouse;
import org.xiaxiang.xiaxiang.data.LoginData;
import org.xiaxiang.xiaxiang.utils.Storage;
import org.xiaxiang.xiaxiang.common.Const;

/**
 * Created by chenyujing on 2016/8/6.
 */
public class LoginActivity extends ParentActivity implements OnClickListener, Const {

    private static final String TAG = "LoginActivity";
    private Button mButtonLogin;
    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private LoginData mLoginData;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initLoginButton();
    }

    @Override
    protected void onStart() {
        super.onStart();
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

    private void initLoginButton() {
        mButtonLogin = (Button) findViewById(R.id.login_button);
        mEditTextUsername = (EditText) findViewById(R.id.login_username_edittext);
        mEditTextPassword = (EditText) findViewById(R.id.login_password_edittext);
        mButtonLogin.setOnClickListener(this);

        mLoginData = DataWarehouse.getGlobalData(this).loginData;

        mLoginData.username = Storage.getString(this, KEY_USERNAME);
        mLoginData.password = Storage.getString(this, KEY_PASSWORD);
        mLoginData.loginServer = Storage.getString(this, KEY_LOGIN_SERVER);
        mLoginData.isAutoLogin = Storage.getBoolean(this, KEY_AUTO_LOGIN);
        mLoginData.isSavePassword = Storage.getBoolean(this, KEY_SAVE_PASSWORD);
        mEditTextUsername.setText(mLoginData.username);
        mEditTextPassword.setText(mLoginData.password);

    }

    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.login_button:
                onClick_Login(view);
                break;

            default:
                break;
        }

    }

    public void onClick_Login(View view) {

        mLoginData.username = mEditTextUsername.getText().toString();
        mLoginData.password = mEditTextPassword.getText().toString();
        mLoginData.loginServer = "120.76.136.30";

        Storage.putString(this, KEY_USERNAME, mLoginData.username);
        Storage.putString(this, KEY_PASSWORD, mLoginData.password);

        // Toast.makeText(getActivity(), "ok", Toast.LENGTH_LONG).show();
        new Thread(new Runnable()
        {

            @Override
            public void run()
            {

                if (login())
                {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                     startActivity(intent);
                    finish();
                }
                else
                {
                    mHandler.post(new Runnable()
                    {

                        @Override
                        public void run()
                        {
                            Toast.makeText(LoginActivity.this,
                                    "登录失败，请检查用户名、密码和服务器IP的正确性！",
                                    Toast.LENGTH_LONG).show();

                        }
                    });

                }

            }
        }).start();

    }

    private boolean login()
    {

        boolean hasErrors = false;
        String errorMessage = null;

        if (!hasErrors)
        {

            try
            {
                Log.i(TAG, "mLoginData.loginServer " + mLoginData.loginServer);
                XMPPConnection connection = XMPPUtil.getXMPPConnection(mLoginData.loginServer);

                if (connection == null)
                {
                    throw new Exception("连接服务器失败.");
                }
                connection.login(mLoginData.username, mLoginData.password);


                DataWarehouse.setXMPPConnection(this, connection);
                DataWarehouse.setServiceName(this, connection.getServiceName());


            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;

            }

        }

        return true;
    }
}
