package br.com.Daos;

import br.com.Classes.Movimentacao;
import br.com.ConexaoBanco.ConnectionUtils;
import br.com.Exceptions.MovimentacaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoMovimentacao {

    //Insere um produto na tabela "produto" do banco de dados
    public static void inserir(Movimentacao movimentacao)
            throws SQLException, Exception {
        //Monta a string de inserção de um produtoo no BD,
        //utilizando os dados do produto passados como parâmetro
        String sql = "INSERT INTO movimentacao (TipoMovimentacao, NomeMovimentacao, "
                + "ProprietarioMovimentacao, ValorMovimentacao, DataMovimentacao, "
                + "NumeroDeParcelas, StatusDespesa, MovimentacaoFixa, MovimentacaoEnabled) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql);

            statement.setString(1, movimentacao.getTipoMovimentacao());
            statement.setString(2, movimentacao.getNomeMovimentacao());
            statement.setString(3, movimentacao.getProprietarioDaMovimentacao());
            statement.setString(4, movimentacao.getValorMovimentacao());
            statement.setString(5, movimentacao.getDataMovimentacao());
            statement.setString(6, movimentacao.getNumeroDeParcelas());
            statement.setString(7, movimentacao.getStatusDespesa());
            statement.setString(8, movimentacao.getMovimentacaoFixa());
            statement.setString(9, movimentacao.getMovimentacaoEnabled());
            System.out.println(statement.toString());

            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            //Executa o comando no banco de dados
            statement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Executa o comando SQL montado
        //executarSQL(sql);
    }

    //Deleta um produto na tabela "produto" do banco de dados
    public static void deletar(int id)
            throws SQLException, Exception {
        //Monta a string de remoção de um cliente no BD,
        //utilizando os dados do produto passados como parâmetro
        String sql = "UPDATE movimentacao SET MovimentacaoEnabled = ?"
                + " WHERE MovimentacaoId = ?;";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql);

            statement.setString(1, "false");
            statement.setInt(2, id);

            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            //Executa o comando no banco de dados
            statement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Executa o comando SQL montado
        //executarSQL(sql);
    }

    //Altera um produto na tabela "produto" do banco de dados
    public static void alterar(Movimentacao movimentacao, int id)
            throws SQLException, Exception {
        //Monta a string de alteracao de um produtoo no BD,
        //utilizando os dados do produto passados como parâmetro
        String sql = "UPDATE movimentacao "
                + "SET TipoMovimentacao = ?, "
                + "NomeMovimentacao = ?, "
                + "ProprietarioMovimentacao = ?, "
                + "ValorMovimentacao = ?, "
                + "DataMovimentacao = ?, "
                + "NumeroDeParcelas = ?, "
                + "StatusDespesa = ?, "
                + "MovimentacaoFixa = ?, "
                + "MovimentacaoEnabled = ? "
                + "WHERE MovimentacaoId = ?;";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql);

            statement.setString(1, movimentacao.getTipoMovimentacao());
            statement.setString(2, movimentacao.getNomeMovimentacao());
            statement.setString(3, movimentacao.getProprietarioDaMovimentacao());
            statement.setString(4, movimentacao.getValorMovimentacao());
            statement.setString(5, movimentacao.getDataMovimentacao());
            statement.setString(6, movimentacao.getNumeroDeParcelas());
            statement.setString(7, movimentacao.getStatusDespesa());
            statement.setString(8, movimentacao.getMovimentacaoFixa());
            statement.setString(9, movimentacao.getMovimentacaoEnabled());
            statement.setString(10, "" + id);
            System.out.println(statement.toString());

            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            //Executa o comando no banco de dados
            statement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Executa o comando SQL montado
        //executarSQL(sql);
    }

    //Pesquisa um produto na tabela "produto" do banco de dados
    public static List<Movimentacao> pesquisar(String palavra)
            throws SQLException, Exception {

        //Monta a string de pesquisa de um cliente no BD,
        //utilizando os dados do produto passados como parâmetro
        String sql = "SELECT * FROM Movimentacao "
                + " WHERE Movimentacao.MovimentacaoEnabled = 'true';";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;
        List<Movimentacao> listaMovimentacao = new ArrayList<>();
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + palavra + "%");

            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);

            ResultSet result = statement.executeQuery();
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaMovimentacao == null) {
                    listaMovimentacao = new ArrayList<Movimentacao>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                Movimentacao movimentacao = new Movimentacao();
                statement.setInt(1, movimentacao.getIdMovimentacao());
                statement.setString(2, movimentacao.getTipoMovimentacao());
                statement.setString(3, movimentacao.getNomeMovimentacao());
                statement.setString(4, movimentacao.getProprietarioDaMovimentacao());
                statement.setString(5, movimentacao.getValorMovimentacao());
                statement.setString(6, movimentacao.getDataMovimentacao());
                statement.setString(7, movimentacao.getNumeroDeParcelas());
                statement.setString(8, movimentacao.getStatusDespesa());
                statement.setString(9, movimentacao.getMovimentacaoFixa());
                statement.setString(10, movimentacao.getMovimentacaoEnabled());
                System.out.println(statement.toString());

                //Adiciona a instância na lista
                listaMovimentacao.add(movimentacao);
            }
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaMovimentacao;
    }

    //Obtém uma instância da classe "Produto" através de dados do
    //banco de dados, de acordo com o ID fornecido como parâmetro
    public static Movimentacao obter(Integer id)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o produto
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM movimentacao WHERE movimentacaoId = ? AND "
                + "MovimentacaoEnabled = 'true';";
        PreparedStatement statement = null;
        Connection connection = null;

        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        //Armazena o valor da consulta numa lista temporária
        List<Movimentacao> listaMovimentacao = (List<Movimentacao>) executarConsulta(sql);

        //Verifica se a lista de resposta não é nula e contém resultados
        if (listaMovimentacao != null && listaMovimentacao.size() > 0) {
            //Como a consulta foi feita por ID, este é uma chave
            //primária (só pode haver um) e a verificação de tamanho
            //da lista foi maior que zero, deve significar que há
            //apenas um item de resultado. Retornaremos este primeiro
            //e único item, já que ele é o que se deseja obter.
            return listaMovimentacao.get(0);
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados e a lista estava nula ou vazia.
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return null;
    }

    //Executa um comando SQL de consulta no banco de dados,
    //tratando da abertura, execução e fechamento de elementos
    //do JDBC necessários e a iteração de elementos de resultado
    //para composição de uma lista de produtos para retorno.
    public static List<Movimentacao> executarConsulta(String sql) throws
            MovimentacaoException, SQLException, Exception {
        //Lista de produtos de resultado
        List<Movimentacao> listaMovimentacao = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        Statement statement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.createStatement();
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando CONSULTA SQL: " + sql);
            //Executa a consulta SQL no banco de dados
            result = statement.executeQuery(sql);
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaMovimentacao == null) {
                    listaMovimentacao = new ArrayList<Movimentacao>();
                }
                //Cria uma instância de produto e popula com os valores do BD
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setIdMovimentacao(result.getInt("MovimentacaoId"));
                movimentacao.setTipoMovimentacao(result.getString("TipoMovimentacao"));
                movimentacao.setNomeMovimentacao(result.getString("NomeMovimentacao"));
                movimentacao.setProprietarioDaMovimentacao(result.getString("ProprietarioMovimentacao"));
                movimentacao.setValorMovimentacao(result.getString("ValorMovimentacao"));
                movimentacao.setDataMovimentacao(result.getString("DataMovimentacao"));
                movimentacao.setNumeroDeParcelas(result.getString("NumeroDeParcelas"));
                movimentacao.setMovimentacaoFixa(result.getString("MovimentacaoFixa"));
                movimentacao.setStatusDespesa(result.getString("StatusDespesa"));
                movimentacao.setMovimentacaoEnabled(result.getString("MovimentacaoEnabled"));
                //Adiciona a instância na lista
                listaMovimentacao.add(movimentacao);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de clientes do banco de dados
        return listaMovimentacao;
    }

    //Lista todos os produtos da tabela quartos
    public static List<Movimentacao> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de produtos no banco, considerando
        //apenas a coluna de ativação de produtos ("enabled")
        String sql = "SELECT * FROM movimentacao WHERE MovimentacaoEnabled = 'true'";

        //Retorna o resultado da execução da consulta SQL montada
        return executarConsulta(sql);
    }

    public static Movimentacao retornarMovimentacao(int id) throws
            SQLException, Exception {
        String sql = "SELECT * FROM movimentacao "
                + " WHERE movimentacao.MovimentacaoId = ?";
        Movimentacao movimentacao = new Movimentacao();
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;

        //Abre uma conexão com o banco de dados
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        //Exibe no console o que será executado no banco de dados
        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();
        //Itera por cada item do resultado

        while (result.next()) {
            //Cria uma instância de Produto e popula com os valores do BD
            movimentacao.setIdMovimentacao(result.getInt("MovimentacaoId"));
            movimentacao.setTipoMovimentacao(result.getString("TipoMovimentacao"));
            movimentacao.setNomeMovimentacao(result.getString("NomeMovimentacao"));
            movimentacao.setProprietarioDaMovimentacao(result.getString("ProprietarioMovimentacao"));
            movimentacao.setValorMovimentacao(result.getString("ValorMovimentacao"));
            movimentacao.setDataMovimentacao(result.getString("DataMovimentacao"));
            movimentacao.setNumeroDeParcelas(result.getString("NumeroDeParcelas"));
            movimentacao.setMovimentacaoFixa(result.getString("MovimentacaoFixa"));
            movimentacao.setStatusDespesa(result.getString("StatusDespesa"));
            movimentacao.setMovimentacaoEnabled(result.getString("MovimentacaoEnabled"));
            connection.close();
            return movimentacao;
        }

        return null;
    }

    public static Movimentacao retornarValor(String nome) throws
            SQLException, Exception {
        String sql = "SELECT * FROM movimentacao "
                + " WHERE movimentacao.NomeMovimentacao = ?";
        Movimentacao movimentacao = new Movimentacao();
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;

        //Abre uma conexão com o banco de dados
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, nome);

        //Exibe no console o que será executado no banco de dados
        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();
        //Itera por cada item do resultado

        while (result.next()) {
            //Cria uma instância de Produto e popula com os valores do BD
            movimentacao.setValorMovimentacao(result.getString("ValorMovimentacao"));
            connection.close();
            return movimentacao;
        }
        return null;
    }

    public static boolean verificarMovimentacaoCadastrado(int idMovimentacao) throws
            SQLException, Exception {

        String sql = "SELECT * "
                + "FROM movimentacao "
                + "WHERE movimentacao.MovimentacaoId = ? ";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;

        //Abre uma conexão com o banco de dados
        connection = ConnectionUtils.getConnection();
        //Cria um statement para execução de instruções SQL
        statement = connection.prepareStatement(sql);
        statement.setInt(1, idMovimentacao);

        //Exibe no console o que será executado no banco de dados
        System.out.println("Executando CONSULTA SQL: " + sql);
        //Executa a consulta SQL no banco de dados
        result = statement.executeQuery();
        while (result.next()) {
            connection.close();
            return true;
        }
        //Retorna sem duplicada
        return false;
    }

}
