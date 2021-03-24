# Game Store BR

###  Sistema de cadastro de compradores e vendedores onde é possível registrar um catálogo de produtos bem como compras realizadas. As compras podem ser realizadas por diferentes formas de pagamento.

  
**Funcionalidades do sistema:**

- **Cadastrar Comprador:** Cadastra um comprador ao informar o nome, CPF e saldo inicial. Não podem existir dois compradores com o mesmo CPF.
 
- **Listar Compradores:** Exibe na tela uma lista com informações resumidas dos compradores cadastrados no sistema, contendo os dados pessoais, compras e valores a pagar.
- **Consultar Comprador:** Realiza a consulta dos dados de um comprador ao informar o seu CPF. 
 
- **Cadastrar Vendedor:** Cadastra um vendedor ao informar o nome e CNPJ. Não podem existir dois vendedores com o mesmo CNPJ.
 
- **Listar Vendedores:** Exibe na tela uma lista com informações resumidas dos vendedores cadastrados no sistema, contendo os dados pessoais, vendas, valores a receber e catálogo de produtos.
 
- **Consultar Vendedor:** Exibe os dados de um vendedor ao informar o seu CNPJ. 
 
- **Cadastrar Produto:** Cadastra um produto ao informar o CPNJ do vendedor que contém o catálogo de destino, nome e valor do produto.
 
- **Registrar Transação Comercial:** Registra uma transação do tipo compra/venda ao informar o CPF do comprador, CNPJ do vendedor e escolher a lista de produtos e a forma de pagamento. Neste caso, de acordo com o meio de pagamento, a transação atualiza o saldo, os valores a pagar e as compras realizadas do comprador informado, assim como o saldo, os valores a receber e as vendas realizadas do vendedor informado.

**Conceitos do sistema:**

- **Formas de Pagamento:**

  - PIX: Instantaneamente debita o valor da conta do comprador e deposita na conta do vendedor.

  - Boleto: Verifica se a data de vencimento do boleto não foi excedida. Instantaneamente debita o valor da conta do comprador e adiciona nos valores a receber do vendedor, descontado do valor para emissão do boleto.

  - Débito: Instantaneamente debita o valor da conta do comprador e deposita na conta do vendedor, descontado da taxa percentual de cobrança da operadora do cartão.

  - Crédito: Coloca o valor na lista de valores a pagar do comprador e adiciona nos valores a receber do vendedor, descontado da taxa percentual de cobrança da operadora do cartão.

- **Compra/Venda**:
  - CPF Comprador
  - CNPJ do Vendedor
  - Forma de Pagamento
  - Produtos
  
- **Comprador**
  - Nome
  - CPF
  - Saldo da conta
  - Valores a pagar
  - Compras realizadas

- **Vendedor**
  - Nome
  - Saldo da conta
  - Valores a receber
  - Vendas realizadas
  - Catálogo de produtos
  
- **Produto**
  - Código
  - Nome
  - Preço

> To Do: 

> Formatar impressões de acordo com padrões tabelados.

> Tratar exceções de tipo de variável inseridas nos menus.

> Validar formatos de CPF, CNPJ.

> Tratar exceções utilizando Exceptions
