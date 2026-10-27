package com.andbr.exercicio4.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task (
    var id: String = "",
    var description: String = "",
    // Por padrão, toda nova tarefa é criada com o status TODO.
    var status: Status = Status.TODO
): Parcelable