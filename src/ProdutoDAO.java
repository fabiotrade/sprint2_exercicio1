import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDAO {

    private Connection connection = new ConnectionFactory().getConnection();

    public ProdutoDAO() throws SQLException {
    }

    public void insere() throws SQLException {
        Statement stm = connection.createStatement();
        stm.execute("DROP TABLE IF EXISTS produto");
        stm.execute("CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), quantidade INT, preco FLOAT, PRIMARY KEY (id)) Engine = InnoDB");
        stm.execute("INSERT INTO PRODUTO (nome, descricao, quantidade, preco) VALUES ('SMARTPHONE', 'SMARTPHONE MOTOROLA', 15, 1800)");
        stm.execute("INSERT INTO PRODUTO (nome, descricao, quantidade, preco) VALUES ('SMARTPHONE', 'SMARTPHONE XIAOMI', 18, 1900)");
        stm.execute("INSERT INTO PRODUTO (nome, descricao, quantidade, preco) VALUES ('SMARTPHONE', 'SMARTPHONE NOKIA', 10, 1700)");
        stm.close();
        listagem();
    }
    public void atualiza() throws SQLException {

        Statement stm = connection.createStatement();

        stm.execute("UPDATE PRODUTO SET NOME = 'NOTEBOOK', DESCRICAO = 'NOTEBOOK APPLE' WHERE ID = 1");
        stm.close();
        listagem();



    }
    public void exclui() throws SQLException {

        Statement stm = connection.createStatement();
        stm.execute("DELETE FROM PRODUTO WHERE ID = 2");
        stm.close();
        listagem();

    }
    public void listagem() throws SQLException {
        Statement stm = connection.createStatement();
        stm.execute("SELECT * FROM produto");

        ResultSet rst = stm.getResultSet();

        while(rst.next()){
            Integer id = rst.getInt("ID");
            String nome = rst.getString("NOME");
            String descricao = rst.getString("DESCRICAO");
            int quantidade = rst.getInt("QUANTIDADE");
            double preco = rst.getDouble("PRECO");

            System.out.println(" \nID: " + id );
            System.out.println(" NOME: " + nome);
            System.out.println(" DESC: " + descricao);
            System.out.println(" QUANTIDADE: " + quantidade);
            System.out.println(" PRECO: " + preco + "\n");
        }




    }

}
