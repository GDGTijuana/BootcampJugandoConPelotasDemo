package com.danmazter.androidbootcamp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: Danmazter
 * Date: 11/23/12
 * Time: 9:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class Menu extends Activity implements OnClickListener {

    Button btnNew, btnAbout, btnClose;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        btnNew = (Button) findViewById(R.id.btnNew);
        btnClose = (Button)findViewById(R.id.btnExit);
        btnAbout = (Button)findViewById(R.id.btnAbout);

        btnNew.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        btnAbout.setOnClickListener(this);

    }
    @Override
    public void onClick(View btnEvent)
    {
        switch (btnEvent.getId())
        {
            case R.id.btnNew:
                Intent intentNew = new Intent(Menu.this, GameActivity.class);
                startActivity(intentNew);
                break;

            case R.id.btnAbout:
                Intent intentAbout = new Intent(Menu.this, About.class);
                startActivity(intentAbout);
                break;
            case R.id.btnExit:
                finish();
                break;

        }
    }
}