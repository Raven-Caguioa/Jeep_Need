package com.example.jeep_need

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        navigationView = findViewById(R.id.nav_view)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView.setupWithNavController(navController)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.login_nav) {
                toolbar.visibility = View.GONE
                navigationView.visibility = View.GONE
            }
            else if(destination.id == R.id.forgotPassword){
                toolbar.visibility = View.GONE
                navigationView.visibility = View.GONE
            }
            else if(destination.id == R.id.signup_Passenger){
                toolbar.visibility = View.GONE
                navigationView.visibility = View.GONE
            }
            else if(destination.id == R.id.signup_Driver){
                toolbar.visibility = View.GONE
                navigationView.visibility = View.GONE
            }
            else if(destination.id == R.id.signup_choice){
                toolbar.visibility = View.GONE
                navigationView.visibility = View.GONE
            }
            else if(destination.id == R.id.landingPage){
                toolbar.visibility = View.GONE
                navigationView.visibility = View.GONE
            }
            else if(destination.id == R.id.home){
                toolbar.visibility = View.VISIBLE
                navigationView.visibility = View.VISIBLE
                toolbar.title = "JeepNeed"
            }
            else if(destination.id == R.id.profile){
                toolbar.visibility = View.VISIBLE
                navigationView.visibility = View.VISIBLE
                toolbar.title = "Account"
            }
            else if(destination.id == R.id.routes){
                toolbar.visibility = View.VISIBLE
                navigationView.visibility = View.VISIBLE
                toolbar.title = "Account"
            }
            else {
                toolbar.visibility = View.VISIBLE
                navigationView.visibility = View.VISIBLE
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
    }
}