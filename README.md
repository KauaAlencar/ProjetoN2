# ✅ **QuickShop — Sistema de E-commerce em Java**

O **QuickShop** é um sistema simples de e-commerce desenvolvido em **Java**, com foco no aprendizado e aplicação prática de conceitos de **Programação Orientada a Objetos (POO)**.

O sistema foi pensado para simular as principais funcionalidades de uma loja virtual: **cadastro de clientes**, **cadastro de produtos**, **realização de pedidos** e **consulta de histórico de compras**.

---

## 📝 **Descrição do projeto**

A ideia foi criar uma estrutura enxuta, porém completa, que representasse de forma didática como funciona o fluxo básico de um e-commerce. Todas as interações são feitas via **console**, através de menus intuitivos.

### ✅ Fluxo do sistema:

* **Menu inicial:**

  * O usuário pode se identificar como **cliente** ou como **administrador**.

* **Cliente:**

  * Pode realizar login com seu ID ou, caso ainda não seja cadastrado, efetuar um **cadastro simples** informando nome, e-mail, telefone e endereço.
  * Após se identificar, o cliente tem acesso a um menu com as opções de:

    * **Ver Catálogo de Produtos:** Exibe todos os produtos disponíveis, com informações de código, descrição, preço e estoque.
    * **Fazer Novo Pedido:** Permite selecionar produtos e quantidades, verificando a disponibilidade em estoque. O estoque é atualizado automaticamente após o pedido.
    * **Ver Meus Pedidos:** Lista todos os pedidos realizados pelo cliente, com os detalhes de cada um.

* **Administrador:**

  * Pode realizar o **cadastro de novos produtos**, informando fabricante, descrição, preço unitário e quantidade em estoque.
  * O sistema gera automaticamente um **código sequencial** para cada novo produto cadastrado.

---

## 💡 **Decisões de implementação**

* Utilizei classes para representar cada elemento essencial do sistema:

  * `Cliente`: armazena informações pessoais e gera um ID único automaticamente.
  * `Produto`: armazena dados do produto e gera um código único.
  * `Item`: representa um produto dentro de um pedido, associando quantidade e preço no momento da compra.
  * `Pedido`: armazena a lista de itens comprados e calcula o valor total.
  * `Loja`: centraliza e gerencia as coleções de clientes, produtos e pedidos, além de fornecer métodos auxiliares como busca e cadastro.

* Para armazenar os dados, optei pelo uso de **ArrayLists**, que são estruturas dinâmicas e fáceis de manipular.

* O fluxo do sistema foi organizado para ser **intuitivo e linear**, simulando uma experiência próxima de um usuário interagindo com um sistema real, mas sem complicar com autenticações ou persistência de dados em arquivos/bancos de dados.

* Todo o **controle de estoque** é feito automaticamente: ao realizar um pedido, o estoque do produto é reduzido conforme a quantidade solicitada.

* A **geração automática de IDs e códigos** foi uma decisão importante para garantir a unicidade e simplificar a lógica de cadastro.

---

## 🎯 **Aprendizados com o projeto**

Esse projeto me ajudou a:

* Consolidar o entendimento sobre **Orientação a Objetos**, especialmente na criação de classes e na definição de métodos.
* Praticar a **associação entre classes**, modelando relações como Cliente → Pedido → Item → Produto.
* Trabalhar com **coleções dinâmicas** (`ArrayList`) e percorrê-las para buscas e exibições.
* Criar **fluxos de interação via console**, estruturando menus claros e utilizando controle de fluxo com condicionais e loops.
* Implementar e validar **regras de negócio**, como:

  * Não permitir realizar um pedido se a quantidade for maior do que o estoque disponível.
  * Não cadastrar produtos com preço negativo ou estoque inválido.

---

## ⚙️ **Possíveis melhorias**

* Implementar **persistência de dados**, salvando clientes, produtos e pedidos em arquivos ou banco de dados.
* Criar uma **interface gráfica** para deixar a interação mais amigável.
* Adicionar **autenticação** para o administrador, garantindo maior segurança no cadastro de produtos.
* Permitir ao cliente **alterar seus dados cadastrais** ou **cancelar pedidos**.

---

Esse projeto foi uma ótima oportunidade de aplicar, de forma prática e concreta, os principais conceitos de programação que venho estudando, além de exercitar minha capacidade de modelar sistemas e resolver problemas de forma lógica.
