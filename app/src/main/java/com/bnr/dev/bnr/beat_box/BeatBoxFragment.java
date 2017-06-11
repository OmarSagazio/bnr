package com.bnr.dev.bnr.beat_box;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bnr.dev.bnr.R;
import com.bnr.dev.bnr.databinding.BbFragmentBeatBoxBinding;

/**
 * Created by dev-w8-12 on 26-May-17.
 */
public class BeatBoxFragment extends Fragment {

    // members
    private BeatBox mBeatBox;

    // factory
    public static BeatBoxFragment newInstance() {
        return new BeatBoxFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBeatBox = new BeatBox(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        BbFragmentBeatBoxBinding binding = DataBindingUtil
            .inflate(inflater, R.layout.bb_fragment_beat_box, container, false);

        binding.bbRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        binding.bbRecyclerView.setAdapter(new SoundAdapter(getActivity(), mBeatBox.getSounds(), mBeatBox));

        return binding.getRoot();
    }


}
