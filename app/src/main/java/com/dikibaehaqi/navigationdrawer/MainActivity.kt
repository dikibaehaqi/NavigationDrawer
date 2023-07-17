package com.dikibaehaqi.navigationdrawer
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dikibaehaqi.navigationdrawer.databinding.ActivityMainBinding
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var profilecircleImageView: CircleImageView
    private var profileImage ="https://lh3.googleusercontent.com/pw/AIL4fc-6hTYfCSsDXucRdB15Y3F4Ij8Aeu5lAZTC59naJ9vneghtBoAXrR_Bl70XbT3auR84Lckfdn_XIkMHiT60hrEBoH1Qh9PbV7G-zpUnL79usGJZuJn0Muo1zbnm66szl7lknUArSa4n9WIH1qFjbDZxFSLRBt6QSkb2X53s66zH8ReTb9uUZ9BHr5toYBzlrL8i5EoU8vuxRjzxjmQ9CwEa6bIB8T29gMJsKnl_pSN2PGb67Fv8X7Vbkv4mx80203j5cs-eCFNp54rK6rUK_L3sBFY7Q49scJcwJwwK5de1GOqMEZhORdL5topC3tiX780VFoeco137n-tx3E-De2yliKepBSlMKBC3JkZ0clk8lAqHqEjbI1aUMU68e9dZuzm0jebpV-BtsQIy09cm3j0ZiERRTUca-lc5aArRsXLVNBnfvIo7bxeKZXBgWT6QDEo51tYzACyXWP_ja68PX54ed9xXXAl9unq3kwswDAw9Hvhylq9Teq-D7knhUU-aCxmUvuQPMrSJlftuloHwMLDQsMCESLULqgZ_sd8TfZqgFEMFwnX-2tprJ_5SLJUs_Pkvk_WR7KznhNmpA0nCjhI9njtKG2AE77lVrCuDGOgbmF2UWh5mrD2e57UUj6LZPiZc_ZjljHKkfXi78uoxSbLoC_PDUdPXyQhcPkIpm7vmvQYy-mOD1va6PEcGOe-avkwM4KXP5ec_9x0njM9mQYyeHEqtKwjHFapIMc1Y-V4bF9SyaPGqpNJIE6JQnwBA6xhYuavz0rOsIzUn7YDHHPhkZ5PACZ3FlEHPCKAZ1kOAZZfKXRWZHw4GzDqpvS1LPEHv2-KDGPk58aNlJHpP41iZ4c0dGuoLswfo9UKhZ6eusl5G2p6gxbKWGfQU-ILzV3rf7QTRj0HjckmMeAYlW5c9QFxVOPXi0FZE4m5l7I2N5Zxv8ahnqxNCYg=w400-h400-s-no?authuser=0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        profilecircleImageView = navView.getHeaderView(0).findViewById(R.id.imageview)
        Glide.with(this).load(profileImage).into(profilecircleImageView)


        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_cart
        ), drawerLayout)


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}