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
import com.andbr.exercicio4.databinding.FragmentDoneBinding
import com.andbr.exercicio4.ui.adapter.TaskAdapter

class DoneFragment : Fragment() {

    private var _binding: FragmentDoneBinding? = null
    private val binding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViewTask(getTask())
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
            TaskAdapter.SELECT_BACK -> {
                Toast.makeText(requireContext(), "Voltar ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_REMOVER -> {
                Toast.makeText(requireContext(), "Removendo ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_EDIT -> {
                Toast.makeText(requireContext(), "Editando ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_DETAILS -> {
                Toast.makeText(requireContext(), "Detalhes ${task.description}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getTask() = listOf(
        Task(id = "9", description = "Finalizar documentação do projeto", Status.DONE)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}