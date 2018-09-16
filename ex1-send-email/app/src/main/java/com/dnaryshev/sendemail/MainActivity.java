package com.dnaryshev.sendemail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView _msgTxt;
    private Button _previewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _msgTxt = findViewById(R.id.message_text_input);
        _previewBtn = findViewById(R.id.preview_button);
        _previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPreviewMessageActivity();
            }
        });
    }

    public void openPreviewMessageActivity() {
        String msg = _msgTxt.getText().toString();
        PreviewMessageActivity.openActivity(this, msg);
    }
}
