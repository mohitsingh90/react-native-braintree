package com.braintreemodule;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.braintreepayments.api.dropin.DropInActivity;
import com.braintreepayments.api.dropin.DropInResult;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;

public class MainActivity extends ReactActivity {

    private ReactInstanceManager mReactInstanceManager;

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "BraintreeModule";
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("abcd","result");

//        mReactInstanceManager.onActivityResult(requestCode, resultCode, data);
    }

}
