package id.duza.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView tvMessage = (TextView) findViewById(R.id.tv_welcome_message);

        // menerima intent lalu mengambil data string yg dikirim dari MainActivity dengan key Intent.EXTRA_TEXT
        String username = getIntent().getStringExtra(Intent.EXTRA_TEXT);

        // Mengubah isi text dari textview atau meng set teks nya
        tvMessage.setText("Welcome " + username);
    }
}
