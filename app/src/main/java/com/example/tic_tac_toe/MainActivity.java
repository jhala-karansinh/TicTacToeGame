package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //JAY-MATAJI
    //ZALA KARANSINH SHAKTISINH

    int turn = 0;

    int[] state = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    int[][] winPos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    int count = 0;

    boolean isActive = true;

    TextView status,askrestart;

    private void resetGame() {
        isActive = true;

        turn = 0;

        count = 0;

        for(int i=0;i<9;i++) {
            state[i] = -1;
        }

        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView24)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView25)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView26)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView27)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView28)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView29)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView30)).setImageResource(0);

        status = findViewById(R.id.turnStatus);
        status.setText("Player-1's Turn");

        askrestart = findViewById(R.id.askrestart);
        askrestart.setText("");
    }

    private boolean checkWin(int[] state,int a,int b,int c) {

        if(state[a] != -1 && state[a] == state[b] && state[b] == state[c] && isActive) {

            if(a == 0 && b == 1 && c == 2) {
                ImageView imageView = findViewById(R.id.imageView24);
                imageView.setImageResource(R.drawable.hor);
                //imageView.animate().translationYBy(1000f).setDuration(200);
            }
            else if(a == 3 && b == 4 && c == 5 ) {
                ImageView imageView = findViewById(R.id.imageView25);
                imageView.setImageResource(R.drawable.hor);
                //imageView.animate().translationYBy(1000f).setDuration(200);
            }
            else if(a == 6 && b == 7 && c == 8 ) {
                ImageView imageView = findViewById(R.id.imageView26);
                imageView.setImageResource(R.drawable.hor);
                //imageView.animate().translationYBy(1000f).setDuration(200);
            }
            else if(a == 0 && b == 3 && c == 6 ) {
                ImageView imageView = findViewById(R.id.imageView27);
                imageView.setImageResource(R.drawable.ver);
                //imageView.animate().translationYBy(1000f).setDuration(200);
            }
            else if(a == 1 && b == 4 && c == 7 ) {
                ImageView imageView = findViewById(R.id.imageView28);
                imageView.setImageResource(R.drawable.ver);
                //imageView.animate().translationYBy(1000f).setDuration(200);
            }
            else if(a == 2 && b == 5 && c == 8 ) {
                ImageView imageView = findViewById(R.id.imageView29);
                imageView.setImageResource(R.drawable.ver);
                //imageView.animate().translationYBy(1000f).setDuration(200);
            }
            else if(a == 0 && b == 4 && c == 8) {
                ImageView imageView = findViewById(R.id.imageView30);
                imageView.setImageResource(R.drawable.cross1);
            }
            else {
                ImageView imageView = findViewById(R.id.imageView30);
                imageView.setImageResource(R.drawable.cross2);
            }

            return true;
        }
        return false;
    }

    public void tapped(View view) {

        if(count!=9) {
            count++;
        }

        ImageView img = (ImageView)view;
        int cell = Integer.parseInt(img.getTag().toString());

        if(cell == 9) {
            resetGame();
            return;
        }

        if(state[cell] == -1 && isActive) {
            state[cell] = turn;

            img.setTranslationY(-1000f);

            if(turn==0)
            {
                img.setImageResource(R.drawable.mindu);
                turn = 1;
                status = findViewById(R.id.turnStatus);
                status.setText("Player2's Turn");
            }
            else {
                img.setImageResource(R.drawable.chokdi);
                turn = 0;
                status = findViewById(R.id.turnStatus);
                status.setText("Player1's Turn");
            }

            img.animate().translationYBy(1000f).setDuration(10);
        }

        for(int i=0;i<8;i++) {
            if(checkWin(state,winPos[i][0],winPos[i][1],winPos[i][2])) {
                isActive = false;

                String winStr;

                if(turn == 0)
                {
                    winStr = "X IS WINNER !!!";
                }
                else
                {
                    winStr = "O IS WINNER !!!";
                }

                askrestart = findViewById(R.id.askrestart);
                askrestart.setText("Click here to restart - > ");
                status.setText(winStr);
            }
        }

        if(count >= 9 && isActive) {
            String winStr = "IT'S A DRAW !!!";
            status.setText(winStr);

            askrestart = findViewById(R.id.askrestart);
            askrestart.setText("Click here to restart - > ");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}