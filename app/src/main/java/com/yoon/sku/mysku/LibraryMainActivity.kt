package com.yoon.sku.mysku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yoon.sku.mysku.databinding.ActivityLibraryMainBinding

class LibraryMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLibraryMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_main)
    }
}