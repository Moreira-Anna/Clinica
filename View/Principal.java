
package View;

import DAO.PacienteDao;
import Model.Consulta;
import Model.Paciente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ANA MOREIRA
 */
public class Principal extends javax.swing.JFrame {

    public void limparCampos() {
        buscaCpf.setText("");
        consNomeP.setText("");
        consTeleP.setText("");
        consCons.setText("");
        descriçãoCon.setText("");
    }

    PacienteDao PD = new PacienteDao();
    PacienteDao P = new PacienteDao();

    MedicoBuscar MB = new MedicoBuscar();
    PacienteCad cad = new PacienteCad();
    Consulta C = new Consulta();

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        rtCpf = new javax.swing.JLabel();
        buscaCpf = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        consTeleP = new javax.swing.JTextField();
        rtCons = new javax.swing.JLabel();
        consCons = new javax.swing.JTextField();
        consApagar = new javax.swing.JButton();
        consAlterar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        consNomeP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        descriçãoCon = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnCadMed = new javax.swing.JMenuItem();
        mnCadPac = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(59, 147, 171));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        rtCpf.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        rtCpf.setForeground(new java.awt.Color(255, 255, 255));
        rtCpf.setText("CPF do paciente:");

        buscaCpf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buscaCpf.setForeground(new java.awt.Color(0, 0, 204));

        btBuscar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btBuscar.setForeground(new java.awt.Color(59, 147, 171));
        btBuscar.setText("BUSCAR");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        consTeleP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        consTeleP.setForeground(new java.awt.Color(0, 0, 204));

        rtCons.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        rtCons.setForeground(new java.awt.Color(255, 255, 255));
        rtCons.setText("Dia da Consulta");

        consCons.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        consCons.setForeground(new java.awt.Color(0, 0, 204));

        consApagar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        consApagar.setForeground(new java.awt.Color(59, 147, 171));
        consApagar.setText("EXCLUIR");
        consApagar.setActionCommand("");
        consApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consApagarActionPerformed(evt);
            }
        });

        consAlterar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        consAlterar.setForeground(new java.awt.Color(59, 147, 171));
        consAlterar.setText("ALTERAR");
        consAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consAlterarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome Paciente");

        consNomeP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        consNomeP.setForeground(new java.awt.Color(0, 0, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefone Paciente");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Descrição ");

        descriçãoCon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        descriçãoCon.setForeground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btBuscar)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(consApagar)
                        .addGap(30, 30, 30)
                        .addComponent(consAlterar)
                        .addGap(73, 73, 73))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rtCons, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(consCons, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(descriçãoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(consTeleP)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(consNomeP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(rtCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btBuscar)
                .addGap(44, 44, 44))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(consNomeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(consTeleP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtCons)
                    .addComponent(consCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(descriçãoCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consApagar)
                    .addComponent(consAlterar))
                .addContainerGap())
        );

        jMenu1.setBackground(new java.awt.Color(204, 204, 255));
        jMenu1.setForeground(new java.awt.Color(59, 147, 171));
        jMenu1.setText("Inserir");

        jMenuItem2.setText("Relatório");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        mnCadMed.setText("Cadastrar médico");
        mnCadMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadMedActionPerformed(evt);
            }
        });
        jMenu1.add(mnCadMed);

        mnCadPac.setText("Cadastrar paciente");
        mnCadPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadPacActionPerformed(evt);
            }
        });
        jMenu1.add(mnCadPac);

        jMenuItem1.setText("Buscar Medico");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed

        Paciente pac = P.read(buscaCpf.getText());

        if (pac != null) {
            consNomeP.setText(pac.getNomePac());
            consTeleP.setText(pac.getTelefonePac());
            consCons.setText(pac.getConsulta().getDataCon());
            descriçãoCon.setText(pac.getConsulta().getDescrição());
            JOptionPane.showMessageDialog(this, "Encontrado!");
        } else {
            JOptionPane.showMessageDialog(this, "Não encontrado.");
        }

    }//GEN-LAST:event_btBuscarActionPerformed

    private void mnCadMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadMedActionPerformed
        MedicoCad medico = new MedicoCad();
        medico.setVisible(true);
    }//GEN-LAST:event_mnCadMedActionPerformed

    private void mnCadPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadPacActionPerformed

        cad.setVisible(true);
    }//GEN-LAST:event_mnCadPacActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        MB.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void consApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consApagarActionPerformed
  try {
    if (P != null) {
        P.delete(buscaCpf.getText());
        limparCampos();
        JOptionPane.showMessageDialog(null, "Registro deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Erro ao deletar o registro: Paciente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Erro ao deletar o registro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_consApagarActionPerformed

    private void consAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consAlterarActionPerformed

        String cpf = buscaCpf.getText().trim();
        String nome = consNomeP.getText();
        String tele = consTeleP.getText();
        String data = consCons.getText();
        String descricao = descriçãoCon.getText();

        if (!cpf.isEmpty()) {
            Paciente novo = new Paciente();
            novo.setCpf(cpf);
            novo.setNomePac(nome);
            novo.setTelefonePac(tele);

            // Verifica se a consulta já existe
            if (novo.getConsulta() != null) {
                novo.getConsulta().setDataCon(data);
                novo.getConsulta().setDescrição(descricao);
            } else {
                // Se não existir, cria uma nova consulta e define os valores
                Consulta novaConsulta = new Consulta();
                novaConsulta.setDataCon(data);
                novaConsulta.setDescrição(descricao);
                novo.setConsulta(novaConsulta);
            }

            // Passe o CFM original para o método de atualização
            String Original = buscaCpf.getText().trim();
            PD.update(novo);
            JOptionPane.showMessageDialog(this, "Atualizado com Sucesso");
        } else {
            JOptionPane.showMessageDialog(this, "Erro: O CFM não pode estar vazio!");
        }
        limparCampos();



    }//GEN-LAST:event_consAlterarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    Relatorio r = new Relatorio();
        r.setVisible(true);       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MedicoCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedicoCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedicoCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedicoCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JTextField buscaCpf;
    private javax.swing.JButton consAlterar;
    private javax.swing.JButton consApagar;
    private javax.swing.JTextField consCons;
    private javax.swing.JTextField consNomeP;
    private javax.swing.JTextField consTeleP;
    private javax.swing.JTextField descriçãoCon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem mnCadMed;
    private javax.swing.JMenuItem mnCadPac;
    private javax.swing.JLabel rtCons;
    private javax.swing.JLabel rtCpf;
    // End of variables declaration//GEN-END:variables
}
