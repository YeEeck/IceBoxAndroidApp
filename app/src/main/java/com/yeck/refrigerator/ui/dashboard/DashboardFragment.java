package com.yeck.refrigerator.ui.dashboard;

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

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public interface dashboard{
        void changePadding();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        return root;
    }

    @Override
    public void onStart() {

        super.onStart();
        ((dashboard) requireActivity()).changePadding();

    }
}
