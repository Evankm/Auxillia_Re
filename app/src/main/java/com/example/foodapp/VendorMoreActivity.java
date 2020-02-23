package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class VendorMoreActivity extends AppCompatActivity {

    //declaring fields and buttons
    Button logOutBttn;
    ListView vendorsListView;
    String mName[] = {"Subway", "Pizza Hut", "Pappa John's", "McDonalds", "Qdoba"};
    String mLocation[] = {"temp address 123", "temp address 123","temp address 123", "temp address 123", "temp address 123"};
    String mDestination [] = {"temp address 123", "temp address 123","temp address 123", "temp address 123", "temp address 123"};
    String mDiscription [] = {"heyo ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolo",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolo",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolo",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolo",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_more);

            //linking variables to buttons & text
            logOutBttn = findViewById(R.id.logOutBttn);
            vendorsListView = findViewById(R.id.VendorMoreListView);
            VendorMoreAdapter adapter = new VendorMoreAdapter(this, mName, mLocation, mDestination, mDiscription);
            vendorsListView.setAdapter(adapter);

            vendorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    startActivity(new Intent(VendorMoreActivity.this, MapsActivity.class));
                    finish() ;
                }
            });

            logOutBttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    toLogin();
                }
            });
        }

    private class VendorMoreAdapter extends ArrayAdapter<String>{
        Context context;
        String rName[];
        String rLocation[];
        String rDestination[];
        String rDiscription[];


        VendorMoreAdapter(Context c, String name[], String location[], String destination[], String discription[]){
            super(c, R.layout.vendor_list, R.id.VendorName, name );
            this.context = c;
            this.rName = name;
            this.rLocation = location;
            this.rDestination = destination;
            this.rDiscription = discription;

        }
        @NonNull
        @Override
        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.vendor_food,parent, false);
            TextView name = view.findViewById(R.id.VendorMoreName);
            TextView location = view.findViewById(R.id.vendorMoreLocation);
            TextView destination = view.findViewById(R.id.VendorMoreDestination);
            TextView discription = view.findViewById(R.id.VendorMoreDiscription);

            name.setText(rName[position]);
            location.setText(rLocation[position]);
            destination.setText(rDestination[position]);
            discription.setText(rDiscription[position]);

            return view;
        }
    }

    //sends user to login page
    private void toLogin()
    {
        Intent loginIntent = new Intent (VendorMoreActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

}
