package DAO;
// Ana Moreira
import Model.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoDao extends BaseDao<Medico> {

    @Override
    protected Medico criarAPartirDoResultSet(ResultSet resultSet) throws SQLException {
        Medico medico = new Medico();
        medico.setCfm(resultSet.getString("cfm"));
        medico.setNomeMed(resultSet.getString("nome"));
        medico.setTelefoneMed(resultSet.getString("telefone"));
        return medico;
    }

public void create(Medico medico) {
    if (medico.getCfm().length() > 6) {
        throw new IllegalArgumentException("O número CFM não pode ter mais de 6 dígitos.");
    }
    
    String sql = "INSERT INTO medico (cfm, nome, telefone) VALUES (?, ?, ?)";
    create(medico, sql, (stmt, m) -> {
        stmt.setString(1, m.getCfm());
        stmt.setString(2, m.getNomeMed());
        stmt.setString(3, m.getTelefoneMed());
    });
}


    public Medico read(String cfm) {
        String sql = "SELECT * FROM medico WHERE cfm = ?";
        return read(sql, (stmt, key) -> stmt.setString(1, key), cfm);
    }

    public void update(Medico medico, String originalCfm) {
        String sql = "UPDATE medico SET cfm = ?, nome = ?, telefone = ? WHERE cfm = ?";
        update(medico, sql, (stmt, m) -> {
            stmt.setString(1, m.getCfm());
            stmt.setString(2, m.getNomeMed());
            stmt.setString(3, m.getTelefoneMed());
            stmt.setString(4, originalCfm);
        });
    }

    public void delete(String cfm) {
        String sql = "DELETE FROM medico WHERE cfm = ?";
        delete(sql, (stmt, key) -> stmt.setString(1, key), cfm);
    }
    
        public Medico addMedico(String cfm, String nome, String telefone) {
        Medico medico = new Medico();
        medico.setCfm(cfm);
        medico.setNomeMed(nome);
        medico.setTelefoneMed(telefone);

        return medico;
    }
}
