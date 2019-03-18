package com.ljt.libraryseatmanager.fragment;

import android.support.v4.app.Fragment;

import com.ljt.libraryseatmanager.Util.HandleBackInterface;
import com.ljt.libraryseatmanager.Util.HandleBackUtil;

public class BaseFragment extends Fragment implements HandleBackInterface {

    @Override
    public boolean onBackPressed() {
        return HandleBackUtil.handleBackPress(this);
    }
}
