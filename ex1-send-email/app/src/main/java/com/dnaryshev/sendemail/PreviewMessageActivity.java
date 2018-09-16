package com.dnaryshev.sendemail;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PreviewMessageActivity extends AppCompatActivity {

    private static final String PREVIEW_MSG = "PREVIEW_MSG";
    private String _msg;
    private Button _emailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_message);
        TextView view = findViewById(R.id.preview_text);
        _msg = getIntent().getStringExtra(PREVIEW_MSG);
        view.setText(_msg);
        _emailBtn = findViewById(R.id.email_button);
        _emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnEmailButtonClick(v);
            }
        });
    }

    private void OnEmailButtonClick(View v) {
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
        sendIntent.setData(Uri.parse("mailto:"));
        if (sendIntent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(this, R.string.no_email_app, Toast.LENGTH_LONG).show();
        } else {
            sendIntent.putExtra(Intent.EXTRA_EMAIL, R.string.email);
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.subject);
            sendIntent.putExtra(Intent.EXTRA_TEXT, _msg);
            startActivity(sendIntent);
        }
    }

    public static void openActivity(Activity activity, String msg) {
        Intent intent = new Intent(activity, PreviewMessageActivity.class);
        intent.putExtra(PREVIEW_MSG, msg);
        activity.startActivity(intent);
    }
}
