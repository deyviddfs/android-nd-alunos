package br.com.deyvidfernandes.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.deyvidfernandes.Aluno
import br.com.deyvidfernandes.AlunoAdapter
import br.com.deyvidfernandes.databinding.FragmentAlunosBinding

class AlunosFragment : Fragment() {

    var alunos = mutableListOf<Aluno>(
        Aluno("Martin Theo da Costa", "15158", "Ciência da Computação", "2022", "3CCF"),
        Aluno("Isaac Raimundo Roberto Mendes", "16528", "Ciência da Computação", "2022", "3CCF"),
        Aluno("Cláudio Gabriel Melo", "15833", "Ciência da Computação", "2022", "3CCF"),
        Aluno("Henry Carlos Nicolas Gomes", "18476", "Ciência da Computação", "2022", "3CCF"),
        Aluno("Bernardo Marcos da Cunha", "15228", "Ciência da Computação", "2022", "3CCF"),
        Aluno("Noah Manuel Isaac Jesus", "15988", "Ciência da Computação", "2022", "3CCF")
    )

    lateinit var binding: FragmentAlunosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlunosBinding.inflate(inflater, container, false)
        val view = binding.root

        val recyclerView = binding.recyclerView //findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = AlunoAdapter(alunos)

        val itemDecor = DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)

        return view
    }
}