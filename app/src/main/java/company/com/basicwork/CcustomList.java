package company.com.basicwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CcustomList extends AppCompatActivity {

    ListView list;
    ArrayList<EmplyeeCustomList> empData = new ArrayList<EmplyeeCustomList>();
    AsyncHttpClient client = new AsyncHttpClient();
    String url = "http://192.232.214.91/~almglsalbldyinmk//cou_mem.php?key=albldy";

    void getconnectWebService() {
        client.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                Log.e("onstart", "1");
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, String content) {
                parseJson(content);

                Log.d("onsuccess","request");

                Log.d("onsuccess", webData.get(0).position + "");
//                n3ml ea b2a
                super.onSuccess(statusCode, content);
                Adapterr adapter = new Adapterr(CcustomList.this, webData);
                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    Toast.makeText(CcustomList.this, "empData.get(position).text1", Toast.LENGTH_SHORT).show();
                                                    if (position == 0) {
                                                        // eb3t 3laaa  el r2esya
                                                        Intent i = new Intent();
                                                        i.putExtra("NAME", webData.get(position).name);
                                                    } else if (position == 1) {
                                                        // ay 7aga we hakaza
                                                    }
                                                }
                                            }
                );
            }

            @Override
            public void onFinish() {
                Log.e("onfinish", "3");
                super.onFinish();
            }

            @Override
            public void onFailure(Throwable error, String content) {
                Log.e("onfailture", "4");
                super.onFailure(error, content);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccustom_list);
        getconnectWebService();

        list = (ListView) findViewById(R.id.listVe);



    }

    ArrayList<EmplyeeCustomList> webData;

    void parseJson(String resp) {

        Gson gson = new Gson();
        String jsonOutput = resp;
        Type listType = new TypeToken<ArrayList<EmplyeeCustomList>>() {

        }.getType();
        webData = gson.fromJson(jsonOutput, listType);}
}

