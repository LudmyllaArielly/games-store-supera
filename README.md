## Games Store
  O projeto consiste em um Desafio proposto pela Supera Inovação em Tecnologia, onde é 
preciso construir uma camada de serviço como exemplo de um ecommerce de games, 
utlizando linguagem de programação Java.

### Requisitos
  - Existe um exemplo de carga de banco de dados em memória em ProductDAoExampleTest.java
  - Os valores exibidos no checkout (frete, subtotal e total) devem ser calculados dinamicamente
  - O usuário poderá adicionar e remover produtos do carrinho
  - O usuário poderá ordenar os produtos por preço, popularidade (score) e ordem alfabética.
  - A cada produto adicionado, deve-se somar R$ 10,00 ao frete.
  - O frete é grátis para compras acima de R$ 250,00 (sem o frete dos demais produtos)

### Tecnologias usadas:
  - Spring framework
  - Swagger
  - MapStruct
  - Maven
  - Linguagem de programação java
  - Mysql

### Porque usar spring framework
  É framework que facilita bastante o desenvolvimento, deixa o código mais limpo e légivel além disso,
proporciona várias ferramentas embutidas, é mais fácil de manter, possui anotations muito eficientes e 
acelera a produtividade.

### Porque usar Swagger
  O swagger é um framework para descrição de consumo de apis restfull, além de ser mais fácil documentar
utlizando o swagger, ele também gera as estruturas json automáticamente que acelera o desenvolvimento.

### Porque usar mapstruct
  Mapstruct é um gerador de código que facilita muito o desenvolvimento, evitando grande blocos de códigos,
desorganizaçâo deixando mais prático a conversão de (Data Transfer Object) dto.

### Iniciando
git clone https://github.com/LudmyllaArielly/games-store-supera \
cd game-store-supera

### Pré-requisitos
mvn --version\
Ver a indicação da versão do mavem instalada como também, a versão do JDK, dentre outras.\
Esses requisistos são obrigátorios,assim é necessário definir corretamentecas variáveis de ambiente JAVA_HOME E M2_HOME.

### Compilar
-mvn compile\
Esse comando compila o projeto e deposita resultados no diretório target.

### Empacontando o projeto
- mvn package\
Gera o arquivo games-store-supera-jar no diretório target, esse arquivo não é executável. Para verificar o conteúdo do arquivo execute o comando jar vft.

- mvn package -P executavel-dir\
Gera o arquivo games-store-supera.jar, executável. Para executar utilize o comando java -jar target/games-store-supera-dir.jar

- mvn package -P api\
Gera arquivo executável em conjunto com todas as dependências juntas em um único arquivo target/api.jar

### Executando a aplicação e a RESTFul API
  Para executar a aplicação utilize o comando java -jar target/api.jar ou mvn spring-boot:run. Desssa forma, 
é colocada em execução a Api gerada por mvn package -P Api na porta 8080.\
Exemplo de endereço:http://localhost:8080/carts

### A Api Games Store conta com os seguintes end-points
##### cart-resource 
*/carts listAllCart\
*/carts addItems\
*/carts removeItens\
*/carts/{id} findByCart\
*/carts/{id} addMoreItems\
*/carts/{id} checkout

##### product-resource 
*/products/orderbyalphabetical\
*/products/orderbyprice\
*/products/orderbyscore

### Informações extras
Contém um file de insert de produtos.\
caminho src/main/resources/products-insert.file


