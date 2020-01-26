package ad3d.com.completeapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendToExplore(View view) {
        // Do something in response to button
        Intent intent = new Intent(getApplicationContext(), Explore1.class);
        startActivity(intent);
    }

    public void gotoContributionPage(View view){
        Intent gotoContribute = new Intent(getApplicationContext(), ContributionPage.class);
        startActivity(gotoContribute);
    }




}