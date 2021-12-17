package neo.vn.test365children.Activity.doctruyen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;

public class Activity_menu_doctruyen extends BaseActivity {
    @BindView(R.id.btn_eng)
    Button btn_eng;
    @BindView(R.id.btn_vie)
    Button btn_vie;
    @BindView(R.id.btn_back)
    ImageView btn_back;
    @BindView(R.id.img_background)
    ImageView img_background;

    @Override
    public int setContentViewId() {
        return R.layout.activity_menu_doctruyen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load(R.drawable.bg_congchua5).into(img_background);
        initEvent();
    }

    private void initEvent() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_menu_doctruyen.this);
                finish();
            }
        });
        btn_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_menu_doctruyen.this);
                Intent intent = new Intent(Activity_menu_doctruyen.this, ActivityWebviewReadStory.class);
                intent.putExtra(Constants.KEY_SEND_LANGUAGE, "eng");
                startActivity(intent);
            }
        });
        btn_vie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_menu_doctruyen.this);
                Intent intent = new Intent(Activity_menu_doctruyen.this, ActivityWebviewReadStory.class);
                intent.putExtra(Constants.KEY_SEND_LANGUAGE, "vie");
                startActivity(intent);
            }
        });
    }
}
