package com.bnr.dev.bnr.beat_box;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by dev-w8-12 on 11-Jun-17.
 */
public class SoundViewModel extends BaseObservable {

    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    @Bindable
    public String getTitle() {
        return mSound.getName();
    }

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound) {
        this.mSound = sound;
        notifyChange();
    }
}
