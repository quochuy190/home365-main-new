package neo.vn.test365children.Activity.login.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import neo.vn.test365children.Activity.login.ActivityRegister;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.R;

public class PhoneAuthActivity extends BaseActivity {
    @BindView(R.id.btnGetOtp)
    TextView btnGetOtp;
    private static final String TAG = "PhoneAuthActivity";
    private EditText edtPhone;
    private TextView title;
    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]
    String sPhone = "";
    private Boolean isVerify = false;

    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    public int setContentViewId() {
        return R.layout.activity_otp_firebase;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        edtPhone = findViewById(R.id.edtOtp);
        title = findViewById(R.id.txtInputPhone);
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                Log.d(TAG, "onVerificationCompleted:" + credential.getSmsCode() + credential.zzb());
                hideDialogLoading();
                edtPhone.setText(credential.getSmsCode());
                signInWithPhoneAuthCredential(credential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Log.w(TAG, "onVerificationFailed", e);

                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                }
                hideDialogLoading();
                Toast.makeText(PhoneAuthActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                // Show a message and update the UI
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                mVerificationId = verificationId;
                mResendToken = token;
                hideDialogLoading();

            }
        };
        // [END phone_auth_callbacks]

        btnGetOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogLoading();
                if (!isVerify) {
                    sPhone = edtPhone.getText().toString();
                    if (sPhone.length() > 9) {
                        String phone = "";
                        if (sPhone.substring(0, 1).equals("0")) {
                            phone = "+84" + sPhone.substring(0);
                        } else
                            phone = sPhone;
                        startPhoneNumberVerification(phone);
                        isVerify = !isVerify;
                        edtPhone.setText("");
                        edtPhone.setHint(getString(R.string.input_otp));
                        title.setText(getString(R.string.input_otp_phone) + " " + sPhone);
                    } else
                        showAlertDialog(getString(R.string.error), getString(R.string.error_phone_length));

                } else {
                    String code = edtPhone.getText().toString();
                    verifyPhoneNumberWithCode(mVerificationId, code);
                }

            }
        });
    }

    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    // [END on_start_check_user]


    private void startPhoneNumberVerification(String phoneNumber) {
        // [START start_phone_auth]
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
        // [END start_phone_auth]
    }

    private void verifyPhoneNumberWithCode(String verificationId, String code) {
        // [START verify_with_code]
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                hideDialogLoading();
                Intent intent = new Intent(PhoneAuthActivity.this, ActivityRegister.class);
                intent.putExtra("phone", sPhone);
                startActivity(intent);
                FirebaseUser user = task.getResult().getUser();
            }
        });
        // [END verify_with_code]
    }

    // [START resend_verification]
    private void resendVerificationCode(String phoneNumber,
                                        PhoneAuthProvider.ForceResendingToken token) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .setForceResendingToken(token)     // ForceResendingToken from callbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
    // [END resend_verification]

    // [START sign_in_with_phone]
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");

                            Intent intent = new Intent(PhoneAuthActivity.this, ActivityRegister.class);
                            if (sPhone.indexOf("+84")>-1) {
                                intent.putExtra("phone", sPhone.replace("+84", "0"));
                            } else
                                intent.putExtra("phone", sPhone);
                            startActivity(intent);
                            finish();
                            FirebaseUser user = task.getResult().getUser();
                            // Update UI
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }
    // [END sign_in_with_phone]

    private void updateUI(FirebaseUser user) {

    }
}
