package com.ljt.libraryseatmanager.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ljt.libraryseatmanager.MainActivity;
import com.ljt.libraryseatmanager.R;
import com.ljt.libraryseatmanager.Util.HandleBackInterface;
import com.ljt.libraryseatmanager.Util.HandleBackUtil;
import com.ljt.libraryseatmanager.Util.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class RuleFragment extends BaseFragment  {
    private TextView ruleContent;
    private Button ruleBackBtn;
    private TextView fuHbuText;
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            ruleContent.setText(rule);

        }
    };
    private String rule;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rule_fragment, container, false);
        ruleContent = (TextView) view.findViewById(R.id.rule_content);
        fuHbuText = (TextView) view.findViewById(R.id.fu_text_hbu);
        ruleBackBtn = (Button) view.findViewById(R.id.rule_back);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setSpannText();
        initDate();
        ruleBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RuleFragment ruleFragment=new RuleFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,null);
                fragmentTransaction.commit();
            }
        });
    }

    private void initDate() {
        HttpUtil.sendOkHttpRequest("http://192.168.1.115:8080/102455", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                rule = response.body().string();
                Log.d("ljt", rule);
                if (null!= rule)
                {
                    Message message=Message.obtain();

                    handler.sendMessage(message);
                }
            }
        });
    }

    private void setSpannText() {
        SpannableString urlString = new SpannableString("详情请访问河北大学图书馆官方网站");

        URLSpan urlSpan = new URLSpan("http://lib.hbu.edu.cn/newsinfo?id=1719&cid=2");
        urlString.setSpan(urlSpan, 4, urlString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        fuHbuText.setMovementMethod(LinkMovementMethod.getInstance());
        fuHbuText.setHighlightColor(Color.parseColor("#36969696"));

        fuHbuText.setText(urlString);
    }
}
