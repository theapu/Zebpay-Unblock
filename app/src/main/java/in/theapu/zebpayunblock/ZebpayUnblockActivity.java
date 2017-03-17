package in.theapu.zebpayunblock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ZebpayUnblockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zebpay_unblock);
        Toast.makeText(this, "Zebpay unblock xposed module active.",
                Toast.LENGTH_LONG).show();
        finish();
    }
}
