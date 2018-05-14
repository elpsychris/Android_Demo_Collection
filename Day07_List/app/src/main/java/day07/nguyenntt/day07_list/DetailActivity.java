package day07.nguyenntt.day07_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView txtDetail = findViewById(R.id.txtDetail);
        Intent intent = getIntent();
        String detail = intent.getStringExtra("detail");
        txtDetail.setText("You choose position: " + detail);
    }
}
