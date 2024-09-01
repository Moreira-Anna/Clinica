package DAO;
// Ana Moreira

import Model.Consulta;
import Model.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteDao extends BaseDao<Paciente> {

    @Override
    protected Paciente criarAPartirDoResultSet(ResultSet resultSet) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setCpf(resultSet.getString("cpf"));
        paciente.setNomePac(resultSet.getString("nome"));
        paciente.setTelefonePac(resultSet.getString("telefone"));

        if (resultSet.getMetaData().getColumnCount() >= 4) {
            System.out.println("Coluna 'datacon' encontrada no ResultSet.");
            Consulta consulta = new Consulta();
            consulta.setDataCon(resultSet.getString("datacon"));
            consulta.setDescrição(resultSet.getString("descricao"));
            paciente.setConsulta(consulta);
        } else {
            System.out.println("Coluna 'datacon' não encontrada no ResultSet.");
        }

        return paciente;
    }

    public String create(Paciente paciente) {
        if (paciente.getCpf().length() != 11) {
            return "Erro: CPF deve ter exatamente 11 dígitos.";
        }

        String sqlPaciente = "INSERT INTO paciente (cpf, nome, telefone) VALUES (?, ?, ?)";
        try {
            create(paciente, sqlPaciente, (stmt, p) -> {
                stmt.setString(1, p.getCpf());
                stmt.setString(2, p.getNomePac());
                stmt.setString(3, p.getTelefonePac());
            });
        } catch (Exception e) {
            return "Erro ao criar paciente: " + e.getMessage();
        }

        Consulta consulta = paciente.getConsulta();
        if (consulta != null) {
            String sqlConsulta = "INSERT INTO consulta (cpf_paciente, datacon, descricao) VALUES (?, ?, ?)";
            try {
                create(paciente, sqlConsulta, (stmt, p) -> {
                    stmt.setString(1, p.getCpf());
                    stmt.setString(2, p.getConsulta().getDataCon());
                    stmt.setString(3, p.getConsulta().getDescrição());
                });
            } catch (Exception e) {
                return "Erro ao criar consulta: " + e.getMessage();
            }
        }

        return "Sucesso: Paciente e consulta criados com sucesso.";
    }

    public Paciente read(String cpf) {
        String sql = "SELECT p.cpf, p.nome, p.telefone, c.datacon, c.descricao "
                + "FROM paciente p "
                + "LEFT JOIN consulta c ON p.cpf = c.cpf_paciente "
                + "WHERE p.cpf = ?";
        return read(sql, (stmt, key) -> stmt.setString(1, key), cpf);
    }

    public void update(Paciente paciente) {
        if (paciente.getCpf() == null || paciente.getCpf().isEmpty() || paciente.getCpf().length() > 11) {
            throw new IllegalArgumentException("CPF inválido");
        }

        Paciente pacienteExistente = read(paciente.getCpf());
        if (pacienteExistente != null && !pacienteExistente.getCpf().equals(paciente.getCpf())) {
            throw new IllegalArgumentException("O CPF não pode ser alterado");
        }

        String sql = "UPDATE paciente SET nome = ?, telefone = ? WHERE cpf = ?";
        update(paciente, sql, (stmt, p) -> {
            stmt.setString(1, p.getNomePac());
            stmt.setString(2, p.getTelefonePac());
            stmt.setString(3, p.getCpf());
        });

        Consulta consulta = paciente.getConsulta();
        if (consulta != null) {
            String updateConsultaSql = "UPDATE consulta SET datacon = ?, descricao = ? WHERE cpf_paciente = ?";
            try ( PreparedStatement stmt = JDBCUtil.getConnection().prepareStatement(updateConsultaSql)) {
                stmt.setString(1, consulta.getDataCon());
                stmt.setString(2, consulta.getDescrição());
                stmt.setString(3, paciente.getCpf());
                stmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete(String cpf) {
        String deleteConsultaSql = "DELETE FROM consulta WHERE cpf_paciente = ?";
        delete(deleteConsultaSql, (stmt, key) -> stmt.setString(1, key), cpf);

        String deletePacienteSql = "DELETE FROM paciente WHERE cpf = ?";
        delete(deletePacienteSql, (stmt, key) -> stmt.setString(1, key), cpf);
    }

    public Paciente addPaciente(String cpf, String nomePac, String telefonePac, String data, String descricao) {
        Paciente paciente = new Paciente();
        paciente.setCpf(cpf);
        paciente.setNomePac(nomePac);
        paciente.setTelefonePac(telefonePac);
        Consulta consulta = new Consulta();
        consulta.setDataCon(data);
        consulta.setDescrição(descricao);
        paciente.setConsulta(consulta);

        return paciente;
    }
}
