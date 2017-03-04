package company.com.basicwork;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;


/**
 * Created by CW on 07/02/2017.
 */

class ServiceEx extends Service {

    MediaPlayer player;

    void lunchToast() {

        player = MediaPlayer.create(this, R.raw.chandelier);
        player.setLooping(false);
        player.start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        lunchToast();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        player.stop();
        super.onDestroy();
    }
}
