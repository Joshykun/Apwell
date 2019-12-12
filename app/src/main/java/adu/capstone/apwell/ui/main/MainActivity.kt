package adu.capstone.apwell.ui.main

import adu.capstone.apwell.R
import adu.capstone.apwell.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity @Inject constructor() : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    inner class TradePagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment = getFragmentAndTitle(position).second
        override fun getCount(): Int = PAGE_COUNT
    }



    private fun getFragmentAndTitle(position: Int): Pair<String, Fragment> = when (position) {
        0 -> Pair("NEW ORDER", Fragment())
        1 -> Pair("NEW ORDER", Fragment())

        else -> Pair("", Fragment())
    }

    companion object {
        private const val PAGE_COUNT = 2
    }
}
