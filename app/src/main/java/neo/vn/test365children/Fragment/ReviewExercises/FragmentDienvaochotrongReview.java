package neo.vn.test365children.Fragment.ReviewExercises;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseFragment;
import neo.vn.test365children.Models.CauhoiDetail;
import neo.vn.test365children.R;


/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 8/6/2018
 * @updated 8/6/2018
 * @modified by
 * @updated on 8/6/2018
 * @since 1.0
 */
public class FragmentDienvaochotrongReview extends BaseFragment {
    private static final String TAG = "FragmentDienvaochotrong";
    private CauhoiDetail mCauhoi;
    @BindView(R.id.webview_dienchotrong)
    public WebView browser;
    @BindView(R.id.webview_dapan)
    public WebView webview_dapan;
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.txt_lable)
    TextView txt_lable;
    @BindView(R.id.img_anwser_chil)
    ImageView img_anwser_chil;
    @BindView(R.id.btn_xemdiem_dientu)
    Button btn_xemdiem;
    @BindView(R.id.img_reload)
    ImageView img_reload;

    public static FragmentDienvaochotrongReview newInstance(CauhoiDetail restaurant) {
        FragmentDienvaochotrongReview restaurantDetailFragment = new FragmentDienvaochotrongReview();
        Bundle args = new Bundle();
        //args.putSerializable("cauhoi",restaurant);
        args.putParcelable("cauhoi", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCauhoi = Parcels.unwrap(getArguments().getParcelable("cauhoi"));

    }

    private void reload() {
        browser.reload();
        webview_dapan.reload();
        browser.setWebViewClient(new WebViewClient());
        webview_dapan.setWebViewClient(new WebViewClient());
    }

    private void initEvent() {
        img_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reload();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    String sHtml;
    String sHtml_anwser_true;

    @SuppressLint("JavascriptInterface")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dienvaochotrong, container, false);
        ButterKnife.bind(this, view);
        initEvent();
        btn_xemdiem.setVisibility(View.GONE);

        if (mCauhoi.getsNumberDe() != null && mCauhoi.getsCauhoi_huongdan() != null)
            txt_lable.setText(("Bài " + mCauhoi.getsNumberDe() + "_Câu "
                    + mCauhoi.getsSubNumberCau() + ": " + mCauhoi.getsCauhoi_huongdan())
                    + " (" + Float.parseFloat(mCauhoi.getsPOINT()) + " đ)");

        Glide.with(this).load(R.drawable.bg_nghe_nhin).into(img_background);
        //  browser.setInitialScale(220);
        //   webview_dapan.setInitialScale(220);
        WebSettings webSettings = browser.getSettings();
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
        webSettings.setDefaultFontSize(17);
        WebSettings webSettings2 = webview_dapan.getSettings();
        webSettings2.setTextSize(WebSettings.TextSize.NORMAL);
        webSettings2.setDefaultFontSize(17);
        browser.setWebChromeClient(new WebChromeClient());
        browser.clearCache(true);
        browser.clearFormData();
        browser.clearHistory();
        webview_dapan.clearCache(true);
        webview_dapan.clearFormData();
        webview_dapan.clearHistory();
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings();
        browser.setBackgroundColor(Color.TRANSPARENT);
        browser.getSettings().setJavaScriptEnabled(true);
        webview_dapan.setBackgroundColor(Color.TRANSPARENT);
        WebSettings settings = browser.getSettings();
        WebSettings settings_dapan = webview_dapan.getSettings();
        settings.setTextZoom((int) (settings.getTextZoom() * 1.2));
        settings_dapan.setTextZoom((int) (settings.getTextZoom() * 1.2));
        String sHtml_dapan;
        sHtml_anwser_true = mCauhoi.getsHTML_CONTENT().replaceAll("<<<>>",
                "<< < >>");
        sHtml_anwser_true = mCauhoi.getsHTML_CONTENT().replaceAll(">>>",
                " > >>");
        Log.i(TAG, "onCreateView: " + sHtml_anwser_true);
        sHtml_dapan = "<br /> <div  style='text-align:center;'>" +
                "<b>Đáp án </b></div><br />" +
                sHtml_anwser_true.replaceAll("<<", "<u><b><font color='blue'>")
                        .replaceAll(">>", "</font>" + "</b></u>");
        webview_dapan.loadDataWithBaseURL("", sHtml_dapan, "text/html",
                "UTF-8", "");
        webview_dapan.setVisibility(View.VISIBLE);
        img_anwser_chil.setVisibility(View.VISIBLE);
        if (mCauhoi.getsRESULT_CHILD() != null && mCauhoi.getsANSWER_CHILD().length() > 0) {
            sHtml = replaceXML("<<",
                    ">>", mCauhoi.getsANSWER_CHILD());
            if (mCauhoi.getsRESULT_CHILD().equals("1")) {
                img_anwser_chil.setImageResource(R.drawable.icon_anwser_true);
            } else
                img_anwser_chil.setImageResource(R.drawable.icon_anwser_false);
            browser.loadDataWithBaseURL("", sHtml, "text/html", "UTF-8", "");
        } else {
            img_anwser_chil.setImageResource(R.drawable.icon_anwser_unknow);
        }

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        webview_dapan.clearHistory();
        webview_dapan.clearFormData();
        webview_dapan.clearCache(true);

        browser.clearHistory();
        browser.clearFormData();
        browser.clearCache(true);
    }

    public String replaceStringBuffer(int first, int last, String st, int index, int leght) {
        String s = "";
        StringBuffer sbf = new StringBuffer(st);
        s = String.valueOf(sbf.replace(first, last, "<u><b><font color='red'>__</font></b></u>"));
        // s = String.valueOf(sbf.replace(first, last, "<img src=\"http://content1.test365.vn//upload//image/toan//tamgiacvuong.PNG\" style=\"height:10%; width:10%;\">"));
        return s;
    }

    public List<String> sAnwser_true = new ArrayList<>();

    public String replaceXML(String start, String end, String st) {
        String s = st;
        if (s.length() == 0)
            return s;
        int index = s.indexOf(start);
        // int index_end = st.indexOf(end);
        int matchLength = start.length();
        int iCount = 1;
        while (index >= 0) {  // indexOf returns -1 if no match found
            int leght = 0;
            int startIndex = s.indexOf(start, index);
            int endIndex = s.indexOf(end, index + matchLength);
            //   System.out.println(s.substring(startIndex + 1, endIndex));
            if (startIndex > -1 && startIndex < endIndex) {
                String sAnwser = s.substring(startIndex + 2, endIndex);
                leght = sAnwser.length();
                sAnwser_true.add(sAnwser);
                s = replaceStringBuffer((startIndex), endIndex + 2, s, iCount, leght);
            }
            index = s.indexOf(start, index + matchLength);
            iCount++;
        }
        Log.i(TAG, "sAnwser_true size: " + sAnwser_true.size());
        //  s.replaceAll("<<", "");
        return s;
    }

    public String replaceAnwserChil(String start, String end, String st, int position) {
        String s = st;
        if (s.length() == 0)
            return s;
        int index = s.indexOf(start);
        // int index_end = st.indexOf(end);
        int matchLength = start.length();
        int iCount = 1;
        while (index >= 0) {  // indexOf returns -1 if no match found
            int leght = 0;
            int startIndex = s.indexOf(start, index);
            int endIndex = s.indexOf(end, index + matchLength);
            //   System.out.println(s.substring(startIndex + 1, endIndex));
            if (startIndex > -1 && startIndex < endIndex && iCount == position) {
                String sAnwser = s.substring(startIndex + 2, endIndex);
                s = replaceStringBuffer_position((startIndex), endIndex + 2, s, iCount, position);
            }
            index = s.indexOf(start, index + matchLength);
            iCount++;
        }
        Log.i(TAG, "sAnwser_true size: " + sAnwser_true.size());
        //  s.replaceAll("<<", "");
        return s;
    }

    public String replaceStringBuffer_position(int first, int last, String st, int index, int position) {
        String s = "";
        StringBuffer sbf = new StringBuffer(st);
        List<String> mLisAnwser = new ArrayList<>();
        mLisAnwser.add(App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).getsAnwserChil_Dientu_1());
        mLisAnwser.add(App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).getsAnwserChil_Dientu_2());
        mLisAnwser.add(App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).getsAnwserChil_Dientu_3());
        mLisAnwser.add(App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).getsAnwserChil_Dientu_4());
        mLisAnwser.add(App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).getsAnwserChil_Dientu_5());
        mLisAnwser.add(App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).getsAnwserChil_Dientu_6());
        mLisAnwser.add(App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).getsAnwserChil_Dientu_7());
        mLisAnwser.add(App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).getsAnwserChil_Dientu_8());
        mLisAnwser.add(App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).getsAnwserChil_Dientu_9());
        mLisAnwser.add(App.mLisCauhoi.get(Integer.parseInt(mCauhoi.getsNumberDe()) - 1).getLisInfo()
                .get(Integer.parseInt(mCauhoi.getsSubNumberCau()) - 1).getsAnwserChil_Dientu_10());
        if (mLisAnwser.get((position - 1)) != null && mLisAnwser.get((position - 1)).length() > 0) {
            String sContent = mLisAnwser.get((position - 1));
            s = String.valueOf(sbf.replace(first, last, "<u><b><font color='red'>" + sContent + "</font></b></u>"));
        }
        // s = String.valueOf(sbf.replace(first, last, "<img src=\"http://content1.test365.vn//upload//image/toan//tamgiacvuong.PNG\" style=\"height:10%; width:10%;\">"));
        return s;
    }

    public String replaceXML_start_anwser(String start, String end, String st) {
        String s = st;
        if (s.length() == 0)
            return s;
        int index = s.indexOf(start);
        // int index_end = st.indexOf(end);
        int matchLength = start.length();
        int iCount = 1;
        while (index >= 0) {  // indexOf returns -1 if no match found
            int leght = 0;
            int startIndex = s.indexOf(start, index);
            int endIndex = s.indexOf(end, index + matchLength);
            //   System.out.println(s.substring(startIndex + 1, endIndex));
            if (startIndex > -1 && startIndex < endIndex) {
                String sAnwser = s.substring(startIndex + 2, endIndex);
                leght = sAnwser.length();
                s = replaceStringBuffer_start_anwser((startIndex), endIndex + 2, s, iCount, leght);
            }
            index = s.indexOf(start, index + matchLength);
            iCount++;
        }
        return s;
    }

    public String replaceStringBuffer_start_anwser(int first, int last, String st, int index, int leght) {
        String s = "";
        StringBuffer sbf = new StringBuffer(st);
        s = String.valueOf(sbf.replace(first, last, "<< >>"));
        // s = String.valueOf(sbf.replace(first, last, "<img src=\"http://content1.test365.vn//upload//image/toan//tamgiacvuong.PNG\" style=\"height:10%; width:10%;\">"));
        return s;
    }
}
