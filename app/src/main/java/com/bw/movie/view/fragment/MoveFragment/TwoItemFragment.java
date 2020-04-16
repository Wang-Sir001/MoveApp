package com.bw.movie.view.fragment.MoveFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.bawei.mymovie.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoItemFragment extends Fragment {

    public TwoItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two_item, container, false);
    }
}
