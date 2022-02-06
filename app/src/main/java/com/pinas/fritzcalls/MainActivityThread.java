package com.pinas.fritzcalls;

import android.content.Intent;
import android.os.AsyncTask;

public class MainActivityThread extends AsyncTask<MainActivity, Integer, Boolean> {

    @Override
    protected Boolean doInBackground(MainActivity... mainActivities) {
        CallController.getInstance().getCallList("fx8320xtred");
        boolean isProcessing = true;

        while (isProcessing) {
            if (Globals.getInstance().getCalls().size() > 0) {
                isProcessing = false;
                Intent goToCallList = new Intent(mainActivities[0], CallListActivity.class);
                mainActivities[0].startActivity(goToCallList);
                mainActivities[0].finish();
            }
        }
        return false;
    }
}
