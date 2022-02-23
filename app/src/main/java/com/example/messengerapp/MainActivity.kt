package com.example.messengerapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.messengerapp.Fragments.ChatFragment
import com.example.messengerapp.Fragments.SearchFragment
import com.example.messengerapp.Fragments.SettingsFragment
import com.example.messengerapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val viewPagerAdapter = viewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(ChatFragment(),"chat")
        viewPagerAdapter.addFragment(SearchFragment(),"Search")
        viewPagerAdapter.addFragment(SettingsFragment(),"Settings")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setSupportActionBar(toolbarMain: Toolbar) {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    internal class  viewPagerAdapter(fragmentManager: FragmentManager):
            FragmentPagerAdapter(fragmentManager)
    {
        private val fragments: ArrayList<Fragment>
        private val titles: ArrayList<String>

        init {
            fragments= ArrayList<Fragment>()
            titles = ArrayList<String>()
        }
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }
        override fun getCount(): Int {
            return fragments.size
        }


        fun addFragment(fragment: Fragment, title: String)
        {
            fragments.add(fragment)
            titles.add(title)
        }

        override fun getPageTitle(i: Int): CharSequence {
            return titles[i]
        }

        fun addFragment(fragment: ChatFragment,title: String) {

        }

        fun addFragment(settingsFragment: SettingsFragment,s: String) {

        }

        fun addFragment(searchFragment: SearchFragment,s: String) {

        }


    }

}