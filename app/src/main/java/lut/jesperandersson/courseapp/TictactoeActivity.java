package lut.jesperandersson.courseapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TictactoeActivity extends AppCompatActivity {

    TicTacGamestate gamestate;
    int xImg;
    int oImg;
    int emptyImg;
    boolean gameOver;

    ImageButton[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        ImageView playerTicImageView = (ImageView) findViewById(R.id.playerTicImageView);
        ImageView cpuTacImageView = (ImageView) findViewById(R.id.cpuTacImageView);

        playerTicImageView.setImageResource(R.drawable.x);
        cpuTacImageView.setImageResource(R.drawable.o);


        gamestate = new TicTacGamestate();
        xImg = R.drawable.x;
        oImg = R.drawable.o;
        emptyImg = R.drawable.empty;
        gameOver = false;

        buttons = new ImageButton[9];
        buttons[0] = (ImageButton) findViewById(R.id.topLeftSq);
        buttons[1] = (ImageButton) findViewById(R.id.topMiddleSq);
        buttons[2] = (ImageButton) findViewById(R.id.topRightSq);
        buttons[3] = (ImageButton) findViewById(R.id.middleLeftSq);
        buttons[4] = (ImageButton) findViewById(R.id.middleMiddleSq);
        buttons[5] = (ImageButton) findViewById(R.id.middleRightSq);
        buttons[6] = (ImageButton) findViewById(R.id.bottomLeftSq);
        buttons[7] = (ImageButton) findViewById(R.id.bottomMiddleSq);
        buttons[8] = (ImageButton) findViewById(R.id.bottomRightSq);

        for (int i=0; i<9; i++){
            ImageButton button = buttons[i];
            int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!gameOver){
                        gamestate.makePlayerMove(finalI);
                        updateBoard();
                        String gameOverMsg = gamestate.getGameOverMsg();
                        if (gameOverMsg != null){
                            TextView gameResultTextView = (TextView) findViewById(R.id.gameResultTextView);
                            gameResultTextView.setText(gameOverMsg);
                            gameOver = true;
                        }
                    }
                }
            });
        }

        Button resetBtn = (Button) findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameOver = false;
                gamestate = new TicTacGamestate();
                TextView gameResultTextView = (TextView) findViewById(R.id.gameResultTextView);
                gameResultTextView.setText("");
                updateBoard();
            }
        });
    }

    private void updateBoard() {
        for (int i=0; i<9; i++){
            int sqValue = gamestate.board[i];
            ImageButton button = buttons[i];
            switch (sqValue){
                case 1:
                    setImage(button, xImg);
                    break;
                case -1:
                    setImage(button, oImg);
                    break;
                default:
                    setImage(button, emptyImg);
                    break;
            }
        }
    }

    private void setImage(ImageButton button, int img) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), img, options);
        button.setImageBitmap(scaledImg);
    }
}