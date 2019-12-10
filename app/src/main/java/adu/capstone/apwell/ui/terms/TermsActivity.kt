package adu.capstone.apwell.ui.terms

import adu.capstone.apwell.R
import adu.capstone.apwell.databinding.ActivityTermsAndConditionBinding
import adu.capstone.apwell.ui.register.RegisterActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

class TermsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTermsAndConditionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_terms_and_condition)

        binding.buttonaccept.setOnClickListener { v ->  startActivity(Intent(this, RegisterActivity::class.java)) }
    }


}
