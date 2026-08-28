package com.andbr.exercicio4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.andbr.exercicio4.databinding.FragmentFormTaskBinding
import com.andbr.exercicio4.ui.util.initToolbar
import com.andbr.exercicio4.ui.util.showBottomSheet
import com.andbr.exercicio4.R

class FormTaskFragment : Fragment() {

    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }

    private fun initListener(){
        binding.buttonSave.setOnClickListener {
            validateData()
        }
    }

    private fun validateData(){
        val description = binding.editTextDescricao.text.toString().trim()
        if (description.isNotBlank()){
            Toast.makeText(requireContext(), "Tudo OK!", Toast.LENGTH_SHORT).show()
        } else {
            showBottomSheet(message = getString(R.string.description_empty_form_task_fragment))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}