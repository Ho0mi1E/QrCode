package com.example.qrcode.presintation.codeHistory.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qrcode.domain.interactor.ScanCodeForView
import com.example.qrcode.presintation.codeHistory.clickListener.ClickListener

class CodeAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<CodeViewHolder>() {

    private var codeList = listOf<ScanCodeForView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CodeViewHolder {
        return CodeViewHolder.newInstance(parent, clickListener)
    }

    override fun onBindViewHolder(holder: CodeViewHolder, position: Int) {
        holder.bindItem(codeList[position])
    }

    override fun getItemCount(): Int {
        return codeList.size
    }

    fun submitItem(list: List<ScanCodeForView>) {
        codeList = list
        notifyDataSetChanged()
    }
}