package com.tounawang.mvp.model;

import com.tounawang.listenter.OnLoadListener;

/**
 * Description :Model的基类，可实现统一管理Model，类适于baseActivity的功能
 * Author : liujun
 * Email  : liujin2son@163.com
 * Date   : 2016/8/11 0011
 */
public interface BaseModel<T> {

    /**加载数据*/
    void loadData(String url,OnLoadListener onLoadListener);

    /**
     * 启动界面的Model
     */
    interface StartActivityModel extends BaseModel<String> {
         String getText();
    }

}


