package com.example.dailyexpenses.helpers

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionHelper {
    companion object {
        @JvmStatic
        fun requestPermissions(activity: Activity) {

            // Check if we have write permission
            try{
                val requestCode = 2
                val reqPermissions = arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA
                )
                // fine location permission
                val permissionCheckFineLocation =
                    ContextCompat.checkSelfPermission(activity, reqPermissions[0]) ==
                            PackageManager.PERMISSION_GRANTED
                // coarse location permission
                val permissionCheckCoarseLocation =
                    ContextCompat.checkSelfPermission(activity, reqPermissions[1]) ==
                            PackageManager.PERMISSION_GRANTED
                if (!(permissionCheckFineLocation && permissionCheckCoarseLocation)) { // if permissions are not already granted, request permission from the user
                    ActivityCompat.requestPermissions(activity, reqPermissions, requestCode)
                } else {
                    Toast.makeText(activity, "izin alınamadı", Toast.LENGTH_LONG).show()

                    // update UI to reflect that the location display did not actually start
                    // spinner.setSelection(0, true)
                }

            } catch(ex:Exception){
                ex.printStackTrace()
            }
        }
    }
}