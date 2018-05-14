package day07.nguyenntt.day07_list;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MultiListActivity extends ListActivity {

    private String[] listSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView view = getListView();
        view.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        view.setTextFilterEnabled(true);

        listSubject = getResources().getStringArray(R.array.listSubject);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_checked,listSubject);

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, "Selected: " + listSubject[position], Toast.LENGTH_LONG).show();
    }
}
