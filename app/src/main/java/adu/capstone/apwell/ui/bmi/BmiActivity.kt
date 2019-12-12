package adu.capstone.apwell.ui.bmi

import adu.capstone.apwell.R
import adu.capstone.apwell.databinding.ActivityBmiBinding
import adu.capstone.apwell.ui.main.MainActivity
import adu.capstone.apwell.ui.register.RegisterActivity
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_bmi.*
import javax.inject.Inject

class BmiActivity @Inject constructor(): DaggerAppCompatActivity(){

    private lateinit var binding : ActivityBmiBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_bmi)

        buttonproceed.setOnClickListener{v -> startActivity(Intent(this, MainActivity::class.java))  }
    }


    override fun onBackPressed() {
        if(cardheightpicker.visibility == View.VISIBLE){ cardheightpicker.visibility = View.INVISIBLE}
        else
        {
            AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Are you sure you want to exit?")
                .setPositiveButton("YES") { dialog, which ->  this.finish()}
                .setNegativeButton("NO"){dialog, which ->  return@setNegativeButton }
                .create().show()
        }
    }
}
