package neo.vn.test365children.Activity.doctruyen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import androidx.core.widget.NestedScrollView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.net.ssl.TrustManagerFactory;

import butterknife.BindView;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ClickDialog;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;

public class ActivityWebviewReadStory extends BaseActivity {
    private static final String TAG = "Activity_webview_doctru";
    @BindView(R.id.btn_back)
    ImageView btn_back;
    @BindView(R.id.btn_home)
    ImageView btn_home;
    @BindView(R.id.webview_doctruyen)
    WebView webView;
    @BindView(R.id.txt_url)
    TextView txt_url;
    @BindView(R.id.view_scroll)
    NestedScrollView view_scroll;
    private String sLanguage;
    private String sUrlEng = "https://doctruyen.home365.online/en/";
    private String sUrlVie = "https://doctruyen.home365.online/vn/";
    private String sUrlGift = "https://vuonqua.home365.online/";
    //private String sUrlBCT = "http://online.gov.vn/HomePage/CustomAppDisplay.aspx?DocId=488";
    private String sUrlBCT = "http://online.gov.vn/Home/WebDetails/88671";
    private String sUrl_policy = "https://home365.online/dieu-khoan/";
    private String sUrl_web = "https://home365.online/";
    String sUserMother, sUserChil, sPass, sUrl;
    String googleDocs = "https://docs.google.com/viewer?url=";

    @Override
    public int setContentViewId() {
        return R.layout.activity_webview_story;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initEvent();
        initWebview();
    }

    private void visible_url() {
        Animation animationRotale = AnimationUtils.loadAnimation(this, R.anim.show_url_web);
        txt_url.startAnimation(animationRotale);
    }

    private void gone_url() {
        Animation animationRotale = AnimationUtils.loadAnimation(this, R.anim.gone_url_web);
        txt_url.startAnimation(animationRotale);
    }


    private void initData() {
        sUserMother = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        sUserChil = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        sPass = SharedPrefs.getInstance().get(Constants.KEY_PASSWORD, String.class);
        sUrl = getIntent().getStringExtra(Constants.KEY_SEND_URL_WEBVIEW);

    }

    private void initWebview() {
        showDialogLoading();
        sLanguage = getIntent().getStringExtra(Constants.KEY_SEND_LANGUAGE);

        if (sLanguage != null) {
      /*      if (sLanguage.equals("Gift") || sLanguage.equals("review_video")) {
                txt_url.setVisibility(View.GONE);
            } else {
                txt_url.setVisibility(View.VISIBLE);
            }*/
            if (sLanguage.equals("eng")) {
                txt_url.setText("READ STORY");
                goUrl(sUrlEng);
            } else if (sLanguage.equals("vie")) {
                txt_url.setText("ĐỌC TRUYỆN");
                goUrl(sUrlVie);
            } else if (sLanguage.equals("Gift")) {
                txt_url.setText("VƯỜN QUÀ");
                sUrlGift = sUrlGift + "?mother=" + sUserMother + "&child=" + sUserChil + "&password=" + sPass;
                goUrl(sUrlGift);
            } else if (sLanguage.equals("BCT")) {
                txt_url.setText("BỘ CÔNG THƯƠNG");
                // sUrlGift = sUrlGift + "?mother=" + sUserMother + "&child=" + sUserChil + "&password=" + sPass;
                goUrl(sUrlBCT);
            } else if (sLanguage.equals("policy")) {
                txt_url.setText("CHÍNH SÁCH BẢO MẬT");
                // sUrlGift = sUrlGift + "?mother=" + sUserMother + "&child=" + sUserChil + "&password=" + sPass;
                goUrl(sUrl_policy);
            } else if (sLanguage.equals("web")) {
                txt_url.setText("HOME 365");
                // sUrlGift = sUrlGift + "?mother=" + sUserMother + "&child=" + sUserChil + "&password=" + sPass;
                goUrl(sUrl_web);
            } else if (sLanguage.equals("review_video")) {
                if (sUrl != null)
                    goUrl(sUrl);
            } else if (sLanguage.equals("share_exer")) {
                btn_home.setImageResource(R.drawable.icon_printer);
                txt_url.setText("HOME 365");
                if (sUrl != null)
                    goUrl(googleDocs + sUrl);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: webivew");
    }

    private void initEvent() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                    // txt_url.setText(webView.getUrl());
                } else {
                    KeyboardUtil.play_click_button(ActivityWebviewReadStory.this);
                    showDialogComfirm("Thông báo", "Bạn có chắc chắn muốn thoát khỏi trang", true, new ClickDialog() {
                        @Override
                        public void onClickYesDialog() {
                            KeyboardUtil.play_click_button(ActivityWebviewReadStory.this);
                            finish();
                        }

                        @Override
                        public void onClickNoDialog() {

                        }
                    });
                }
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityWebviewReadStory.this);
                if (sLanguage.equals("share_exer")) {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = sUrl;
                    String shareSub = "Home365";
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(sharingIntent, "Home365"));
                  /*  download_pdf();
                    printOrCreatePdfFromWebview();*/
                } else {
                    showDialogComfirm("Thông báo",
                            "Bạn có chắc chắn muốn thoát khỏi trang",
                            true, new ClickDialog() {
                                @Override
                                public void onClickYesDialog() {
                                    KeyboardUtil.play_click_button(ActivityWebviewReadStory.this);
                                    finish();
                                }

                                @Override
                                public void onClickNoDialog() {

                                }
                            });
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
            //  txt_url.setText(webView.getUrl());
        } else {
            showDialogComfirm("Thông báo", "Bạn có chắc chắn muốn thoát khỏi trang",
                    true, new ClickDialog() {
                        @Override
                        public void onClickYesDialog() {
                            finish();
                        }

                        @Override
                        public void onClickNoDialog() {
                        }
                    });
        }
    }

    private void goUrl(String url) {
        if (url.isEmpty()) {
            Toast.makeText(this, "Please enter url", Toast.LENGTH_SHORT).show();
            return;
        }
        webView.setWebViewClient(new Browser_home());
        webView.setWebChromeClient(new MyChrome());
        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.clearSslPreferences();
        webView.clearFormData();
        webView.clearCache(true);
        webView.clearHistory();
        webView.clearMatches();
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
        webSettings.setDefaultFontSize(18);
        webSettings.setTextZoom((int) (webSettings.getTextZoom() * 1.1));
        webSettings.setBuiltInZoomControls(true);
        webSettings.setAllowFileAccess(true);
        //webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webView.requestFocusFromTouch();
        webView.loadUrl(url);
    }

    TrustManagerFactory tmf = null;

    private class CheckServerTrustedWebViewClient extends WebViewClient {

    }

    class Browser_home extends WebViewClient {
        Browser_home() {
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.e(TAG, "onPageStarted: start loading");
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (request.hasGesture()) {
                    showDialogLoading();
                }
            }
            Log.e(TAG, "shouldOverrideUrlLoading: loading");
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // setTitle(view.getTitle());
            Log.e(TAG, "onPageFinished: " + url);
            hideDialogLoading();
            view_scroll.scrollTo(0, 0);
            view_scroll.fullScroll(View.FOCUS_UP);
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Log.e(TAG, "onReceivedError: ");
            super.onReceivedError(view, request, error);
        }

    }

    private class MyChrome extends WebChromeClient {
        private View mCustomView;
        private CustomViewCallback mCustomViewCallback;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        MyChrome() {
        }

        public Bitmap getDefaultVideoPoster() {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView() {
            ((FrameLayout) getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, CustomViewCallback paramCustomViewCallback) {
            if (this.mCustomView != null) {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout) getWindow().getDecorView()).addView(this.mCustomView,
                    new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }
}
