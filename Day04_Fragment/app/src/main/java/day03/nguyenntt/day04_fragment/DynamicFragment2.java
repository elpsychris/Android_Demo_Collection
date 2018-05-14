package day03.nguyenntt.day04_fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class DynamicFragment2 extends Fragment {
    @Override
    public void onStart() {
        super.onStart();

        Button btn = getActivity().findViewById(R.id.btnDynamic2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txt = getActivity().findViewById(R.id.txt);
                EditText edtNum1 = getActivity().findViewById(R.id.edtNum1);
                EditText edtNum2 = getActivity().findViewById(R.id.edtNum2);
                TextView txtRes = getActivity().findViewById(R.id.txtRes);

                int result = Integer.parseInt(edtNum1.getText().toString())
                        + Integer.parseInt(edtNum2.getText().toString());

                txtRes.setText(result + "");

                Toast.makeText(getActivity(),txt.getText().toString() + " Fragment 2",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dynamic_fragment2,container,false);
    }
}
