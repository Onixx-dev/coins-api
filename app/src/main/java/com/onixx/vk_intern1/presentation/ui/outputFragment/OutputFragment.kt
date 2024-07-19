package com.onixx.vk_intern1.presentation.ui.outputFragment

import android.os.Bundle
import android.util.Log
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
import androidx.fragment.app.Fragment
import com.onixx.vk_intern1.MainViewModel
import com.onixx.vk_intern1.R
import com.onixx.vk_intern1.presentation.ui.inputFragment.InputFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class OutputFragment : Fragment() {

    companion object {
        fun newInstance() = InputFragment()
    }

    private val viewModel by viewModel<MainViewModel>()
    lateinit var button : Button

    private lateinit var resultsTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_output, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultsTextView = view.findViewById(R.id.fragmentResultTextView)
    }




}