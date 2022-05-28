package com.morandev.alura.conversoruniversal.views.conversor;

public class ConversorDeOtraCosa extends javax.swing.JPanel {

  public ConversorDeOtraCosa() {
        initComponents();
    }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConversor = new javax.swing.JPanel();
        headerTitleTxt = new javax.swing.JLabel();

        panelConversor.setBackground(new java.awt.Color(212, 241, 244));
        panelConversor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerTitleTxt.setBackground(new java.awt.Color(212, 241, 244));
        headerTitleTxt.setFont(new java.awt.Font("Consolas", 1, 40)); // NOI18N
        headerTitleTxt.setForeground(new java.awt.Color(131, 140, 155));
        headerTitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitleTxt.setText("Conversor de Otra Cosa");
        panelConversor.add(headerTitleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 107));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelConversor, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelConversor, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headerTitleTxt;
    private javax.swing.JPanel panelConversor;
    // End of variables declaration//GEN-END:variables
}
