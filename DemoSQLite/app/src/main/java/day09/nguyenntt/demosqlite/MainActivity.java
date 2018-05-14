package day09.nguyenntt.demosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    private EditText edtText;
    private Button btnAdd, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);

        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        edtText = findViewById(R.id.edtText);

        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String text = edtText.getText().toString();

                if (text.length() == 0) {
                    Toast.makeText(getBaseContext(), "You must input something", Toast.LENGTH_LONG).show();
                } else {
                    addData(text);
                    edtText.setText("");
                }
            }
        });
    }

    private void addData(String text) {
        boolean insert = db.addData(text);
        if (insert) {
            Toast.makeText(this, "Added successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Something wrong!", Toast.LENGTH_SHORT).show();
        }
    }
}
