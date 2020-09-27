/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.telas;

import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JFrame {

    // iniciando variáveis de conexão
    Connection conexao = null;
    // variáveis especiais de apoio a conexão
    PreparedStatement pst = null;
    // objeto matriz que recebe o resultado do comando sql
    ResultSet rs = null;
    
    public TelaUsuario() {
        initComponents();
        // executa metodo de conexao
        conexao = ModuloConexao.conector();
    }
    
    // metodo para consultar usuario
    private void consultar() {
           String sql = "SELECT * FROM tbusuarios WHERE iduser = ?";
            
        try {
            // prepara execução do sql
            pst = conexao.prepareStatement(sql);
            
            // recebe o dado caixa de texto e seta no comando sql
            pst.setString(1, userIdInput.getText());
            
            // executa comando select
            rs = pst.executeQuery();
                // se encontrou algo no banco
                if(rs.next()) {
                   userInput.setText(rs.getString(2));
                   userPhone.setText(rs.getString(3));
                   userLogin.setText(rs.getString(4));
                   userPass.setText(rs.getString(5));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Usuário não cadastrado.");
                    
                    // limpando campos do form
                    userInput.setText(null);
                    userPhone.setText(null);
                    userLogin.setText(null);
                    userPass.setText(null);
                }
            return;
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return;
        }
            
    }

    // metodo para adicionar usuario
    public void adicionar() {
        
        String sql = "INSERT INTO tbusuarios(usuario, login, senha, fone) VALUES (?,?,?,?)";
        try {
            // prepara execução do sql
            pst = conexao.prepareStatement(sql);
            
            // recebe os dados do form setando no comando sql
            pst.setString(1, userInput.getText());
            pst.setString(2, userLogin.getText());
            pst.setString(3, userPass.getText());
            pst.setString(4, userPhone.getText());
            
            // validação dos campos
            if(userInput.getText().isEmpty() || userLogin.getText().isEmpty() || userPass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos são obrigatórios.");
            } else {
                    int adicionado = pst.executeUpdate();
                    
                    if(adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso.");
                        
                        // limpando campos do form
                        userInput.setText(null);
                        userPhone.setText(null);
                        userLogin.setText(null);
                        userPass.setText(null);
                    }
            }
            return;
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return;
        }
        
    
    }
    
    // metodo que atualiza usuário
    public void alterar() {
        String sql = "UPDATE tbusuarios SET usuario=?, fone=?, login=?, senha=? WHERE iduser=?";
        
        try {
            // prepara execução do sql
            pst = conexao.prepareStatement(sql);
            
            // recebe os dados do form setando no comando sql
            pst.setString(1, userInput.getText());
            pst.setString(2, userLogin.getText());
            pst.setString(3, userPass.getText());
            pst.setString(4, userPhone.getText());
            pst.setString(5, userIdInput.getText());
            
            // validação dos campos
            if(userIdInput.getText().isEmpty() || userInput.getText().isEmpty() || userLogin.getText().isEmpty() || userPass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos são obrigatórios.");
            } else {
                    int adicionado = pst.executeUpdate();
                    
                    if(adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Dados do usuário alterado com sucesso!");
                        
                        // limpando campos do form
                        userInput.setText(null);
                        userPhone.setText(null);
                        userLogin.setText(null);
                        userPass.setText(null);
                    }
            }
            return;
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return;
        }
        
    }
    
    // metodo para remover usuário
    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
        
        // verifica se confirmou a exclusão
        if(confirma == JOptionPane.YES_OPTION) {
             // comando sql
            String sql = "DELETE FROM tbusuarios WHERE iduser=?";
            
            try {
                // prepara  execução do comando sql
                pst = conexao.prepareStatement(sql);
                
                // recebe campo id do form
                pst.setString(1, userIdInput.getText());
                
                // executa o comando sql
                int apagado = pst.executeUpdate();
                
                // se removeu
                if(apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    
                    // limpando campos do form
                        userIdInput.setText(null);
                        userInput.setText(null);
                        userPhone.setText(null);
                        userLogin.setText(null);
                        userPass.setText(null);
                        
                        // fecha tela
                        this.dispose();
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
        txtIdUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userInput = new javax.swing.JTextField();
        userLogin = new javax.swing.JTextField();
        btnUserCreate = new javax.swing.JButton();
        btnUserSearch = new javax.swing.JButton();
        btnUserUpdate = new javax.swing.JButton();
        btnUserDelete = new javax.swing.JButton();
        userPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        userIdInput = new javax.swing.JTextField();
        userPass = new javax.swing.JPasswordField();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuários");
        setResizable(false);

        txtIdUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdUser.setText("Usuário:");

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setText("Telefone:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Senha:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Login:");

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
        jLabel5.setText("Id:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUserDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUser)
                            .addComponent(txtIdUser)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(userPass))
                                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userIdInput)
                                    .addGap(213, 213, 213)))
                            .addComponent(userPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(userIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdUser)
                    .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(userPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        setSize(new java.awt.Dimension(512, 443));
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
                new TelaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUserCreate;
    private javax.swing.JButton btnUserDelete;
    private javax.swing.JButton btnUserSearch;
    private javax.swing.JButton btnUserUpdate;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel txtIdUser;
    private javax.swing.JLabel txtUser;
    private javax.swing.JTextField userIdInput;
    private javax.swing.JTextField userInput;
    private javax.swing.JTextField userLogin;
    private javax.swing.JPasswordField userPass;
    private javax.swing.JTextField userPhone;
    // End of variables declaration//GEN-END:variables
}
