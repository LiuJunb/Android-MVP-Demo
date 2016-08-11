package com.tounawang.mvp.presenter;

import android.content.Context;

import com.tounawang.R;
import com.tounawang.listenter.OnLoadListener;
import com.tounawang.mvp.model.BaseModel;
import com.tounawang.mvp.model.StartActivityModelImpl;
import com.tounawang.mvp.view.BaseView;

/**
 * Description :
 * Author : liujun
 * Email  : liujin2son@163.com
 * Date   : 2016/8/11 0011
 */
public class StartActivityPresenterImpl implements BasePresenter.StartActivityPresenter{
    private  Context context;
    /**获取到mvp中的view*/
    private  BaseView.StartActivityView  startActivityView;
    /**获取到mvp中的model*/
    private  BaseModel.StartActivityModel startActivityModel;

    /**
     * 构造器
     * @param context  上下文
     * @param startActivityView  mvp中的view
     */
    public StartActivityPresenterImpl(Context context, BaseView.StartActivityView startActivityView) {
        this.context=context;
        this.startActivityView=startActivityView;
        this.startActivityModel=new StartActivityModelImpl();
    }


    @Override
    public void onClick(int id) {
        switch (id) {
            case R.id.button1:
                String str= startActivityView.getText();
//                String str=startActivityModel.getText();
                startActivityView.setText("获取界面的上的文字："+str);
                break;
            default:
                break;
        }
    }

    @Override
    public String loadDate(String url) {
        startActivityView.showProgress();
        startActivityModel.loadData(url, new OnLoadListener<String>() {
             @Override
             public void onSuccess(String s) {
                 //这里只是显示一个Toast而已，其实可以调用setDate（）方法
//                startActivityView.showToast("网络加载成功："+s);
                 startActivityView.setText("网络加载成功："+s);
                 startActivityView.hideProgress();
             }

             @Override
             public void onFailure(String msg, Exception e) {
                 startActivityView.showToast("网络加载失败："+msg);
                 startActivityView.setText("网络加载失败："+msg);
                 startActivityView.hideProgress();
//                 startActivityView.showNetWorkError();
             }
         });
        return null;
    }
}
