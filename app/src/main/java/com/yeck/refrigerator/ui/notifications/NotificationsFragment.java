package com.yeck.refrigerator.ui.notifications;

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

import q.rorbin.verticaltablayout.VerticalTabLayout;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public interface talkBack{
        void change();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        return root;
    }

    @Override
    public void onStart() {

        super.onStart();
        ((talkBack)getActivity()).change();
    }
}
