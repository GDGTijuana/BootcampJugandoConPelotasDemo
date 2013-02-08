package com.danmazter.androidbootcamp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.Toast;

public class GameActivity extends Activity implements OnTouchListener {
    /**
     * Called when the activity is first created.
     */
    FrameLayout frmLayout;
    Toast toast;
    PowerManager.WakeLock wakeLock;
    float tamXPantalla, tamYPantalla;
    final float XLIMIT=1140; //el real es 1196
    final float YLIMIT = 700; //el real es 720
    float xNearLimit, yNearLimit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        frmLayout = (FrameLayout)findViewById(R.id.main_view);
        Pelota ball = new Pelota(GameActivity.this, 0, 710, 25);
        frmLayout.addView(ball);
        frmLayout.setOnTouchListener(this);

        tamXPantalla = getWindowManager().getDefaultDisplay().getWidth();
        tamYPantalla = getWindowManager().getDefaultDisplay().getHeight();
        xNearLimit = (tamXPantalla - 150);   //990
        yNearLimit = (tamYPantalla - 150);   //570

        //el permiso para evitar el lock...
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK,"WLGame");
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                frmLayout = (FrameLayout) view; //el frameactual...
                frmLayout.removeAllViews();
                frmLayout.addView(new Pelota(GameActivity.this,touchX,touchY,25));


                if((touchX >= xNearLimit && touchX<XLIMIT) || (touchY >= yNearLimit && touchY <YLIMIT))
                {
                    imprimeMensaje(touchX,touchY,"Vas a Perder...");
                }
                else if((touchX>=(tamXPantalla-50)) || (touchY >= (tamYPantalla-50)))
                {
                    imprimeMensaje(touchX, touchY, "Te lo dije, ya perdiste guey...");
                }


                break;
            case MotionEvent.ACTION_UP:
                frmLayout = (FrameLayout) view; //el frameactual...
                frmLayout.removeAllViews();
                frmLayout.addView(new Pelota(GameActivity.this,0 ,0, 25));
               // toast.cancel();
                break;

        }
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void imprimeMensaje(float x, float y, String mensaje)
    {
        toast = Toast.makeText(GameActivity.this,mensaje+ " [" + x+" ,"+y+" ]",Toast.LENGTH_SHORT );
        toast.show();
    }
}
