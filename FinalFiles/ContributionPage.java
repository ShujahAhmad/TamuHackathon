package ad3d.com.completeapp;


import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.UploadTask;

public class ContributionPage extends AppCompatActivity {
    EditText txtName, txtAddress, door_Length, door_Width, minTableHeight, AR_sscore, exComm;
    Switch AC_switch;
    Button contribution_upload;


    DatabaseReference reff;
    Member2 member2;

    long maxid = 0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_contribution_page);
        Toast.makeText(ContributionPage.this, "Firebase connected", Toast.LENGTH_LONG).show();

        txtName = (EditText)findViewById(R.id.nameInput);
        txtAddress = (EditText)findViewById(R.id.addressInput);
        door_Length = (EditText)findViewById(R.id.door_length);
        door_Width = (EditText)findViewById(R.id.door_width);
        minTableHeight = (EditText)findViewById(R.id.min_table_height);
        AC_switch = (Switch)findViewById(R.id.switch1);
        // check current state of a Switch (true or false).
        Boolean switchState = AC_switch.isChecked();
        final String switch_String = switchState.toString();
        AR_sscore = (EditText)findViewById(R.id.AR_Score);
        exComm = (EditText)findViewById(R.id.extraComments);

        contribution_upload = (Button)findViewById(R.id.contributionSubmit);

        member2 = new Member2();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        contribution_upload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                member2.setName(txtName.getText().toString().trim());
                member2.setAddress(txtAddress.getText().toString().trim());
                member2.setDoorLength(door_Length.getText().toString().trim());
                member2.setDoorwidth(door_Width.getText().toString().trim());
                member2.setMinTableHeight(minTableHeight.getText().toString().trim());
                member2.setRampBoolean(switch_String);
                member2.setARScore(AR_sscore.getText().toString().trim());
                member2.setExtraComments(exComm.getText().toString().trim());
                reff.child(String.valueOf(maxid+1)).setValue(member2);
                Toast.makeText(ContributionPage.this, "Should be sending data to firebase", Toast.LENGTH_LONG).show();
            }
        });

        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //final DatabaseReference myRef = database.getReference("Name/FirsName");
        //myRef.push().setValue("Shujah");
        //final DatabaseReference myRef2 = database.getReference("Name/LastName");
        //myRef2.push().setValue("Perfect");


    }



}