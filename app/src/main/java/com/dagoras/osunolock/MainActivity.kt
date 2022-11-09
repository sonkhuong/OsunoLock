package com.dagoras.osunolock

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.dagoras.osunolock.databinding.ActivityMainBinding
import com.dagoras.osunolock.list_manager.fragment.ListManagerLockFragmentDirections
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarHeader)
        drawerLayout = binding.mainDrawer
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navigationHost) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        findViewById<Toolbar>(R.id.toolbarHeader)
            .setupWithNavController(navController, appBarConfiguration)
        binding.navigationView.setNavigationItemSelectedListener(this);
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val result = when (item.itemId) {
            R.id.nav_add_lock -> {
                val action =
                    ListManagerLockFragmentDirections.actionListManagerLockFragmentToManagerScanLockFragment()
                navController.navigate(action)
                true
            }
            R.id.nav_gateway -> {
                true
            }
            R.id.nav_message -> {
                true
            }
            R.id.nav_service -> {
                true
            }
            R.id.nav_setting -> {
                val action =
                    ListManagerLockFragmentDirections.actionListManagerLockFragmentToSystemSettingFragment2()
                navController.navigate(action)
                true
            }
            R.id.nav_info -> {
                true
            }
            else -> false
        }
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        return result
    }
}