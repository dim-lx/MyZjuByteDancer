package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.chapter3.homework.recycler.LinearItemDecoration;
import com.example.chapter3.homework.recycler.MyAdapter;
import com.example.chapter3.homework.recycler.TestDataJoin;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView animationView;
    private RecyclerView rv;
    private AnimatorSet animatorSet;
    private MyAdapter mAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view=inflater.inflate(R.layout.fragment_placeholder,container,false);
        context = view.getContext();
        recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setAlpha(0);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        mAdapter = new MyAdapter(TestDataJoin.getData());
        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL );
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                animationView = getView().findViewById(R.id.animation_view);
                ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(animationView,
                        "alpha", 1, 0);
                alphaAnimator.setDuration(1000);
                animatorSet = new AnimatorSet(); animatorSet.playTogether(alphaAnimator);
                animatorSet.start();

                rv = getView().findViewById(R.id.recycler);
                ObjectAnimator alphacycle = ObjectAnimator.ofFloat(rv,
                        "alpha", 0, 1);
                alphacycle.setDuration(1000);
                animatorSet = new AnimatorSet(); animatorSet.playTogether(alphacycle);
                animatorSet.start();



            }
        }, 5000);
    }
}
