  package co.edu.eafit.jquiro12.first_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

  public class MainActivity extends AppCompatActivity {
    private int rand1;
    private int rand2;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pickRandomNumber();

    }

    private void pickRandomNumber(){
        Random randy = new Random();

        rand1 = randy.nextInt(10);
        while(true) {
            rand2 = randy.nextInt(10);
            if(rand1 != rand2) break;
        }
        Button lbutt = (Button) findViewById(R.id.left_button);
        lbutt.setText(Integer.toString(rand1));

        Button rbutt = (Button) findViewById(R.id.rigth_button);
        rbutt.setText(Integer.toString(rand2));

    }

    public void LeftButtonClick(View view ){
        if (rand1 > rand2){
            //Correct
            points++;
            Toast.makeText(this, "Great Job!", Toast.LENGTH_SHORT).show();


        }else{
            //Incorrect
            points--;
            Toast.makeText(this, "You suck.", Toast.LENGTH_SHORT).show();
        }

        //Update display of points
        TextView tv = (TextView) findViewById(R.id.points_field);
        tv.setText("Points " +  points);
        pickRandomNumber();

    }


    public void RigthButtonClick(View view ){
        if (rand1 < rand2){
            //Correct
            points++;
            Toast.makeText(this, "Great Job!", Toast.LENGTH_SHORT).show();


        }else{
            //Incorrect
            points--;
            Toast.makeText(this, "You suck.", Toast.LENGTH_SHORT).show();
        }

        //Update display of points
        TextView tv = (TextView) findViewById(R.id.points_field);
        tv.setText("Points " +  points);
        pickRandomNumber();


    }

}
