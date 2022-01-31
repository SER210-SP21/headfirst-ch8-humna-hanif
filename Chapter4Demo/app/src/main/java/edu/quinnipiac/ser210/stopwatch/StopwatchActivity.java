package edu.quinnipiac.ser210.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;
import android.os.Handler;


public class StopwatchActivity extends AppCompatActivity {

    //Use the seconds and running variables to record the number of seconds passed and whether the stopwatch is running
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning; //records whether the stopwatch was running before the onStop() method was called

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning"); //restore the state of the wasRunning variable if the activity is recreated
        }
        runTimer(); //starting it when the activity is created
    }

    //If the activity's paused, stop the stopwatch
    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    //If the activity's resumed, start the stopwatch again if it was running previously
    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning); //save the state of the wasRunning variable
    }

    //Start the stopwatch running when the Start button is clicked
    //Gets called when the Start button is clicked
    public void onClickStart(View view) {
        running = true; //start the stopwatch
    }

    //Stop the stopwatch running when the Stop button is clicked
    //Gets called when the Stop button is clicked
    public void onClickStop(View view) {
        running = false; //stop the stopwatch
    }

    //Reset the stopwatch when the Reset button is clicked
    //Gets called when the Reset button is clicked
    public void onClickReset(View view) {
        //stop the stopwatch and set the seconds to 0
        running = false;
        seconds = 0;
    }

    //Get a reference to the text view in the layout; format the contents of the seconds variable into hours, minutes, and seconds and then display results in the text view
    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view); //get the text view
        final Handler handler = new Handler(); //create new handler
        handler.post(new Runnable() {
            @Override
            public void run() {
                //Format the seconds into hours, minutes, and seconds
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++; //if running is true, increment the seconds variable
                }
                handler.postDelayed(this, 1000); //post the code in the Runnable to be run again after a delay of 1000 milliseconds
            }
            });

    }

}