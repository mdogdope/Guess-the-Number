package to.us.ekimhest.guessinggame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences highScorePrefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int highScore = highScorePrefs.getInt("highScore", 0);

        TextView highScoreDisplay = (TextView) findViewById(R.id.high_score_text_view);
        highScoreDisplay.setText("High Score: " + highScore);
    }

    public void playButton(View view) {
        Intent start = new Intent(this, MainGame.class);
        startActivity(start);
    }

    public void settings(View view) {
        Intent settings = new Intent(this, Settings.class);
        startActivity(settings);
    }
}
