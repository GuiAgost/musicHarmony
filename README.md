# <p align="center"><img src="https://user-images.githubusercontent.com/76624588/205338718-cda225e0-8e8e-4a8c-a89d-2060ad5882ae.png" width="300" hedight="700"></p>

🎶 **musicHarmony** é um sistema web para aprendizado de teoria musical básica, desenvolvido como parte do TCC II. O projeto utiliza **Java com Spring Boot**, arquitetura em camadas, **JPA/Hibernate** e testes unitários para demonstrar boas práticas de desenvolvimento backend.

## 📌 Funcionalidades

- 📚 Consulta de conteúdo musical
- 📊 Organização de módulos de teoria musical

## 🛠️ Características técnicas

- 📦 Arquitetura em camadas (Controller → Service → Repository)
- 🧠 Testes unitários cobrindo lógica do backend

## 🖥️ Ferramentas utilizadas neste projeto

<!-- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" width="50" hedight="50"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="50" hedight="50"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" width="50" hedight="50"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="50" hedight="50"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/bootstrap/bootstrap-original.svg" width="50" hedight="50"/><img 
src="https://user-images.githubusercontent.com/76624588/205323253-ffa93319-78f6-46f3-bfa0-31a434ea451e.png" width="50" hedight="50"/><img
src="https://user-images.githubusercontent.com/76624588/205321409-7988a692-8487-454e-a741-d9c6b648d39d.png" width="50" hedight="50"/><img
src="https://user-images.githubusercontent.com/76624588/205321805-9b766e81-800e-4843-a1fb-071246ca5ce5.png" width="50" hedight="50"/>  -->
- **Java 17+**
- **Spring Boot**
- **JPA / Hibernate**
- **PostgreSQL**
- **JUnit & Mockito**
- **Maven**
- **Bootstrap**
- **IntelliJ IDEA**


## 🏗️ Arquitetura e organização do código

O projeto segue o padrão de arquitetura em camadas:

- Controller: camada responsável pelas requisições HTTP
- Service: camada de regras de negócio
- Repository: acesso a dados e persistência
- DTO: transferência de dados entre camadas
- Entity: mapeamento das entidades do banco de dados
  
<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205307829-d6dbb0b4-a608-4a9a-8bf3-a9d0d7c7f124.jpg" width="400" hedight="800"></p>

## ➡️ Caso de uso

O sistema permite que o usuário:
- realize cadastro e autenticação
- acesse módulos de teoria musical
- responda questionários
- consulte acordes e estruturas musicais

📎 Diagramas completos disponíveis na pasta `/docs`

## 🖼️ Armazenamento de imagens no banco de dados

As imagens dos acordes musicais são armazenadas diretamente no banco de dados
utilizando o tipo `BYTEA` (PostgreSQL), permitindo centralização dos dados
e recuperação das imagens pela aplicação backend.

Exemplo de inserção de imagem a partir de um arquivo local em ambiente de desenvolvimento:

```sql
INSERT INTO image (id, chord_name, image)
VALUES (
  40,
  'Em7(b5)',
  pg_read_binary_file('/path/to/chords/Em7b5.png')
);
```

<!-- insert into image (id, chord_name, image) values (40, 'Em7(b5)', pg_read_binary_file('D:/Documents/CienciaDaComputacao/TCC2/Imagens/Chords/Em7(b5).png'))-->

## 🚀 Como rodar localmente

### Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- Java 17 ou superior
- Maven
- PostgreSQL

---

### Passos

1. Clone o repositório:
```bash
git clone https://github.com/GuiAgost/musicHarmony.git
```

2. Acesse a pasta do projeto:
```bash
cd musicHarmony
```

3. Configure o banco de dados:

* Crie um banco de dados PostgreSQL (exemplo: musicharmony_db)
* Atualize as configurações no arquivo application.properties:

    * spring.datasource.url
    * spring.datasource.username
    * spring.datasource.password

4. Execute a aplicação:
```bash
mvn spring-boot:run
```

5. Para executar os testes unitários:
```bash
mvn test
```


## 🙌 Conclusão

O MusicHarmony aplica arquitetura em camadas e boas práticas de desenvolvimento backend com Java e Spring Boot, contemplando regras de negócio e persistência com JPA/Hibernate. Como próximos passos, prevê-se a aplicação de padrões de projeto e melhorias no front-end.

