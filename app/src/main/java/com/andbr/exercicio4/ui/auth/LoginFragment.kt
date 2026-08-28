package com.andbr.exercicio4.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.andbr.exercicio4.R
import com.andbr.exercicio4.databinding.FragmentLoginBinding
import com.andbr.exercicio4.databinding.FragmentRegisterBinding
import com.andbr.exercicio4.ui.util.showBottomSheet
import kotlinx.serialization.Required


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener(){
        binding.buttonLogin.setOnClickListener {
            validateData()
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnRecover.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)
        }

    }

    private fun validateData(){
        val email = binding.edittextEmail.text.toString().trim()
        val senha = binding.edittextSenha.text.toString().trim()
        if (email.isNotBlank()){
            if(senha.isNotBlank()){
                // Comentário temporário somente para testar a validação dos dados
                findNavController().navigate(R.id.action_global_homeFragment)
            } else {
                showBottomSheet(message = getString(R.string.password_empty))
            }
        } else {
            showBottomSheet(message = getString(R.string.email_empty))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}