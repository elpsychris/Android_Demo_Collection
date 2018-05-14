package day04.nguyenntt.day05_spinnerdate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView dob = findViewById(R.id.txtDOB);
        TextView nat = findViewById(R.id.txtNat);

        Intent intent = getIntent();
        Bundle bun = intent.getBundleExtra("INFO");
        dob.setText(bun.getString("birthday"));
        nat.setText(bun.getString("nationality"));
    }
}
