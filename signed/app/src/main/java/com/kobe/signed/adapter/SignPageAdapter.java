package com.kobe.signed.adapter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kobe.signed.R;
import com.kobe.signed.model.SignInfoModel;
import com.sackcentury.shinebuttonlib.ShineButton;

/**
 * Created by kobewang on 2018/1/30.
 */

public class SignPageAdapter extends BaseQuickAdapter<SignInfoModel.DataBean.SignSettingsBean, BaseViewHolder> {

    private static int[][] iconRes = {{R.drawable.ic_star_gray, R.drawable.ic_star_light},
            {R.drawable.ic_diamond_gray, R.drawable.ic_diamond_light}};

    private static int[][] shineColorRes = {{R.color.star_primary_color, R.color.star_primary_color_dark},
            {R.color.diamond_primary_color, R.color.diamond_primary_color_dark}};

    public SignPageAdapter(Context context, int layoutResId, SignInfoModel.DataBean data) {
        super(layoutResId, data.getSign_settings());
        mContext = context;
        mSignedDays = data.getSigned_days();
    }

    private Context mContext;

    private int mSignedDays;

    private boolean shineNewSignedDay = false;

    @Override
    protected void convert(BaseViewHolder helper, SignInfoModel.DataBean.SignSettingsBean item) {
        final BaseViewHolder baseViewHolder = helper;
        final SignInfoModel.DataBean.SignSettingsBean signSettingsBean = item;
        baseViewHolder.setImageResource(R.id.iv_sign_tip, iconRes[signSettingsBean.getType() - 1][baseViewHolder.getPosition() > mSignedDays - 1 ? 0 : 1]);
        baseViewHolder.setText(R.id.txt_rewards, signSettingsBean.getRewards() <= 500 ? ("+" + signSettingsBean.getRewards()) : ("+" + signSettingsBean.getRewards() / 1000 + "K"));
        baseViewHolder.setText(R.id.txt_days, "第" + signSettingsBean.getDays() + "天");
        if (baseViewHolder.getPosition() == mSignedDays && shineNewSignedDay) {
            final ShineButton shine = ((ShineButton) baseViewHolder.getView(R.id.btn_shine));
            shine.setSmallShineColor(mContext.getColor(shineColorRes[signSettingsBean.getType() - 1][0]));
            shine.setBigShineColor(mContext.getColor(shineColorRes[signSettingsBean.getType() - 1][1]));
            shine.postDelayed(new Runnable() {
                @Override
                public void run() {
                    shine.setVisibility(View.VISIBLE);
                    shine.setAnimDuration(1500);
                    shine.setChecked(true, true);
                    baseViewHolder.setImageResource(R.id.iv_sign_tip, iconRes[signSettingsBean.getType() - 1][1]);
                }
            }, 0);
        }
    }

    //加载新的数据
    public void updateData(SignInfoModel.DataBean data, int signedDays) {
        shineNewSignedDay = false;
        this.setNewData(data.getSign_settings());
    }

    //点亮的效果
    public void shineNewSignedDay() {
        shineNewSignedDay = true;
        notifyItemChanged(mSignedDays);
    }
}
