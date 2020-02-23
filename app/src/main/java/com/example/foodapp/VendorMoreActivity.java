package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class VendorMoreActivity extends AppCompatActivity {

    Button backBttn;
    ListView vendorsListView;
    String mName[] = {"Subway", "Pizza Hut", "Pappa John's", "McDonalds", "Qdoba"};
    String mLocation[] = {"temp address 123", "temp address 123","temp address 123", "temp address 123", "temp address 123"};
    String mDestination [] = {"temp address 123", "temp address 123","temp address 123", "temp address 123", "temp address 123"};
    String mDiscription [] = {"5 lbs. Herbs Cilantro, 6 lbs. Lettuce, 7 lbs. Olives, 10 lbs. Bread.",
            "20 lbs. Cheese, 10 lbs. Chicken, 10 lbs. Garlic, 15 lbs. Flour, 20 lbs. Tomatoes.",
            "13 lbs. Flour, 23 lbs. Parsley, 10 lbs. Pepperoni, 10 lbs. Sausage, 15 lbs. Lettuce.",
            "15 lbs. Bread, 13 lbs. Beef, 7 lbs. Onions, 13 lbs. Potatoes, Lettuce.",
            "23 lbs. Beans, 12 lbs. Rice, 23 lbs. Lettuce, 14 lbs. Onions, 7 lbs. Guacamole, 12 lbs. Tomatoes, 7 lbs. Cilantro.",
            "12 lbs. Chicken, 12 lbs. Beef, 12 lbs. Tomatoes, 8 lbs. Lettuce, 23 lbs. Rice, 23 lbs.Bread."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_more);

            backBttn = findViewById(R.id.backBttn);
            vendorsListView = findViewById(R.id.VendorMoreListView);
            VendorMoreAdapter adapter = new VendorMoreAdapter(this, mName,  mDiscription);
            vendorsListView.setAdapter(adapter);

            vendorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    startActivity(new Intent(VendorMoreActivity.this, MapsActivity.class));
                    finish() ;
                }
            });
            backBttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    toSelect();
                }
            });
        }

    private class VendorMoreAdapter extends ArrayAdapter<String>{
        Context context;
        String rName[];
        String rDiscription[];

        VendorMoreAdapter(Context c, String name[], String discription[]){
            super(c, R.layout.vendor_list, R.id.VendorName, name );
            this.context = c;
            this.rName = name;
            this.rDiscription = discription;

        }
        @NonNull
        @Override
        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.vendor_more_list,parent, false);
            TextView name = view.findViewById(R.id.VendorMoreName);

            TextView discription = view.findViewById(R.id.VendorMoreDiscription);

            name.setText(rName[position]);

            discription.setText(rDiscription[position]);

            return view;
        }
    }
    private void toSelect()
    {
        Intent venIntent = new Intent (VendorMoreActivity.this, VVPActivity.class);
        startActivity(venIntent);
        finish();
    }

}
