# Desafio-B2W
Utilizei o Spring Boot 2.3.1 para desenvolver a API e o banco de dados MongoDB Community 4.2.8. O arquivo Planetas.csv presente na raiz do projeto contém todos os planetas com nome, clima, terreno e aparições. 

A tabela abaixo inclui todas as rotas da API e suas funcionalidades:

|Funcionalidade                     |Rota                                           |Método HTTP |
|-----------------------------------|-----------------------------------------------|------------|
|Adiciona um novo planeta           |http://localhost:8080/api/planetas             |POST        |
|Lista todos os planetas            |http://localhost:8080/api/planetas             |GET         |
|Busca um planeta pelo nome         |http://localhost:8080/api/planetas/nome/{nome} |GET         |
|Busca um planeta pelo id           |http://localhost:8080/api/planetas/{id}        |GET         |
|Remove um planeta pelo seu id      |http://localhost:8080/api/planetas/{id}        |DELETE      |
