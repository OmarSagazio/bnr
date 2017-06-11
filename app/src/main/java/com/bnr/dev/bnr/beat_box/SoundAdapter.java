package com.bnr.dev.bnr.beat_box;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bnr.dev.bnr.R;
import com.bnr.dev.bnr.databinding.BbListItemSoundBinding;

import java.util.List;

/**
 * Created by dev-w8-12 on 10-Jun-17.
 */
public class SoundAdapter extends RecyclerView.Adapter<SoundViewHolder> {

    // members
    private Context mContext;
    private List<Sound> mSounds;
    //
    private BeatBox mBeatBox;

    // constructor
    public SoundAdapter(Context context, List<Sound> sounds, BeatBox beatBox) {
        mContext = context;
        mSounds = sounds;
        mBeatBox = beatBox;
    }


    @Override
    public SoundViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        BbListItemSoundBinding binding = DataBindingUtil
            .inflate(inflater, R.layout.bb_list_item_sound, parent, false);

        return new SoundViewHolder(binding, mBeatBox);
    }

    @Override
    public void onBindViewHolder(SoundViewHolder holder, int position) {
        Sound sound = mSounds.get(position);
        holder.bind(sound);
    }

    @Override
    public int getItemCount() {
        return mSounds.size();
    }


}
