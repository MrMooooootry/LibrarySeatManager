package com.ljt.libraryseatmanager.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ljt.libraryseatmanager.R;

import org.w3c.dom.Text;


public class SeatChooseFragment extends Fragment {

    private TextView timeText;
    private TextView dateText;
    private TextView seatText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chose_fragment, container, false);

        dateText = (TextView)view.findViewById(R.id.date_text);
        timeText =(TextView)view.findViewById(R.id.time_text);
        seatText = (TextView) view.findViewById(R.id.seat_text);

        return view;

    }
}
