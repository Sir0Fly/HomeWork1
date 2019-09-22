package com.example.yaoyufei.homework1.presenter;


import com.example.yaoyufei.homework1.bean.WhoBean;
import com.example.yaoyufei.homework1.model.WhoModel;
import com.example.yaoyufei.homework1.view.WhoView;

public class WhoPresenter {
    private final WhoModel whoModel;
    private WhoView whoView;

    public WhoPresenter(WhoView whoView) {
        this.whoView = whoView;
        whoModel = new WhoModel();
    }

    public void getInfo(int pager){
        whoModel.getData(pager, new WhoModel.WhoCallback() {
            @Override
            public void onSuccess(WhoBean whoBean) {
                if (whoView!=null){
                    whoView.onSuccess(whoBean);
                }
            }

            @Override
            public void onField(String s) {

                whoView.onField(s);
            }
        });
    }

}
