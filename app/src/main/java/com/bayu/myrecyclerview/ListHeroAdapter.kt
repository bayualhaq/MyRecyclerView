package com.bayu.myrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bayu.myrecyclerview.databinding.ItemRowHeroBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback:OnItemClickCallback){
        this.onItemClickCallback=onItemClickCallback
    }

    inner class ListViewHolder(private val binding: ItemRowHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            with(binding) {
                Glide.with(itemView.context).load(hero.photo)
                    .apply(RequestOptions().override(55, 55)).into(imgItemPhoto)

                tvItemName.text = hero.name
                tvItemDescription.text = hero.description

                itemView.setOnClickListener{onItemClickCallback?.onItemClicked(hero)}
            }
        }

    }

    interface OnItemClickCallback{
        fun onItemClicked(data:Hero)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemRowHeroBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size
}