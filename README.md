# App de Doação de Itens

Aplicativo Android em Kotlin para cadastro, visualização e gerenciamento de itens para doação, com Firebase Authentication e Cloud Firestore.

## Alterações Realizadas

- **Validação de campos**  
  Corrigida a leitura de nome, quantidade e categoria para que a mensagem de preenchimento apareça apenas quando necessário.

- **Função de salvar item**  
  Revisada para prevenir erros de inserção, garantir envio completo dos dados e tratar sucesso/falha corretamente.

- **Atualização da lista**  
  Adaptador notificado após alterações (`notifyDataSetChanged()`), garantindo que os itens apareçam em tempo real.

- **Estrutura dos dados**  
  Padronizado o formato dos objetos no Firestore para compatibilidade com a listagem.

- **Organização do código**  
  Reestruturado o fluxo: **Validação → Salvar → Atualizar lista → Fechar tela** para maior clareza e manutenção.
