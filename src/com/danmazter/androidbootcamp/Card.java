package com.danmazter.androidbootcamp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: Danmazter
 * Date: 11/18/12
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Card extends Activity{

    protected void onCreate(Bundle danmazterInstance)
    {
        super.onCreate(danmazterInstance);
        setContentView(R.layout.card);
        Thread timer  = new Thread(){
            public void run()
            {
              try{
                    sleep(2000);
              }
              catch (InterruptedException ex)
              {
                  ex.printStackTrace();
              }
                finally {
                  Intent intent = new Intent (Card.this, Menu.class);
                    startActivity(intent);
              }

            }
        };
        timer.start();

    }

}
