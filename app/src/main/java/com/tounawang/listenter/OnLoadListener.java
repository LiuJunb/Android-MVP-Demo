package com.tounawang.listenter;

/**
 * Description :网络请求的回调
 * Author : liujun
 * Email  : liujin2son@163.com
 * Date   : 2016/8/11 0011
 */
public interface OnLoadListener<T> {
    void onSuccess(T t);
    void onFailure(String msg, Exception e);
}
