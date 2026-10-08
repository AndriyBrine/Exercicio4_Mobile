package com.andbr.exercicio4.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.andbr.exercicio4.R
import com.andbr.exercicio4.databinding.FragmentSplashBinding
import com.google.firebase.auth.FirebaseAuth


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    // lateinit permite criar uma variável nula (assim como a ?)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Autenticação com o serviço Firebase
        auth = FirebaseAuth.getInstance()

        Handler(Looper.getMainLooper()).postDelayed({checkAuth()}, 3000)
    }

    private fun checkAuth(){
        try {
            // Representa o usuário autenticado no Firebase
            val currentUser = auth.currentUser

            if(currentUser!=null){
                // Logado
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            } else {
                // Desligado
                findNavController().navigate(R.id.action_splashFragment_to_autentication)
            }
        } catch (e: Exception){
            Toast.makeText(requireContext(), e.message.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}