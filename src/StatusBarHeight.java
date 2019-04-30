package sun.app.StatusBarHeight;

import android.content.Context;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
 //自定义插件需要继承CordovaPlugin类，并且覆盖execute方法。
public class StatusBarHeight extends CordovaPlugin {

    @Override
    //参数action是用来判断执行哪个方法，args是json格式的参数，callbackContext响应返回结果。
    public boolean execute(String action,  CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

     //私有方法--调用的功能方法
    private void coolMethod(CallbackContext callbackContext) {
        Context context = this.cordova.getActivity().getApplicationContext();
        int height = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            height = context.getResources().getDimensionPixelSize(resourceId);
        }
        callbackContext.success(this.px2dip(height, context));
    }

    private String px2dip(int px, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return (px / density) + "";
    }
}