package ad3d.com.completeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Explore1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore1);

    }

    public void sendBack(View view) {
        // Do something in response to button
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    /*public void goToMaps(View view){
        Intent intent = new Intent(getApplicationContext(), RetrieveMain.class);
        startActivity(intent);
    }*/
}