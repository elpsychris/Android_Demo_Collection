package day01.nguyenntt.day02_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
    }

    public void clickToAdd(View view) {
        Intent intent = this.getIntent();
        EditText edtNum1 = findViewById(R.id.edtNum1);
        EditText edtNum2 = findViewById(R.id.edtNum2);

        int num1 = Integer.parseInt(edtNum1.getText().toString());
        int num2 = Integer.parseInt(edtNum2.getText().toString());
        int result = num1 + num2;

        intent.putExtra("result", result + "");
        this.setResult(RESULT_OK, intent);
        finish();

    }

    public void clickToSub(View view) {
        Intent intent = this.getIntent();
        EditText edt1 = findViewById(R.id.edtNum1);
        EditText edt2 = findViewById(R.id.edtNum2);

        int num1 = Integer.parseInt(edt1.getText().toString());
        int num2 = Integer.parseInt(edt2.getText().toString());

        int res = num1 - num2;
        intent.putExtra("result", res + "");

        this.setResult(RESULT_OK, intent);
        finish();
    }
}
