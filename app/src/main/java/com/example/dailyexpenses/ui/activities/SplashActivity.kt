package com.example.dailyexpenses.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.dailyexpenses.R
import com.example.dailyexpenses.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DailyExpenses)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, MainActivity::class.java)

        binding.apply {
            splashscreenIconView.alpha = 0f
            splashscreenIconView.animate().setDuration(1000).alpha(1f).withEndAction{
                startActivity(intent)
                finish()
            }
        }
    }

}