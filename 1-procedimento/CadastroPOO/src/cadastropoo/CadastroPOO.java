
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
   
