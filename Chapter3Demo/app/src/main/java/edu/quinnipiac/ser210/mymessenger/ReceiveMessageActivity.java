package edu.quinnipiac.ser210.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message"; //Name of the extra value we're passing in the intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(messageText);
    }

    //Call onSendMessage() when the button is clicked
    public void onSendMessage (View view) {
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        startActivity(intent); //Start activity ReceiveMessageActivity
    }
}