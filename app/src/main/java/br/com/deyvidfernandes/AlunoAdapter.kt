package br.com.deyvidfernandes

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.deyvidfernandes.database.Aluno
import br.com.deyvidfernandes.database.AppDatabase

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

        holder.itemView.setOnClickListener {
            val builder = AlertDialog.Builder(holder.itemView.context)
            builder.setMessage(R.string.tem_certeza_que_deseja_excluir)
                            .setCancelable(false)
                            .setPositiveButton(R.string.sim) { dialog, id ->
                                // Delete selected note from database
                                val appDb = AppDatabase.getDatabase(holder.itemView.context)
                                appDb.alunoDao().delete(aluno)

                                holder.itemView.findNavController().navigate(R.id.alunosFragment)
                            }
                            .setNegativeButton(R.string.nao) { dialog, id ->
                                dialog.dismiss()
                            }
            val alert = builder.create()
            alert.show()
        }
    }

    //Retorna o tamanho da lista
    override fun getItemCount(): Int {
        return dataSet.size
    }
}