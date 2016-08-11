package com.tounawang.mvp.presenter;

/**
 * Description :Presenter的基类，可实现统一管理Presenter，类适于baseActivity的功能
 * Author : liujun
 * Email  : liujin2son@163.com
 * Date   : 2016/8/11 0011
 */
public interface BasePresenter<T>{

    T loadDate(String url);

    interface StartActivityPresenter extends BasePresenter<String> {
        void onClick(int id);
    }
}
