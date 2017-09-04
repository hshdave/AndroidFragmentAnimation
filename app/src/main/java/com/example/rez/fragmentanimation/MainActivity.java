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
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);       //Simple Transition choices: Fade, Open, Close
        transaction.replace(R.id.fragContainer, aFragment);
        transaction.commit();
    }

    public void GoToBClicked(View v)
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.slide_left, R.animator.slide_right);
                        //Creating 2 animatiosn using the Animator
                        //We change the property X of both.
                        //First will exit the Fragment A with a slide to Right
                        //Then it will enter the new Fragment with Slide Left
        transaction.replace(R.id.fragContainer, bFragment);
        transaction.commit();
    }
}
