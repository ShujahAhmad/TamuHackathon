package com.example.currentplacedetailsonmap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RetrieveMain extends AppCompatActivity {
    String address;
    String restaurantName;
    EditText nameInput;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        nameInput = (EditText) findViewById(R.id.name);
        sendButton = (Button) findViewById(R.id.send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restaurantName = nameInput.getText().toString();//stored restaurant name
                FirebaseDatabase restDataBase = FirebaseDatabase.getInstance();
                DatabaseReference myData = restDataBase.getReference("Restraunt");///change later
                myData.child(restaurantName).addValueEventListener((new ValueEventListener(){
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       address = dataSnapshot.getValue().toString();
                       address = address.substring(9,address.length()-1);
                       transition(restaurantName, address);
                   }
                   @Override
                    public void onCancelled(DatabaseError databaseError) {

                   }
                }));
            }
        });


    }
    public void transition(String name, String address) {
        Intent maps = new Intent(this, MapsActivityCurrentPlace.class);
        maps.putExtra("name", name);
//        try {
//            Thread.sleep(2 * 1000);
//        } catch (InterruptedException ie) {
//            Thread.currentThread().interrupt();
//        }
        maps.putExtra("address", address);
        startActivity(maps);
    }
}
