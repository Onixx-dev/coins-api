package com.onixx.vk_intern1.presentation.ui.inputFragment

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.onixx.vk_intern1.MainViewModel
import com.onixx.vk_intern1.R
import com.onixx.vk_intern1.presentation.ResultActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class InputFragment : Fragment() {

    companion object {
        fun newInstance() = InputFragment()
    }

    private val viewModel by viewModel<MainViewModel>()

    private lateinit var spinnerInput: Spinner
    private lateinit var spinnerOutput: Spinner
    private lateinit var buttonConvert: Button
    private lateinit var buttonActivity: Button
    private lateinit var inputText: EditText
    private lateinit var outputText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val view = inflater.inflate(R.layout.fragment_input, container, false)




        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinners(view)
        initButtons(view)
        initTextViews(view)

    }


    fun initSpinners(view: View) {
        spinnerInput = view.findViewById(R.id.spinner1)
        viewModel.moneyUnits.observe(viewLifecycleOwner) {
            val adapter = ArrayAdapter(
                view.context,
                android.R.layout.simple_spinner_item,
                viewModel.moneyUnits.value!!.data.keys.toList()
            )
            spinnerInput.adapter = adapter
        }

        spinnerInput.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                viewModel.base = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }



        spinnerOutput = view.findViewById(R.id.spinner2)
        viewModel.moneyUnits.observe(viewLifecycleOwner) {
            val adapter = ArrayAdapter(
                view.context,
                android.R.layout.simple_spinner_item,
                viewModel.moneyUnits.value!!.data.keys.toList()
            )
            spinnerOutput.adapter = adapter
        }

        spinnerOutput.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                viewModel.currense = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }

    fun initButtons(view: View) {
        buttonConvert = view.findViewById(R.id.button_fragment)
        buttonConvert.setOnClickListener {
            try {
                viewModel.inputValue = inputText.text.toString().toDouble()
                viewModel.exchangeModifier.observe(viewLifecycleOwner){
                    resultToFragment(view)
                }
                viewModel.convert()
            } catch (ex: Exception) {
                Toast.makeText(this.context, ex.message, Toast.LENGTH_SHORT).show()
            }

        }


        buttonActivity = view.findViewById(R.id.button_activity)
        buttonActivity.setOnClickListener {
            try {
                viewModel.inputValue = inputText.text.toString().toDouble()
                viewModel.exchangeModifier.observe(viewLifecycleOwner){
                    resultToActivity(view)
                }
                viewModel.convert()
            } catch (ex: Exception) {
                Toast.makeText(this.context, ex.message, Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun initTextViews(view: View) {
        inputText = view.findViewById(R.id.input1)

        outputText = view.findViewById(R.id.input2)
        viewModel.exchangeModifier.observe(viewLifecycleOwner) {
            outputText.setText(viewModel.outputValue.toString())
        }


    }

    fun resultToFragment(view: View) {
        val fragmentBelongActivity = activity
        val fragmentManager = fragmentBelongActivity?.supportFragmentManager
        val rightFragment = fragmentManager?.findFragmentById(R.id.fragment2)
        val rightFragmentTextView = rightFragment?.view?.findViewById<TextView>(R.id.fragmentResultTextView)
        rightFragmentTextView?.text = "${viewModel.inputValue} ${viewModel.base} = ${viewModel.outputValue} ${viewModel.currense}"
    }

    fun resultToActivity(view: View) {
        val randomIntent = Intent(this.context, ResultActivity::class.java)
        randomIntent.putExtra(
            "result",
            "${viewModel.inputValue} ${viewModel.base} = ${viewModel.outputValue} ${viewModel.currense}"
        )
        startActivity(randomIntent)
    }

}