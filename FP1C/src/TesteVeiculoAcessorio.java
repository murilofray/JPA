
import br.edu.ifsp.pep.modelo.Acessorio;
import br.edu.ifsp.pep.modelo.Veiculo;
import br.ifsp.edu.pep.dao.AcessorioDAO;
import br.ifsp.edu.pep.dao.VeiculoDAO;
import java.math.BigDecimal;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author aluno
 */
public class TesteVeiculoAcessorio {

    private static final VeiculoDAO veiculoDAO = new VeiculoDAO();

    public static void main(String[] args) {
        adicionarVeiculo();
        exibirVeiculo();
    }

    private static void adicionarVeiculo() {
        AcessorioDAO acessorioDAO = new AcessorioDAO();
        for (int i = 0; i < 10; i++) {
            Acessorio acessorio = new Acessorio();
            acessorio.setDescricao("Acessorio " + i);
            acessorioDAO.inserir(acessorio);
        }
        for (int i = 0; i < 10; i++) {
            Veiculo veiculo = new Veiculo();
            veiculo.setAnoFabricacao(2009);
            veiculo.setAnoModelo(2010);
            veiculo.setDataCadastro(new Date());
            veiculo.setFabricante("Ford");
            veiculo.setModelo("Edge");
            veiculo.setTipoCombustivel("Gasolina");
            veiculo.setValor(new BigDecimal(60.0 * (i + 1)));

            veiculoDAO.inserir(veiculo);
        }

        for (int i = 11; i < 21; i++) {
            Veiculo veiculo = new Veiculo();
            veiculo.getAcessorios().add(acessorioDAO.retornarAcessorio(1));
            veiculo.getAcessorios().add(acessorioDAO.retornarAcessorio(2));
            veiculo.getAcessorios().add(acessorioDAO.retornarAcessorio(3));
            veiculo.setAnoFabricacao(2009);
            veiculo.setAnoModelo(2010);
            veiculo.setDataCadastro(new Date());
            veiculo.setFabricante("Ford");
            veiculo.setModelo("Edge");
            veiculo.setTipoCombustivel("Gasolina");
            veiculo.setValor(new BigDecimal(60.0 * (i + 1)));
            veiculoDAO.inserir(veiculo);
        }
    }

    private static void exibirVeiculo() {
        for (Veiculo v : veiculoDAO.buscar()) {
            System.out.println("Fabricante: " + v.getFabricante());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Tipo Combustivel: " + v.getTipoCombustivel());
            System.out.println("Ano Fabricacao: " + v.getAnoFabricacao());
            System.out.println("Ano Modelo: " + v.getAnoModelo());
            System.out.println("Codigo: " + v.getCodigo());
            System.out.println("Data Cadastro: " + v.getDataCadastro());
            System.out.println("Valor: " + v.getValor());
            for (Acessorio a : v.getAcessorios()) {
                System.out.println("Acessorio: " + a.getDescricao());
            }
            System.out.println("\n");
        }
    }
}
