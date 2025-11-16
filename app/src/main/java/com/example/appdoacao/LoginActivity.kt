package com.example.appdoacao

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.example.appdoacao.databinding.ActivityLoginBinding // ✅ Corrigido

class LoginActivity : AppCompatActivity() {

    // 1. Declarar o ViewBinding
    private lateinit var binding: ActivityLoginBinding
    // 2. Declarar o Firebase Auth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 3. Inflar o layout com ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 4. Inicializar o Firebase Auth
        auth = Firebase.auth

        // 5. Configurar cliques dos botões
        binding.btnLogin.setOnClickListener {
            loginUser()
        }

        binding.btnRegister.setOnClickListener {
            registerUser()
        }
    }

    // 6. Função para verificar se o usuário já está logado
    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // Usuário já logado, vá para a MainActivity
            goToMainActivity()
        }
    }

    // 7. Função de Cadastro
    private fun registerUser() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Email e Senha devem ser preenchidos.", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Cadastro com sucesso, vá para a MainActivity
                    Toast.makeText(baseContext, "Cadastro realizado com sucesso.", Toast.LENGTH_SHORT).show()
                    goToMainActivity()
                } else {
                    // Se falhar, mostre uma mensagem
                    Toast.makeText(baseContext, "Falha no cadastro: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    // 8. Função de Login
    private fun loginUser() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Email e Senha devem ser preenchidos.", Toast.LENGTH_SHORT).show()
            return
        }

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login com sucesso, vá para a MainActivity
                    goToMainActivity()
                } else {
                    // Se falhar, mostre uma mensagem
                    Toast.makeText(baseContext, "Falha no login.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    // 9. Função helper para navegar
    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Fecha a LoginActivity para não voltar
    }
}