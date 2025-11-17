

# 📦 App Doação

Aplicativo Android desenvolvido em **Kotlin + Firebase**, focado em permitir que usuários cadastrem, editem, listem e removam itens destinados à doação. O app conta com autenticação, integração com Firestore e interface simples para gerenciamento dos itens.

---

# 🛠️ Alterações e Melhorias Implementadas

## ✅ App de Doação de Itens

Aplicativo Android em Kotlin para cadastro, visualização e gerenciamento de itens para doação, com Firebase Authentication e Cloud Firestore.

### ✔ Validação de Campos

Correção das validações para garantir que **nome**, **quantidade** e **categoria** exibam mensagens apenas quando houver realmente campos vazios.

### ✔ Função de Salvar Item

Revisada para:

* evitar erros de inserção
* garantir que todos os dados sejam enviados corretamente
* tratar corretamente **sucesso** e **falha** na persistência do Firestore

### ✔ Atualização da Lista em Tempo Real

O adaptador é notificado após cada modificação (`notifyDataSetChanged()`), garantindo que os itens aparecem imediatamente para o usuário.

### ✔ Estrutura dos Dados

Padronização do formato dos objetos salvos no Firestore para manter total compatibilidade com a listagem, edição e exclusão.

### ✔ Organização do Código

Fluxo reestruturado para clareza e manutenção:

**Validação → Salvar → Atualizar Lista → Fechar a Tela**

---

## 🚀 Funcionalidades

### 🔐 Autenticação (Firebase Auth)

* Cadastro de usuário com e-mail e senha
* Login
* Redirecionamento automático se já estiver logado
* Logout e controle de sessão

---

### 📋 Gerenciamento de Itens (Firestore)

O usuário pode:

✔ Adicionar novos itens
✔ Editar itens existentes
✔ Remover itens
✔ Listar apenas os itens ligados ao seu próprio **userId**

Cada item contém:

* **Título**
* **Descrição**
* **Categoria**
* **ID do usuário (para filtrar no Firestore)**

---

## 🧭 Fluxo do Aplicativo

### **1. LoginActivity**

* Login ou criação de conta
* Se já estiver autenticado, vai direto para o app

### **2. MainActivity**

* Lista de itens cadastrados pelo usuário
* Botão para adicionar novos itens
* Clique em um item abre a tela de edição

### **3. EditItemActivity**

* Criar ou editar itens
* Carrega automaticamente os dados ao editar
* Botão de remover item disponível apenas no modo edição

---

## 🛠 Tecnologias Utilizadas

* **Kotlin**
* **Android SDK**
* **Firebase Authentication**
* **Firebase Firestore**
* **RecyclerView + Adapter**
* **ViewBinding**
* **FloatingActionButton**

---

## 📂 Estrutura do Projeto (Resumo)

```
app/
 ├── MainActivity.kt
 ├── LoginActivity.kt
 ├── EditItemActivity.kt
 ├── ItemAdapter.kt
 ├── Item.kt
 ├── layout/
 │     ├── activity_main.xml
 │     ├── activity_login.xml
 │     ├── activity_edit_item.xml
 │     └── item_row.xml
 └── AndroidManifest.xml
```

---

## 🔧 Como Rodar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/SEU-USUARIO/App_Doacao.git
```

### 2. Abra no Android Studio

### 3. Configure o Firebase

* Crie um projeto no Firebase
* Registre o app Android
* Baixe o **google-services.json** e coloque em:

```
app/google-services.json
```

Ative:

* Authentication (Email/Senha)
* Cloud Firestore

### 4. Compile e Execute

No emulador ou dispositivo físico.

---

## 🔥 Próximas Melhorias (para enriquecer o portfólio)

* Upload de imagens dos itens
* Filtrar por categoria / busca
* Implementar MVVM e Repository
* Dark/Light mode
* Tela dedicada de detalhes dos itens
* Migrar para ListAdapter + DiffUtil
* Publicar APK no GitHub Releases

---

## 🎯 Objetivo do Projeto

Criado para demonstrar domínio em:

* Desenvolvimento Android nativo
* CRUD com Firebase
* Estruturas de lista com RecyclerView
* Validação de dados
* Autenticação
* Boas práticas de organização de código

---

## 🙋 Autor

**Thais Rodrigues (Belganciaga)**

🔗 LinkedIn: https://www.linkedin.com/in/thayrodrigues0308/

🐙 GitHub: https://github.com/Belganciaga


