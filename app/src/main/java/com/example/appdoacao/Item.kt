package com.example.appdoacao

import com.google.firebase.firestore.DocumentId

data class Item(
    @DocumentId // Anotação para que o Firestore popule o ID do documento aqui
    val id: String? = null,
    val title: String? = null,
    val description: String? = null,
    val category: String? = null,
    val userId: String? = null // Para saber quem doou
)