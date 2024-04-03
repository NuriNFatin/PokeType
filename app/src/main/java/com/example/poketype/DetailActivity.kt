package com.example.poketype

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)

        val pokemon = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(MainActivity.EXTRA_POKEMON, Pokemon::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(MainActivity.EXTRA_POKEMON)
        }

        tvName.text = pokemon?.name
        tvDescription.text = pokemon?.description
        if (pokemon != null) {
            imgPhoto.setImageResource(pokemon.photo)
        }
    }
}