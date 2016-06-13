package thescone.chainspiritform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CallbackManager callbackManager;

    EditText vendorName;
    EditText vendorIC;
    EditText vendorAddress;
    EditText vendorMobile;
    EditText vendorEmail;
    EditText vendorSignInPlatform;
    Button register_btn;
    LoginButton fbSignIn_btn;
    myDBHandler dbHandler;

    Register register = new Register();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        facebookSDKInitialize();

        setContentView(R.layout.activity_main);

        vendorName = (EditText) findViewById(R.id.vendorName);
        vendorIC = (EditText) findViewById(R.id.vendorIC);
        vendorAddress = (EditText) findViewById(R.id.vendorAddress);
        vendorMobile = (EditText) findViewById(R.id.vendorMobile);
        vendorEmail = (EditText) findViewById(R.id.vendorEmail);
        vendorSignInPlatform = (EditText) findViewById(R.id.vendorSignInPlatform);
        register_btn = (Button) findViewById(R.id.register_btn);
        fbSignIn_btn = (LoginButton) findViewById(R.id.fbSignIn_btn);
        fbSignIn_btn.setReadPermissions("email");
        getLoginDetails(fbSignIn_btn);

        dbHandler = new myDBHandler(this, null, null, 1);

        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(MainActivity.this, "Adding into database...", Toast.LENGTH_SHORT).show();
        register.set_vendorName(vendorName.getText().toString());
        register.set_vendorIC(vendorIC.getText().toString());
        register.set_vendorAddress(vendorAddress.getText().toString());
        register.set_vendorMobile(Long.parseLong(vendorMobile.getText().toString()));
        register.set_vendorEmail(vendorEmail.getText().toString());
        register.set_vendorSignInPlatform(vendorSignInPlatform.getText().toString());
        dbHandler.addRegister(new Register(register.get_vendorName(),
                register.get_vendorIC(),
                register.get_vendorAddress(),
                register.get_vendorMobile(),
                register.get_vendorEmail(),
                register.get_vendorSignInPlatform()
        ));
        Toast.makeText(MainActivity.this, "Register Success", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }

    protected void facebookSDKInitialize() {

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
    }

    protected void getLoginDetails(LoginButton fbSignIn_btn){

        // Callback registration
        fbSignIn_btn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult login_result) {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

            }

            @Override
            public void onCancel() {
                // if cancel
            }

            @Override
            public void onError(FacebookException exception) {
                //  if error
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Log.e("data",data.toString());
    }
}