package com.example.dulajdilrukshan.indoorapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;



public class PathActivity extends AppCompatActivity {
    ImageView drawingImageView;
    TextView error;
    com.example.dulajdilrukshan.indoorapplication.Paths paths = new com.example.dulajdilrukshan.indoorapplication.Paths();
    private Timer mytimer;
    WifiManager wifiManager;

    double d;
    double temp;
    double txpower = 32;
    double val = 1.8;



    RequestQueue MyRequestQueue;

    float x, y;
    double exp1, exp2, exp3, distance1, distance2, distance3, rssi1, rssi2, rssi3;
    String bssid1, bssid2, bssid3;
    StringRequest MyStringRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
        MyRequestQueue = Volley.newRequestQueue(this);
        audit();

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        mytimer = new Timer();
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethod();
            }
        }, 0, 2000);

    }

    // Overriding compare method to sort by rss level
    Comparator<ScanResult> comparator = new Comparator<ScanResult>() {
        @Override
        public int compare(ScanResult lhs, ScanResult rhs) {
            return (lhs.level < rhs.level ? 1 : (lhs.level == rhs.level ? 0 : -1));
        }
    };

    private void TimerMethod() {
        this.runOnUiThread(measureRSSI);
    }

    private Runnable measureRSSI = new Runnable() {

        public void run() {

            if (wifiManager.isWifiEnabled()) {

                wifiManager.startScan();
                List<ScanResult> results = wifiManager.getScanResults();


                try {


                    // Sorting the results list
                    Collections.sort(results, comparator);
                    int i = 0;

                    if (results.size() >= 3) {


                        // distance = 10 ^ ((27.55 - (20 * log10(frequency)) + signalLevel)/20)

                        // AP 1
                        while (i < results.size()) {
                            // AP 1
                            if (results.get(i).BSSID.equalsIgnoreCase("80:3f:5d:36:98:e5")) {
                                rssi1 = results.get(i).level;
                                bssid1 = results.get(i).BSSID;
                                exp1 = (27.55 - (20 * Math.log10(2412)) + Math.abs(rssi1)) / (10 * val);
                                distance1 = Math.pow(10.0, exp1);
                            } else if (results.get(i).BSSID.equalsIgnoreCase("98:e7:f5:d1:0c:28")) {
                                // AP 2
                                rssi2 = results.get(i).level;
                                bssid2 = results.get(i).BSSID;
                                exp2 = (27.55 - (20 * Math.log10(2412)) + Math.abs(rssi2)) / (10 * val);
                                distance2 = Math.pow(10.0, exp2);
                            } else if (results.get(i).BSSID.equalsIgnoreCase("80:3f:5d:36:98:b8")) {
                                // AP 3
                                rssi3 = results.get(i).level;
                                bssid3 = results.get(i).BSSID;
                                exp3 = (27.55 - (20 * Math.log10(2412)) + Math.abs(rssi3)) / (10 * val);
                                distance3 = Math.pow(10.0, exp3);
                            }

                            // Traversing to the next element
                            i++;
                        }


                        String url = "http://ec2-18-191-196-123.us-east-2.compute.amazonaws.com:8081/getlocation";

                        MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);

                                    // Convert meters into pixels
                                    x = ((float) jsonObject.getDouble("x")) * 25;
                                    y = ((float) jsonObject.getDouble("y")) * 25;


                                    showLocation(x, y);

                                    Toast.makeText(PathActivity.this, jsonObject.getDouble("x") + " " + jsonObject.getDouble("y"), Toast.LENGTH_SHORT).show();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }) {
                            protected Map<String, String> getParams() {
                                Map<String, String> FormData = new HashMap<String, String>();

                                FormData.put("bssid1", bssid1);
                                FormData.put("bssid2", bssid2);
                                FormData.put("bssid3", bssid3);
                                FormData.put("r1", distance1 + "");
                                FormData.put("r2", distance2 + "");
                                FormData.put("r3", distance3 + "");
//
                                return FormData;
                            }
                        };

                        MyRequestQueue.add(MyStringRequest);
                    } else {
                        Toast.makeText(PathActivity.this, "Not Enough Access Points", Toast.LENGTH_SHORT).show();
                    }


                } catch (Exception e) {
                    String err = e.getMessage();
                }

            }

        }
    };

    public void audit() {

        String to, from;

        Intent intent = getIntent();

        to = intent.getStringExtra("to");
        from = intent.getStringExtra("from");
        // from=intent.getStringExtra("from");
        if (to != null) {
            if (from.equals("Lift Lobby")) {
                if (to.equals("Auditorium")) {
                    lifttoauditorium();
                } else if (to.equals("MSC Room")) {
                    lifttomscroom();
                } else if (to.equals("Lecture Hall 1")) {
                    lifttohallone();
                } else if (to.equals("Multimedia Lab")) {
                    lifttomultimedia();
                } else if (to.equals("Library")) {
                    lifttolibrary();
                } else if (to.equals("Staff Room")) {
                    lifttoStaffroom();
                } else if (to.equals("Wash Rooms")) {
                    lifttoWashroom();
                } else if (to.equals("Common Room")) {
                    lifttocommomroom();
                } else if (to.equals("DCCN Lab")) {
                    lifttodccnlab();
                }
            }

        }

    }

    public Canvas imagepaths() {

        drawingImageView = (ImageView) this.findViewById(R.id.DrawingImageView);

        DisplayMetrics displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;


        Bitmap bitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        drawingImageView.setImageBitmap(bitmap);
        return canvas;
    }

    public void showLocation(float x, float y) {

        paths.showLocation(imagepaths(), x, y);
    }

    public void lifttoauditorium() {
        float x = (float) 12.0 * 25;
        float y = (float) 15.0 * 25;

        paths.lifttoaudit(imagepaths());


    }

    public void lifttolibrary() {
        paths.lifttolibrary(imagepaths());

    }

    public void lifttomscroom() {

        paths.lifttomscroom(imagepaths());


    }

    public void lifttomultimedia() {
        paths.lifttomultimedia(imagepaths());
    }

    public void lifttohallone() {
        paths.lifttohallone(imagepaths());


    }

    public void lifttodccnlab() {

        paths.lifttodccnlab(imagepaths());

    }

    public void lifttoStaffroom() {

        paths.lifttoaudit(imagepaths());

    }

    public void lifttoWashroom() {

        paths.lifttoWashroom(imagepaths());

    }

    public void lifttocommomroom() {

        paths.lifttocommomroom(imagepaths());

    }


    public void navigation(View view) {
        Intent search = new Intent(this,SearchActivity.class);
        startActivity(search);
    }

    public void submit(View view) {
        EditText  txtsub = (EditText) findViewById(R.id.txtval);
        Double value =Double.parseDouble(txtsub.getText().toString());

        val= value;

        txtsub.setText("");

    }
}
