package com.example.poketype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val EXTRA_POKEMON = "key_pokemon"
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var rvPokemon: RecyclerView
    private val list = ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPokemon = findViewById(R.id.rv_poketype)
        rvPokemon.setHasFixedSize(true)
        list.addAll(getListPokemon())
        showRecyclerList()
    }

    private fun getListPokemon(): ArrayList<Pokemon> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPokemon = ArrayList<Pokemon>()
        for (i in dataName.indices) {
            val pokemon = Pokemon(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listPokemon.add(pokemon)
        }
        return listPokemon
    }

    private fun showRecyclerList() {
        rvPokemon.layoutManager = LinearLayoutManager(this)
        val listPokemonAdapter = ConcreteListPokemonAdapter(list)
        rvPokemon.adapter = listPokemonAdapter
        listPokemonAdapter.setOnItemClickCallback(object : ListPokemonAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Pokemon) {
                showSelectedPokemon(data)
            }
        })
    }

    private fun showSelectedPokemon(data: Pokemon) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(MainActivity.EXTRA_POKEMON, data )
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this@MainActivity, About::class.java)
                intent.putExtra("image", R.drawable.lb)
                intent.putExtra("name", "NURI NUR'AINI FATIN")
                intent.putExtra("email", "nurifatin12@upi.edu")
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    

    class ConcreteListPokemonAdapter(listPokemon: ArrayList<Pokemon>) : ListPokemonAdapter(listPokemon) {
    override fun getItemCount(): Int = listPokemon.size}
}
