package com.example.poketype

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
abstract class ListPokemonAdapter(val listPokemon: ArrayList<Pokemon>) : RecyclerView.Adapter<ListPokemonAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    abstract override fun getItemCount(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_poke, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pokemon = listPokemon[position]
        holder.imgPhoto.setImageResource(pokemon.photo)
        holder.tvName.text = pokemon.name
        holder.tvDescription.text = pokemon.description
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPokemon[holder.adapterPosition]) }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }


    interface OnItemClickCallback {
        fun onItemClicked(data: Pokemon)
    }
}