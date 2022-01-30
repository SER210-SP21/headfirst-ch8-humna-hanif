package edu.quinnipiac.ser210.ls03_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

    //get the string from the intent
    String value = getIntent().getStringExtra("inputKey");
    // reference to text view
    TextView returnVal = (TextView) findViewById(R.id.displayintentextra);
    returnVal.setText(value); // value = retrieved from input
    }

    // call of super method and override
    // get the return value
    @Override
    public void finish() {
        EditText returnVal = (EditText) findViewById(R.id.returnValue);
        // make an intent that will send information back to main activity
        Intent data = new Intent(this, MainActivity.class);
        // put this return value in the extras, give key, a value which is the returnVal text)
        data.putExtra("returnKey", returnVal.getText().toString());
        // insteading of calling start call setresult to go back

        setResult(RESULT_OK, data); // looking for a code different than the request code
        // standard code and put the intent

        super.finish();
    }
}