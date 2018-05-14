package day07.nguyenntt.day07_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToSingle(View view) {
        Intent intent = new Intent(this, SingleListActivity.class);
        startActivity(intent);

    }

    public void clickToMultiple(View view) {
        Intent intent = new Intent(this, MultiListActivity.class);
        startActivity(intent);
    }
}
