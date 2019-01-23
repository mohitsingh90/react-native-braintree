package com.braintreemodule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.braintreepayments.api.dropin.DropInActivity;
import com.braintreepayments.api.dropin.DropInRequest;
import com.braintreepayments.api.dropin.DropInResult;
import com.facebook.react.bridge.Callback;

import java.util.Objects;

public class BraintreeDropinView extends AppCompatActivity {

    int REQUEST_CODE = 404;
    static Callback successCallback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DropInRequest dropInRequest = new DropInRequest().clientToken(BraintreeView.clientToken);
        startActivityForResult(dropInRequest.getIntent(this), REQUEST_CODE);
    }

     public void onBraintreeSubmit( String clientToken,Callback successCallback) {
        DropInRequest dropInRequest = new DropInRequest().clientToken(clientToken);
        BraintreeDropinView.successCallback = successCallback;
        startActivityForResult(dropInRequest.getIntent(this), REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
}
