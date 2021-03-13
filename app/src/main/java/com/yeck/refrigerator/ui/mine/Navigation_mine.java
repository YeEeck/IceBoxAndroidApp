package com.yeck.refrigerator.ui.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.yeck.refrigerator.R;

import java.util.Objects;

public class Navigation_mine extends Fragment {

    private MineViewModel MineViewModel;

    public interface mineBack{
        void setWebView();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MineViewModel =
                ViewModelProviders.of(this).get(MineViewModel.class);
        View root = inflater.inflate(R.layout.fragment_navigation_mine, container, false);

        return root;
    }

    @Override
    public void onStart() {

        super.onStart();
        ((mineBack) requireActivity()).setWebView();

    }

}
