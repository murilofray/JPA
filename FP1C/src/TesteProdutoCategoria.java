import br.edu.ifsp.pep.modelo.Categoria;
import br.edu.ifsp.pep.modelo.Produto;
import br.ifsp.edu.pep.dao.CategoriaDAO;
import br.ifsp.edu.pep.dao.ProdutoDAO;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Aluno
 */
public class TesteProdutoCategoria {

    private static ProdutoDAO produtoDAO = new ProdutoDAO();

    public static void main(String[] args) {
        adicionarProduto();
        exibirProdutos();
       // reajustarPreco(10);
    }

    private static void teste() {
//        EntityManager em = Persistence
//                .createEntityManagerFactory("aula1PU")
//                .createEntityManager();
//
//        Categoria categoria = new Categoria();
//        categoria.setDescricao("Informática");
//
//        CategoriaDAO categoriaDAO = new CategoriaDAO();
//        categoriaDAO.inserir(categoria);
//
//        Produto produto = new Produto();
//        produto.setDescricao("Teclado");
//        produto.setPreco(new BigDecimal(60.0));
//        produto.setQuantidade(100);
//
//        produto.setCategoria(categoria);
//
//        produtoDAO.inserir(produto);
//
//        List<Produto> produtos = produtoDAO.buscar();
//        for (Produto p : produtos) {
//            System.out.println("Descrição: " + p.getDescricao());
//            System.out.println("Categoria: " + p.getCategoria().getDescricao());
//        }
    }

    private static void adicionarProduto() {
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        for (int i = 0; i < 10; i++) {
            Categoria categoria = new Categoria();
            categoria.setDescricao("Categoria " + i);
            categoriaDAO.inserir(categoria);

            Produto produto = new Produto();
            produto.setDescricao("Produto " + i);
            produto.setPreco(new BigDecimal(60.0 * (i + 1)));
            produto.setQuantidade(100);

            produto.setCategoria(categoria);

            produtoDAO.inserir(produto);
        }
    }

    private static void exibirProdutos() {
        for (Produto p : produtoDAO.buscar()) {
            System.out.println("Descrição: " + p.getDescricao());
            System.out.println("Categoria: " + p.getCategoria().getDescricao());
        }
    }
    
//     private static void reajustarPreco(double porcentagem) {
//         for (Produto p : produtoDAO.buscar()) {
//             BigDecimal ajustar = (p.getPreco().multiply((porcentagem/100)));
//             p.setPreco(ajustar.add(p.getPreco()));
//             
//             produtoDAO.alterar(p);
//         }
//     }
}