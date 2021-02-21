package cordova.plugin.mathcalculator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.util.Log;

/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {

private static final String TAG = "<------- ZoomIonicAngularPlugin ---------->";
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException 
    {
        if(action.equals("add"))
        {
            this.add(args,callbackContext);
            Log.v(TAG, "add................................");
			Log.d(TAG, "add................................");
            return true;
        }else if(action.equals("subtract"))
        {
            Log.v(TAG, "subtract................................");
			Log.d(TAG, "subtract................................");
            this.subtract(args,callbackContext);
            return true;
        }

        return false;
    }

    private void add(JSONArray args, CallbackContext callback) 
    {
        if(args  != null)
        {
            try
            {
                int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));

                            Log.v(TAG, "addf................................");
			Log.d(TAG, "addf................................");

                callback.success("" + (p1+p2) );

            }catch(Exception ex)
            {
                callback.error("Something went  wrong" + ex);
            }
        }
        else
        {
            callback.error("Please dont pass  null value");
        }
    }

    private void subtract(JSONArray args, CallbackContext callback) 
    {
        if(args  != null)
        {
            try
            {
                int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));

                callback.success("" + (p1-p2) );

            }catch(Exception ex)
            {
                callback.error("Something went  wrong" + ex);
            }
        }
        else
        {
            callback.error("Please dont pass  null value");
        }

    }

}
