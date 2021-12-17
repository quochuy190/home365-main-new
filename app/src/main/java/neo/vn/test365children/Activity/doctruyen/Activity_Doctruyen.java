package neo.vn.test365children.Activity.doctruyen;

import android.os.Bundle;
import android.webkit.WebView;

import butterknife.BindView;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.R;

public class Activity_Doctruyen extends BaseActivity {
    @BindView(R.id.webview_doctruyen)
    WebView webview_doctruyen;
    @Override
    public int setContentViewId() {
        return R.layout.activity_webview_doctruyen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWebview();
    }

    private void initWebview() {

    }
}
