package adu.capstone.apwell.ui.register

import adu.capstone.apwell.R
import adu.capstone.apwell.databinding.FragmentGenderPickerBinding
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerAppCompatDialogFragment
import javax.inject.Inject

class GenderPickerFragment @Inject constructor(): DaggerAppCompatDialogFragment() {

    lateinit var gender:String

    private lateinit var binding : FragmentGenderPickerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using binding
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_gender_picker, container, false)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)

        binding.dMalePic.setOnClickListener{v ->
            gender = "Male"
            this.dismiss()}
        binding.dFemalePic.setOnClickListener{v ->
            gender = "Female"
            this.dismiss()}

        return binding.root
    }

    override fun onDismiss(dialog: DialogInterface) {

        var main = this.activity!! as RegisterActivity
        main.onClose(gender)
    }

    interface IDialogGenderDismissListener{
        fun onClose(strGender:String)
    }

}
