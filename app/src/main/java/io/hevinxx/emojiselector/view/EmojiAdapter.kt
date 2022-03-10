package io.hevinxx.emojiselector.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.hevinxx.emojiselector.databinding.ItemEmojiBinding

class EmojiAdapter : RecyclerView.Adapter<EmojiViewHolder>() {
    val emojis = (0x1F600..0x1F64F).map {
        String(Character.toChars(it))
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder {
        val binding = ItemEmojiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmojiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) {
        holder.bind(emojis[position])
    }

    override fun getItemCount(): Int {
        return emojis.size
    }
}

class EmojiViewHolder(private val binding: ItemEmojiBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(emoji: String) {
        binding.emoji.text = emoji
    }
}