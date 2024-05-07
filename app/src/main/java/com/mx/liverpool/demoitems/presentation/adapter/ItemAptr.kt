package com.mx.liverpool.demoitems.presentation.adapter


import ProductLiver
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mx.liverpool.demoitems.R
import com.mx.liverpool.demoitems.databinding.ItemCardViewBinding

class ItemAptr(private var items: List<ProductLiver>) :
    RecyclerView.Adapter<ItemAptr.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductLiver) {
            Log.d("ItemAdapter", "Producto: $item")
            binding.tvTitle.text = item.title
            binding.tvNormalPrice.text = item.normalPrice.toString()
            binding.tvDiscountPrice.text = item.discountPrice.toString()
            binding.tvNormalPrice.paintFlags =
                binding.tvNormalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

            Glide.with(binding.root.context)
                .load(item.imageUrl)
                .placeholder(R.drawable.ic_product)
                .error(R.drawable.ic_error_placeholder)
                .into(binding.imgProduct)

            val colors = item.availabilityColors
            if (colors.isNullOrEmpty()) {
                binding.vColor1?.setBackgroundColor(Color.TRANSPARENT)
                binding.vColor2?.setBackgroundColor(Color.TRANSPARENT)
                binding.vColor3?.setBackgroundColor(Color.TRANSPARENT)
            } else {
                val color1 = if (colors.isNotEmpty() && colors[0].colorHex.isNotBlank()) {
                    try {
                        Color.parseColor(colors[0].colorHex)
                    } catch (e: Exception) {
                        Color.TRANSPARENT
                    }
                } else {
                    Color.TRANSPARENT
                }
                val color2 = if (colors.size > 1 && colors[1].colorHex.isNotBlank()) {
                    try {
                        Color.parseColor(colors[1].colorHex)
                    } catch (e: Exception) {
                        Color.TRANSPARENT
                    }
                } else {
                    color1
                }
                val color3 = if (colors.size > 2 && colors[2].colorHex.isNotBlank()) {
                    try {
                        Color.parseColor(colors[2].colorHex)
                    } catch (e: Exception) {
                        Color.TRANSPARENT
                    }
                } else {
                    color1
                }
                binding.vColor1?.setBackgroundColor(color1)
                binding.vColor2?.setBackgroundColor(color2)
                binding.vColor3?.setBackgroundColor(color3)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ItemCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(newItems: List<ProductLiver>) {
        items = newItems
        notifyDataSetChanged()
    }
}