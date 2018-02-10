package com.kobe.signed;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.gson.Gson;
import com.kobe.signed.View.DropZoomScrollView;
import com.kobe.signed.adapter.SignPageAdapter;
import com.kobe.signed.model.SignInfoModel;

public class MainActivity extends AppCompatActivity implements View.OnScrollChangeListener {


    private String mJson;

    private RecyclerView recyclerView;
    private SignPageAdapter mSignPageAdapter;
    private Context mContext;

    private Toolbar mToolbar;
    private View mToolbarBg;
    private DropZoomScrollView mDropZoomScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initView() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarBg = findViewById(R.id.toolbar_bg);

        initRecyclerView();

        Button btn = (Button) findViewById(R.id.btn_sign);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(mContext, R.anim.btn_sign_click_anim);
                v.startAnimation(animationSet);
                mSignPageAdapter.shineNewSignedDay();
                //mSignPageAdapter.notifyDataSetChanged();
            }
        });

        mDropZoomScrollView = (DropZoomScrollView) findViewById(R.id.pull_to_refresh);
        mDropZoomScrollView.setOnScrollChangeListener(this);

    }


    private void initRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mJson = this.getString(R.string.data2);

        Gson gs = new Gson();
        SignInfoModel.DataBean s = gs.fromJson(mJson, SignInfoModel.DataBean.class);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 7);
        recyclerView.setLayoutManager(gridLayoutManager);
        mSignPageAdapter = new SignPageAdapter(this, R.layout.sign_page_item, s);
        recyclerView.setAdapter(mSignPageAdapter);

    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        mToolbarBg.setAlpha((float) scrollY / ((ViewGroup) mDropZoomScrollView.getChildAt(0)).getChildAt(0).getHeight());
    }
}
