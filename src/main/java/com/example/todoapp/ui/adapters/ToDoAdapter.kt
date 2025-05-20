package com.example.todoapp.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.entity.RecordEntity
import com.example.todoapp.databinding.CardDesignBinding
import com.example.todoapp.ui.fragments.MainFragment
import com.example.todoapp.ui.fragments.MainFragmentDirections
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter( var context: Context,
                   var records: List<RecordEntity>)
    : RecyclerView.Adapter<ToDoAdapter.CardDesignHolder>(){

        inner class CardDesignHolder(var design : CardDesignBinding)
            : RecyclerView.ViewHolder(design.root){

        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoAdapter.CardDesignHolder {
        val design = CardDesignBinding.inflate(LayoutInflater.from(context),parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: ToDoAdapter.CardDesignHolder, position: Int) {
        val record = records.get(position)
        val screenDesign = holder.design

        screenDesign.tvToDoTitle.text = record.record_title

        screenDesign.cvToDo.setOnClickListener {
            val nav = MainFragmentDirections.mainToDetailNav(record)
            Navigation.findNavController(it).navigate(nav)
        }

        screenDesign.ivDelete.setOnClickListener {
            Snackbar.make(it,"To Do will be deleted, Are you sure?", Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    Log.e("DELETE","TO DO DELETED")
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return  records.size
    }

}