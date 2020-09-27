/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.telas;

import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaOS extends javax.swing.JFrame {

    // iniciando variáveis de conexão
    Connection conexao = null;
    // variáveis especiais de apoio a conexão
    PreparedStatement pst = null;
    // objeto matriz que recebe o resultado do comando sql
    ResultSet rs = null;
    ResultSet tot = null;
    public TelaOS() {
        initComponents();
        // executa metodo de conexao
        conexao = ModuloConexao.conector();
    }
    
    // metodo para consultar ordens de serviços
    private void consultar() {
           String sql = "SELECT * FROM tbos WHERE os = ?";
           
           if(inputOs.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null, "Preencha o id da OS");
               return;
           }
            
        try {
            // prepara execução do sql
            pst = conexao.prepareStatement(sql);
            
            // recebe o dado caixa de texto e seta no comando sql
            pst.setString(1, inputOs.getText());
            
            // executa comando select
            rs = pst.executeQuery();
                // se encontrou algo no banco
                if(rs.next()) {
                   osData.setText(rs.getString(2));
                   inputEQuip.setText(rs.getString(3));
                   inputDef.setText(rs.getString(4));
                   inputServ.setText(rs.getString(5));
                   inputTec.setText(rs.getString(6));
                   inputValue.setText(rs.getString(7));
                   inputIdCli.setText(rs.getString(8));
                }
                else {
                    JOptionPane.showMessageDialog(null, "OS não encontrada.");
                    
                    // limpando campos do form
                    inputEQuip.setText(null);
                    inputDef.setText(null);
                    inputServ.setText(null);
                    inputTec.setText(null);
                    inputValue.setText(null);
                    inputIdCli.setText(null);
                }
            return;
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return;
        }
            
    }

    // metodo para adicionar  ordens de serviços
    public void adicionar() {
        // validação dos campos
        if(inputEQuip.getText().isEmpty() || inputDef.getText().isEmpty() || inputServ.getText().isEmpty() || inputTec.getText().isEmpty() || inputValue.getText().isEmpty() || inputIdCli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
            return;
        }
        // comando para verificar se possui cliente com id repassado
        String sqlCli = "SELECT * FROM tbclientes WHERE idcli = ?";
        
        try {
            // prepara conexão do select do cliente
            pst = conexao.prepareStatement(sqlCli);
            // seta o id no cliente no comando sql
            pst.setString(1, inputIdCli.getText());
            // recebe a execução do comando select
            rs = pst.executeQuery();
            // verifica se possui cliente com id repassado.
            if(rs.first() == true) {
                
                // comando sql para inserir os
                String sql = "INSERT INTO tbos(equipamento, defeito, servico, tecnico, valor, idcli) VALUES (?,?,?,?,?,?)";
                    // prepara execução do sql
                    pst = conexao.prepareStatement(sql);

                    // recebe os dados do form setando no comando sql
                    pst.setString(1, inputEQuip.getText());
                    pst.setString(2, inputDef.getText());
                    pst.setString(3, inputServ.getText());
                    pst.setString(4, inputTec.getText());
                    pst.setString(5, inputValue.getText());
                    pst.setString(6, inputIdCli.getText());
                    // recebe valor se o comando foi bem sucedido
                    int adicionado = pst.executeUpdate();

                            if(adicionado > 0) {
                                JOptionPane.showMessageDialog(null, "OS adicionada com sucesso.");

                                // limpando campos do form
                                inputEQuip.setText(null);
                                inputDef.setText(null);
                                inputServ.setText(null);
                                inputTec.setText(null);
                                inputValue.setText(null);
                                inputIdCli.setText(null);

                                return;
                            }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum cliente correspondente.");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return;
        }
    
    }
    
    // metodo que atualiza  ordens de serviços
    public void alterar() {
        // validação dos campos
        if(inputEQuip.getText().isEmpty() || inputDef.getText().isEmpty() || inputServ.getText().isEmpty() || inputTec.getText().isEmpty() || inputValue.getText().isEmpty() || inputIdCli.getText().isEmpty() || inputOs.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos são obrigatórios.");
        }
        // comando para verificar se possui cliente com id repassado
        String sqlCli = "SELECT * FROM tbclientes WHERE idcli = ?";
        
        
        try {
            // prepara conexão do select do cliente
            pst = conexao.prepareStatement(sqlCli);
            // seta o id no cliente no comando sql
            pst.setString(1, inputIdCli.getText());
            // recebe a execução do comando select
            rs = pst.executeQuery();
            
            // verifica se possui cliente com id repassado.
            if(rs.first() == true) {
                // comando que atualiza os
                String sql = "UPDATE tbos SET equipamento=?, defeito=?, servico=?, tecnico=?, valor=?, idcli=? WHERE os=?";
                
                // prepara execução do sql
                pst = conexao.prepareStatement(sql);

                // recebe os dados do form setando no comando sql
                pst.setString(1, inputEQuip.getText());
                pst.setString(2, inputDef.getText());
                pst.setString(3, inputServ.getText());
                pst.setString(4, inputTec.getText());
                pst.setString(5, inputValue.getText());
                pst.setString(6, inputIdCli.getText());
                pst.setString(7, inputOs.getText());
                
                int adicionado = pst.executeUpdate();
                    
                    if(adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Dados da OS alterado com sucesso!");
                        
                        // limpando campos do form
                        inputOs.setText(null);
                        inputEQuip.setText(null);
                        inputDef.setText(null);
                        inputServ.setText(null);
                        inputTec.setText(null);
                        inputValue.setText(null);
                        inputIdCli.setText(null);
                    }
            }
             else {
                JOptionPane.showMessageDialog(null, "Nenhum cliente correspondente.");
                return;
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return;
        }
        
    }
    
    // metodo para remover  ordens de serviços
    private void remover() {
        
        if(inputOs.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o id da OS para exclusão.");
            return;
        }
        
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta OS?", "Atenção", JOptionPane.YES_NO_OPTION);
        
        // verifica se confirmou a exclusão
        if(confirma == JOptionPane.YES_OPTION) {
             // comando sql
            String sql = "DELETE FROM tbos WHERE os=?";
            
            try {
                // prepara  execução do comando sql
                pst = conexao.prepareStatement(sql);
                
                // recebe campo id do form
                pst.setString(1, inputOs.getText());
                
                // executa o comando sql
                int apagado = pst.executeUpdate();
                
                // se removeu
                if(apagado > 0) {
                    JOptionPane.showMessageDialog(null, "OS removida com sucesso!");
                    
                        // limpando campos do form
                        inputEQuip.setText(null);
                        inputDef.setText(null);
                        inputServ.setText(null);
                        inputTec.setText(null);
                        inputValue.setText(null);
                        inputIdCli.setText(null);
                        
                        // fecha tela
                        this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "OS não encontrada.");
                    
                        // limpando campos do form
                        inputEQuip.setText(null);
                        inputDef.setText(null);
                        inputServ.setText(null);
                        inputTec.setText(null);
                        inputValue.setText(null);
                        inputIdCli.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        Equipamento = new javax.swing.JLabel();
        txtUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputEQuip = new javax.swing.JTextField();
        inputDef = new javax.swing.JTextField();
        btnUserCreate = new javax.swing.JButton();
        btnUserSearch = new javax.swing.JButton();
        btnUserUpdate = new javax.swing.JButton();
        btnUserDelete = new javax.swing.JButton();
        inputServ = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputOs = new javax.swing.JTextField();
        inputTec = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputValue = new javax.swing.JTextField();
        inputIdCli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        osData = new javax.swing.JTextField();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuários");
        setResizable(false);

        Equipamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Equipamento.setText("Equipamento");

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setText("Serviço");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Técnico");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Defeito");

        btnUserCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/create.png"))); // NOI18N
        btnUserCreate.setToolTipText("Cadastrar");
        btnUserCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserCreateActionPerformed(evt);
            }
        });

        btnUserSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/read.png"))); // NOI18N
        btnUserSearch.setToolTipText("Consultar");
        btnUserSearch.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserSearchActionPerformed(evt);
            }
        });

        btnUserUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/update.png"))); // NOI18N
        btnUserUpdate.setToolTipText("Alterar usuário");
        btnUserUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserUpdateActionPerformed(evt);
            }
        });

        btnUserDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/delete.png"))); // NOI18N
        btnUserDelete.setToolTipText("Excluir");
        btnUserDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserDeleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("OS");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Valor");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("id Cliente");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUser)
                                .addComponent(jLabel3)))
                        .addGap(18, 23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Equipamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputEQuip, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputOs)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(osData, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputDef)
                    .addComponent(inputServ)
                    .addComponent(inputIdCli)
                    .addComponent(inputValue, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(inputTec))
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUserDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUserDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(inputOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(osData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Equipamento)
                            .addComponent(inputEQuip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputTec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(inputValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUserSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUserCreate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUserUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
        );

        setSize(new java.awt.Dimension(512, 459));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserSearchActionPerformed
        consultar();
    }//GEN-LAST:event_btnUserSearchActionPerformed

    private void btnUserCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserCreateActionPerformed
        // chama metodo que adiciona usuario
        adicionar();
    }//GEN-LAST:event_btnUserCreateActionPerformed

    private void btnUserUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserUpdateActionPerformed
        // chama metodo que altera usuário
        alterar();
    }//GEN-LAST:event_btnUserUpdateActionPerformed

    private void btnUserDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDeleteActionPerformed
        // chama metodo para excluir usuário
        remover();
    }//GEN-LAST:event_btnUserDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Equipamento;
    private javax.swing.JButton btnUserCreate;
    private javax.swing.JButton btnUserDelete;
    private javax.swing.JButton btnUserSearch;
    private javax.swing.JButton btnUserUpdate;
    private javax.swing.JTextField inputDef;
    private javax.swing.JTextField inputEQuip;
    private javax.swing.JTextField inputIdCli;
    private javax.swing.JTextField inputOs;
    private javax.swing.JTextField inputServ;
    private javax.swing.JTextField inputTec;
    private javax.swing.JTextField inputValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField osData;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables
}
