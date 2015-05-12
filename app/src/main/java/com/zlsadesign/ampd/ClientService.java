package com.zlsadesign.ampd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ClientService extends Service {
  public ClientService() {
  }

  @Override
  public IBinder onBind(Intent intent) {
    throw new UnsupportedOperationException("Not yet implemented");
  }
}
