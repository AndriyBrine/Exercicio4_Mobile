package com.andbr.exercicio4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.andbr.exercicio4.data.model.Status
import com.andbr.exercicio4.data.model.Task
import com.andbr.exercicio4.databinding.FragmentTodoBinding
import com.andbr.exercicio4.ui.adapter.TaskAdapter

class TodoFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initRecyclerViewTask(getTask())
    }

    private fun initListeners() {
        // Configurações de clique de botões adicionais, se houver
    }

    private fun initRecyclerViewTask(taskList: List<Task>) {
        taskAdapter = TaskAdapter(requireContext(), taskList) { task, option ->
            optionSelected(task, option)
        }
        binding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTask.setHasFixedSize(true)
        binding.recyclerViewTask.adapter = taskAdapter
    }

    private fun optionSelected(task: Task, option: Int) {
        when (option) {
            TaskAdapter.SELECT_REMOVER -> {
                Toast.makeText(requireContext(), "Removendo ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_EDIT -> {
                Toast.makeText(requireContext(), "Editando ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_DETAILS -> {
                Toast.makeText(requireContext(), "Detalhes ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_NEXT -> {
                Toast.makeText(requireContext(), "Próximo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getTask() = listOf(
        Task(id = "0", description = "Criar nova tela do app", Status.TODO),
        Task(id = "1", description = "Validar informações na tela de login", Status.TODO),
        Task(id = "2", description = "Adicionar nova funcionalidade no app", Status.TODO),
        Task(id = "3", description = "Salvar token localmente", Status.TODO),
        Task(id = "4", description = "Criar funcionalide de logout no app", Status.TODO)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}