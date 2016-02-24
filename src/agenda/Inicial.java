package agenda;

import static java.lang.System.exit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Inicial extends javax.swing.JFrame {

    private ArrayList<Object> id = new ArrayList<>();
    private ArrayList<Object> nome = new ArrayList<>();
    private ArrayList<Object> telFixo = new ArrayList<>();
    private ArrayList<Object> telCel = new ArrayList<>();
    private ArrayList<Object> email = new ArrayList<>();

    public Inicial() throws SQLException {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        ResultSet rs = null;
        Banco a = new Banco();
        rs = a.preencheTabelaContato();

        while (rs.next()) {
            id.add(rs.getInt("id"));
            nome.add(rs.getString("nome"));
            telFixo.add(rs.getString("telfixo"));
            telCel.add(rs.getString("telcel"));
            email.add(rs.getString("email"));
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableContatos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableContatos.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        DefaultTableModel model = (DefaultTableModel) tableContatos.getModel();

        for (int i = 0; i < id.size(); i++) {
            model.addRow(new Object[]{id.get(i), nome.get(i), telFixo.get(i), telCel.get(i), email.get(i)});
        }

        tableContatos.setDefaultRenderer(Object.class, new CellRenderer());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        buttonSair = new javax.swing.JButton();
        buttonNovoCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textBuscar = new javax.swing.JTextField();
        buttonBuscar = new javax.swing.JButton();
        buttoAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda Marin Château v.1.0");

        tableContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Telefone Fixo", "Telefone Celular", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableContatos);
        if (tableContatos.getColumnModel().getColumnCount() > 0) {
            tableContatos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableContatos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableContatos.getColumnModel().getColumn(2).setPreferredWidth(75);
            tableContatos.getColumnModel().getColumn(3).setPreferredWidth(75);
            tableContatos.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        buttonSair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonSair.setText("Sair");
        buttonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSairMouseClicked(evt);
            }
        });
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        buttonNovoCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonNovoCliente.setText("Novo Cliente");
        buttonNovoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonNovoClienteMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Agenda");

        textBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscarActionPerformed(evt);
            }
        });

        buttonBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonBuscar.setText("Buscar");
        buttonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBuscarMouseClicked(evt);
            }
        });

        buttoAtualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttoAtualizar.setText("Atualizar");
        buttoAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttoAtualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttoAtualizar)
                                .addGap(18, 18, 18)
                                .addComponent(buttonNovoCliente))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNovoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNovoClienteMouseClicked
        // TODO add your handling code here:
        NovoCliente a = new NovoCliente();
        a.setVisible(true);
    }//GEN-LAST:event_buttonNovoClienteMouseClicked

    private void buttonSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSairMouseClicked
        // TODO add your handling code here:
        exit(0);
    }//GEN-LAST:event_buttonSairMouseClicked

    private void buttoAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttoAtualizarMouseClicked
        // TODO add your handling code here:
        this.dispose();
        Inicial a = null;
        try {
            a = new Inicial();
        } catch (SQLException ex) {
            Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.setVisible(true);
    }//GEN-LAST:event_buttoAtualizarMouseClicked

    private void buttonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBuscarMouseClicked
        // TODO add your handling code here:
        Banco a = new Banco();
        ResultSet rs = null;

        rs = a.buscaContato(textBuscar.getText());
        TabelaBusca b = null;
        try {
            b = new TabelaBusca(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        b.setVisible(true);
    }//GEN-LAST:event_buttonBuscarMouseClicked

    private void textBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscarActionPerformed
        // TODO add your handling code here:
        buttonBuscarMouseClicked(null);
    }//GEN-LAST:event_textBuscarActionPerformed

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        // TODO add your handling code here:
        exit(0);
    }//GEN-LAST:event_buttonSairActionPerformed

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
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inicial().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttoAtualizar;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonNovoCliente;
    private javax.swing.JButton buttonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JTable tableContatos = new javax.swing.JTable();
    private javax.swing.JTextField textBuscar;
    // End of variables declaration//GEN-END:variables

}
