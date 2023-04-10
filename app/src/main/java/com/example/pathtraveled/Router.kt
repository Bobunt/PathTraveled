package com.example.pathtraveled

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.pathtraveled.main.mainFragment
import com.example.pathtraveled.navigator.mapFragment

object Router {
    private fun showFragment(currentFragment: Fragment, fm: FragmentManager?, container: Int, addToBackStack: Boolean = true) {
        try {
            if (fm != null) {
                val transaction = fm.beginTransaction()
                transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out)
                transaction.replace(container, currentFragment, currentFragment::class.java.simpleName)
                if (addToBackStack) transaction.addToBackStack(currentFragment::class.java.simpleName)
                transaction.commit()
            }
        } catch (e: Exception) {
            e
        }
    }

    private fun clearBackStack(fm: FragmentManager?){
        val count = fm?.backStackEntryCount ?: 0
        for (i in 0 until count) {
            fm?.popBackStack()
        }
    }

    private fun showInFragmentMainFragent(fragment: Fragment, fm: FragmentManager?, addToBackStack: Boolean = true){
        showFragment(fragment, fm, R.id.mainFragment, addToBackStack)
    }

    fun showMainFragmentMain(fm: FragmentManager?){
        clearBackStack(fm)
        showInFragmentMainFragent(mainFragment(), fm, addToBackStack = false)
    }

    fun showInMapFragment(fm: FragmentManager?){
        clearBackStack(fm)
        showInFragmentMainFragent(mapFragment(), fm, addToBackStack = false)
    }

    fun showInGetRouteMapFragment(fm: FragmentManager?){
        clearBackStack(fm)
        showInFragmentMainFragent(mapFragment(), fm, addToBackStack = false)
    }
}