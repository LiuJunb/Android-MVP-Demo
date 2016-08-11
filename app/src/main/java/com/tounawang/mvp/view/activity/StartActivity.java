package com.tounawang.mvp.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tounawang.R;
import com.tounawang.mvp.presenter.StartActivityPresenterImpl;
import com.tounawang.mvp.view.BaseView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StartActivity extends BaseActivity implements BaseView.StartActivityView {

    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.button2)
    Button button2;

    private StartActivityPresenterImpl mPresenterImpl;
    private String url="https://www.google.com";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    protected void initDate() {
        mPresenterImpl = new StartActivityPresenterImpl(getContext(), this);
    }

    @Override
    protected void setListener() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //从界面上获取数据展示（演示mvp调用步骤）
                mPresenterImpl.onClick(R.id.button1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //从网络上获取数据展示(演示mvp调用步骤)
                mPresenterImpl.loadDate(url);
            }
        });
    }

    @Override
    public void setData(List<String> datas) {

    }

    @Override
    public void showNetWorkError() {

    }

    @Override
    public void hideProgress() {
        hideProgressDailog();

    }

    @Override
    public void showProgress() {
        showProgressDailog();
    }

    @Override
    public void showToast(String msg) {
        Toast(msg);
    }


    @Override
    public void setText(String str) {

        tv.setText(str);
    }

    @Override
    public String getText() {
       return tv.getText().toString();
    }


}
