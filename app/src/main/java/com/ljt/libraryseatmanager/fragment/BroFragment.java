package com.ljt.libraryseatmanager.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.ljt.libraryseatmanager.MyLstAdapter;
import com.ljt.libraryseatmanager.R;

import java.util.ArrayList;
import java.util.List;

public class BroFragment extends BaseFragment {

    private ListView listViewFirst;
    private Button nextBtnFirst;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bro_fragment, container, false);
        listViewFirst = (ListView) view.findViewById(R.id.lis_view_first);
        nextBtnFirst = view.findViewById(R.id.nxt_btn_first);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        
    }

    private void initData() {
        List<String> strings=new ArrayList<>();
        // TODO: 2019/3/18  
    }
}
