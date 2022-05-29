package com.morandev.alura.conversoruniversal.views.conversor;

public class ConversorDeOtraCosa extends javax.swing.JPanel {

  public ConversorDeOtraCosa() {
        initComponents();
    }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConversor1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        headerTitleTxt = new javax.swing.JLabel();
        userInput = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbDivisa1 = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        headerTitleTxt1 = new javax.swing.JLabel();
        headerTitleTxt2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        userInput1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbDivisa = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        panelConversor1.setBackground(new java.awt.Color(212, 241, 244));
        panelConversor1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 89, 42));

        headerTitleTxt.setBackground(new java.awt.Color(255, 255, 255));
        headerTitleTxt.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        headerTitleTxt.setForeground(new java.awt.Color(255, 255, 255));
        headerTitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        headerTitleTxt.setText("FECHA:");

        userInput.setBackground(new java.awt.Color(240, 89, 42));
        userInput.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        userInput.setForeground(new java.awt.Color(255, 255, 255));
        userInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        userInput.setText("Ejm 1000");
        userInput.setToolTipText("");
        userInput.setBorder(null);
        userInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userInputFocusGained(evt);
            }
        });
        userInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userInputKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userInputKeyTyped(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(240, 89, 42));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("US DOLLAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        cmbDivisa1.setBackground(new java.awt.Color(240, 89, 42));
        cmbDivisa1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cmbDivisa1.setForeground(new java.awt.Color(255, 255, 255));
        cmbDivisa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD" }));
        cmbDivisa1.setAutoscrolls(true);
        cmbDivisa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbDivisa1.setFocusable(false);
        cmbDivisa1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDivisa1ItemStateChanged(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        headerTitleTxt1.setBackground(new java.awt.Color(255, 255, 255));
        headerTitleTxt1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        headerTitleTxt1.setForeground(new java.awt.Color(255, 255, 255));
        headerTitleTxt1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        headerTitleTxt1.setText("29/05/22");

        headerTitleTxt2.setBackground(new java.awt.Color(255, 255, 255));
        headerTitleTxt2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        headerTitleTxt2.setForeground(new java.awt.Color(255, 255, 255));
        headerTitleTxt2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        headerTitleTxt2.setText("CONVERSOR DE DIVISAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(cmbDivisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(headerTitleTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(headerTitleTxt1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(headerTitleTxt2)
                    .addContainerGap(508, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headerTitleTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbDivisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(242, 242, 242)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1424, 1424, 1424))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(headerTitleTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1865, Short.MAX_VALUE)))
        );

        panelConversor1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 260));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        userInput1.setBackground(new java.awt.Color(255, 255, 255));
        userInput1.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        userInput1.setForeground(new java.awt.Color(116, 116, 116));
        userInput1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        userInput1.setText("Ejm 1000");
        userInput1.setToolTipText("");
        userInput1.setBorder(null);
        userInput1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userInput1FocusGained(evt);
            }
        });
        userInput1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userInput1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userInput1KeyTyped(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(116, 116, 116));
        jSeparator2.setForeground(new java.awt.Color(116, 116, 116));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(116, 116, 116));
        jLabel2.setText("EURO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        cmbDivisa.setBackground(new java.awt.Color(255, 255, 255));
        cmbDivisa.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cmbDivisa.setForeground(new java.awt.Color(116, 116, 116));
        cmbDivisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD" }));
        cmbDivisa.setAutoscrolls(true);
        cmbDivisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbDivisa.setFocusable(false);
        cmbDivisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDivisaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(userInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(cmbDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        panelConversor1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 690, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelConversor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelConversor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInputFocusGained
        if( userInput.getText().equals("Ejm 1000") )
        userInput.setText("");
    }//GEN-LAST:event_userInputFocusGained

    private void userInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInputKeyReleased

        if( userInput.getText().isEmpty() ) {
            userInput2.setText("");
            return;
        }

        if( !userInput.getText().isEmpty() || !userInput.getText().equals(ABORT)  )
        convertAndPrintInputData( userInput );

        if ( userInput.getText().length() >= 15 )
        userInput.setText("");

    }//GEN-LAST:event_userInputKeyReleased

    private void userInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInputKeyTyped

        if ( !Character.isDigit( evt.getKeyChar() ) ) {
            evt.consume();
        }

    }//GEN-LAST:event_userInputKeyTyped

    private void userInput1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInput1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_userInput1FocusGained

    private void userInput1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInput1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_userInput1KeyReleased

    private void userInput1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInput1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_userInput1KeyTyped

    private void cmbDivisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDivisaItemStateChanged

        if( evt.getStateChange() == 1 ) {
            //!userInput2.getText().isEmpty(

                //inicio del programa
                if( userInput.getText().equals("Ejm 1000") ) {
                    setDivisaFrom( cmbDivisa );
                } else {
                    //el usuario interactua

                    if ( userInput2.getText().isEmpty() ) {
                        setDivisaTo( cmbDivisa );
                        convertAndPrintInputData( userInput );
                        return;
                    }

                    setDivisaFrom( cmbDivisa );
                    convertAndPrintInputData( userInput );

                }
            }

    }//GEN-LAST:event_cmbDivisaItemStateChanged

    private void cmbDivisa1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDivisa1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDivisa1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbDivisa;
    private javax.swing.JComboBox<String> cmbDivisa1;
    private javax.swing.JLabel headerTitleTxt;
    private javax.swing.JLabel headerTitleTxt1;
    private javax.swing.JLabel headerTitleTxt2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panelConversor1;
    private javax.swing.JTextField userInput;
    private javax.swing.JTextField userInput1;
    // End of variables declaration//GEN-END:variables
}
