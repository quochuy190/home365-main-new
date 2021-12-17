package neo.vn.test365children.Activity.game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;

public class ActivityGuideGameTPTT extends BaseActivity {
    @BindView(R.id.img_bang_guide_game)
    ImageView img_bang;
    @BindView(R.id.imageView15)
    ImageView img_teacher;
    @BindView(R.id.imageView13)
    ImageView img_background;
    @BindView(R.id.btn_start_game)
    Button btn_start_game;
    MediaPlayer mPlayer;

    @Override
    public int setContentViewId() {
        return R.layout.activity_guilde_game;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load(R.drawable.bg_start_game).into(img_background);
        Glide.with(this).load(R.drawable.icon_bang).into(img_bang);
        Glide.with(this).load(R.drawable.icon_teacher).into(img_teacher);
        mPlayer = new MediaPlayer();
        play_start_game();
        btn_start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.animation_click_button(ActivityGuideGameTPTT.this, btn_start_game);
                Intent intent = new Intent(ActivityGuideGameTPTT.this, ActivityGameTrieuphutrithuc.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPlayer != null && !mPlayer.isPlaying()) {
            mPlayer.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.pause();
        }
    }

    public void play_start_game() {
        //mp3 = new MediaPlayer();
        mPlayer.release();
        mPlayer = MediaPlayer.create(ActivityGuideGameTPTT.this, R.raw.nhac_mo_dau_2008);
        mPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayer.release();
    }
}
