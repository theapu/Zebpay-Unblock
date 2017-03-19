package in.theapu.zebpayunblock;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ZebpayUnblockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zebpay_unblock);
        Toast.makeText(this, "Zebpay unblock xposed module active. Launcher icon will be removed.",
                Toast.LENGTH_LONG).show();
        PackageManager p = getPackageManager();
        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        // activity which is first time open in manifiest file which is declare as
        // <category android:name="android.intent.category.LAUNCHER" />
        finish();
    }

}
