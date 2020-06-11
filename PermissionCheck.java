package project.dawon.permissioncheck;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionCheck {

    private Activity activity;

    PermissionCheck(Activity activity) {
        this.activity = activity;
    }

    private List<String> permissionDeniedList;

    public void check(List<String> permission) {
        permissionDeniedList = new ArrayList<String>();
        for(String p : permission) {
            if (ContextCompat.checkSelfPermission(activity, p) != PackageManager.PERMISSION_GRANTED) {
                permissionDeniedList.add(p);
            }
        }

        permissionGranted();
    }

    private void permissionGranted() {
        if(permissionDeniedList.size() > 0) {
            String[] permission = permissionDeniedList.toArray(new String[permissionDeniedList.size()]);
            System.err.println(permission);
            System.err.println(permissionDeniedList);
            ActivityCompat.requestPermissions(activity, permission, 100);
        } else {
            //permission이 전부 Granted임.
        }
    }
}
