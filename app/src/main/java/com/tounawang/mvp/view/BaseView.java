package com.tounawang.mvp.view;

import java.util.List;

/**
 * Description :View的基类，可实现统一管理BaseView，类适于baseActivity的功能
 * Author : liujun
 * Email  : liujin2son@163.com
 * Date   : 2016/8/11 0011
 */
public interface  BaseView<T> {
    /**填充数据*/
    void setData(List<T> datas);
    /**显示网络请求出错*/
    void showNetWorkError();
    /**隐藏进度条*/
    void hideProgress();
    /**显示进度条*/
    void showProgress();
    /**显示Toast*/
    void showToast(String msg);
    /**
     * 欢迎界面的View
     */
    interface StartActivityView extends BaseView<String> {
        void setText(String str);
        String getText();
    }
}
