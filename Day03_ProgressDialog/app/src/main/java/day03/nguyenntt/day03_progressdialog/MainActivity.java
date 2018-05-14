package day03.nguyenntt.day03_progressdialog;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnPro;
    ProgressDialog myPro_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPro = findViewById(R.id.btnProgress);

        btnPro.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          myPro_bar = new ProgressDialog(MainActivity.this);
                                          myPro_bar.setMessage("Loading...");
                                          myPro_bar.setTitle("Please wait...");
                                          myPro_bar.setProgressStyle(myPro_bar.STYLE_HORIZONTAL);
                                          myPro_bar.setMax(20);
                                          myPro_bar.setProgress(0);
                                          myPro_bar.show();
                                          new Thread(new Runnable() {
                                              @Override
                                              public void run() {
                                                  try {
                                                      while (myPro_bar.getProgress() < myPro_bar.getMax()) {
                                                          Thread.sleep(1000);
                                                          handler.sendMessage(handler.obtainMessage());
                                                      }

                                                      if (myPro_bar.getProgress() == myPro_bar.getMax()) {
                                                          myPro_bar.dismiss();
                                                      }
                                                  } catch (Exception e) {
                                                      e.printStackTrace();
                                                  }
                                              }
                                          }).start();
                                      }

                                      Handler handler = new Handler() {
                                          public void handleMessage(Message msg) {
                                              super.handleMessage(msg);
                                              myPro_bar.incrementProgressBy(2);
                                          }
                                      };

                                  }
        );
    }

    public void clickToSend(View view) {
        Intent intent = new Intent(this, SendSMSActivity.class);
        startActivity(intent);
    }
}
