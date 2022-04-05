package com.example.aprende_play;
import java.math.BigDecimal;

import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.paypal.android.sdk.payments.PayPalAuthorization;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalFuturePaymentActivity;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

public class PayPremium extends Activity {

    public static final String TAG = "Payment exmaple";
    public static final String PAYPAL_KEY = "AesEiVBEJvXAbQqVP96sTO9onJJ5qSF5m_tcbmDFVIS6tGb3tBQZqK72P6h5y_wuPKMGuDNuaGHGJEb2";
    private static final int REQUEST_CODE_PAYMENT = 1;
    private static final int REQUEST_CODE_FUTURE_PAYMENT = 2;
    private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_PRODUCTION;
    //PayPalPayment getThingToBuy;
    private static PayPalConfiguration config;
    //= new PayPalConfiguration()


    //.environment(CONFIG_ENVIRONMENT)
    //.clientId(CONFIG_CLIENT_ID)

    // configuracion minima del ente
    //.merchantName("Mi tienda")
    //.merchantPrivacyPolicyUri(
    //      Uri.parse("https://www.mi_tienda.com/privacy"))
    //.merchantUserAgreementUri(
    //      Uri.parse("https://www.mi_tienda.com/legal"));

    PayPalPayment getThingToBuy;
    Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_premium);
order = (Button)findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
           makePago();

            }
        });
        configPaypal();
    }

    private void makePago() {
        Intent intent = new Intent(PayPremium.this,
                PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);

        getThingToBuy= new PayPalPayment(new BigDecimal(String.valueOf("11")), "MXN",
                "premium", PayPalPayment.PAYMENT_INTENT_SALE);
        Intent payment = new Intent(PayPremium.this, PaymentActivity.class);
        payment.putExtra(PaymentActivity.EXTRA_PAYMENT, getThingToBuy);
        payment.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startActivityForResult(payment, REQUEST_CODE_PAYMENT);
    }

    private void configPaypal() {
        config = new PayPalConfiguration()
                .environment(CONFIG_ENVIRONMENT)
                .clientId(PAYPAL_KEY)
                .merchantName("PAYPAL LOGIN")
                .merchantPrivacyPolicyUri(Uri.parse("https://www.mi_tienda.com/privacy"))
                .merchantUserAgreementUri(Uri.parse("https://www.mi_tienda.com/legal"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PAYMENT) {
            if (resultCode == Activity.RESULT_OK){
            PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
            if (confirm != null) {
                try {
                    // informacion extra del pedido
                    System.out.println(confirm.toJSONObject().toString(4));
                    System.out.println(confirm.getPayment().toJSONObject()
                            .toString(4));

                    Toast.makeText(getApplicationContext(), "Orden procesada",
                            Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    Toast.makeText(PayPremium.this, e.toString(), Toast.LENGTH_SHORT).show();

                }
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(PayPremium.this, "cancelado", Toast.LENGTH_SHORT).show();
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
            Toast.makeText(PayPremium.this, "ERROR", Toast.LENGTH_SHORT).show();

        }
    }else if(requestCode == REQUEST_CODE_FUTURE_PAYMENT){
if (resultCode== Activity.RESULT_OK ){
    PayPalAuthorization authorization = data.getParcelableExtra(PayPalFuturePaymentActivity.EXTRA_RESULT_AUTHORIZATION);
    if (authorization != null){
        try {
            Log.i("EJEMPLO JAA",authorization.toJSONObject().toString(4));
            String authorization_code = authorization.getAuthorizationCode();
            Log.d("EXMAPLO2",authorization_code);
    }catch (Exception e){

        }
}
    }
    }
}
}



