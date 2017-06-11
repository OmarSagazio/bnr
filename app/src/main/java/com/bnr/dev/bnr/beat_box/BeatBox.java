package com.bnr.dev.bnr.beat_box;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-w8-12 on 10-Jun-17.
 */
public class BeatBox {

    // statics
    private static final String TAG = BeatBox.class.getName();
    private static final String SOUND_FOLDER = "sample_sounds";

    // members
    private AssetManager mAsset;
    private List<Sound> mSounds;

    // constructor
    public BeatBox(Context context) {
        mAsset = context.getAssets();
        mSounds = new ArrayList<>();

        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;

        try {
            soundNames = mAsset.list(SOUND_FOLDER);
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        } catch (IOException ioe) {
            Log.e(TAG, "Could not list assets", ioe);
            return;
        }

        for (String fileName : soundNames) {
            String assetPath = SOUND_FOLDER + "/" + fileName;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }

}
