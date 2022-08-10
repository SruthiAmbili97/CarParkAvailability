package sg.edu.rp.c346.id21006564.carparkavailability;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView lvCarParkAvailability;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCarParkAvailability=findViewById(R.id.lvCarParkAvailability);
        client= new AsyncHttpClient();
    }
    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<CarParkAvailability> alCarParkAvailability = new ArrayList<CarParkAvailability>();

        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {

            String carpark_number;
            String update_datetime;
            String total_lots;
            String lot_type;
            String lots_available;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try{
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrcarpark_data = firstObj.getJSONArray("carpark_data");

                    for(int i = 0; i < jsonArrcarpark_data.length(); i++) {
                        JSONObject jsonObjcarpark_info = jsonArrcarpark_data.getJSONObject(i);
                        JSONArray jsonArraycarpark_info = (JSONArray) jsonObjcarpark_info.get("carpark_info");
                        JSONObject dataobj = jsonArraycarpark_info.getJSONObject(0);

                        total_lots= dataobj.getString("total_lots");
                       lot_type = dataobj.getString("lot_type");
                        lots_available = dataobj.getString("lots_available");
                        carpark_number = jsonObjcarpark_info.getString("carpark_number");
                        update_datetime = jsonObjcarpark_info.getString("update_datetime");

                        CarParkAvailability cpAvailability = new CarParkAvailability(carpark_number ,update_datetime,total_lots,lot_type,lots_available);
                        alCarParkAvailability.add(cpAvailability);
                    }

                }
                catch(JSONException e){
                    Log.d("exception", e.toString());

                }
                ArrayAdapter<CarParkAvailability> aaCarParkAvailabity= new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, alCarParkAvailability);
                lvCarParkAvailability.setAdapter(aaCarParkAvailabity);


                //POINT X – Code to display List View


            }//end onSuccess
        });
    }//end onResume


}