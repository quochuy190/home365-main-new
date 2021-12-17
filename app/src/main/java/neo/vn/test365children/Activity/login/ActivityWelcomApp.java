package neo.vn.test365children.Activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import neo.vn.test365children.Activity.ActivityHome;
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
public class ActivityWelcomApp extends BaseActivity {
    @BindView(R.id.btn_start)
    Button btn_start;
    @BindView(R.id.img_background)
    ImageView img_background;

    @Override
    public int setContentViewId() {
        return R.layout.activity_chaomung;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load(R.drawable.bg_chaomung).into(img_background);
        SharedPrefs.getInstance().put(Constants.KEY_IS_WELCOM_APP, true);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityWelcomApp.this, ActivityHome.class));
                finish();
            }
        });
    }
}
