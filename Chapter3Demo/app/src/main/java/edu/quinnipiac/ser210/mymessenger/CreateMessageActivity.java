package edu.quinnipiac.ser210.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.circularreveal.CircularRevealWidget;

public class CreateMessageActivity extends AppCompatActivity {

    //Gets called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    //Call onSendMessage() when the button is clicked
    //Called when the button's clicked
    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message); //Get the text that's in the EditText
        String messageText = messageView.getText().toString(); //Get the text that's in the EditText

        //Create an intent that uses a send action; not an intent explicitly for ReceiveMessageActivity
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser); // get the chooser title


        Intent chosenIntent = Intent.createChooser(intent, chooserTitle); // display the chooser dialog
        startActivity(chosenIntent); //Start the activity that the user selected
    }
}