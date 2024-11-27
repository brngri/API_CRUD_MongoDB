<h1 align="center">🍃 API CRUD com MongoDB e AWS</h1>

<div align="center">
  <img src="https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white" alt="MongoDB">
  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring">
  <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white" alt="Postman">
  <img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white" alt="Docker">
  <img src="https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white" alt="AWS">
</div>

---

## 📄 Resumo

Este projeto tem como objetivo aprender a utilizar um banco de dados NoSQL e realizar o deploy de uma aplicação utilizando o serviço EC2 da AWS.

---

## 🔧 Tecnologias

- **Linguagens:** Java  
- **Frameworks:** Spring Boot  
- **Banco de Dados:** MongoDB  
- **Serviço de Virtualização:** AWS EC2  
- **Outras Ferramentas:** Git, Docker e Postman  

---

## ✅ Práticas Adotadas

- **Versionamento de Código:** Git para controle de versões e colaboração.  
- **Documentação:** Manutenção de documentação clara e detalhada.  
- **Consultas:** MongoRepository para operações com MongoDB.  
- **API REST:** Implementação de endpoints RESTful.  
- **Containerização com Docker:** Banco de dados MongoDB containerizado.  

---

## 🚀 Como Executar a Aplicação

### 📋 Pré-requisitos

- Conhecimento de AWS EC2 e Docker.  
- [Postman](https://www.postman.com/downloads/).  
- [Maven](https://maven.apache.org/download.cgi) ([Como instalar](https://www.youtube.com/watch?v=rfhTnfbBQcY)).  

---

### 🛠️ Passos para Execução

1. **Clone o repositório:**  
   ```bash
     git clone https://github.com/brngri/API_CRUD_MongoDB.git
    ```

## 🚀 Como Configurar e Executar a Aplicação na AWS EC2

### 1. Crie um serviço VPC e uma instância EC2

- Assista ao [vídeo tutorial](https://www.youtube.com/watch?v=bEkCdlrxF54&t=1708s) no canal Fernanda Kipper.
- **Importante:** No Security Group, certifique-se de deixar a porta **27017** aberta para o MongoDB.

---

### 2. Acesse sua instância EC2

Conecte-se à sua instância utilizando SSH:  
```bash
ssh ec2-user@SEU_ENDEREÇO_DNS_OU_IPV4
```

---

### 3. Prepare a instância
- Atualize o sistema operacional, instale o JDK 17 e configure o Docker:
  ```bash
  sudo yum update
  sudo yum install java-17-amazon-corretto-headless
  sudo yum install -y docker
  sudo systemctl start docker
  sudo systemctl enable docker
  sudo usermod -aG docker ec2-user
  exit
  ssh ec2-user@SEU_ENDEREÇO_DNS_OU_IPV4
  ```

  ---

  ### 4. Execute o MongoDB no Docker
- Baixe e execute o container do MongoDB:
  ```bash
    docker run --name mongodb -d -p 27017:27017 mongo:5.0
  ```

---

### 5. Compile e envie o arquivo .jar para a VM
- Compile o projeto utilizando o Maven e envie o arquivo para a instância EC2:
  ```bash
  mvn clean package
  scp ./target/crud-0.0.1-SNAPSHOT.jar ec2-user@SEU_ENDEREÇO_DNS:/home/ec2-user
  ```

---
### 6. Configure o banco no MongoDB Compass

- Criar uma conexão: mongodb://Coloque o endereço DNS gerado pela AWS:27017/
  
- Crie o BDD com o nome: crud-demo
  
- Crie uma collection com o nome: employee
   
### 7. Rodar API

  - Na VM digite
    ```cmd
     java -jar crud-0.0.1-SNAPSHOT.jar
    ```

### 8. Abra o postman
   
#### LISTAR (GET)

URL:
```url
http://SEU DNS GERADO PELA AWS:8080/api/emp/listAll
```

#### CRIAR (POST)

URL:
```url
http://SEU DNS GERADO PELA AWS:8080/api/emp/create
```
Body:
```JSON
{
    "name":"VAI SER DELETADO",
    "location":"Tester",
    "salary": 0
}
````

#### ATUALIZAR (PUT)

URL:
```url
http://SEU DNS GERADO PELA AWS:8080/api/emp/create
```
Body:
```JSON
{
    "id":"PEGUE O ID NO MongoDBcompass",
    "name":"Você Aprendeu AWS EC2",
    "location":"SEO MASTER",
    "salary": 100000000
}
```

#### DELETAR (DELETE)

- OBS: Ao copiar e colar o ID, tome cuidado para não dar espaço, pois pode dar (Employee does not exist)
  
URL:
```url
http://SEU DNS GERADO PELA AWS:8080/api/emp/delete?id=PEGUE O ID NO MongoDBcompass
```

