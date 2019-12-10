package adu.capstone.apwell.ui.register

import adu.capstone.apwell.R
import adu.capstone.apwell.databinding.ActivityRegisterBinding
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity @Inject constructor() : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<RegisterViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        regparent.setOnClickListener { v ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

        viewModel.errorCommand.observe(this, Observer {
            showToast(it)
        })

        buttonregister.setOnClickListener { v -> validate() }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        AlertDialog.Builder(this)
            .setCancelable(false)
            .setTitle("Are you sure you want to exit?")
            .setPositiveButton("YES") { dialog, which -> this.finish() }
            .setNegativeButton(
                "NO",
                DialogInterface.OnClickListener { dialog, which -> return@OnClickListener })
            .create().show()
    }


    private fun validate() {
        viewModel.registerUser(textname.text.toString(), textgender.text.toString())
    }

    private fun showToast(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }
}
