# <p align="center"><img src="https://user-images.githubusercontent.com/76624588/205338718-cda225e0-8e8e-4a8c-a89d-2060ad5882ae.png" width="300" hedight="700"></p>

# 👨‍🎓 Projeto TCC II - MusicHarmony

📚 Este é o projeto da disciplina TCC, foi desenvolvido o sistema web abordando sobre teoria musical de nível básico:

- Aulas: Conceito Musical, Tríade, Tétrade e Transposição;
- Identificar as notas que compõem os acordes de tríade e tétrade;
- Transpor a nota/acorde;
- Pesquisa de acordes.

## 🎯 Objetivo
O objetivo principal deste trabalho foi apresentado a proposta de desenvolvimento de
uma aplicação web para auxiliar os músicos iniciantes a consultar além das aulas apresentadas,
identificar as notas de acorde tríade, identificar as notas de acorde tétrade, identificar o acorde/-
nota transposta e pesquisa de diagrama de acorde.

## 🏗️ Arquitetura de projeto
<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205307829-d6dbb0b4-a608-4a9a-8bf3-a9d0d7c7f124.jpg" width="400" hedight="800"></p>

## 🖥️ Ferramentas utilizadas neste projeto

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" width="50" hedight="50"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="50" hedight="50"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" width="50" hedight="50"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="50" hedight="50"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/bootstrap/bootstrap-original.svg" width="50" hedight="50"/><img 
src="https://user-images.githubusercontent.com/76624588/205323253-ffa93319-78f6-46f3-bfa0-31a434ea451e.png" width="50" hedight="50"/><img
src="https://user-images.githubusercontent.com/76624588/205321409-7988a692-8487-454e-a741-d9c6b648d39d.png" width="50" hedight="50"/><img
src="https://user-images.githubusercontent.com/76624588/205321805-9b766e81-800e-4843-a1fb-071246ca5ce5.png" width="50" hedight="50"/>

## 🖼️ Inserção de imagens no banco de dados

insert into image (id, chord_name, image) values (40, 'Em7(b5)', pg_read_binary_file('D:/Documents/CienciaDaComputacao/TCC2/Imagens/Chords/Em7(b5).png'))

## ➡️ Caso de uso

<p align="center"><img width="300" alt="casosDeUso" src="https://user-images.githubusercontent.com/76624588/205335113-4027d71c-04c3-42f1-aeb0-cec7b5dd03c7.png"></p>

## ➡️ Diagrama de Classes

<p align="center"><img width="350" alt="diagramaDeClasse" src="https://user-images.githubusercontent.com/76624588/205336053-ceec3c3c-6d68-48b1-98cd-f45dd1ea41d5.png"></p>

## ➡️ Diagrama de Sequência

<p align="center"><img width="700" alt="diagramaDeSequencia" src="https://user-images.githubusercontent.com/76624588/205336297-ae967d34-4455-42cd-9699-3020f04aea74.png"></p>

## ➡️ Diagrama de Atividade

<p align="center"><img width="450" alt="diagramaDeAtividade" src="https://user-images.githubusercontent.com/76624588/205336808-c3aa0a01-a021-40b6-95da-1258913c750b.png"></p>

## 🖼️ Tela Login

<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205340384-c068e3d0-4e2e-473c-b306-3ab9ab185237.jpg" width="400" hedight="800"></p>

## 🖼️ Tela Cadastro

<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205340442-a418346d-e53b-413c-9489-763e07774549.jpg" width="400" hedight="800"></p>


## 🖼️ Tela Aulas

<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205340474-2a3ba449-dfbc-4b09-a1bf-bb52377c6487.jpg" width="400" hedight="800"></p>
<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205340514-54fd01c8-3835-49e9-9294-68f884e7c83e.jpg" width="400" hedight="800"></p>

## 🖼️ Tela Tríade

<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205340753-efa6b246-42a9-4dd1-aeaa-53f5b925073a.jpg" width="400" hedight="800"></p>


## 🖼️ Tela Tretrade

<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205340730-344e31e2-68e6-4577-bc71-1dacc28981c1.jpg" width="400" hedight="800"></p>


## 🖼️ Tela Transposição

<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205340779-50eba086-0742-46b1-a6af-2c44a28bef64.jpg" width="400" hedight="800"></p>

## 🖼️ Tela Questioários

<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205340840-951ff666-3bd6-4c91-9b0a-11b4ab4a198b.jpg" width="400" hedight="800"></p>


## 🖼️ Tela Pesquisar Acordes

<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205341640-0fd009bf-3778-424f-a724-f88646aead97.png" width="400" hedight="800"></p>

<p align="center"><img src="https://user-images.githubusercontent.com/76624588/205340977-4371df7a-c640-43c8-803b-c8294e01bbd0.jpg" width="400" hedight="800"></p>

## 🙌 Considerações Finais

* Para a solução da proposta desenvolvida através da modelagem de software, foi necessário o uso de alguns frameworks da linguagem Java, desenvolvimento de cálculo para transposição, a validação Regular expression (regex) para validar String, a lógica de cadastro e login, a
utilização do JPA Hibernate para mapeamento banco de dados relacional e o desenvolvimento de tríade e tétrade utilizando List.

* As imagens de diagrama de acorde foram adquiridas através de e-books tutorial do cifra club;

* O sistema web atendeu de acordo com os requisitos propostos, possibilitando acrescentar novas funcionalidades e novos conceitos da teoria musical.
