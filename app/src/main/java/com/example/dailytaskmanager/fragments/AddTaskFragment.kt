// src/main/java/com/example/dailytaskmanager/fragments/AddTaskFragment.kt
package com.example.dailytaskmanager.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.dailytaskmanager.R

class AddTaskFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)

        val spinner = view.findViewById<Spinner>(R.id.spinnerPriority)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.priority_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        view.findViewById<Button>(R.id.btnSaveTask).setOnClickListener {
            Toast.makeText(requireContext(), "Task Saved", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return view
    }
}
