package com.appleobject.notekeeper

import android.content.Context
import android.content.Intent
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appleobject.notekeeper.model.NoteInfo

class NoteRecyclerAdapter(private val context: Context, private var notes : List<NoteInfo>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


      class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val textCourse: TextView = itemView.findViewById<TextView>(R.id.textCourse)
        private val textTitle: TextView = itemView.findViewById<TextView>(R.id.textTitle)
         var notePosition = 0

        init{
            itemView.setOnClickListener {
                val intent = Intent(it.context, NoteActivity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)
                it.context.startActivity(intent)
            }

        }

          // Bind the view to the collection
         fun bind(noteInfo: NoteInfo){
             textCourse.text = noteInfo.course?.title
             textTitle.text = noteInfo.title
         }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note_list, parent, false)
        )
    }

    override fun getItemCount() = notes.size


    // We can have more than one ViewHolder
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is NoteViewHolder -> {
                holder.bind(notes[position])
                holder.notePosition = position
            }
        }
    }
}