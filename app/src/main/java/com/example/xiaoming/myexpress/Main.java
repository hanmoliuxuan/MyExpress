package com.example.xiaoming.myexpress;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main extends AppCompatActivity {
    Button find;
    Spinner spinner;
    ArrayAdapter<String> arrayAdapter;
    List<String> list;
    EditText num;
    String url = "http://www.kuaidi100.com/query?type=";
    String express = "shunfeng";
    TextView info;
    SimpleAdapter adapter;
    EditText normal;
    SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
        adapter();
        linster();
    }

    private void adapter() {
        list = new ArrayList<>();
        list.add("顺丰");
        list.add("圆通");
        list.add("EMS");
        list.add("中通");
        list.add("韵达");
        list.add("百世");
        list.add("宅急送");
        list.add("中国邮政");
        list.add("天天");
        list.add("德邦");
        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(arrayAdapter);
    }

    private void linster() {
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "单号不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    switch (spinner.getSelectedItemPosition()) {
                        case 0:
                            express = "shunfeng";
                            url += express;
                            break;
                        case 1:
                            express = "yuantong";
                            url += express;
                            break;
                        case 2:
                            express = "ems";
                            url += express;
                            break;
                        case 3:
                            express = "zhongtong";
                            url += express;
                            break;
                        case 4:
                            express = "yunda";
                            url += express;
                            break;
                        case 5:
                            express = "huitongkuaidi";
                            url += express;
                            break;
                        case 6:
                            express = "zhaijisong";
                            url += express;
                            break;
                        case 7:
                            express = "zhongguoyouzheng";
                            url += express;
                            break;
                        case 8:
                            express = "tiantian";
                            url += express;
                        case 9:
                            express = "debangwuliu";
                            url += express;
                            break;
                    }
                    url += "&postid=" + num.getText().toString();

                    OkHttpClient client = new OkHttpClient.Builder()
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .writeTimeout(10, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .build();
                    Request request=new Request.Builder().url(url).build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Toast.makeText(getApplicationContext(),"获取失败",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            final String res=response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    StringBuilder myinfo= new StringBuilder();
                                    Item item= JSON.parseObject(res,Item.class);
                                    normal.setText(res);
                                    url = "http://www.kuaidi100.com/query?type=";
//                                    String myinfo=item.toString();
//                                    myinfo=myinfo.replaceAll(",","");
//                                    myinfo=myinfo.replaceAll("[\\[\\]]", "");

                                    JSONObject jsonObject= JSON.parseObject(res);
                                    for (int i=0;i<item.getData().size();i++)
                                    {
                                        Data data= item.getData().get(i);
                                        myinfo.append(data.getContext()).append("\n");
                                        myinfo.append(data.getTime()).append("\n"+""+"\n");
                                    }
                                    info.setText(myinfo.toString());

                                }
                            });
                        }
                    });
                }
            }
        });
    }

    private void init() {
        spinner = findViewById(R.id.spinner);
        find = findViewById(R.id.find);
        num = findViewById(R.id.num);
        info=findViewById(R.id.info);
        normal=findViewById(R.id.thenormal);
    }
}
