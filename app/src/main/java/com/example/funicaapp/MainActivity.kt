package com.example.funicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.funicaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val menuAdapter = MenuAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        handleWindowInset()

        binding.menuItemRecycleView.layoutManager =
            LinearLayoutManager(this)
        binding.menuItemRecycleView.adapter = menuAdapter

        updateAdapter()

    }

    private fun handleWindowInset() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

            binding.root.updatePadding(bottom = insets.bottom)

            windowInsets

        }
    }

    private fun updateAdapter() {
        menuAdapter.submitList(menuItem.toList())
    }
}

val menuItem = listOf(
    MenuItem(R.drawable.ic_user_icon, "Edit Profile", R.drawable.ic_right_icon),
    MenuItem(R.drawable.ic_pin_icon, "Address", R.drawable.ic_right_icon),
    MenuItem(R.drawable.ic_notifications_icon, "Notifications", R.drawable.ic_right_icon),
    MenuItem(R.drawable.ic_payments_icon, "Payment", R.drawable.ic_right_icon),
    MenuItem(R.drawable.ic_security_icon, "Security", R.drawable.ic_right_icon),
    MenuItem(R.drawable.ic_language_icon, "Language", R.drawable.ic_right_icon, "English (US)"),
    MenuItem(R.drawable.ic_eye_icon, "Dark Mode", R.drawable.ic_switcher_icon, hasSwitch = true),
    MenuItem(R.drawable.ic_security_icon, "Privacy", R.drawable.ic_right_icon),
    MenuItem(R.drawable.ic_help_icon, "Help Center", R.drawable.ic_right_icon),
    MenuItem(R.drawable.ic_friends_icon, "Invite Friends", R.drawable.ic_right_icon),
    MenuItem(R.drawable.ic_log_out_icon, "Logout", null),

    )