package neo.vn.test365children.Activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.Activity.ActivityMenuBaitap;
import neo.vn.test365children.Activity.skill.Activity_Menu_Skill;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.SharedPrefs;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 15-May-2019
 * Time: 15:09
 * Version: 1.0
 */
public class ActivityGuildPractice extends BaseActivity {
    @BindView(R.id.btn_start)
    Button btn_start;
    String sOption;
    @BindView(R.id.txt_title_guild)
    TextView txt_title_guild;
    @BindView(R.id.txt_guild_content)
    TextView txt_guild_content;
    @BindView(R.id.img_broad_guild)
    ImageView img_broad_guild;

    @Override
    public int setContentViewId() {
        return R.layout.activity_guild_function;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load(R.drawable.icon_bang).into(img_broad_guild);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sOption != null && sOption.equals(Constants.KEY_VALUE_GUIL_PRACTICE))
                    startActivity(new Intent(ActivityGuildPractice.this, ActivityMenuBaitap.class));
                else if (sOption != null && sOption.equals(Constants.KEY_VALUE_GUIL_SKILL))
                    startActivity(new Intent(ActivityGuildPractice.this, Activity_Menu_Skill.class));
                finish();
            }
        });
        initData();
    }

    private void initData() {
        sOption = getIntent().getStringExtra(Constants.KEY_SEND_OPTION_GUILD);
        if (sOption.equals(Constants.KEY_VALUE_GUIL_PRACTICE)) {
            SharedPrefs.getInstance().put(Constants.KEY_IS_START_PRACTICE, true);
            txt_title_guild.setText("LUYỆN TẬP");
            txt_guild_content.setText(R.string.txt_guild_practice);
        } else if (sOption.equals(Constants.KEY_VALUE_GUIL_SKILL)) {
            SharedPrefs.getInstance().put(Constants.KEY_IS_START_SKILL, true);
            txt_title_guild.setText("KHOÁ HỌC KỸ NĂNG");
            txt_guild_content.setText(R.string.txt_guild_skill);
        }
    }
}
