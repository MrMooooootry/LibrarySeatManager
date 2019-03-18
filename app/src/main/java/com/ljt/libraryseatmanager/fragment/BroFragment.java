package com.ljt.libraryseatmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ljt.libraryseatmanager.MyLstAdapter;
import com.ljt.libraryseatmanager.R;
import com.ljt.libraryseatmanager.bean.Areas;
import com.ljt.libraryseatmanager.bean.Floors;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BroFragment extends BaseFragment {
    public static final int LEVEL_FLOOR=0;
    public static final int LEVEL_AREA=1;

    private ListView listViewFirst;
    private Button nextBtnFirst;

    private List<String> dataList;
    private String selectedFloor;
    private String selectedArea;
    private int currentLevel;
    private TextView titleText;
    private MyLstAdapter myLstAdapter;
    private List<Floors> floorsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bro_fragment, container, false);
        titleText = (TextView) view.findViewById(R.id.title_text);
        listViewFirst = (ListView) view.findViewById(R.id.lis_view_first);
        nextBtnFirst =(Button) view.findViewById(R.id.nxt_btn_first);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        currentLevel=0;
        super.onActivityCreated(savedInstanceState);
        initData();
        listViewFirst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentLevel==LEVEL_FLOOR)
                { Log.d("ljt","点击位置为");

                    String name = floorsList.get(position).getName();
                    Log.d("ljt","点击位置为"+name);
                    List<Areas> areas = floorsList.get(position).getAreas();
                    Log.d("ljt","areas数组大小为"+areas.size());
                    quarryArea(name,areas);

                }
                else if (currentLevel==LEVEL_AREA)
                {

                }
            }
        });
        
    }

    private void quarryArea(String s,List<Areas> areas) {
    titleText.setText(s);

    if (areas.size()>0)
    {
        dataList.clear();
        for (int i=0;i<areas.size();i++)
        {
            Areas areas1 = areas.get(i);
            String name = areas1.getName();
            dataList.add(name);
        }
        myLstAdapter.notifyDataSetChanged();
        currentLevel=LEVEL_AREA;


    }
    }

    private void initData() {
        Log.d("ljt","进入initData");

        dataList=new ArrayList<>();
        // TODO: 2019/3/18
        floorsList = new ArrayList<>();

        for (int i=2;i<7;i++){
            Floors floor=new Floors();
            List<Areas> areas=new ArrayList<>();
            floor.setName(i+"层平面图");
            if (i==2)
            {
                Areas areas1=new Areas();
                areas1.setName("二楼新书区域");
                areas.add(areas1);
            }
            else {
                for (int j=0;j<3;j++)
                {
                    Areas area=new Areas();
                    switch (j)
                    {
                        case 0 :
                            area.setName("东区");
                            break;
                        case 1 :
                            area.setName("北区");
                            break;
                        case 2 :
                            area.setName("西区");
                            break;
                    }
                    areas.add(area);
                }
            }
            floor.setAreas(areas);
            floorsList.add(floor);

        }
        Log.d("ljt","数据初始化成功");


        if (floorsList.size()>0)
        {
           dataList.clear();
//            for (Floors floor:floorsList
//                 ) {
//                dataList.add(floor.getName());
//
//
//            }
            for (int i = 0; i< floorsList.size(); i++)
            {
                Floors floors= floorsList.get(i);
                dataList.add(floors.getName());
                Log.d("ljt",floors.getName());
            }
        }
        else {
            Log.d("ljt","size小于0");
        }

        myLstAdapter = new MyLstAdapter(getActivity(),dataList);
        listViewFirst.setAdapter(myLstAdapter);



    }
}
