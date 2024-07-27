package com.example.daggerhiltretrofit.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerhiltretrofit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myViewModel : MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dagger hilt - Retrofit

        // CLEAN ARCHITECTURE - MVVM

        myViewModel.fetchPost()

        myViewModel.post.observe(this) {post ->
            binding.tvTitle.text = post.title
            binding.tvBody.text = post.body
        }
    }
}