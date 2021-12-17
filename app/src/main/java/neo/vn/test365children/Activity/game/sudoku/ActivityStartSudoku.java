package neo.vn.test365children.Activity.game.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import neo.vn.test365children.Activity.game.Activity_Guild_Game;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Presenter.PresenterStartGameSudoku;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;

public class ActivityStartSudoku extends BaseActivity {
    @BindView(R.id.imageView23)
    ImageView img_background;
    @BindView(R.id.imageView21)
    ImageView img_logo_sudoku;
    @BindView(R.id.imageView24)
    ImageView img_number_sudoku;
    @BindView(R.id.imageView22)
    ImageView img_boy_sudoku;
    @BindView(R.id.btn_level_1)
    Button btn_level_1;
    @BindView(R.id.btn_level_2)
    Button btn_level_2;
    @BindView(R.id.btn_level_3)
    Button btn_level_3;
    @BindView(R.id.btn_back)
    ImageView btn_back;
    @BindView(R.id.txt_guilde)
    TextView txt_guilde;
    private PresenterStartGameSudoku mPresenter;

    @Override
    public int setContentViewId() {
        return R.layout.activity_start_game_sudoku;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterStartGameSudoku();
        initShowBackground();
        initEvent();
    }

    private void initEvent() {
        txt_guilde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityStartSudoku.this);
                Intent intent = new Intent(ActivityStartSudoku.this,
                        Activity_Guild_Game.class);
                intent.putExtra(Constants.KEY_SEND_GUILD_GAME, "SUDOKU");
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityStartSudoku.this);
                finish();
            }
        });
        final Intent intent = new Intent(ActivityStartSudoku.this, ActivityGamePlaySudoku.class);
        btn_level_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityStartSudoku.this);
                get_api_start_game();
                KeyboardUtil.animation_click_button(ActivityStartSudoku.this, btn_level_1);
                intent.putExtra(Constants.KEY_SEND_LEVEL_SUDOKU, 30);
                startActivity(intent);
            }
        });
        btn_level_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityStartSudoku.this);
                get_api_start_game();
                KeyboardUtil.animation_click_button(ActivityStartSudoku.this, btn_level_2);
                intent.putExtra(Constants.KEY_SEND_LEVEL_SUDOKU, 40);
                startActivity(intent);
            }
        });
        btn_level_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityStartSudoku.this);
                get_api_start_game();
                KeyboardUtil.animation_click_button(ActivityStartSudoku.this, btn_level_3);
                intent.putExtra(Constants.KEY_SEND_LEVEL_SUDOKU, 45);
                startActivity(intent);
            }
        });
    }

    private void initShowBackground() {
        Glide.with(this).load(R.drawable.bg_game_sudoku).into(img_background);
        Glide.with(this).load(R.drawable.logo_sudoku).into(img_logo_sudoku);
        Glide.with(this).load(R.drawable.bg_number_sudoku).into(img_number_sudoku);
        Glide.with(this).load(R.drawable.icon_boy_sudoku).into(img_boy_sudoku);
    }

    Calendar cal;
    Date date;
    SimpleDateFormat dft = null;

    private String get_current_time() {
        String date = "";
        //Set ngày giờ hiện tại khi mới chạy lần đầu
        cal = Calendar.getInstance();
        //Định dạng kiểu ngày / tháng /năm
        dft = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        date = dft.format(cal.getTime());
        //hiển thị lên giao diện
        return date;
    }

    public void get_api_start_game() {
        String sUserMother = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        String sUserKid = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        mPresenter.api_start_game_sudoku(sUserMother, sUserKid, get_current_time());
    }
}
