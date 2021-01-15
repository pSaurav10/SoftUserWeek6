package com.example.softuserassignment.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.softuserassignment.MainActivity
import com.example.softuserassignment.R
import com.example.softuserassignment.model.User

class DashboardFragment : Fragment() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etAddress: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private lateinit var rbOthers: RadioButton
    private lateinit var btnSave: Button
    private var gender = ""

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_dashboard, container, false)
        etName = view?.findViewById(R.id.etName) as EditText
        etAge = view?.findViewById(R.id.etAge) as EditText
        etAddress = view?.findViewById(R.id.etAddress) as EditText
        rgGender = view?.findViewById(R.id.rgGender) as RadioGroup
        rbMale = view?.findViewById(R.id.rbMale) as RadioButton
        rbFemale = view?.findViewById(R.id.rbFemale) as RadioButton
        rbOthers = view?.findViewById(R.id.rbOthers) as RadioButton
        btnSave = view?.findViewById(R.id.btnSave) as Button
        btnSave.setOnClickListener{
            if(validate()) {
                var name: String
                var age: Int
                var address: String

                name = etName.text.toString()
                age = etAge.text.toString().toInt()
                address = etAddress.text.toString()
                when {
                    rbMale.isChecked -> {
                        gender = "Male"
                    }
                    rbFemale.isChecked -> {
                        gender = "Female"
                    }
                    rbOthers.isChecked -> {
                        gender = "Others"
                    }
                }
                MainActivity.UserList.add(User(name, age, gender, address))
                Toast.makeText(this@DashboardFragment.activity as Context?, "Student Added", Toast.LENGTH_SHORT).show()
                clear()

            }
        }
        return view
    }
    fun validate(): Boolean {
        var flag = true
        if (TextUtils.isEmpty(etName.text)) {
            etName.error = "Please enter Name"
            etName.requestFocus()
            return false
        }
        if (TextUtils.isEmpty(etAge.text)) {
            etAge.error = "Please enter Age"
            etAge.requestFocus()
            return false
        }
        if (rgGender.checkedRadioButtonId == -1){
            Toast.makeText(this@DashboardFragment.activity as Context?, "Please select a Gender", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(etAddress.text)) {
            etAddress.error = "Please enter Address"
            etAddress.requestFocus()
            return false
        }

        return flag
    }
    fun clear(){
        etName.text.clear()
        etAddress.text.clear()
        etAge.text.clear()
        rgGender.clearCheck()
    }
}