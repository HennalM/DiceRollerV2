package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


   public static int number = 0;


    private TextView Hello;
    private EditText NumberEntered;
    private Button validate;
    private Object numberToFind;
    private int counter = 0;
    private TextView Result;
    private TextView Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hello = (TextView) findViewById(R.id.HelloWorld);
        NumberEntered = (EditText) findViewById(R.id.NumberEntered);
        Result = (TextView) findViewById(R.id.count);
        Score = (TextView) findViewById(R.id.counter);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void roll_the_dice(View view) {
        TextView tv = (TextView) this.findViewById(R.id.RollDice);

        Random r = new Random();

        number = r.nextInt((6 )) +1;

        tv.setText(Integer.toString(number));


        int n = Integer.parseInt(NumberEntered.getText().toString());

        try {
            if (n < 1 || n > 6) {
                Toast.makeText(this, "Invalid input! Please put a Valid input between 1 - 6", Toast.LENGTH_SHORT).show();
            } else if (n == number) {
                Toast.makeText(this, "CONGRATULATION!, The number you inputted is match a number!", Toast.LENGTH_SHORT).show();
                counter = counter + 1;
                Result.setText(Integer.toString(counter));

            }
        } catch (Exception e) {
            Toast.makeText(this, "Please insert a numerical value", Toast.LENGTH_SHORT).show();
            //test
        }

    }


    public void DiceBreaker(View view) {

        //TextView DiceBreaker = this.findViewById(R.id.DiceBreaker);
        TextView Question = this.findViewById(R.id.QUEST);

        Random rand = new Random();
        int num2 = rand.nextInt((6-1)+1)+1;
        switch (num2 ) {
            case 1:
                Question.setText("If you could go anywhere in the world, where would you go?");
                break;

            case 2:
                Question.setText("If you were stranded on a desert island, what three things would you want to take with you?");
                break;

            case 3:
                Question.setText("If you could eat only one food for the rest of your life, what would that be?");
                break;

            case 4:
                Question.setText("If you won a million dollars, what is the first thing you would buy?");
                break;

            case 5:
                Question.setText("If you could spend the day with one fictional character, who would it be?");
                break;

            case 6:
                Question.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
                break;

            default:
                Question.setText("There is a Question ERROR");
                break;
        }
    }

}

