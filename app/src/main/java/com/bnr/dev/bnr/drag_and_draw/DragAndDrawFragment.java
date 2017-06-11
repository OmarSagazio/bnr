package com.bnr.dev.bnr.drag_and_draw;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bnr.dev.bnr.R;
import com.bnr.dev.bnr.databinding.DadFragmentDragAndDrawBinding;

/**
 * Created by dev-w8-12 on 11-Jun-17.
 */
public class DragAndDrawFragment extends Fragment {

    // static
//    private static final String TAG = DragAndDrawFragment.class.getName();

    // factory
    public static DragAndDrawFragment newInstance() {
        return new DragAndDrawFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        DadFragmentDragAndDrawBinding binding = DataBindingUtil
            .inflate(inflater, R.layout.dad_fragment_drag_and_draw, container, false);

        return binding.getRoot();
    }
}
