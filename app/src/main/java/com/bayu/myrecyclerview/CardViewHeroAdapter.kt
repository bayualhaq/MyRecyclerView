package com.bayu.myrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bayu.myrecyclerview.databinding.ItemCardviewHeroBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<CardViewHeroAdapter.CardViewHolder>() {
    inner class CardViewHolder(private val binding: ItemCardviewHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            with(binding) {
                Glide.with(itemView.context).load(hero.photo)
                    .apply(RequestOptions().override(350, 550)).into(imgItemPhoto)

                tvItemName.text = hero.name
                tvItemDescription.text = hero.description

                btnSetFavorite.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "Favorite ${hero.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                btnSetShare.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "Share ${hero.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                itemView.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "Kamu memilih ${hero.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardviewHeroBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size


}