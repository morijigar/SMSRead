package com.example.apifetch

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.apifetch.adapter.TabsPagerAdapter
import com.example.apifetch.base.BaseActivity
import com.example.apifetch.databinding.ActivityDetailBinding
import com.example.apifetch.databse.Rows
import com.example.apifetch.models.Datum
import com.example.apifetch.viewmodel.DetailActivityViewModel
import com.example.myapplication.databse.Database
import com.google.android.material.tabs.TabLayout


class DetailActivityActivity : BaseActivity<ActivityDetailBinding, DetailActivityViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.activity_detail
    override val viewModel: DetailActivityViewModel
        get() = ViewModelProvider(this).get(DetailActivityViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tabsPagerAdapter = TabsPagerAdapter(this, supportFragmentManager)

        viewDataBinding!!.viewPager.adapter = tabsPagerAdapter
        viewDataBinding!!.tabs.setupWithViewPager(viewDataBinding!!.viewPager)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item)
    }


}
