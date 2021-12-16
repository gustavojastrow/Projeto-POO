package aplicacao;

import empresa.Empresa;
import empresa.Produto;
import pessoas.*;

import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Empresa emp = new Empresa();
        Scanner sc = new Scanner(System.in);

        //EMPRESA
        JOptionPane.showMessageDialog(null, "Registro da empresa");
        String nomeEmpresa = JOptionPane.showInputDialog("Digite o nome da empresa: ");
        emp.setNome(nomeEmpresa);
        int dataFundacao = Integer.parseInt(JOptionPane.showInputDialog("Digite a data de fundação: "));
        emp.setDataFundacao(dataFundacao);
        System.out.println("- EMPRESA -");
        System.out.println("Empresa: " + emp);

        // PRODUTOS
        JOptionPane.showMessageDialog(null, "Registro de produtos");
        int N = Integer.parseInt(JOptionPane.showInputDialog("Quantos produtos serão registrados? "));
        for (int i = 0; i < N; i++) {
            long idProduto = Long.parseLong(JOptionPane.showInputDialog("Digite o ID do produto: "));
            if(emp.isProdutoCadastrado(idProduto)) {
                JOptionPane.showMessageDialog(null, "Esse ID já foi cadastrado!" );
                i--;
                continue;
            }
            String designacao = JOptionPane.showInputDialog("Designação: ");
            double precoVendaPublico = Double.parseDouble(JOptionPane.showInputDialog("Preço: "));
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Estoque: "));
            Produto p01 = new Produto(idProduto, designacao, precoVendaPublico, stock);
            emp.addProduto(p01);
        }
        System.out.println();
        emp.mostraProdutos();
        System.out.println();

        // ALTERAR PRODUTOS
        char opcao = JOptionPane.showInputDialog("Deseja alterar algum produto? Digite [s] para sim e [n] para não: ").charAt(0);
        if (opcao == 's') {
            char opcaoProduto = JOptionPane.showInputDialog("Digite [r] para remover produtos ou digite [a] para atualizar produtos: ").charAt(0);
            if (opcaoProduto == 'r') {
                int idRemover = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto que será removido: "));
                emp.removerProdutos(idRemover);
                JOptionPane.showMessageDialog(null, "Produto removido!");
                System.out.println();
                emp.mostraProdutos();
                System.out.println();
            } else if (opcaoProduto == 'a') {
                int idAtualizar = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto que será atualizado: "));
                Produto atualizado = emp.obterProduto(idAtualizar);
                if (atualizado == null) {
                    JOptionPane.showMessageDialog(null, "Esse ID não existe!" );
                } else {
                    int idAtualizado = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo ID:"));
                    atualizado.setIdProduto(idAtualizado);
                    if(emp.isProdutoCadastrado(idAtualizar)) {
                        JOptionPane.showMessageDialog(null, "Esse ID já foi cadastrado!" );
                    }
                    else {
                        String designacao = JOptionPane.showInputDialog("Designação: ");
                        atualizado.setDesignacao(designacao);
                        double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço: "));
                        atualizado.setPrecoVendaPublico(preco);
                        int stock = Integer.parseInt(JOptionPane.showInputDialog("Estoque: "));
                        atualizado.setStock(stock);
                        System.out.println();
                        emp.atualizarProduto(atualizado);
                        JOptionPane.showMessageDialog(null, "Produto atualizado!");
                        emp.mostraProdutos();
                        System.out.println();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Erro de digitação!");
            }
        } else if (opcao == 'n') {
            System.out.println();
        } else {
            JOptionPane.showMessageDialog(null, "Erro de digitação!");
        }

        // PESSOAS
        JOptionPane.showMessageDialog(null, "Registro de pessoas");
        char opcaoPessoa = JOptionPane.showInputDialog("Digite [e] para registrar empregados, digite [f] para registrar fornecedores ou digite [c] para registrar clientes.").charAt(0);
        //EMPREGADO
        if (opcaoPessoa == 'e') {
            JOptionPane.showMessageDialog(null, "Registro de empregados");
            int M = Integer.parseInt(JOptionPane.showInputDialog("Quantos empregados serão registrados? "));
            for (int i = 0; i < M; i++) {
                String nome = JOptionPane.showInputDialog("Digite o nome: ");
                long contribuinte = Long.parseLong(JOptionPane.showInputDialog("Valor do contribuinte: "));
                byte idade = Byte.parseByte(JOptionPane.showInputDialog("Idade: "));
                Pessoa empregado1 = new Empregado(nome, contribuinte, idade);
                int numeroSeccao = Integer.parseInt(JOptionPane.showInputDialog("Numero de seção: "));
                ((Empregado) empregado1).setNumeroSeccao(numeroSeccao);
                float salario = Float.parseFloat(JOptionPane.showInputDialog("Valor salario base: "));
                ((Empregado) empregado1).setSalarioBase(salario);
                float iRS = Float.parseFloat(JOptionPane.showInputDialog("Valor do iRS: "));
                ((Empregado) empregado1).setiRS(iRS);
                emp.addPessoa(empregado1);

                CodigoPostal codEmpregado1 = new CodigoPostal();

                JOptionPane.showMessageDialog(null, "Registro do código postal");
                int indicativo = Integer.parseInt(JOptionPane.showInputDialog("Indicativo: "));
                codEmpregado1.setIndicativo(indicativo);
                int extensao = Integer.parseInt(JOptionPane.showInputDialog("Extensão: "));
                codEmpregado1.setExtensao(extensao);
                String zona = JOptionPane.showInputDialog("Zona: ");
                codEmpregado1.setZona(zona);
                empregado1.setCp(codEmpregado1);
            }
            System.out.println("Lista de empregados: ");
            emp.mostraPessoas();
        }
        //FORNECEDOR
        else if (opcaoPessoa == 'f') {
            JOptionPane.showMessageDialog(null, "Registro de fornecedores");
            int M = Integer.parseInt(JOptionPane.showInputDialog("Quantos fornecedores serão registrados? "));
            for (int i = 0; i < M; i++) {
                String nome = JOptionPane.showInputDialog("Digite o nome: ");
                long contribuinte = Integer.parseInt(JOptionPane.showInputDialog("Valor do contribuinte: "));
                byte idade = Byte.parseByte(JOptionPane.showInputDialog("Idade: "));
                Pessoa fornecedor1 = new Fornecedor(nome, contribuinte, idade);

                float plafond = Float.parseFloat(JOptionPane.showInputDialog("Plafond: "));
                ((Fornecedor) fornecedor1).setPlafond(plafond);
                float valorDivida = Float.parseFloat(JOptionPane.showInputDialog("Valor em dívida: "));
                ((Fornecedor) fornecedor1).setValorEmDivida(valorDivida);
                emp.addPessoa(fornecedor1);

                CodigoPostal codFornecedor1 = new CodigoPostal();

                JOptionPane.showMessageDialog(null, "Registro do código postal");
                int indicativo = Integer.parseInt(JOptionPane.showInputDialog("Indicativo: "));
                codFornecedor1.setIndicativo(indicativo);
                int extensao = Integer.parseInt(JOptionPane.showInputDialog("Extensão: "));
                codFornecedor1.setExtensao(extensao);
                String zona = JOptionPane.showInputDialog("Zona: ");
                codFornecedor1.setZona(zona);
                fornecedor1.setCp(codFornecedor1);
            }
            System.out.println("Lista de fornecedores: ");
            emp.mostraPessoas();
        }
        //CLIENTE

        else if (opcaoPessoa == 'c') {
            JOptionPane.showMessageDialog(null, "Registro de clientes");
            int M = Integer.parseInt(JOptionPane.showInputDialog("Quantos clientes serão registrados? "));
            for (int i = 0; i < M; i++) {
                String nome = JOptionPane.showInputDialog("Digite o nome: ");
                long contribuinte = Integer.parseInt(JOptionPane.showInputDialog("Valor do contribuinte: "));
                byte idade = Byte.parseByte(JOptionPane.showInputDialog("Idade: "));
                Pessoa cliente1 = new Cliente(nome, contribuinte, idade);

                float plafond = Float.parseFloat(JOptionPane.showInputDialog("Plafond: "));
                ((Cliente) cliente1).setPlafond(plafond);
                float valorDivida = Float.parseFloat(JOptionPane.showInputDialog("Valor em dívida: "));
                ((Cliente) cliente1).setValorEmDivida(valorDivida);
                emp.addPessoa(cliente1);

                CodigoPostal codCliente1 = new CodigoPostal();

                JOptionPane.showMessageDialog(null, "Registro do código postal");
                int indicativo = Integer.parseInt(JOptionPane.showInputDialog("Indicativo: "));
                codCliente1.setIndicativo(indicativo);
                int extensao = Integer.parseInt(JOptionPane.showInputDialog("Extensão: "));
                codCliente1.setExtensao(extensao);
                String zona = JOptionPane.showInputDialog("Zona: ");
                codCliente1.setZona(zona);
                cliente1.setCp(codCliente1);
            }
            System.out.println("Lista de clientes: ");
            emp.mostraPessoas();
        }

        //TRATAMENTO DE ERRO
        else {
            JOptionPane.showMessageDialog(null, "Erro de digitação!");
        }
        System.out.println();
        sc.close();
    }
}


