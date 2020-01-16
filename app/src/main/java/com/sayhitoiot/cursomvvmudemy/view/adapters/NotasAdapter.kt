package com.sayhitoiot.cursomvvmudemy.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sayhitoiot.cursomvvmudemy.R
import com.sayhitoiot.cursomvvmudemy.model.Nota
import kotlinx.android.synthetic.main.item_notas.view.*

class NotasViewHolder(val view: View): RecyclerView.ViewHolder(view){
    fun bindView(item: Nota){
        with(view){
            tv_nota.setText(item.text)
        }
    }
}

class NotasAdapter(val data: MutableList<Nota> = mutableListOf()):
    RecyclerView.Adapter<NotasViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notas, parent, false)
        return NotasViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NotasViewHolder, position: Int) {
        holder.bindView(data[position])
    }

    fun addItem(nota: Nota){
        data.add(nota)
        notifyItemInserted(0)
        //notifyDataSetChanged()
    }

    fun addAll(notas: List<Nota>){
        data.clear()
        data.addAll(notas)
        notifyDataSetChanged()
    }

    fun removeItem(nota: Nota){
        data.remove(nota)
        notifyDataSetChanged()
    }

}