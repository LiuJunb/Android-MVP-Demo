package com.tounawang.mvp.view.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tounawang.utils.LogUtils;

import butterknife.ButterKnife;

/**
 * Description :
 * Author : liujun
 * Email  : liujin2son@163.com
 * Date   : 2016/8/11 0011
 */
public abstract class BaseFragment extends Fragment{

    private Context context;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = initView();
        ButterKnife.bind(this, view);
        LogUtils.i("BaseFragment", getClass().getSimpleName());
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context=getActivity();
      //  findViewById();
        initData();
    }

   public void Toast(String content) {
        Toast.makeText(context, content, Toast.LENGTH_LONG).show();
    }

    protected View findViewById(int id){
        return getView().findViewById(id);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * 初始化view
     * @return
     */
    protected abstract View initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

   // protected abstract void findViewById();

}
