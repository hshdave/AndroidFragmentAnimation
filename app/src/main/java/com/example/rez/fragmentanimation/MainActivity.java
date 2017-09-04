package com.example.rez.fragmentanimation;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AFragment aFragment;
    BFragment bFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aFragment = new AFragment();
        bFragment = new BFragment();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.fragContainer, aFragment);
        transaction.commit();
    }

    public void GoToAClicked(View v)
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragContainer, aFragment);
        transaction.commit();
    }

    public void GoToBClicked(View v)
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragContainer, bFragment);
        transaction.commit();
    }
}
