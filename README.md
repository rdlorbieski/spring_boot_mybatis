
# README - Solução de Inserção de Estatísticas


Este repositório contém uma solução de exemplo para inserção de dados estatísticos em uma tabela PostgreSQL usando Spring Boot e MyBatis. A solução inclui um controlador REST, um serviço, um mapper MyBatis e uma classe DTO para representar os dados estatísticos.



## Pré-requisitos

Antes de executar esta solução, certifique-se de ter o seguinte instalado e configurado:

## Tópicos
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/) configurado com a tabela 'statistic' conforme especificada abaixo:

```sql
CREATE TABLE IF NOT EXISTS public.statistic
(
id bigint NOT NULL DEFAULT nextval('statistic_id_seq'::regclass),
max double precision NOT NULL,
mean double precision NOT NULL,
median double precision NOT NULL,
min double precision NOT NULL,
CONSTRAINT statistic_pkey PRIMARY KEY (id)
);
```

- Um ambiente de desenvolvimento integrado (IDE) de sua escolha, como Eclipse ou IntelliJ IDEA.Um ambiente de desenvolvimento integrado (IDE) de sua escolha, como Eclipse ou IntelliJ IDEA.


## Configuração
### 1. Configuração do Banco de Dados
Certifique-se de que o PostgreSQL esteja configurado e em execução com a tabela statistic criada conforme especificado acima. Você também deve configurar a conexão com o banco de dados no arquivo application.yml (ou .properties) com as informações corretas:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/seu-banco-de-dados
    username: seu-usuario
    password: sua-senha
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  application:
    name: NomeDoSeuAplicativo

mybatis:
  mapper-locations: classpath:mapper/*.xml
```

### 2. Execução da Aplicação
Você pode executar a aplicação usando sua IDE ou através da linha de comando com o Maven:
```bash
    mvn spring-boot:run
```
A aplicação estará disponível em http://localhost:8080.


## Uso

### Inserção de Estatísticas

Para inserir dados estatísticos, você pode usar uma chamada REST POST com um corpo JSON. Use a seguinte URL:

```bash
    POST http://localhost:8080/statistics/inserir
```

Exemplo de corpo JSON:

```json
    {
    	"max": 6.0,
      "mean": 3.4,
    	"median": 3.0,
    	"min": 1.0	
    }
```
