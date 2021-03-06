/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.telas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import br.com.infox.dal.ModuloConexao;
import java.sql.*;

/**
 *
 * @author SAMSUNG
 */
public class TelaPrincipal extends javax.swing.JFrame {
    Connection conexao = null;
    // variáveis especiais de apoio a conexão
    PreparedStatement pst = null;
    // objeto matriz que recebe o resultado do comando sql
    ResultSet rs = null;
    public TelaPrincipal() {
        initComponents();
       
        // exibe caixa de confirmação
        // data atual
        String data = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        // setando data no label
        lblDate.setText(data);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        MainCad = new javax.swing.JMenu();
        CadClient = new javax.swing.JMenuItem();
        CadOs = new javax.swing.JMenuItem();
        cadUsers = new javax.swing.JMenuItem();
        MainRel = new javax.swing.JMenu();
        relClientes = new javax.swing.JMenuItem();
        relServices = new javax.swing.JMenuItem();
        relOS = new javax.swing.JMenuItem();
        MainHelp = new javax.swing.JMenu();
        HelpAbout = new javax.swing.JMenuItem();
        MainOptions = new javax.swing.JMenu();
        OptionsClose = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("infoX - Sistema de Controle de OS");
        setBackground(new java.awt.Color(51, 204, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/x.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("ADMINISTRADOR");

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("WALLACE FROTA DA SILVA");

        lblDate.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(lblDate)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(60, 60, 60)
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setForeground(new java.awt.Color(0, 51, 51));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/fr.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Maiandra GD", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("infoX");

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Soluções em Ordens de Serviços");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(94, 94, 94))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setForeground(new java.awt.Color(0, 153, 255));

        MainCad.setText("Cadastro");

        CadClient.setText("Cliente");
        CadClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadClientActionPerformed(evt);
            }
        });
        MainCad.add(CadClient);

        CadOs.setText("OS");
        CadOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadOsActionPerformed(evt);
            }
        });
        MainCad.add(CadOs);

        cadUsers.setText("Usuários");
        cadUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadUsersActionPerformed(evt);
            }
        });
        MainCad.add(cadUsers);

        Menu.add(MainCad);

        MainRel.setText("Relatório");
        MainRel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainRelActionPerformed(evt);
            }
        });

        relClientes.setText("Clientes");
        relClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relClientesActionPerformed(evt);
            }
        });
        MainRel.add(relClientes);

        relServices.setText("Serviços");
        relServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relServicesActionPerformed(evt);
            }
        });
        MainRel.add(relServices);

        relOS.setText("OS");
        relOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relOSActionPerformed(evt);
            }
        });
        MainRel.add(relOS);

        Menu.add(MainRel);

        MainHelp.setText("Ajuda");

        HelpAbout.setText("Sobre");
        HelpAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpAboutActionPerformed(evt);
            }
        });
        MainHelp.add(HelpAbout);

        Menu.add(MainHelp);

        MainOptions.setText("Opções");

        OptionsClose.setText("Sair");
        OptionsClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsCloseActionPerformed(evt);
            }
        });
        MainOptions.add(OptionsClose);

        Menu.add(MainOptions);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(902, 561));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CadClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadClientActionPerformed
        // chamada da tela de clientes
        TelaCliente cliente = new TelaCliente();
        cliente.setVisible(true);
    }//GEN-LAST:event_CadClientActionPerformed

    private void OptionsCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsCloseActionPerformed
        // EXIBE CAIXA DE CONFIRMAÇÃO DE SAÍDA
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção!", JOptionPane.YES_NO_OPTION);
        // EXECUTA A AÇÃO ESCOLHIDA
        if(sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_OptionsCloseActionPerformed

    private void HelpAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpAboutActionPerformed
        // chamando tela sobre
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_HelpAboutActionPerformed

    private void cadUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadUsersActionPerformed
        // chamada da tela de usuário
        TelaUsuario usuario = new TelaUsuario();
        usuario.setVisible(true);
    }//GEN-LAST:event_cadUsersActionPerformed

    private void CadOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadOsActionPerformed
        // chamada da tela de OS
        TelaOS os = new TelaOS();
        os.setVisible(true);
    }//GEN-LAST:event_CadOsActionPerformed
    // emite relatórios de serviços
    private void relServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relServicesActionPerformed

        // exibe caixa de confirmação
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão deste relatório.", "Atenção!", JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION)  {
            String sql = " SELECT O.os, O.equipamento, O.defeito, O.servico, O.tecnico, O.valor, C.nomecli, C.fonecli " +
                         " FROM tbos as O " +
                         " INNER JOIN tbclientes as C " +
                         " ON (O.idcli = C.idcli) ";
            
            // imprime relatório servicos
            try {
                // abre conexão
                conexao = ModuloConexao.conector();
                // prepara execução do sql
                pst = conexao.prepareStatement(sql);
                // executa comando select
                rs = pst.executeQuery();
                    // se encontrou algo no banco
                    while (rs.next()) {
                        String equipamento = rs.getString("equipamento");
                        String defeito = rs.getString("defeito");
                        String servico = rs.getString("servico");
                        String tecnico = rs.getString("tecnico");
                        int valor = rs.getInt("valor");
                        String nome = rs.getString("nomecli");
                        int fone = rs.getInt("fonecli");
                        System.out.println(
                                " Equipamento: " + equipamento + " || " +
                                " Defeito: " + defeito + " || " +
                                " Servico: "+ servico + " || " +
                                " Técnico: " + tecnico + " || " +
                                " Valor: " + valor + " || " +
                                " Nome: " + nome + " || " +
                                " Telefone: " + fone);
                        System.out.println();
                    }
                    // fechar a conexão com o BD
                    conexao.close();
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return;
            }  
        }
    }//GEN-LAST:event_relServicesActionPerformed

    private void MainRelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainRelActionPerformed
        
    }//GEN-LAST:event_MainRelActionPerformed
    
    // emite relatório de clientes
    private void relClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relClientesActionPerformed

        // exibe caixa de confirmação
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão deste relatório.", "Atenção!", JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION)  {
            String sql = "SELECT * FROM tbclientes";
            // imprime relatório de clientes
            try {
                // abre conexão
                conexao = ModuloConexao.conector();
                // prepara execução do sql
                pst = conexao.prepareStatement(sql);
                // executa comando select
                rs = pst.executeQuery();
                    // se encontrou algo no banco
                    while (rs.next()) {
                        String nome = rs.getString(2);
                        String endereco = rs.getString(3);
                        int fone = rs.getInt(4);
                        String email = rs.getString(5);
                        System.out.println("Nome: " + nome + " Endereço: " + endereco + " Telefone: "+ fone + " E-mail: " + email);
                        System.out.println();
                    }
                     
                    // fechar a conexão com o BD
                    conexao.close();
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return;
            }  
        }
    }//GEN-LAST:event_relClientesActionPerformed
    // emite relatório de os
    private void relOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relOSActionPerformed

        // exibe caixa de confirmação
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão deste relatório.", "Atenção!", JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION)  {
            String sql = "SELECT * FROM tbos ORDER BY data_os DESC";
            // imprime relatório de OS's
            try {
                // abre conexão
                conexao = ModuloConexao.conector();
                // prepara execução do sql
                pst = conexao.prepareStatement(sql);
                // executa comando select
                rs = pst.executeQuery();
                    // se encontrou algo no banco
                    while (rs.next()) {
                        int os = rs.getInt("os");
                        String equipamento = rs.getString("equipamento");
                        String defeito = rs.getString("defeito");
                        String servico = rs.getString("servico");
                        String tecnico = rs.getString("tecnico");
                        int valor = rs.getInt("valor");
                        int idcli = rs.getInt("idcli");
                        System.out.println(
                                " OS: " + os + " || " +
                                " Equipamento: " + equipamento + " || " +
                                " Defeito: " + defeito + " || " +
                                " Servico: "+ servico + " || " +
                                " Técnico: " + tecnico + " || " +
                                " Valor: " + valor + " || " +
                                " ID cliente: " + idcli);
                        System.out.println();
                    }
                    // fechar a conexão com o BD
                    conexao.close();
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return;
            }  
        }
    }//GEN-LAST:event_relOSActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CadClient;
    private javax.swing.JMenuItem CadOs;
    private javax.swing.JMenuItem HelpAbout;
    private javax.swing.JMenu MainCad;
    private javax.swing.JMenu MainHelp;
    private javax.swing.JMenu MainOptions;
    private javax.swing.JMenu MainRel;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem OptionsClose;
    private javax.swing.JMenuItem cadUsers;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JMenuItem relClientes;
    private javax.swing.JMenuItem relOS;
    private javax.swing.JMenuItem relServices;
    // End of variables declaration//GEN-END:variables
}
