package com.example.appdoacao

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    private val firestore = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val listaItens = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // BOTÃO +
        findViewById<FloatingActionButton>(R.id.fabAddItem).setOnClickListener {
            startActivity(Intent(this, EditItemActivity::class.java))
        }

        // LISTA
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemAdapter = ItemAdapter(listaItens) { item ->
            val intent = Intent(this, EditItemActivity::class.java)
            intent.putExtra("ITEM_ID", item.id)
            startActivity(intent)
        }

        recyclerView.adapter = itemAdapter
    }

    override fun onResume() {
        super.onResume()
        carregarItens()
    }

    private fun carregarItens() {
        val userId = auth.currentUser?.uid ?: return

        firestore.collection("items")
            .whereEqualTo("userId", userId)  // SOMENTE ITENS DO USUÁRIO
            .get()
            .addOnSuccessListener { result ->

                val itens = result.toObjects(Item::class.java) // 🔥 ID vem automático!

                listaItens.clear()
                listaItens.addAll(itens)

                itemAdapter.updateData(listaItens)
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }
    }
}
