package br.com.deyvidfernandes.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.deyvidfernandes.AlunoAdapter
import br.com.deyvidfernandes.database.AppDatabase
import br.com.deyvidfernandes.databinding.FragmentAlunosBinding

class AlunosFragment : Fragment() {

    lateinit var binding: FragmentAlunosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlunosBinding.inflate(inflater, container, false)
        val view = binding.root
        val recyclerView = binding.recyclerView
        val appDb = AppDatabase.getDatabase(view.context);
        var alunos = appDb.alunoDao().getAll();
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = AlunoAdapter(alunos)

        val itemDecor = DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)

        return view
    }
}