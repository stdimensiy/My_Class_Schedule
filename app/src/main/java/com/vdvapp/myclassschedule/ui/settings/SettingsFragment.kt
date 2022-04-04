package com.vdvapp.myclassschedule.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.vdvapp.myclassschedule.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}