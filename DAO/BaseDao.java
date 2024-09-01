package DAO;
//Ana Moreira
import DAO.JDBCUtil;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public abstract class BaseDao<T> {

    protected abstract T criarAPartirDoResultSet(ResultSet resultSet) throws SQLException;

public void create(T entity, String sql, PreparedStatementSetter<T> pss) {
    try {
        JDBCUtil.init(new File(System.getProperty("user.dir") + "/src/DAO/bancoD.properties"));
    } catch (IOException | ClassNotFoundException ex) {
        Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
    }

    try (PreparedStatement stmt = JDBCUtil.getConnection().prepareStatement(sql)) {
        pss.setParameters(stmt, entity);
        stmt.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao salvar.");
        Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            JDBCUtil.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


    public T read(String sql, PreparedStatementSetter<String> pss, String key) {
        T result = null;

        try {
            JDBCUtil.init(new File(System.getProperty("user.dir") + "/src/DAO/bancoD.properties"));

            try (PreparedStatement stmt = JDBCUtil.getConnection().prepareStatement(sql)) {
                pss.setParameters(stmt, key);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    result = criarAPartirDoResultSet(rs);
                }
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public void update(T entity, String sql, PreparedStatementSetter<T> pss) {
        try {
            JDBCUtil.init(new File(System.getProperty("user.dir") + "/src/DAO/bancoD.properties"));
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PreparedStatement stmt = JDBCUtil.getConnection().prepareStatement(sql)) {
            pss.setParameters(stmt, entity);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar.");
            Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                JDBCUtil.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete(String sql, PreparedStatementSetter<String> pss, String key) {
        try {
            JDBCUtil.init(new File(System.getProperty("user.dir") + "/src/DAO/bancoD.properties"));
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PreparedStatement stmt = JDBCUtil.getConnection().prepareStatement(sql)) {
            pss.setParameters(stmt, key);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar.");
            Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                JDBCUtil.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FunctionalInterface
    public interface PreparedStatementSetter<T> {
        void setParameters(PreparedStatement ps, T entity) throws SQLException;
    }
}
