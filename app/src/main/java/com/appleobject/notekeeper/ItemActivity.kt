package com.appleobject.notekeeper

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.appleobject.notekeeper.model.DataManager
import kotlinx.android.synthetic.main.activity_item.*
import kotlinx.android.synthetic.main.content_note_list.*

class ItemActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    private val linearLayoutManager by lazy {
        LinearLayoutManager(this)
    }

    private val noteRecyclerAdapter by lazy {
        NoteRecyclerAdapter(this, DataManager.notes)
    }

    private val coursesLayoutManager by lazy {
        GridLayoutManager(this, 2)
    }

    private val coursesRecyclerAdapter by lazy {
        CourseRecyclerAdapter(this, DataManager.courses.values.toList())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            startActivity(Intent(this, NoteActivity::class.java))
        }

        displayNote()


        nav_view.setNavigationItemSelectedListener(this)

        val toggleDrawer = ActionBarDrawerToggle(this,
            drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggleDrawer)
        drawer_layout.setDrawerListener(toggleDrawer)
        toggleDrawer.syncState()

    }

    private fun displayCourses() {
        listItems.layoutManager = coursesLayoutManager
        listItems.adapter = coursesRecyclerAdapter

        nav_view.menu.findItem(R.id.nav_courses).isChecked = true
    }

    private fun displayNote() {
        listItems.layoutManager = linearLayoutManager
        listItems.adapter = noteRecyclerAdapter

        nav_view.menu.findItem(R.id.nav_notes).isChecked = true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.item, menu)
        return true
    }


    override fun onResume() {
        super.onResume()
        listItems.adapter?.notifyDataSetChanged()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_notes ->{
                displayNote()
            }
            R.id.nav_courses -> {
                displayCourses()
            }
            R.id.nav_share -> {
                handleSelection("Don't you think you've shared enough..")
            }
            R.id.nav_send -> {
                handleSelection("Send")
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun handleSelection(message: String) {
        Snackbar.make(listItems, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onNavigateUp(): Boolean {
         super.onNavigateUp()
        return true
    }

}