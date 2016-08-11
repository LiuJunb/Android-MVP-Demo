package com.tounawang.mvp.view.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tounawang.R;
import com.tounawang.utils.ActivityCollector;
import com.tounawang.utils.LogUtils;

import butterknife.ButterKnife;

/**
 * Description :
 * Author : liujun
 * Email  : liujin2son@163.com
 * Date   : 2016/8/11 0011
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Context context;
    private BaseActivity activity;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        activity = this;
        setContentView(getLayoutId());
        LogUtils.i("BaseActivity", getClass().getSimpleName());
        ButterKnife.bind(this);
        ActivityCollector.addActivity(this);
        initDate();
        setListener();
    }

    public void Toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    public void showProgressDailog(){
        if(progressDialog==null)
            //注意这里的参数只能使用activity，只有activity能add window
             progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("请等候，数据加载中……");
        progressDialog.show();
    }

    public void hideProgressDailog(){
        if(progressDialog==null)return;
        if(progressDialog.isShowing())
            progressDialog.dismiss();
    }

    public  Context getContext() {
        return context;
    }

    public  Activity getActivity() {
        return activity;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    protected abstract void setListener();
    protected abstract int getLayoutId();
    protected abstract void initDate();
}
