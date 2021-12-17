package neo.vn.test365children.Activity.game.game_kow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.Activity.game.Activity_Guild_Game;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;

public class ActivityKoWStart extends BaseActivity {
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.btn_start_kow)
    Button btn_start_kow;
    @BindView(R.id.txt_guilde)
    TextView txt_guilde;

    @Override
    public int setContentViewId() {
        return R.layout.activity_game_kow_start;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load(R.drawable.bg_game_kow_start).into(img_background);
        initEvent();
    }

    private void initEvent() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityKoWStart.this);
                finish();
            }
        });
        txt_guilde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityKoWStart.this);
                Intent intent = new Intent(ActivityKoWStart.this,
                        Activity_Guild_Game.class);
                intent.putExtra(Constants.KEY_SEND_GUILD_GAME, "KOW");
                startActivity(intent);
            }
        });
    }

    public void start_activity(View v) {
        KeyboardUtil.play_click_button(ActivityKoWStart.this);
        KeyboardUtil.animation_click_button(ActivityKoWStart.this, btn_start_kow);
        startActivity(new Intent(ActivityKoWStart.this, ActivityKoWMenuGame.class));
    }

}
