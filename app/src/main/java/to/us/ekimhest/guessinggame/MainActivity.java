package to.us.ekimhest.guessinggame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice("D9A6F8EAFC051A2FE60ACC2A62417A13")
                .build();
        mAdView.loadAd(adRequest);

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
