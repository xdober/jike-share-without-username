package com.example.rongren.jike_share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class share extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (action.equals(Intent.ACTION_SEND) && type!=null) {
            if (type.equals("text/plain")) {
                handleSendText(intent);
            }
        }
    }

    private void handleSendText(Intent intent) {
        String shareText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (shareText!=null) {
            int index = shareText.indexOf("?username");
            if (index!=-1) {
                shareText = shareText.substring(0, index);
            }
            shareText(shareText);
            finish();
        }
    }

    private void shareText(String string) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, string);
        intent.setType("text/plain");
        startActivity(intent);
    }
}
