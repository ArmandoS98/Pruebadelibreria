package armando.gt.com.pruebadelibreria;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.q42.android.scrollingimageview.ScrollingImageView;

import xyz.hanks.library.bang.SmallBangView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScrollingImageView scrollingBackground = findViewById(R.id.scrolling_background);


        final SmallBangView like_heart = findViewById(R.id.like_heart);
        like_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (like_heart.isSelected()) {
                    like_heart.setSelected(false);
                    Toast.makeText(MainActivity.this, "No te gusta ", Toast.LENGTH_SHORT).show();
                } else {
                    like_heart.setSelected(true);
                    like_heart.likeAnimation(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            Toast.makeText(MainActivity.this, "Te gusta Boku No Heroe", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        final SmallBangView like_text = findViewById(R.id.like_text);
        like_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (like_text.isSelected()) {
                    like_text.setSelected(false);
                } else {
                    like_text.setSelected(true);
                    like_text.likeAnimation();
                }
            }
        });

        //scrollingBackground.stop();
        scrollingBackground.start();
    }
}
