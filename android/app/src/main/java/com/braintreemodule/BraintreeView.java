package com.braintreemodule;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.braintreepayments.api.dropin.DropInActivity;
import com.braintreepayments.api.dropin.DropInRequest;
import com.braintreepayments.api.dropin.DropInResult;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class BraintreeView extends ReactContextBaseJavaModule {
    public  static  String result = "";
    static Callback successCallback;
    static String clientToken;
    ReactApplicationContext reactContext;


    public BraintreeView(ReactApplicationContext reactContext)
    {
        super(reactContext);
        this.reactContext = reactContext;
        //this.reactContext.addActivityEventListener(this);
    }

    /*@ReactMethod
    public void getResult(Callback successCallback){
        successCallback.invoke(null, result);

    }
*/
    @ReactMethod
    public void showBraintreeDropin(String clientToken, final Callback successCallback){


        /*DropInRequest dropInRequest = new DropInRequest().clientToken(clientToken);
        BraintreeDropinView.successCallback = successCallback;
        Intent intent = dropInRequest.getIntent(getCurrentActivity());
        getCurrentActivity().startActivityForResult(intent, Activity.RESULT_OK);*/

        BraintreeView.successCallback = successCallback;
        Intent intent = new Intent(reactContext,BraintreeDropinView.class);
        intent.putExtra("clientToken",clientToken);
        reactContext.startActivity(intent);

    }

    @Override
    public String getName() {
        return "BraintreeView";
    }


    /*@Override
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            DropInResult result = data.getParcelableExtra(DropInResult.EXTRA_DROP_IN_RESULT);
            Log.d("msgNonce", result.getPaymentMethodNonce().getNonce());
            BraintreeView.successCallback.invoke(null,result.getPaymentMethodNonce().getNonce());

        } else if (resultCode == Activity.RESULT_CANCELED) {
            // the user canceled
            Log.d("mylog", "user canceled");
        } else {
            // handle errors here, an exception may be available in
            Exception error = (Exception) data.getSerializableExtra(DropInActivity.EXTRA_ERROR);
            Log.d("mylog", "Error : " + error.toString());
        }
    }

    @Override
    public void onNewIntent(Intent intent) {

    }*/
}
