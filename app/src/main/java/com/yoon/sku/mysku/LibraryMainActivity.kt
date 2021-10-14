package com.yoon.sku.mysku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yoon.sku.mysku.databinding.ActivityLibraryMainBinding

class LibraryMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLibraryMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibraryMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}