## Vote no Restaurante
[ ![Codeship Status for elvisgs/vote-no-restaurante](https://codeship.com/projects/d53edfe0-1c61-0133-0a97-6a4c1bb6d98c/status?branch=master)](https://codeship.com/projects/94695)

### Requisitos
- Java 8
- Maven 3

### Bibliotecas e frameworks utilizados
- JPA/Hibernate
- vRaptor + JSP
- JUnit + AssertJ + Mockito
- Bootstrap

### Testes
O status da build pode ser visto no Codeship ou para rodar os testes localmente:
`mvn -B test`

### Execução
- `mvn jetty:run`
- Acesse http://localhost:8080/vote-no-restaurante
