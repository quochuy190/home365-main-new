package neo.vn.test365children.Activity.game.game_kow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Models.TopicKoW;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;

public class ActivityKoWMenuLevel extends BaseActivity {
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.btn_start_easy)
    Button btn_start_easy;
    @BindView(R.id.btn_start_hard)
    Button btn_start_hard;
    TopicKoW mTopic;

    @Override
    public int setContentViewId() {
        return R.layout.activity_game_kow_menugame;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load(R.drawable.bg_menu_kow_level).into(img_background);
        mTopic = (TopicKoW) getIntent().getSerializableExtra(Constants.KEY_SEND_LEVEL_KOW);
        initEvent();
    }

    private void initEvent() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityKoWMenuLevel.this);
                finish();
            }
        });
    }

    public void start_activity(View v) {
        KeyboardUtil.play_click_button(ActivityKoWMenuLevel.this);
        Intent intent = new Intent(this, ActivityKoWPlayGame.class);
        intent.putExtra(Constants.KEY_SEND_LEVEL_KOW, mTopic);
        startActivity(intent);
    }

    public void start_activity_easy(View v) {
        KeyboardUtil.play_click_button(ActivityKoWMenuLevel.this);
        Intent intent = new Intent(this, ActivityKowPlay_Level_Two.class);
        intent.putExtra(Constants.KEY_SEND_LEVEL_KOW, mTopic);
        startActivity(intent);
    }

    public void start_activity_normal(View v) {
        KeyboardUtil.play_click_button(ActivityKoWMenuLevel.this);
        Intent intent = new Intent(this, ActivityKowPlayEasyGame.class);
        intent.putExtra(Constants.KEY_SEND_LEVEL_KOW, mTopic);
        startActivity(intent);
    }
}
