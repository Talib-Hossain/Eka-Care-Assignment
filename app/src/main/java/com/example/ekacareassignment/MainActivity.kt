package com.example.ekacareassignment

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.ekacareassignment.data.User
import com.example.ekacareassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding?= null
    private val binding get() = _binding!!
    private val calendar = Calendar.getInstance()

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dob.isFocusable = false
        binding.dob.isClickable = true


        binding.submitButton.setOnClickListener {
            if(validateInput()){
                viewModel.onSubmitClicked(createUser())
                Toast.makeText(this, "User Created", Toast.LENGTH_LONG).show()
            }
        }

        binding.dob.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this, {DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                binding.dob.setText(formattedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun validateInput(): Boolean{
        binding.nameLayout.helperText=""
        binding.ageLayout.helperText = ""
        binding.addressLayout.helperText = ""
        binding.dobLayout.helperText = ""
        if(binding.name.text.isNullOrEmpty()){
            binding.nameLayout.helperText = "Name Can't be Null"
            return false
        }
        if(binding.age.text.isNullOrEmpty()){
            binding.ageLayout.helperText = "Age Can't be Null"
            return false
        }
        if(binding.address.text.isNullOrEmpty()){
            binding.addressLayout.helperText = "Address Can't be Null"
            return false
        }
        if(binding.dob.text.isNullOrEmpty()){
            binding.dobLayout.helperText = "Date of Birth Can't be Null"
            return false
        }
        return true
    }

    private fun createUser(): User{
        return User(
            0,
            binding.name.text.toString(),
            binding.age.text.toString(),
            binding.address.text.toString(),
            binding.dob.text.toString()
        )
    }
}