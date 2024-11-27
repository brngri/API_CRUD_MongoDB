<h1 align="center">🍃 API CRUD com MongoDB e AWS
</h1>



![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)  ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)  ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)  ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)  ![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)

## Resumo

O objetivo desse projeto é aprender a usar um banco NoSQL e aprender a fazer o deploy da aplicação utilizando o serviço EC2 da AWS

## Tecnologias

- **Linguagens**:  Java
- **Frameworks**: Spring Boot
- **Banco de Dados**: MongoDB
- **Serviço de Virtualização**: EC2 da AWS
- **Outras ferramentas**: Git, Docker e Postman

## Práticas Adotadas

- **Versionamento de Código**: Utilização do Git para controle de versões e colaboração.
- **Documentação**: Manutenção de documentação clara e detalhada para facilitar a compreensão e uso da aplicação.
- Consultas com MongoRepository 
- API REST
- **Containerização com Docker**: Utilização do Docker para containerizar o banco de dados na VM.
  

## Como Executar a Aplicação

### Pré-requisitos

- Conhecimento prévio de AWS EC2
- Conhecimento prévio de Docker
- [Postman](https://www.postman.com/downloads/)
- [Maven](https://maven.apache.org/download.cgi): Como instalar -> https://www.youtube.com/watch?v=rfhTnfbBQcY

### Passos para Executar

1. **Clone o repositório:**
```bash
  git clone https://github.com/brngri/API_CRUD_MongoDB.git
```
2. **Crie um serviço VPC e uma instância EC2:**
   - Assista esse vídeo. Canal:Fernanda Kipper | Dev ->  https://www.youtube.com/watch?v=bEkCdlrxF54&t=1708s
   - OBS: Ao criar o Security Group, deixe a porta 27017 aberta para o MongoDB
  
     
3. **Entre na sua instância EC2:**
```bash
  
  ssh ec2-user@coloca o endereço DNS ou IPV4 gerado pela AWS da sua VM (virtual machine)

```
  3.1 **Atualizar SO e instalar jdk 17 na VM**
  ```bash
  
  sudo yum update
  sudo yum install java-17-amazon-corretto-headless

  ```
 3.2 **Instalar docker na VM e rodar o MongoDB**

  3.2.1) Instale o Docker
  ```bash
    sudo yum install -y docker
  ```
  
  3.2.2) Inicie o serviço Docker
  ```bash
    sudo systemctl start docker
   ```
  
  3.2.3) Habilite o Docker para iniciar automaticamente no boot
  ```bash
    sudo systemctl enable docker
  ```
  
  3.2.4) Adicione o usuário atual ao grupo docker (para não precisar usar sudo)
  ```bash
    sudo usermod -aG docker ec2-user
  ```
  
  3.2.5) Saia da VM e faça a conexão via SSH novamente
   ```bash
      exit
   ```
  ```bash
    ssh ec2-user@coloca o endereço DNS ou IPV4 gerado pela AWS da sua VM (virtual machine)
   ```
  
  3.2.6) Rode o MongoDB
  ```bash
    docker run --name mongodb -d -p 27017:27017 mongo:5.0
  ```
  
4. **Atualizar o app.jar (CMD)**
   - CAMINHO = Onde esta localizada a pasta na sua máquina
   ```cmd
     cd CAMINHO\\API_CRUD_MongoDB
   ```
   ```cmd
     mvn clean package
    ```
4. **Passar arquivo .jar da sua máquina para a VM**

   - Abra um outro terminal
   - CAMINHO = Onde esta localizada a pasta na sua máquina
   ```cmd
     cd CAMINHO\API_CRUD_MongoDB
    ```
   - Copiar arquivo para a VM

    Em sua máquina
   
    ```cmd
     scp ./target/crud-0.0.1-SNAPSHOT.jar ec2-user@SEU IPV4:/home/ec2-user 
    ```
   
6. **Criar BDD com o MongoDB compass**

  1 - Criar uma conexão: mongodb://Coloque o endereço DNS gerado pela AWS:27017/

  2 - Crie o BDD com o nome: crud-demo

  3 - Crie uma collection com o nome: employee
   
7.  **Rodar API**

  - Na VM digite
    ```cmd
     java -jar crud-0.0.1-SNAPSHOT.jar
    ```

8. **Abra o postman**
   
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





