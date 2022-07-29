package br.com.deyvidfernandes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlunoAdapter (private val dataSet: List<Aluno>): RecyclerView.Adapter<AlunoAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewAluno: TextView
        val textViewCurso: TextView
        val textViewTurma: TextView

        init {
            textViewAluno = view.findViewById(R.id.textViewAluno)
            textViewCurso = view.findViewById(R.id.textViewCurso)
            textViewTurma = view.findViewById(R.id.textViewTurma)
        }
    }

    //Define o layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.recyclerview_aluno, parent, false)

        return ViewHolder(view)
    }

    //De/Para Objeto para o layout
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val aluno = dataSet[position]
        holder.textViewAluno.text = aluno.nome
        holder.textViewCurso.text = aluno.curso
        holder.textViewTurma.text = aluno.turma
    }

    //Retorna o tamanho da lista
    override fun getItemCount(): Int {
        return dataSet.size
    }
}