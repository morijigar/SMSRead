package com.example.apifetch

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apifetch.adapter.PostAdapter
import com.example.apifetch.base.BaseActivity
import com.example.apifetch.databinding.ActivityMainBinding
import com.example.apifetch.models.Sms
import com.example.apifetch.viewmodel.MainActivityViewModel


class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    val REQUEST_READ_SMS_PERMISSION = 1009

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.activity_main
    override val viewModel: MainActivityViewModel
        get() = ViewModelProvider(this).get(MainActivityViewModel::class.java)

    /*  override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          getSupportActionBar()!!.setDisplayShowTitleEnabled(false);
          setFragmentReplaceBackPress(true, MainFragment.newInstance("", ""))

      }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onserveData()
        viewDataBinding!!.btn.setOnClickListener {
            if(isPermissionGranted()){
                viewDataBinding!!.progress.visibility = View.VISIBLE
                viewModel.readSMS(this)
            }else{
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.READ_SMS),
                    REQUEST_READ_SMS_PERMISSION);
            }
        }
    }

    fun onserveData(){
        viewModel.fetchingSms.observe(this, Observer {

            if(it){
                viewDataBinding!!.progress.visibility = View.VISIBLE
            }else{
                viewDataBinding!!.progress.visibility = View.GONE
                val intent = Intent(this, DetailActivityActivity::class.java)
                startActivity(intent)
            }

        })
    }

    private fun isPermissionGranted(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkSelfPermission(Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED
        } else true
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (REQUEST_READ_SMS_PERMISSION == requestCode) {
                Log.i("TAG", "REQUEST_READ_SMS_PERMISSION Permission Granted")
                viewDataBinding!!.progress.visibility = View.VISIBLE
                viewModel.readSMS(this)
            }
        } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
            if (REQUEST_READ_SMS_PERMISSION == requestCode) {
                // TODO REQUEST_READ_SMS_PERMISSION Permission is not Granted.
                // TODO Request Not Granted.

                // This code is for get permission from setting.
                val i = Intent()
                i.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                i.addCategory(Intent.CATEGORY_DEFAULT)
                i.data = Uri.parse("package:$packageName")
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                startActivity(i)
            }
        }
    }




}
