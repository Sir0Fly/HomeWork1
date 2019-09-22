package com.example.yaoyufei.homework1.presenter;

import com.example.yaoyufei.homework1.bean.TeacherBean;
import com.example.yaoyufei.homework1.model.MainModel;
import com.example.yaoyufei.homework1.view.MainView;

public class MainPresenter {
    private final MainModel mainModel;
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModel();
    }

    public void getInfo(){
        mainModel.getData(new MainModel.MainCallback() {
            @Override
            public void onSuccess(TeacherBean teacherBean) {
                if (mainView!=null){
                    mainView.onSuccess(teacherBean);
                }
            }

            @Override
            public void onField(String s) {

                mainView.onField(s);
            }
        });
    }

}
