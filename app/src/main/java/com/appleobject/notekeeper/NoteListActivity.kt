package com.appleobject.notekeeper

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.appleobject.notekeeper.model.DataManager
import kotlinx.android.synthetic.main.activity_note_list.*
import kotlinx.android.synthetic.main.content_note_list.*

class NoteListActivity : AppCompatActivity() {

    lateinit var noteRecyclerAdapter: NoteRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(findViewById(R.id.toolbar))

        fabNoteList.setOnClickListener { _ ->
            val activityIntent = Intent(this, NoteActivity::class.java)
            startActivity(activityIntent)
        }


        initRecyclerView()
    }


    private fun initRecyclerView(){
        listItems.apply {
            layoutManager = LinearLayoutManager(this@NoteListActivity)
            noteRecyclerAdapter = NoteRecyclerAdapter(this.context, DataManager.notes)
            adapter = noteRecyclerAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        listItems.adapter?.notifyDataSetChanged()

    }
}