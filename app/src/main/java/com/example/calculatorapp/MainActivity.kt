package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // setting the main-view binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        // creating the arrays for the dropdown lists
        val elemset1 = arrayOf("Sodium", "Magnesium", "Chlorine", "Calcium")
        val elemset2 = arrayOf("Hydrogen", "Carbon", "Nitrogen", "Oxygen")

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // calling the popup functions for displaying instructions
        popup()

        //creating and setting of adapters, for viewing
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, elemset1) //adapter for 1st spinner
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, elemset2) //adapter for 2nd spinner

        //saving the button in a variable bby id
        var btn1 = findViewById(R.id.btn) as Button

        //saving the spinner values in a variable by id
        var spinner1 = findViewById(R.id.elements1) as Spinner  //spinner 1
        var spinner2 = findViewById(R.id.elements2) as Spinner  //spinner 2


        // combining the 1st spinner with adapter
        spinner1.adapter = adapter
        spinner1.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (spinner1.selectedItemPosition==0) {
                    binding.elem1.setText("" + spinner1.selectedItem) // Sodium
                }

                if (spinner1.selectedItemPosition==1) {
                    binding.elem1.setText("" + spinner1.selectedItem) // Magnesium
                }

                if (spinner1.selectedItemPosition==2) {
                    binding.elem1.setText("" + spinner1.selectedItem)  // Chlorine
                }

                if (spinner1.selectedItemPosition==3) {
                    binding.elem1.setText("" + spinner1.selectedItem) // Calcium
                }
            }
        }


        // combining the 2nd spinner with adapter
        spinner2.adapter = adapter2
        spinner2.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (spinner2.selectedItemPosition==0) {
                    binding.elem2.setText("" + spinner2.selectedItem) // Hydrogen
                }

                if (spinner2.selectedItemPosition==1) {
                    binding.elem2.setText("" + spinner2.selectedItem) // Carbon
                }

                if (spinner2.selectedItemPosition==2) {
                    binding.elem2.setText("" + spinner2.selectedItem) // Nitrogen
                }

                if (spinner2.selectedItemPosition==3) {
                    binding.elem2.setText("" + spinner2.selectedItem) // Oxygen
                }
            }
        }

        // displaying the results of each combination

        btn1.setOnClickListener {
            if (spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 0) { // Sodium + Hydrogen
                binding.result.setText("The result is Sodium Hydride. ")
            }

            if (spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 1) { // Sodium + Carbon
                binding.result.setText("The result is Sodium Carbonate and Sodium Carbide (reacts with CO).")
            }

            if (spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 2) { // Sodium + Nitrogen
                binding.result.setText("The result is NO REACTION.")
            }

            if (spinner1.selectedItemPosition == 0 && spinner2.selectedItemPosition == 3) { // Sodium + Oxygen
                binding.result.setText("The result is Sodium Oxide.")
            }

            if (spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 0) {  // Magnesium + Hydrogen
                binding.result.setText("The result is Magnesium Hydride.")
            }

            if (spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 1) { // Magnesium + Carbon
                binding.result.setText("The result is Magnesium Oxide + Carbon.")
            }

            if (spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 2) { // Magnesium + Nitrogen
                binding.result.setText("The result is Magnesium Nitride. ")
            }

            if (spinner1.selectedItemPosition == 1 && spinner2.selectedItemPosition == 3) { // Magnesium + Oxygen
                binding.result.setText("The result is Magnesium OXide. ")
            }

            if (spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 0) { // Chlorine + Hydrogen
                binding.result.setText("The result is Hydrogen Chloride.")
            }

            if (spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 1) { // Chlorine + Carbon
                binding.result.setText("The result is Carbon Tetrachloride.")
            }

            if (spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 2) { // Chlorine + Nitrogen
                binding.result.setText("The result is Dinitrogen Trichloride. ")
            }

            if (spinner1.selectedItemPosition == 2 && spinner2.selectedItemPosition == 3) { // Chlorine + Oxygen
                binding.result.setText("The result is NO REACTION.")
            }

            if (spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 0) { // Calcium + Hydrogen
                binding.result.setText("The result is Calcium Hydroxide.")
            }

            if (spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 1) { // Calcium + Carbon
                binding.result.setText("The result is  Calcium Carbonate.")
            }

            if (spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 2) { // Calcium + Nitrogen
                binding.result.setText("The result is Calcium Nitride.")
            }

            if (spinner1.selectedItemPosition == 3 && spinner2.selectedItemPosition == 3) { // Calcium + Oxygen
                binding.result.setText("The result is Calcium Oxide.")
            }
        }
    }

    private fun popup() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Welcome to ChemClimax!")
            .setMessage("This application will help you combine different elements get their reactions. You can combine the solids with gases and find out their results when combined.")
            .setNegativeButton("Got it! Start App") {
                dialog, which ->
                dialog.dismiss()
            }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}