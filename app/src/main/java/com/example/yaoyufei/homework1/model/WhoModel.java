package com.example.yaoyufei.homework1.model;

import com.example.yaoyufei.homework1.bean.WhoBean;
import com.example.yaoyufei.homework1.net.ApiService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WhoModel {
    public void getData(int pager,final WhoCallback mainCallback){
        Observable<WhoBean> teacherBeanObservable = new Retrofit.Builder()
                .baseUrl(ApiService.baseUrl2)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .testWho(pager);

        teacherBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WhoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WhoBean whoBean) {

                        mainCallback.onSuccess(whoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainCallback.onField(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public interface WhoCallback{
        void onSuccess(WhoBean whoBean);
        void onField(String s);
    }
}
