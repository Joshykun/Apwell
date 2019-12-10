package adu.capstone.apwell.ui.register

import adu.capstone.apwell.data.models.User
import adu.capstone.apwell.data.source.LocalCallback
import adu.capstone.apwell.data.source.repository.UserRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val errorCommand = MutableLiveData<String>()

    fun registerUser(strName:String, strGender:String){

        if(checkName(strName) && checkGender(strGender)){

            val user = User(1,strName,strGender)
            userRepository.saveUser(user)

        }

    }


    private fun checkName(strName: String) : Boolean {
        if(strName.isEmpty()) {
            errorCommand.postValue("Please input Name")
            return false
        }
        return true
    }

    private fun checkGender(strGender: String) : Boolean{
        if(strGender.isEmpty()){
            errorCommand.postValue("Please select Gender")
            return false
        }
        return true
    }


}