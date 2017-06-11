package com.bnr.dev.bnr.beat_box;

import android.support.v7.widget.RecyclerView;

import com.bnr.dev.bnr.databinding.BbListItemSoundBinding;


/**
 * Created by dev-w8-12 on 10-Jun-17.
 */
public class SoundViewHolder extends RecyclerView.ViewHolder {

    // members
    private BbListItemSoundBinding mBinding;


    // constructor
    public SoundViewHolder(BbListItemSoundBinding binding, BeatBox beatBox) {
        super(binding.getRoot());
        mBinding = binding;
        mBinding.setViewModel(new SoundViewModel(beatBox));
    }

    // bind
    public void bind(Sound sound) {
        mBinding.getViewModel().setSound(sound);
        mBinding.executePendingBindings();
    }


}
