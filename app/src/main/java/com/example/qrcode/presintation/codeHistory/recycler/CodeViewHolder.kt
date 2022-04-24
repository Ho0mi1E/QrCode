package com.example.qrcode.presintation.codeHistory.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qrcode.databinding.ItemCodesBinding
import com.example.qrcode.domain.interactor.ScanCodeForView
import com.example.qrcode.presintation.codeHistory.clickListener.ClickListener

class CodeViewHolder(
    private val binding: ItemCodesBinding,
    private val clickListener: ClickListener
) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(itemView: ViewGroup, clickListener: ClickListener) = CodeViewHolder(
            ItemCodesBinding.inflate(
                LayoutInflater.from(itemView.context), itemView, false
            ), clickListener
        )
    }

    fun bindItem(code: ScanCodeForView) {
        code.apply {
            binding.text.text = text
            binding.date.text = date
        }
        binding.btn.setOnClickListener {
            clickListener.onButtonClickListener(code)
        }
    }
}