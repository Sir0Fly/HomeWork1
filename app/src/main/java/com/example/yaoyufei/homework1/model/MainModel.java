package com.example.yaoyufei.homework1.model;

import com.example.yaoyufei.homework1.bean.TeacherBean;
import com.example.yaoyufei.homework1.net.ApiService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel {
    public void getData(final MainCallback mainCallback){
        Observable<TeacherBean> teacherBeanObservable = new Retrofit.Builder()
                .baseUrl(ApiService.baseUrl1)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .testTeach();

        teacherBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TeacherBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TeacherBean teacherBean) {

                        mainCallback.onSuccess(teacherBean);
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
    public interface MainCallback{
        void onSuccess(TeacherBean teacherBean);
        void onField(String s);
    }
}
