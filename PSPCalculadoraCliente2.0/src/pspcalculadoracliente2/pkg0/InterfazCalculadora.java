/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspcalculadoracliente2.pkg0;

import javax.swing.JOptionPane;

/**
 *
 * @author quique
 */
public class InterfazCalculadora extends javax.swing.JFrame {

    /**
     * Creates new form InterfazCalculadora
     */
    public InterfazCalculadora() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        texto = new javax.swing.JTextField();
        bo1 = new javax.swing.JButton();
        bo2 = new javax.swing.JButton();
        bo3 = new javax.swing.JButton();
        bo4 = new javax.swing.JButton();
        bo5 = new javax.swing.JButton();
        bo6 = new javax.swing.JButton();
        bo7 = new javax.swing.JButton();
        bo8 = new javax.swing.JButton();
        bo9 = new javax.swing.JButton();
        bo0 = new javax.swing.JButton();
        boSuma = new javax.swing.JButton();
        boResta = new javax.swing.JButton();
        boDivi = new javax.swing.JButton();
        boRaiz = new javax.swing.JButton();
        boSend = new javax.swing.JButton();
        boMulti = new javax.swing.JButton();
        txtpuerto = new javax.swing.JTextField();
        boAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton3.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        texto.setEditable(false);

        bo1.setText("1");
        bo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo1ActionPerformed(evt);
            }
        });

        bo2.setText("2");
        bo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo2ActionPerformed(evt);
            }
        });

        bo3.setText("3");
        bo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo3ActionPerformed(evt);
            }
        });

        bo4.setText("4");
        bo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo4ActionPerformed(evt);
            }
        });

        bo5.setText("5");
        bo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo5ActionPerformed(evt);
            }
        });

        bo6.setText("6");
        bo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo6ActionPerformed(evt);
            }
        });

        bo7.setText("7");
        bo7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo7ActionPerformed(evt);
            }
        });

        bo8.setText("8");
        bo8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo8ActionPerformed(evt);
            }
        });

        bo9.setText("9");
        bo9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo9ActionPerformed(evt);
            }
        });

        bo0.setText("0");
        bo0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo0ActionPerformed(evt);
            }
        });

        boSuma.setText("+");
        boSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boSumaActionPerformed(evt);
            }
        });

        boResta.setText("-");
        boResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boRestaActionPerformed(evt);
            }
        });

        boDivi.setText("/");
        boDivi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boDiviActionPerformed(evt);
            }
        });

        boRaiz.setText("%");
        boRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boRaizActionPerformed(evt);
            }
        });

        boSend.setText("OK");
        boSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boSendActionPerformed(evt);
            }
        });

        boMulti.setText("*");
        boMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boMultiActionPerformed(evt);
            }
        });

        boAceptar.setText("Aceptar");
        boAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Puerto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(texto)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(bo4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bo5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bo6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(boResta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(bo1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bo2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bo3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(boSuma)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bo0)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boDivi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(bo7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bo8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boMulti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bo9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boRaiz)
                            .addComponent(boSend))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(boAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtpuerto)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bo1)
                        .addComponent(bo2)
                        .addComponent(bo3)
                        .addComponent(boSuma))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bo4)
                            .addComponent(bo5)
                            .addComponent(bo6)
                            .addComponent(boResta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bo7)
                            .addComponent(bo8)
                            .addComponent(bo9)
                            .addComponent(boRaiz))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bo0)
                            .addComponent(boDivi)
                            .addComponent(boSend)
                            .addComponent(boMulti)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtpuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boAceptar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo1ActionPerformed
        cadena = cadena + "1";
        texto.setText(cadena);
    }//GEN-LAST:event_bo1ActionPerformed

    private void bo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo2ActionPerformed
        cadena = cadena + "2";
        texto.setText(cadena);
    }//GEN-LAST:event_bo2ActionPerformed

    private void bo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo3ActionPerformed
        cadena = cadena + "3";
        texto.setText(cadena);
    }//GEN-LAST:event_bo3ActionPerformed

    private void bo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo4ActionPerformed
        cadena = cadena + "4";
        texto.setText(cadena);
    }//GEN-LAST:event_bo4ActionPerformed

    private void bo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo5ActionPerformed
        cadena = cadena + "5";
        texto.setText(cadena);
    }//GEN-LAST:event_bo5ActionPerformed

    private void bo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo6ActionPerformed
        cadena = cadena + "6";
        texto.setText(cadena);
    }//GEN-LAST:event_bo6ActionPerformed

    private void bo7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo7ActionPerformed
        cadena = cadena + "7";
        texto.setText(cadena);
    }//GEN-LAST:event_bo7ActionPerformed

    private void bo8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo8ActionPerformed
        cadena = cadena + "8";
        texto.setText(cadena);
    }//GEN-LAST:event_bo8ActionPerformed

    private void bo9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo9ActionPerformed
        cadena = cadena + "9";
        texto.setText(cadena);
    }//GEN-LAST:event_bo9ActionPerformed

    private void bo0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo0ActionPerformed
        cadena = cadena + "0";
        texto.setText(cadena);
    }//GEN-LAST:event_bo0ActionPerformed

    //Los if de los botones de las operaciones son para que recoja el primer número que introduces

    private void boSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boSumaActionPerformed

        if (num == 0) {
            num1 = cadena;
        }
        operacion = "SUM";
        cadena = "";
        texto.setText(cadena);
        num++;
    }//GEN-LAST:event_boSumaActionPerformed

    private void boRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boRestaActionPerformed
        if (num == 0) {
            num1 = cadena;
        }
        operacion = "RES";
        cadena = "";
        texto.setText(cadena);
        num++;
    }//GEN-LAST:event_boRestaActionPerformed

    private void boMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boMultiActionPerformed
        if (num == 0) {
            num1 = cadena;
        }
        operacion = "MULT";
        cadena = "";
        texto.setText(cadena);
        num++;
    }//GEN-LAST:event_boMultiActionPerformed

    private void boDiviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boDiviActionPerformed
        if (num == 0) {
            num1 = cadena;
        }
        operacion = "DIV";
        cadena = "";
        texto.setText(cadena);
        num++;
    }//GEN-LAST:event_boDiviActionPerformed

    private void boRaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boRaizActionPerformed

        operacion = "RZZ";
        m.raiz(cadena, operacion, m2);
        cadena = "";
        texto.setText(m.getTotal());
        m.setTotal("");
        m2++;
    }//GEN-LAST:event_boRaizActionPerformed

    private void boSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boSendActionPerformed
        //Si enviamos un 00 y pulsamos ok cerramos el servidor.
        if (texto.getText().equals("00")) {
            m.cerrar(m2);
        } else {
            if (num > 0) {
                num2 = cadena;
            }
            //Bloqueamos poder dividir entre 0
            if (num1.equals("0") || num2.equals("0") && operacion.equals("DIV")) {
                JOptionPane.showMessageDialog(this, "No puedes dividir entre 0.");
                cadena = "";
                num1 = "";
                num2 = "";
                operacion = "";
                num = 0;
            } else {
                //Llamamos al metodo enviarOperacion de la clase MetodosClientes y le pasamos los parametros
                m.enviarOperacion(num1, num2, operacion, m2);
                m2++;
                cadena = "";
                num1 = "";
                num2 = "";
                operacion = "";

                texto.setText(m.getTotal());
                m.setTotal("");
                num = 0;
            }
        }
    }//GEN-LAST:event_boSendActionPerformed

    private void boAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boAceptarActionPerformed
        npuerto = txtpuerto.getText();
        txtpuerto.setText("");
        m.conexion(npuerto);
    }//GEN-LAST:event_boAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazCalculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bo0;
    public javax.swing.JButton bo1;
    public javax.swing.JButton bo2;
    public javax.swing.JButton bo3;
    public javax.swing.JButton bo4;
    public javax.swing.JButton bo5;
    public javax.swing.JButton bo6;
    public javax.swing.JButton bo7;
    public javax.swing.JButton bo8;
    public javax.swing.JButton bo9;
    public javax.swing.JButton boAceptar;
    public javax.swing.JButton boDivi;
    public javax.swing.JButton boMulti;
    public javax.swing.JButton boRaiz;
    public javax.swing.JButton boResta;
    public javax.swing.JButton boSend;
    public javax.swing.JButton boSuma;
    public javax.swing.JButton jButton3;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JTextField texto;
    public javax.swing.JTextField txtpuerto;
    // End of variables declaration//GEN-END:variables
    String cadena = "";
    String npuerto;
    String operacion;
    String num1, num2;
    int num = 0;
    int m2 = 0;
    MetodosClientes m = new MetodosClientes();
}
