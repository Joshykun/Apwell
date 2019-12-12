package adu.capstone.apwell.ui.register

import adu.capstone.apwell.R
import adu.capstone.apwell.databinding.ActivityRegisterBinding
import adu.capstone.apwell.ui.bmi.BmiActivity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity @Inject constructor(
) : DaggerAppCompatActivity(), GenderPickerFragment.IDialogGenderDismissListener {

    private lateinit var binding: ActivityRegisterBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var genderPickerFragment: GenderPickerFragment

    private val viewModel by viewModels<RegisterViewModel> { viewModelFactory }
    private lateinit var ft: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        regparent.setOnClickListener { v ->
            enableCloseKeyboardViaClick()
        }

        viewModel.errorCommand.observe(this, Observer {
            showToast(it)
        })

        buttonregister.setOnClickListener { v -> validate() }

        textgender.setOnClickListener { v -> pickGender() }
    }

    override fun onBackPressed() {
        showExitDialog()
    }


    private fun pickGender() {
        showDialog("dialogGender")
        genderPickerFragment.isCancelable = false
        genderPickerFragment.show(ft, "dialogGender")
    }


    override fun onClose(strGender: String) {
        textgender.setText(strGender)
        startActivity(Intent(this, BmiActivity::class.java))
    }

    private fun showDialog(tag: String) {
        ft = supportFragmentManager.beginTransaction()
        val prev = supportFragmentManager.findFragmentByTag(tag)
        if (prev != null) {
            ft.remove(prev)
        }
        ft.addToBackStack(null)
    }

    private fun validate() {
        viewModel.registerUser(textname.text.toString(), textgender.text.toString())

    }

    private fun showToast(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }

    private fun enableCloseKeyboardViaClick() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    private fun showExitDialog() {
        AlertDialog.Builder(this)
            .setCancelable(false)
            .setTitle("Are you sure you want to exit?")
            .setPositiveButton("YES") { dialog, which -> this.finish() }
            .setNegativeButton(
                "NO",
                DialogInterface.OnClickListener { dialog, which -> return@OnClickListener })
            .create().show()
    }
}
