package com.example.navdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.navdrawer.fragments.FragmentComment
import com.example.navdrawer.fragments.FragmentPost
import com.example.navdrawer.fragments.FragmentUser
import com.example.navdrawer.fragments.todoFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var drawer: DrawerLayout
    lateinit var navigationview : NavigationView
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        navigationview = findViewById(R.id.nav_view)
        navigationview.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        if(savedInstanceState == null) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            FragmentUser()
        ).commit()
        navigationview.setCheckedItem(R.id.nav_user) }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.nav_user -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentUser()
                ).commit()
            }
            R.id.nav_post -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentPost()
                ).commit()
            }
            R.id.nav_todo -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    todoFragment()
                ).commit()
            }
            R.id.nav_comments -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    FragmentComment()
                ).commit()
            }
            R.id.nav_share -> Toast.makeText(this, "Share Item", Toast.LENGTH_SHORT).show()
            R.id.nav_send -> Toast.makeText(this, "Send Item", Toast.LENGTH_SHORT).show()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }
        else super.onBackPressed()
    }
}
