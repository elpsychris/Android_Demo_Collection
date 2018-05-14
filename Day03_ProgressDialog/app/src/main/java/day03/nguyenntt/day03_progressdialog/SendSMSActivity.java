package day03.nguyenntt.day03_progressdialog;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
    }

    public void clickToSendSMS(View view) {
        EditText phone = findViewById(R.id.edtPhone);
        EditText content = findViewById(R.id.edtContent);

        final SmsManager smsManager = SmsManager.getDefault();
        Intent intent = new Intent("ACTION_MSG_SEND");
        final PendingIntent pending = PendingIntent.getBroadcast(this, 0, intent, 0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg = "Send OK";
                if (result != Activity.RESULT_OK) {
                    msg = "Send failed";
                    Toast.makeText(SendSMSActivity.this, msg, Toast.LENGTH_LONG).show();
                }
            }
        }, new IntentFilter("ACTION_MSG_SEND"));
        smsManager.sendTextMessage(phone.getText().toString(), null, content.getText().toString(), pending, null);
        finish();
    }
}
