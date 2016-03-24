package to.us.ekimhest.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice("D9A6F8EAFC051A2FE60ACC2A62417A13")
                .build();
        mAdView.loadAd(adRequest);

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
