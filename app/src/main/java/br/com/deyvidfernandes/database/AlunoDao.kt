package br.com.deyvidfernandes.database

import androidx.room.*

@Dao
interface AlunoDao {
    @Query("SELECT * FROM aluno ORDER BY nome ASC")
    fun getAll(): List<Aluno>;

    @Insert
    fun insert(vararg aluno: Aluno)

    @Update
    fun update(aluno: Aluno)

    @Delete
    fun delete(aluno: Aluno)
}