package in.theapu.zebpayunblock;

/**
 * Created by APU V on 17-03-2017.
 */

import android.app.AndroidAppHelper;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import de.robv.android.xposed.XC_MethodReplacement;


public class ZebpayUnblocker implements IXposedHookLoadPackage {

    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("zebpay.Application"))
            return;
        findAndHookMethod("zebpay.Application.SplashActivity", lpparam.classLoader, "a", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                boolean bl = (boolean) callMethod(param.thisObject, "b");
                if (bl) {
                    String warning = "App has been hooked by third party app, but ignoring it using Zebpay Unblock.";
                    Context context = AndroidAppHelper.currentApplication();
                    Toast toast = Toast.makeText(context, warning, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                return null;
            }
        });
    }
}

