package neo.vn.test365children.Activity.untility_menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.Activity.doctruyen.ActivityWebviewReadStory;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.BuildConfig;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;

public class Activity_Information extends BaseActivity {
    @BindView(R.id.btn_back)
    ImageView btn_back;
    @BindView(R.id.img_bo_cong_thuong)
    ImageView img_bo_cong_thuong;
    @BindView(R.id.txt_policy)
    TextView txt_policy;
    @BindView(R.id.txt_web)
    TextView txt_web;
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.logo_infor)
    ImageView logo_infor;
    @BindView(R.id.txt_version)
    TextView txt_version;

    @Override
    public int setContentViewId() {
        return R.layout.activity_information;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load(R.drawable.bg_select_class).into(img_background);
        Glide.with(this).load(R.drawable.google_play).into(logo_infor);
        txt_version.setText("Phiên bản: " + BuildConfig.VERSION_NAME);
        initEvent();
    }

    private void initEvent() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Information.this);
                finish();
            }
        });
        img_bo_cong_thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Information.this);
                Intent intent = new Intent(
                        Activity_Information.this, ActivityWebviewReadStory.class);
                intent.putExtra(Constants.KEY_SEND_LANGUAGE, "BCT");
                startActivity(intent);
            }
        });
        txt_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Information.this);
                Intent intent = new Intent(
                        Activity_Information.this, ActivityWebviewReadStory.class);
                intent.putExtra(Constants.KEY_SEND_LANGUAGE, "policy");
                startActivity(intent);
            }
        });
        txt_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Information.this);
                Intent intent = new Intent(
                        Activity_Information.this, ActivityWebviewReadStory.class);
                intent.putExtra(Constants.KEY_SEND_LANGUAGE, "web");
                startActivity(intent);
            }
        });
    }
}
