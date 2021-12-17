package neo.vn.test365children.Activity.game;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.R;

public class Activity_Guild_Game extends BaseActivity {
    @BindView(R.id.btn_back)
    Button btn_back;
    @BindView(R.id.logo_infor)
    ImageView logo_infor;
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.txt_content_infor)
    TextView txt_content_infor;
    String sOption_Game = "";

    @Override
    public int setContentViewId() {
        return R.layout.activity_guild_game;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initEvent();
    }

    private void initData() {
        sOption_Game = getIntent().getStringExtra(Constants.KEY_SEND_GUILD_GAME);
        switch (sOption_Game) {
            case "SUDOKU":
                Glide.with(this).load(R.drawable.icon_game_sudoku).into(logo_infor);
                Glide.with(this).load(R.drawable.bg_menu_game).into(img_background);
                txt_content_infor.setText(getResources().getText(R.string.detail_game_sudoku));
                break;
            case "KOW":
                Glide.with(this).load(R.drawable.bg_kow_playgame).into(img_background);
                Glide.with(this).load(R.drawable.icon_game_kigofword).into(logo_infor);
                txt_content_infor.setText(getResources().getText(R.string.detail_game_kow));
                break;
            case "TNNL":
                Glide.with(this).load(R.drawable.bg_menu_game).into(img_background);
                Glide.with(this).load(R.drawable.icon_game_tinhnhanh).into(logo_infor);
                txt_content_infor.setText(getResources().getText(R.string.detail_game_tnnl));
                break;
        }
    }

    private void initEvent() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
