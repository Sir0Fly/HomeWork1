package com.example.yaoyufei.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yaoyufei.homework1.adapter.MyFragmentStatePagerAdapter;
import com.example.yaoyufei.homework1.bean.TeacherBean;
import com.example.yaoyufei.homework1.bean.WhoBean;
import com.example.yaoyufei.homework1.fragment.ClassesFragment;
import com.example.yaoyufei.homework1.fragment.MainFragment;
import com.example.yaoyufei.homework1.presenter.WhoPresenter;
import com.example.yaoyufei.homework1.view.WhoView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements WhoView {

    private static final String TAG = "Main2Activity";
    private ImageView mItemIv;
    private TextView mItemName;
    /**
     * 关注
     */
    private TextView mItemLove;
    /**
     * 导师
     */
    private TextView mItemJob;
    private TextView mItemPart;
    private TabLayout mMain2Tab;
    private ViewPager mMain2Pager;
    private ArrayList<Fragment> list;
    private int id;
    private List<WhoBean.BodyEntity.ResultEntity> result = new ArrayList<>();
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        initView();
        initData();
        initPager();
    }

    private void initPager() {

        ArrayList<String> strings = new ArrayList<>();

        if (result.size()>0) {
            for (WhoBean.BodyEntity.ResultEntity s : result) {
                String description = s.getDescription();
                strings.add(description);
            }
            Log.d(TAG, "initPager: " + strings);
        }

        list = new ArrayList<>();

        MainFragment mainFragment = new MainFragment();
        list.add(mainFragment);

        ClassesFragment classesFragment = new ClassesFragment();
        list.add(classesFragment);

        MainFragment mainFragment1 = new MainFragment();
        list.add(mainFragment1);

        MyFragmentStatePagerAdapter myFragmentStatePagerAdapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager(), list, strings);
        mMain2Pager.setAdapter(myFragmentStatePagerAdapter);
        mMain2Tab.setupWithViewPager(mMain2Pager);

        mMain2Tab.getTabAt(0).setText("介绍");
        mMain2Tab.getTabAt(1).setText("课程");
        mMain2Tab.getTabAt(2).setText("专题");


    }


    private void initData() {


        int position = intent.getIntExtra("position", -1);


        List<TeacherBean.BodyEntity.ResultEntity> result = (List<TeacherBean.BodyEntity.ResultEntity>) intent.getSerializableExtra("result");

        RequestOptions placeholder = new RequestOptions().circleCrop().placeholder(R.mipmap.ic_launcher);
        Glide.with(this).load(result.get(position).getTeacherPic()).apply(placeholder).into(mItemIv);
        mItemName.setText(result.get(position).getTeacherName());
        mItemJob.setText(result.get(position).getTitle());

        List<?> teacherType = (List<Object>) result.get(position).getTeacherType();
        if (teacherType != null && teacherType.size() > 0) {
            String ty = "#";
            for (int j = 0; j < teacherType.size(); j++) {
                String type = teacherType.get(j).toString();
                String substring = type.substring(type.indexOf("=") + 1, type.lastIndexOf("}"));
                ty += substring + "#";

            }
            mItemPart.setText(ty);
        }


    }

    private void initView() {
        intent = getIntent();
        id = intent.getIntExtra("id", -1);
        new WhoPresenter(this).getInfo(id);

        mItemIv = (ImageView) findViewById(R.id.item_iv);
        mItemName = (TextView) findViewById(R.id.item_name);
        mItemLove = (TextView) findViewById(R.id.item_love);
        mItemJob = (TextView) findViewById(R.id.item_job);
        mItemPart = (TextView) findViewById(R.id.item_part);
        mMain2Tab = (TabLayout) findViewById(R.id.main2_tab);
        mMain2Pager = (ViewPager) findViewById(R.id.main2_pager);
    }

    @Override
    public void onSuccess(WhoBean whoBean) {
        result = whoBean.getBody().getResult();

    }

    @Override
    public void onField(String s) {

    }
}
