package com.bayu.myrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bayu.myrecyclerview.databinding.ItemGridHeroBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class GridViewHolder(private val binding: ItemGridHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hero: Hero) {
            with(binding) {
                Glide.with(itemView.context).load(hero.photo)
                    .apply(RequestOptions().override(350, 350)).into(imgItemPhoto)
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(hero) }

            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GridViewHolder {
        val binding =
            ItemGridHeroBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return GridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size

}