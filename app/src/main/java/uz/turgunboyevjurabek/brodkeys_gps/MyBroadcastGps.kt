package uz.turgunboyevjurabek.brodkeys_gps

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.util.Log
import android.widget.Toast

private const val TAG = "MyBroadcastGps"
class MyBroadcastGps : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG,"onReceive : Boshlandi")

        if(LocationManager.PROVIDERS_CHANGED_ACTION.equals(intent.action)){
            val locationManager=context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

            val isGpsEnabled=locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

            val isNetworkEnabled=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            if (isGpsEnabled || isNetworkEnabled){
                Toast.makeText(context, "gps yoniq", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "onReceive: gps yondi")
            }else{
                Toast.makeText(context, "gps o'chiq", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "onReceive: gps o'chdi")
            }


        }
    }

}