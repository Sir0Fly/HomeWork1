package com.example.yaoyufei.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.yaoyufei.homework1.adapter.MyRecyclerAdapter;
import com.example.yaoyufei.homework1.bean.TeacherBean;
import com.example.yaoyufei.homework1.presenter.MainPresenter;
import com.example.yaoyufei.homework1.view.MainView;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private RecyclerView mMyRecyc;
    private MyRecyclerAdapter myRecyclerAdapter;
    private List<TeacherBean.BodyEntity.ResultEntity> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainPresenter(this).getInfo();
        initView();
        initListener();
    }

    private void initListener() {
        myRecyclerAdapter.setA(new MyRecyclerAdapter.A() {
            @Override
            public void onClickListener(View view, int position) {
                //条转
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                int id = result.get(position).getID();
                intent.putExtra("position",position);
                intent.putExtra("id",id);
                intent.putExtra("result", (Serializable) result);
                startActivity(intent);
            }
        });
        myRecyclerAdapter.setB(new MyRecyclerAdapter.B() {
            @Override
            public void onClickListener(View view, int position) {
                Toast.makeText(MainActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mMyRecyc = (RecyclerView) findViewById(R.id.myRecyc);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mMyRecyc.setLayoutManager(manager);

        myRecyclerAdapter = new MyRecyclerAdapter(this);
        mMyRecyc.setAdapter(myRecyclerAdapter);
    }

    @Override
    public void onSuccess(TeacherBean teacherBean) {
        result = teacherBean.getBody().getResult();
        myRecyclerAdapter.getData(result);
    }

    @Override
    public void onField(String s) {

    }
}
