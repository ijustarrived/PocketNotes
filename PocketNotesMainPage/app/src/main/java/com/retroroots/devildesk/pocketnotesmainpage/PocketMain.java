package com.retroroots.devildesk.pocketnotesmainpage;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TabHost;


public class PocketMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pocket_main);

        if (savedInstanceState == null)
        {
            FragmentManager fragMan = getFragmentManager();

            FragmentTransaction fragTrans = fragMan.beginTransaction();

            MainScreenFragment mainScrnFrag = new MainScreenFragment();

            fragTrans.add(R.id.container, mainScrnFrag,"mainFrag");

            fragTrans.commit();

            TabHost tab = (TabHost)findViewById(R.id.tabHost);

            tab.setup();

            TabHost.TabSpec taskTab = tab.newTabSpec("tasks");

            taskTab.setContent(R.id.Create);

            taskTab.setIndicator("Tasks");

            tab.addTab(taskTab);

            TabHost.TabSpec createTab = tab.newTabSpec("create");

            createTab.setContent(R.id.Create);

            createTab.setIndicator("Create");

            tab.addTab(createTab);


            TabHost.TabSpec reminderTab = tab.newTabSpec("reminder");

            reminderTab.setContent(R.id.Create);

            reminderTab.setIndicator("Reminder");

            tab.addTab(reminderTab);


            /*
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MainScreenFragment())
                    .commit();
                    */
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pocket_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    /*
    public static class PlaceholderFragment extends Fragment
    {

        public PlaceholderFragment()
        {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState)
        {
            View rootView = inflater.inflate(R.layout.fragment_pocket_main, container, false);
            return rootView;
        }
    }
    */
}
