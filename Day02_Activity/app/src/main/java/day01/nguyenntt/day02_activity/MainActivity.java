package day01.nguyenntt.day02_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int reqCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToInput(View view) {
        Intent intent = new Intent(this, CalculateActivity.class);
        startActivityForResult(intent, reqCode);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == reqCode)  {
            if (resultCode == RESULT_OK) {
                String res = data.getStringExtra("result");
                TextView txtResult = findViewById(R.id.txtRes);
                txtResult.setText(res);
            }
        }
    }
}
