package to.us.ekimhest.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        //Display score
        Intent score = getIntent();
        int scoreNum = score.getIntExtra("score", 0);
        scoreDisplayMethod("It took you " + scoreNum + " guesses");
    }

    public void restart(View view) {
        Intent restart = new Intent(this, MainGame.class);
        startActivity(restart);
    }

    public void menuButton(View view) {
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    //Methods====================
    private void scoreDisplayMethod(String scoreText) {
        TextView scoreTextView = (TextView) findViewById(R.id.score);
        scoreTextView.setText(scoreText);
    }
}
