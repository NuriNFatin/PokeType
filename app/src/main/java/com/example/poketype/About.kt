package com.example.poketype

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class About : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val imgPhoto: ImageView = findViewById(R.id.img_item_lb)
        val tvName: TextView = findViewById(R.id.tv_item_nuri)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)

        val intent = intent
        val imageResource = intent.getIntExtra("image", 0)
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        imgPhoto.setImageResource(imageResource)
        tvName.text = name
        tvDescription.text = email
    }
}