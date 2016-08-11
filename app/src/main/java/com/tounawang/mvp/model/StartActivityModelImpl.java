package com.tounawang.mvp.model;

import android.util.Log;

import com.tounawang.listenter.OnLoadListener;
import com.tounawang.network.OkHttpUtils;

/**
 * Description :
 * Author : liujun
 * Email  : liujin2son@163.com
 * Date   : 2016/8/11 0011
 */
public class StartActivityModelImpl implements BaseModel.StartActivityModel {

    @Override
    public void loadData(String url, final OnLoadListener onLoadListener) {
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                Log.d("StartActivityModelImp","response="+response);
                onLoadListener.onSuccess(response);
            }

            @Override
            public void onFailure(Exception e) {
                onLoadListener.onFailure(e.getMessage(),e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    @Override
    public String getText() {
        return "liujun";
    }
}
