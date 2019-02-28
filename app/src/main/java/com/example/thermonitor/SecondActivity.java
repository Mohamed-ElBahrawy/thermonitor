package com.example.thermonitor;

import android.Manifest;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private WifiManager wifiManager;
    private ListView listView;
    private Button button;
    private int Size = 0;
    private List<ScanResult> results;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter adapter;

    ArrayList<Integer> Images = new ArrayList<>();
    ArrayList<String> Names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 10);

        } else {
            button = findViewById(R.id.scanBtn);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scanWifi();
                }
            });
            listView = findViewById(R.id.list);
            wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            if (!wifiManager.isWifiEnabled()) {
                Toast.makeText(this, "Wifi is disabled........we need to enable it", Toast.LENGTH_LONG).show();
            }
            adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
            //listView.setAdapter(adapter);

            scanWifi();
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent3 = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(intent3);
                }
            });
        }

    }

    private void scanWifi() {
        arrayList.clear();
        registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        wifiManager.startScan();
        Toast.makeText(this, "Scanning wifi......", Toast.LENGTH_SHORT).show();


    }


    BroadcastReceiver wifiReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            results = wifiManager.getScanResults();
            unregisterReceiver(this);
            int j=1;

            for (ScanResult scanResult : results) {
                if (scanResult.SSID.equals("ESP"+j)) {
                    arrayList.add(scanResult.SSID);
                    j++;

                    //adapter.notifyDataSetChanged();

                }
            }


            for (int i = 0; i < arrayList.size(); i++) {
                    Names.add(arrayList.get(i));
                    Images.add(R.drawable.espmodel);
            }

            CustomAdapter customAdapter=new CustomAdapter();
            listView.setAdapter(customAdapter);



        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return Images.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.languages,null);
            ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
            imageView.setImageResource(Images.get(position));
            TextView textView=(TextView)convertView.findViewById(R.id.textView);
            textView.setText(Names.get(position));
            return convertView;
        }
    }

}

