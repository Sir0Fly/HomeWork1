package com.example.yaoyufei.homework1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yaoyufei.homework1.R;
import com.example.yaoyufei.homework1.bean.TeacherBean;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    List<TeacherBean.BodyEntity.ResultEntity> list=new ArrayList<>();
    Context context;

    public MyRecyclerAdapter(Context context) {
        this.context = context;
    }
    public void getData(List<TeacherBean.BodyEntity.ResultEntity> list){
        this.list=list;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_teacher, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        RequestOptions options = new RequestOptions().circleCrop().placeholder(R.mipmap.ic_launcher);
        Glide.with(context).load(list.get(i).getTeacherPic()).apply(options).into(viewHolder.iv);

        viewHolder.name.setText(list.get(i).getTeacherName());
        viewHolder.job.setText(list.get(i).getTitle());

        List<?> teacherType = (List<Object>) list.get(i).getTeacherType();
        if (teacherType!=null&&teacherType.size()>0){
            String ty="#";
            for (int j=0;j<teacherType.size();j++){
                String type = teacherType.get(j).toString();
                String substring = type.substring(type.indexOf("=") + 1, type.lastIndexOf("}"));
                ty+=substring+"#";

            }
            viewHolder.part.setText(ty);

        }

        //点击跳转
        viewHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.onClickListener(v,i);
            }
        });
        viewHolder.love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (viewHolder.love.getText().toString().equals("关注")){
                    viewHolder.love.setText("取消关注");
                    b.onClickListener(v,i);
                }else {
                    viewHolder.love.setText("关注");
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView name;
        TextView job;
        TextView part;
        TextView love;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.item_iv);
            name = itemView.findViewById(R.id.item_name);
            job = itemView.findViewById(R.id.item_job);
            part = itemView.findViewById(R.id.item_part);
            love = itemView.findViewById(R.id.item_love);

        }
    }

    //接口回调
    private A a;
    private B b;

    public void setA(A a) {
        this.a = a;
    }

    public void setB(B b) {
        this.b = b;
    }

    public interface A{
        void onClickListener(View view,int position);
    }
    public interface B{
        void onClickListener(View view,int position);
    }
}
