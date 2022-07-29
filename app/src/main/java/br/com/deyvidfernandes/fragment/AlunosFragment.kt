package br.com.deyvidfernandes.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        return view
    }
}