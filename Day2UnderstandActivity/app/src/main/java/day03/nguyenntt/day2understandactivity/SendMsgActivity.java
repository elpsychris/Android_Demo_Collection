package day03.nguyenntt.day2understandactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SendMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg);

        //Get the Intent
        Intent intent = getIntent();
        String msg = intent.getStringExtra("EXTRA");

        TextView textView = findViewById(R.id.textView);
        textView.setText(msg);

    }
}
