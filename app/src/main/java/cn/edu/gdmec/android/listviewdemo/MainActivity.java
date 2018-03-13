package cn.edu.gdmec.android.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener{
    private ListView listView;
    //数据适配器
    private ArrayAdapter<String> arr_adapter;
    private SimpleAdapter simp_adapter;
    private List<Map<String,Object>>dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        //1、新建一个数据适配器
        //ArrayAdapter(上下文，当前ListView加载的每一个列表项所对应的布局文件，数据源)

        /**
         * context:上下文
         * data: 数据源（List data）一个Map所组成的List集合
         *      每一个Map都会去对应listView列表中的一行
         *      每一个Map（键-值对）中的键必须包含所有在from中所指定的键
         * resource：列表项的布局文件ID
         * from：Map中的键名
         * to：绑定数据视图中的ID，与from成对应关系
         */

        //2、适配器加载数据源
        String[] arr_data={"慕课网1","慕课网1","慕课网1","慕课网1"};
        dataList=new ArrayList<Map<String, Object>>();
        arr_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr_data);
        simp_adapter=new SimpleAdapter(this,getData(),R.layout.item,new String[]{"pic","text"},new int[]{R.id.pic,R.id.text});

        //3、视图加载适配器（listView）
      //  listView.setAdapter(arr_adapter);
        listView.setAdapter(simp_adapter);

    }

    private List<Map<String,Object>> getData(){
        for (int i=1;i<=20;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("pic",R.mipmap.ic_launcher);
            map.put("text","MUKEW"+i);
            dataList.add(map);

        }

     return dataList;

    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
