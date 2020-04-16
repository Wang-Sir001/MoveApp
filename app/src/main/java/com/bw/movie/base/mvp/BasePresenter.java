package com.bw.movie.base.mvp;

import java.lang.ref.WeakReference;

/**
 * data:2020/3/16
 * author:王江伟(DJ慢羊羊)
 * function: Presenter层基类
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    //采用弱引用，绑定，解绑，解决内存泄漏
    private WeakReference<V> mVWeakReference;

    public BasePresenter() {
        model = initModel();
    }

    public void attach(V v){
        mVWeakReference = new WeakReference<>(v);
    }

    public void detach(){
        if (mVWeakReference != null) {
            mVWeakReference.clear();
            mVWeakReference=null;
        }
    }

    protected abstract M initModel();

    public V getView(){
        return mVWeakReference.get();
    }

}
