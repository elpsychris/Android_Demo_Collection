package day04.nguyenntt.day05_spinnerdate;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Spinner spNat;
    private String selectedSp;
    private TextView txtDOB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDOB = findViewById(R.id.txtDOB);
        final Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR) - 18;
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        String date = String.format("%d/%d/%d",day, month, year);
        txtDOB.setText(date);

        spNat = findViewById(R.id.spNationality);
        List<String> dataSrc = new ArrayList<>();
        dataSrc.add("Kinh");
        dataSrc.add("Hoa");
        dataSrc.add("It nguoi");

        ArrayAdapter<String> dataAdt = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,  dataSrc);

        dataAdt.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spNat.setAdapter(dataAdt);
        spNat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSp = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onRegister(View view) {
        Bundle bun = new Bundle();
        txtDOB = findViewById(R.id.txtDOB);
        bun.putString("birthday", txtDOB.getText().toString());
        bun.putString("nationality", selectedSp);
        Intent intent = new Intent(this, ShowActivity.class);
        intent.putExtra("INFO", bun);

        startActivity(intent);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        int month = i1 + 1;
        int day = i2;
        txtDOB = findViewById(R.id.txtDOB);

        String date = day + "/" + month + "/" + i;
        txtDOB.setText(date);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void clickToChangeDate(View view) {
        DialogFragment dateFrag = new DatePickerFragment();
        dateFrag.show(getFragmentManager(), "DatePicker");
    }
}
