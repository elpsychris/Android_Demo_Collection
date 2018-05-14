package day03.nguyenntt.day2understandactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickGo(View view) {
        Intent intent = new Intent(this, SendMsgActivity.class);

        EditText name = findViewById(R.id.edtName);
        String msg = name.getText().toString();
        intent.putExtra("EXTRA", msg);

        startActivity(intent);
    }
}
