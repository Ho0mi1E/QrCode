package com.example.qrcode.presintation


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.qrcode.R
import com.example.qrcode.databinding.ActivityMainBinding
import com.example.qrcode.presintation.codeHistory.HistoryFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        openFragment(R.id.container, HistoryFragment.newInstance(), HistoryFragment.TAG)
    }
}
