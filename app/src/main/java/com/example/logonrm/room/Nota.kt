package com.example.logonrm.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "nota")
data class Nota (
        @PrimaryKey(autoGenerate = true)
        var id: Int?,
        var descricao: String
) {
    constructor() : this(null,"")
}