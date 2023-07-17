# Exercicio modulo-04
Repositório criado para entrega da atividade de banco de dados do programa Catalisa.

## Exercício proposto
O império continua sua luta incessante de dominar a galáxia, tentando ao máximo expandir
seu território e eliminar os rebeldes.
Você, como um soldado da resistência, foi designado para desenvolver um sistema para
compartilhar recursos entre os rebeldes.

### A aplicação permite:
- Consultar todos os rebeldes do banco de dados:
  
  Retorna todos os rebeldes cadastrados no banco de dados e suas respectivas informações (id, nome, idade, gênero, localização e se é um rebelde traidor).
  
- Cadastrar novo rebelde no bando de dados:

  Permite o cadastro de novo rebelde, solicitando os seguintes dados ao usuário: nome, idade, gênero e localização.
  
- Atualizar localização de rebelde:

  Permite atualizar a localização de determinado rebelde, solicitando ao usuário o id do rebelde que será atualizado e a nova localização.
  
- Reportar rebelde como traidor:

  Permite reportar um rebelde como traidor, solicitando o id do rebelde que será reportado. Após três reportes para o mesmo rebelde ele é marcado como traidor em suas informações.
  
- Consultar rebeldes traidores:

  Retorna as informações de todos os rebeldes marcados como traidor.
  
- Adicionar recurso a rebelde:

  Permite adicionar recursos (arma,munição, comida e água) a determinado rebelde, solicitando o id do rebelde e id do recurso.
  
- Consultar recursos de rebelde:

  Permite consultar os recursos de determinado rebelde, solicitando o id do rebelde que deseja verificar os recursos.
  
- Deletar rebelde do banco de dados:

  Permite deletar rebelde do banco de dados, solicitando o id do rebelde a ser deletado.

## Ferramentas utilizadas:
- Liguagem Java
- Idea IntelliJ
- DBeaver - para banco de dados postgresql
- Docker - para rodar imagem postgresql

## Conteúdos estudados e aplicados
- Conceitos de POO;
- Princípios de SOLID;
- Estruturas de decisão: if, if-else, switch;
- Estruturas de repetição: do-while;
- Postgresql: banco de dados relacional.
