package com.appleobject.notekeeper

import android.os.Bundle
import androidx.lifecycle.ViewModel

class ItemsActivityViewModel: ViewModel() {

    var isNewlyCreated = true

    var navDrawerDisplaySelectionName =
        "com.appleobject.notekeeper.ItemsActivityViewModel.navDrawerDisplaySelectionName"

    var navDrawerDisplaySelection = R.id.nav_notes

    fun saveState(outState: Bundle){
        outState.putInt(navDrawerDisplaySelectionName, navDrawerDisplaySelection)
    }

    fun restoreState(savedInstanceState: Bundle) {
        navDrawerDisplaySelection = savedInstanceState.getInt(navDrawerDisplaySelectionName)
    }


}