package com.bnr.dev.bnr.sunset;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import com.bnr.dev.bnr.R;
import com.bnr.dev.bnr.databinding.SFragmentSunsetBinding;

/**
 * Created by Mauro on 12/06/2017.
 */
public class SunsetFragment extends Fragment {

    // statics
    private static final String TAG = SunsetFragment.class.getName();

    // members
    private View mSunView;
    private View mSkyView;
    // colors
    private int mBlueSkyColor;
    private int mSunsetSkyColor;
    private int mNightSkyColor;

    // factory
    public static SunsetFragment newInstance() {
        return new SunsetFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SFragmentSunsetBinding binding = DataBindingUtil.inflate(inflater, R.layout.s_fragment_sunset, container, false);

        // views
        mSkyView = binding.sky;
        mSunView = binding.sun;

        // colors
        mBlueSkyColor = ContextCompat.getColor(getActivity(), R.color.blue_sky);
        mSunsetSkyColor = ContextCompat.getColor(getActivity(), R.color.sunset_sky);
        mNightSkyColor = ContextCompat.getColor(getActivity(), R.color.night_sky);

        binding.getRoot().setOnClickListener(v -> startAnimation());

        return binding.getRoot();
    }

    private void startAnimation() {
        float sunYStart = mSunView.getTop();
        float sunYEnd = mSunView.getHeight();

        ObjectAnimator heightAnimator = ObjectAnimator
            .ofFloat(mSunView, "y", sunYStart, sunYEnd)
            .setDuration(3000);
        heightAnimator.setInterpolator(new AccelerateInterpolator());

        ObjectAnimator sunsetSkyAnimator = ObjectAnimator
            .ofInt(mSkyView, "backgroundColor", mBlueSkyColor, mSunsetSkyColor)
            .setDuration(3000);
        sunsetSkyAnimator.setEvaluator(new ArgbEvaluator());

        ObjectAnimator nightSkyAnimator = ObjectAnimator
            .ofInt(mSkyView, "backgroundColor", mSunsetSkyColor, mNightSkyColor)
            .setDuration(1500);
        nightSkyAnimator.setEvaluator(new ArgbEvaluator());


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(heightAnimator)
            .with(sunsetSkyAnimator)
            .before(nightSkyAnimator);
        animatorSet.start();
    }


}
