package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView loadView;
    private ListView listView;
    private static final String ARG_SECTION = "section";

    public PlaceholderFragment() {

    }

    // 用于 fragement 通讯
    public static PlaceholderFragment newInstance(String section) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION, section);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);

        String section = getArguments().getString(ARG_SECTION);

        // 给 listView 传不同的值
        String [] strs = new String[5];
        for (int i = 0; i < 5; i++){
                strs[i] = section;
        }
        Log.d("PlaceholderFragment", section);

        listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strs));
        listView.setAlpha(0);

        loadView = (LottieAnimationView) view.findViewById(R.id.load_view);
        loadView.playAnimation();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {

                AnimatorSet animatorSet = new AnimatorSet();
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                // loadView 淡出
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(loadView, "alpha", 1f, 0f);
                animator1.setDuration(1000);

                // ListView 淡入
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(listView, "alpha", 0f, 1f);
                animator2.setDuration(1000);

                animatorSet.playTogether(animator1, animator2);
                animatorSet.start();
            }
        }, 5000);
    }
}
