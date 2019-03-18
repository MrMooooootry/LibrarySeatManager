package com.ljt.libraryseatmanager;



import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ljt.libraryseatmanager.Util.HandleBackUtil;
import com.ljt.libraryseatmanager.fragment.BaseFragment;
import com.ljt.libraryseatmanager.fragment.BroFragment;
import com.ljt.libraryseatmanager.fragment.LeaveFragment;
import com.ljt.libraryseatmanager.fragment.MineFragment;
import com.ljt.libraryseatmanager.fragment.RuleFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private FrameLayout frameLayout;
    private TextView suggettionText;
    private Button ruleBtn;
    private Button bespokeBtn;
    private Button leaveBtn;
    private Button mineBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        suggettionText = (TextView)findViewById(R.id.suggestion_text);
        ruleBtn = (Button) findViewById(R.id.rule_btn);
        bespokeBtn = (Button) findViewById(R.id.bespoke);
        leaveBtn = (Button) findViewById(R.id.leave);
        mineBtn = (Button) findViewById(R.id.mine);
        frameLayout=(FrameLayout)findViewById(R.id.fragment_container);

        initSpann4Text(this,"请先阅读预约规则",suggettionText,R.drawable.rule);
        initSpann("图预约规则",ruleBtn,R.drawable.rule );
        initSpann("图马上预约",bespokeBtn,R.drawable.bro);
        initSpann("图临时离开/签离",leaveBtn,R.drawable.leave);
        initSpann("图个人中心",mineBtn,R.drawable.mine);
        ruleBtn.setOnClickListener(this);
        bespokeBtn.setOnClickListener(this);
        leaveBtn.setOnClickListener(this);
        mineBtn.setOnClickListener(this);
    }



    private void initSpann(String content, Button buttonm, int id) {

        SpannableString spannableString=new SpannableString(content);
        Drawable drawable=getResources().getDrawable(id);

        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        Log.d("ljt","宽 ："+intrinsicWidth+"     高:  "+intrinsicHeight);
        drawable.setBounds(0,0,intrinsicWidth,intrinsicHeight);
        ImageSpan imageSpan=new ImageSpan(drawable);
        spannableString.setSpan(imageSpan,0,1,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        buttonm.setText(spannableString);
    }public static  void initSpann4Text(Context context,String content, TextView textView, int id) {

        SpannableString spannableString=new SpannableString(content);
        Drawable drawable=context.getResources().getDrawable(id);

        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        Log.d("ljt","宽 ："+intrinsicWidth+"     高:  "+intrinsicHeight);
        drawable.setBounds(0,0,50,50);
        ImageSpan imageSpan=new ImageSpan(drawable);
        spannableString.setSpan(imageSpan,0,1,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.rule_btn:

                RuleFragment ruleFragment=new RuleFragment();
                setFragment(ruleFragment);

                break;
            case R.id.bespoke:

                BroFragment broFragment=new BroFragment();
                setFragment(broFragment);
                break;
            case R.id.leave:
                LeaveFragment leaveFragment=new LeaveFragment();
                setFragment(leaveFragment);
                break;
            case R.id.mine:
                MineFragment mineFragment=new MineFragment();
                setFragment(mineFragment);
                break;

        }
    }

    private void setFragment(Fragment fragment) {
        frameLayout.setVisibility(View.VISIBLE);

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);

        fragmentTransaction.commit();
    }
}
