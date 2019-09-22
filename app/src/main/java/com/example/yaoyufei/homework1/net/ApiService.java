package com.example.yaoyufei.homework1.net;

import com.example.yaoyufei.homework1.bean.TeacherBean;
import com.example.yaoyufei.homework1.bean.WhoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String baseUrl1="https://api.yunxuekeji.cn/";
   // 解释：ID替换成第一个接口中获取得到的ID
    String baseUrl2="https://api.yunxuekeji.cn/";
    //默认视频播放地址：
    //https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/classfile/0/从技术走向管理/001.从技术到管理_第1节_从技术到管理的内外部因素.mp4

    @GET("yunxue_app_api/content/getData/30/66597/1/10")
    Observable<TeacherBean> testTeach();

    @GET("yunxue_app_api/teacher/getTeacherPower/{ID}")
    Observable<WhoBean> testWho(@Path("ID") int id);

}
