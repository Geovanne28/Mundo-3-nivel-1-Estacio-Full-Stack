# Missão Prática | Nível 1 | Mundo 3

## POLO RUA TEREZA - PETRÓPOLIS - RJ

### Desenvolvimento Full Stack

#### Disciplina: Nível 1: Iniciando o Caminho Pelo Java

#### Número da Turma: RPG0014

#### Semestre Letivo: 3

#### Integrantes: Geovanne Alves Barcellos

#### Link Git: https://github.com/Geovanne28/Mundo-3-nivel-1-Estacio-Full-Stack

##

### Objetivos da Prática:

- Utilizar herança e polimorfismo na definição de entidades.
- Utilizar persistência de objetos em arquivos binários.
- Implementar uma interface cadastral em modo texto.
- Utilizar o controle de exceções da plataforma Java.
- No final do projeto, o aluno terá implementado um sistema cadastral em Java,
  utilizando os recursos da programação orientada a objetos e a persistência em
  arquivos binários.

### Título da Prática: 1° Procedimento | Criação das Entidades e Sistema de Persistência


#### Códigos solicitados neste roteiro de aula:

### 

- Classe CadastroPOO:

```

package cadastropoo;

import java.io.IOException;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

public class CadastroPOO {

 public static void main(String[] args) {        

        PessoaFisica geovanne = new PessoaFisica(1, "Geovanne Alves", "156.157.127-11", 27);
        PessoaFisica ana = new PessoaFisica(2, "Ana Paula Alves", "123.456.789-10", 45);

        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(geovanne);
        repo1.inserir(ana);
        try {
            repo1.persistir("pessoas_fisicas.dat");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao persistir os dados.");
            e.printStackTrace(System.out);
        }

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        try {
            repo2.recuperar("pessoas_fisicas.dat");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        
        repo2.obterTodos().forEach(pessoaFisica -> {
            System.out.println("Id: " + pessoaFisica.getId());
            System.out.println("Nome: " + pessoaFisica.getNome());
            System.out.println("CPF: " + pessoaFisica.getCpf());
            System.out.println("Idade: " + pessoaFisica.getIdade());
            System.out.println("-----------------------");
        });

        PessoaJuridica beijaFlor = new PessoaJuridica(3, "Beija Flor Decorações", "47.159.357/1258-00");
        PessoaJuridica geovanneTecnologias = new PessoaJuridica(4, "Geovanne Tecnologias", "12.158.357/256-24");
        
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(beijaFlor);
        repo3.inserir(geovanneTecnologias);

        try {
            repo3.persistir("pessoas_juridicas.dat");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        try {
            repo4.recuperar("pessoas_juridicas.dat");
            repo4.obterTodos().forEach(pessoaFisica -> {
                System.out.println("Id: " + pessoaFisica.getId());
                System.out.println("Nome: " + pessoaFisica.getNome());
                System.out.println("CNPJ: " + pessoaFisica.getCnpj());
                System.out.println("-----------------------");
            });
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
   

```

- Classe Pessoa:

```
package model;

import java.io.Serializable;

public class Pessoa implements Serializable{
    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


```

- Classe PessoaFisica:

```
package model;

import java.io.Serializable;
import model.Pessoa;

public class PessoaFisica extends Pessoa implements Serializable {
    private String cpf;
    private int idade;

    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
```

- Classe PessoaJuridica:

```
package model;

import java.io.Serializable;
import model.Pessoa;

public class PessoaJuridica extends Pessoa implements Serializable {
    private String cnpj;

    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}

```

- Resultado da execução do código

```
run:
Dados de Pessoa Física Armazenados no arquivo: pessoas_fisicas.dat
Dados de Pessoa Física Recuperados do arquivo: pessoas_fisicas.dat
Id: 1
Nome: Geovanne Alves
CPF: 156.157.127-11
Idade: 27
-----------------------
Id: 2
Nome: Ana Paula Alves
CPF: 123.456.789-10
Idade: 45
-----------------------
Dados de Pessoa Jurídica Armazenados no arquivo: pessoas_juridicas.dat
Dados de Pessoa Jurídica Recuperados do arquivo: pessoas_juridicas.dat
Id: 3
Nome: Beija Flor Decorações
CNPJ: 47.159.357/1258-00
-----------------------
Id: 4
Nome: Geovanne Tecnologias
CNPJ: 12.158.357/256-24
-----------------------
BUILD SUCCESSFUL (total time: 0 seconds)

```

### Análise e Conclusão

###

##### a) Quais as vantagens e desvantagens do uso de herança?
  Uma das  vantagens no uso herança nas classes é o reaproveitamento de código evitando refazer o código em vários lugares, o que ajuda na hora de dar manutenção pois precisa editar apenas em um lugar. 

###

##### b) Por que a interface Serializable é necessária ao efetuar persistência em arquivos binários?

Ela é necessária pois permite a classe serializar seus dados transformando num formato que poderá ser salvo num arquivo. 

###

##### c) Como o paradigma funcional é utilizado pela API stream no Java?

A API Stream no Java é uma parte fundamental da biblioteca Java.util.stream que introduziu um paradigma funcional para trabalhar com coleções de dados de forma mais concisa e expressiva.

###

##### d) Quando trabalhamos com Java, qual padrão de desenvolvimento é adotado na persistência de dados em arquivos?

Em Java, ao trabalhar com a persistência de dados em arquivos, um padrão comum é o uso do padrão de projeto "DAO"

##

### Título da Prática: 2° Procedimento | Criação do Cadastro em Modo Texto

#### Códigos solicitados neste roteiro de aula:

###

- Classe CadastroPOO:

```

package cadastropoo;

import java.io.IOException;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;
import java.util.Scanner;

public class CadastroPOO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        while (true) {
            System.out.println("======================================");
            System.out.println("1. Incluir Pessoa");
            System.out.println("2. Alterar Pessoa");
            System.out.println("3. Excluir Pessoa");
            System.out.println("4. Busca pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("6. Persistir dados");
            System.out.println("7. Recuperar dados");
            System.out.println("0. Finalizar Programa");
            System.out.println("======================================");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):");
                    String tipoPessoa = scanner.nextLine();

                    if ("F".equalsIgnoreCase(tipoPessoa)) {
                        System.out.println("Digite os dados da Pessoa Física:");
                        System.out.print("ID: ");
                        int idFisica = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nomeFisica = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha

                        PessoaFisica pessoaFisica = new PessoaFisica(idFisica, nomeFisica, cpf, idade);
                        repoFisica.inserir(pessoaFisica);
                    } else if ("J".equalsIgnoreCase(tipoPessoa)) {
                        System.out.println("Digite os dados da Pessoa Jurídica:");
                        System.out.print("ID: ");
                        int idJuridica = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nomeJuridica = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();

                        PessoaJuridica pessoaJuridica = new PessoaJuridica(idJuridica, nomeJuridica, cnpj);
                        repoJuridica.inserir(pessoaJuridica);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.println("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):");
                    String tipoAlterar = scanner.nextLine();

                    System.out.print("Digite o ID da pessoa que deseja alterar: ");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    if ("F".equalsIgnoreCase(tipoAlterar)) {
                        PessoaFisica pessoaFisica = repoFisica.obter(idAlterar);
                        if (pessoaFisica != null) {
                            System.out.println("Dados atuais da Pessoa Física:");
                            pessoaFisica.exibir();

                            System.out.println("Digite os novos dados da Pessoa Física:");
                            System.out.print("Nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("CPF: ");
                            String novoCpf = scanner.nextLine();
                            System.out.print("Idade: ");
                            int novaIdade = scanner.nextInt();
                            scanner.nextLine(); // Consumir a quebra de linha

                            pessoaFisica.setNome(novoNome);
                            pessoaFisica.setCpf(novoCpf);
                            pessoaFisica.setIdade(novaIdade);

                            repoFisica.alterar(pessoaFisica);
                        } else {
                            System.out.println("Pessoa Física não encontrada com o ID informado.");
                        }
                    } else if ("J".equalsIgnoreCase(tipoAlterar)) {
                        PessoaJuridica pessoaJuridica = repoJuridica.obter(idAlterar);
                        if (pessoaJuridica != null) {
                            System.out.println("Dados atuais da Pessoa Jurídica:");
                            pessoaJuridica.exibir();

                            System.out.println("Digite os novos dados da Pessoa Jurídica:");
                            System.out.print("Nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("CNPJ: ");
                            String novoCnpj = scanner.nextLine();

                            pessoaJuridica.setNome(novoNome);
                            pessoaJuridica.setCnpj(novoCnpj);

                            repoJuridica.alterar(pessoaJuridica);
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada com o ID informado.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):");
                    String tipoExcluir = scanner.nextLine();

                    System.out.print("Digite o ID da pessoa que deseja excluir: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    if ("F".equalsIgnoreCase(tipoExcluir)) {
                        repoFisica.excluir(idExcluir);
                    } else if ("J".equalsIgnoreCase(tipoExcluir)) {
                        repoJuridica.excluir(idExcluir);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 4:
                    System.out.println("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):");
                    String tipoObter = scanner.nextLine();
                    System.out.print("Digite o ID da pessoa que deseja obter: ");
                    int idObter = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    if ("F".equalsIgnoreCase(tipoObter)) {
                        PessoaFisica pessoaFisica = repoFisica.obter(idObter);
                        if (pessoaFisica != null) {
                            System.out.println("Dados da Pessoa Física:");
                            pessoaFisica.exibir();
                        } else {
                            System.out.println("Pessoa Física não encontrada com o ID informado.");
                        }
                    } else if ("J".equalsIgnoreCase(tipoObter)) {
                        PessoaJuridica pessoaJuridica = repoJuridica.obter(idObter);
                        if (pessoaJuridica != null) {
                            System.out.println("Dados da Pessoa Jurídica:");
                            pessoaJuridica.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada com o ID informado.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 5:
                    System.out.println("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):");
                    String tipoExibirTodos = scanner.nextLine();

                    if ("F".equalsIgnoreCase(tipoExibirTodos)) {
                        System.out.println("Pessoas Físicas:");
                        for (PessoaFisica pessoa : repoFisica.obterTodos()) {
                            pessoa.exibir();
                        }
                    } else if ("J".equalsIgnoreCase(tipoExibirTodos)) {
                        System.out.println("Pessoas Jurídicas:");
                        for (PessoaJuridica pessoa : repoJuridica.obterTodos()) {
                            pessoa.exibir();
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 6:
                    System.out.print("Digite o prefixo dos arquivos para salvar os dados: ");
                    String prefixoSalvar = scanner.nextLine();
                    try {
                        repoFisica.persistir(prefixoSalvar + ".fisica.bin");
                        repoJuridica.persistir(prefixoSalvar + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        e.printStackTrace(System.out);
                        System.out.println("Erro ao salvar os dados.");
                    }
                    break;

                case 7:
                    System.out.print("Digite o prefixo dos arquivos para recuperar os dados: ");
                    String prefixoRecuperar = scanner.nextLine();
                    try {
                        repoFisica.recuperar(prefixoRecuperar + ".fisica.bin");
                        repoJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (IOException e) {
                        e.printStackTrace(System.out);
                        System.out.println("Erro ao recuperar os dados.");
                    }
                    break;

                case 0:
                    System.out.println("Finalizando o programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
```

- Resultado da execução do código

```
run:
======================================
1. Incluir Pessoa
2. Alterar Pessoa
3. Excluir Pessoa
4. Busca pelo ID
5. Exibir todos
6. Persistir dados
7. Recuperar dados
0. Finalizar Programa
======================================
1
Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):
F
Digite os dados da Pessoa Física:
ID: 1
Nome: Geovanne Alves Barcellos
CPF: 162.566.747-77
Idade: 27
======================================
1. Incluir Pessoa
2. Alterar Pessoa
3. Excluir Pessoa
4. Busca pelo ID
5. Exibir todos
6. Persistir dados
7. Recuperar dados
0. Finalizar Programa
======================================
4
Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):
F
Digite o ID da pessoa que deseja obter: 1
Dados da Pessoa Física:
ID: 1
Nome: Geovanne Alves Barcellos
CPF: 162.566.747-77
Idade: 27
======================================
1. Incluir Pessoa
2. Alterar Pessoa
3. Excluir Pessoa
4. Busca pelo ID
5. Exibir todos
6. Persistir dados
7. Recuperar dados
0. Finalizar Programa
======================================
1
Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):
F
Digite os dados da Pessoa Física:
ID: 2
Nome: Ana Paula
CPF: 125.568.747-55
Idade: 50
======================================
1. Incluir Pessoa
2. Alterar Pessoa
3. Excluir Pessoa
4. Busca pelo ID
5. Exibir todos
6. Persistir dados
7. Recuperar dados
0. Finalizar Programa
======================================
5
Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):
F
Pessoas Físicas:
ID: 1
Nome: Geovanne Alves Barcellos
CPF: 162.566.747-77
Idade: 27
ID: 2
Nome: Ana Paula
CPF: 125.568.747-55
Idade: 50
======================================
1. Incluir Pessoa
2. Alterar Pessoa
3. Excluir Pessoa
4. Busca pelo ID
5. Exibir todos
6. Persistir dados
7. Recuperar dados
0. Finalizar Programa
======================================

```

### Análise e Conclusão

###

#### 1. O que são elementos estáticos e qual o motivo para o método main adotar esse modificador?

Elementos estáticos podem ser usados sem a necessidade de instanciar a classe proprietária. O método main é declarado como estático porque ele precisa ser chamado diretamente pela JVM (Java Virtual Machine) sem a necessidade de criar um objeto da classe que contém o método.

###

#### 2. Para que serve a classe Scanner?

A classe Scanner em Java é utilizada para ler entradas do usuário a partir do teclado. Ela fornece métodos para ler diferentes tipos de dados, como inteiros, números de ponto flutuante, strings, entre outros.

###

#### 3. Como o uso de classes de repositório impactou na organização do código?

Elas permitiram separar a lógica de acesso as informação segindo o princípio de responsabilidade única,  também permitindo uma melhor reutilização de código, pois outras partes do programa podem utilizar a mesma classe de repositório para acessar os dados de forma consistente.