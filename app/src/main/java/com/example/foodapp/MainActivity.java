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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
{

    ListView vendorsListView;
    String mName[] = {"Subway", "Pizza Hut", "Pappa John's", "McDonalds", "Qdoba"};
    String mLocation[] = {"temp address 123", "temp address 123","temp address 123", "temp address 123", "temp address 123"};
    String mDestination [] = {"temp address 123", "temp address 123","temp address 123", "temp address 123", "temp address 123"};
    private Button logout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linking variables to buttons & text
        logout = findViewById(R.id.logOutBttn);
        mAuth = FirebaseAuth.getInstance();

        //Checks for signed in user
        FirebaseUser currentUser = mAuth.getCurrentUser();

        vendorsListView = findViewById(R.id.listView);
        VendorAdapter adapter = new VendorAdapter(this, mName, mLocation, mDestination);
        vendorsListView.setAdapter(adapter);
        vendorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

        // if no signed in user send to login page, else display name
        if (currentUser == null)
        {
            // beams user to the login page
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        // on click triggers logout method to send user to login page
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });
    }

    class VendorAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rName[];
        String rLocation[];
        String rDestination[];

        VendorAdapter(Context c, String name[], String location[], String destination[]){
            super(c, R.layout.vendor_list, R.id.VendorName, name);
            this.context = c;
            this.rName = name;
            this.rLocation = location;
            this.rDestination = destination;

        }
        @NonNull
        @Override
        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.vendor_list,parent, false);
            TextView name = view.findViewById(R.id.VendorName);
            TextView location = view.findViewById(R.id.vendorLocation);
            TextView destination = view.findViewById(R.id.VendorDestination);

            name.setText(rName[position]);
            location.setText(rLocation[position]);
            destination.setText(rDestination[position]);
            return view;
        }
    }


     void logOut()
    {
        Intent loginIntent = new Intent (MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }
}
