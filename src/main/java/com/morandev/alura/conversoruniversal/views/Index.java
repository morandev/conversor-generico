/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.morandev.alura.conversoruniversal.views;


import java.awt.Color;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

import com.morandev.alura.conversoruniversal.views.conversor.ConversorDivisas;
import com.morandev.alura.conversoruniversal.views.conversor.ConversorDeOtraCosa;

public class Index extends javax.swing.JFrame {
        
    private JPanel conversorDivisas = new ConversorDivisas();
    private JPanel conversorDeOtraCosa = new ConversorDeOtraCosa();
    private int xOnJFrameMove = 0;
    private int yOnJFrameMove = 0;
    private int xScreenDrag = 0;
    private int yScreenDrag = 0;
    
    /**
     *  Constructor
     */
    public Index() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgIndex = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        titleTxt = new javax.swing.JLabel();
        panelCloseTab = new javax.swing.JPanel();
        btnExitContainer = new javax.swing.JPanel();
        btnExitTxt = new javax.swing.JLabel();
        panelOptions = new javax.swing.JPanel();
        botonera = new javax.swing.JPanel();
        btnConversorContainer = new javax.swing.JPanel();
        btnConversorDivisasTxt = new javax.swing.JLabel();
        btnConversorContainer1 = new javax.swing.JPanel();
        btnConversorTemperaturaTxt = new javax.swing.JLabel();
        footerContainer = new javax.swing.JPanel();
        footerTxt = new javax.swing.JLabel();
        panelConversor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1010, 549));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgIndex.setBackground(new java.awt.Color(128, 138, 152));
        bgIndex.setPreferredSize(new java.awt.Dimension(1017, 555));
        bgIndex.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHeader.setBackground(new java.awt.Color(151, 149, 144));
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleTxt.setBackground(new java.awt.Color(151, 149, 144));
        titleTxt.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(185, 172, 140));
        titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTxt.setText("<html><p>Conversor<br>Universal</p></html>");
        titleTxt.setToolTipText("");
        panelHeader.add(titleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 160));

        bgIndex.add(panelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 160));

        panelCloseTab.setBackground(new java.awt.Color(212, 241, 244));
        panelCloseTab.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelCloseTabMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelCloseTabMouseMoved(evt);
            }
        });
        panelCloseTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExitContainer.setBackground(new java.awt.Color(255, 255, 255));
        btnExitContainer.setForeground(new java.awt.Color(255, 255, 255));

        btnExitTxt.setBackground(new java.awt.Color(199, 80, 80));
        btnExitTxt.setFont(new java.awt.Font("Roboto Black", 0, 25)); // NOI18N
        btnExitTxt.setForeground(new java.awt.Color(245, 244, 246));
        btnExitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExitTxt.setText("x");
        btnExitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExitTxt.setOpaque(true);
        btnExitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnExitContainerLayout = new javax.swing.GroupLayout(btnExitContainer);
        btnExitContainer.setLayout(btnExitContainerLayout);
        btnExitContainerLayout.setHorizontalGroup(
            btnExitContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExitContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnExitContainerLayout.setVerticalGroup(
            btnExitContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExitContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelCloseTab.add(btnExitContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 50, 50));

        bgIndex.add(panelCloseTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 690, 50));

        panelOptions.setBackground(new java.awt.Color(151, 149, 144));
        panelOptions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonera.setBackground(new java.awt.Color(184, 169, 141));

        btnConversorContainer.setBackground(new java.awt.Color(131, 140, 155));

        btnConversorDivisasTxt.setBackground(new java.awt.Color(131, 140, 155));
        btnConversorDivisasTxt.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnConversorDivisasTxt.setForeground(new java.awt.Color(185, 172, 140));
        btnConversorDivisasTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConversorDivisasTxt.setText("Conversor Divisas");
        btnConversorDivisasTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConversorDivisasTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConversorDivisasTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConversorDivisasTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConversorDivisasTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnConversorContainerLayout = new javax.swing.GroupLayout(btnConversorContainer);
        btnConversorContainer.setLayout(btnConversorContainerLayout);
        btnConversorContainerLayout.setHorizontalGroup(
            btnConversorContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConversorDivisasTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnConversorContainerLayout.setVerticalGroup(
            btnConversorContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConversorDivisasTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        btnConversorContainer1.setBackground(new java.awt.Color(131, 140, 155));

        btnConversorTemperaturaTxt.setBackground(new java.awt.Color(131, 140, 155));
        btnConversorTemperaturaTxt.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnConversorTemperaturaTxt.setForeground(new java.awt.Color(185, 172, 140));
        btnConversorTemperaturaTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConversorTemperaturaTxt.setText("Conversor Temperatura");
        btnConversorTemperaturaTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConversorTemperaturaTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConversorTemperaturaTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConversorTemperaturaTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConversorTemperaturaTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnConversorContainer1Layout = new javax.swing.GroupLayout(btnConversorContainer1);
        btnConversorContainer1.setLayout(btnConversorContainer1Layout);
        btnConversorContainer1Layout.setHorizontalGroup(
            btnConversorContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConversorTemperaturaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        btnConversorContainer1Layout.setVerticalGroup(
            btnConversorContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConversorTemperaturaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout botoneraLayout = new javax.swing.GroupLayout(botonera);
        botonera.setLayout(botoneraLayout);
        botoneraLayout.setHorizontalGroup(
            botoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConversorContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConversorContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        botoneraLayout.setVerticalGroup(
            botoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoneraLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnConversorContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConversorContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        panelOptions.add(botonera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 280));

        footerContainer.setBackground(new java.awt.Color(151, 149, 144));

        footerTxt.setBackground(new java.awt.Color(128, 138, 152));
        footerTxt.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        footerTxt.setForeground(new java.awt.Color(185, 172, 140));
        footerTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        footerTxt.setText("<html><p><center>© 2021 github.com/morandev <br> Alura Java Challenge </center></p></html>");
        footerTxt.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        footerTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                footerTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                footerTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout footerContainerLayout = new javax.swing.GroupLayout(footerContainer);
        footerContainer.setLayout(footerContainerLayout);
        footerContainerLayout.setHorizontalGroup(
            footerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerContainerLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(footerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        footerContainerLayout.setVerticalGroup(
            footerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerContainerLayout.createSequentialGroup()
                .addComponent(footerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        panelOptions.add(footerContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 320, 80));

        bgIndex.add(panelOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 320, 390));

        panelConversor.setBackground(new java.awt.Color(212, 241, 244));
        panelConversor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        bgIndex.add(panelConversor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 690, 500));

        getContentPane().add(bgIndex, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Configuraciones iniciales del Frame
    */
    private void init() {
        actualizarPanelConversor( conversorDivisas );
    }
    
    public void actualizarPanelConversor(JPanel nuevoPanel) {
        actualizarContentPane( this.panelConversor, nuevoPanel);
    }
    
    public void actualizarContentPane(JPanel actualPanel, JPanel nuevoPanel) {
        nuevoPanel.setSize(700, 500);

        actualPanel.removeAll();
        actualPanel.add( nuevoPanel, new AbsoluteConstraints(0, 0, -1, -1) );
        actualPanel.revalidate();
        actualPanel.repaint();
    }
    
    private void btnExitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitTxtMouseClicked

    private void btnExitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseEntered
        this.btnExitTxt.setBackground(Color.red);
    }//GEN-LAST:event_btnExitTxtMouseEntered

    private void btnExitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseExited
        this.btnExitTxt.setBackground(new Color(199, 80, 80));
    }//GEN-LAST:event_btnExitTxtMouseExited

    private void btnConversorDivisasTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConversorDivisasTxtMouseEntered
        this.btnConversorContainer.setBackground( new Color(140, 156, 140) );
        this.btnConversorDivisasTxt.setForeground( Color.white );
    }//GEN-LAST:event_btnConversorDivisasTxtMouseEntered

    private void btnConversorDivisasTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConversorDivisasTxtMouseExited
        this.btnConversorContainer.setBackground( new Color(131, 140, 155) );
        this.btnConversorDivisasTxt.setForeground( new Color(185,172,140) );
    }//GEN-LAST:event_btnConversorDivisasTxtMouseExited

    private void footerTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footerTxtMouseEntered
        this.footerTxt.setForeground( new Color(255, 193, 41) );
    }//GEN-LAST:event_footerTxtMouseEntered

    private void footerTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footerTxtMouseExited
        this.footerTxt.setForeground( new Color(185,172,140) );
    }//GEN-LAST:event_footerTxtMouseExited

    private void panelCloseTabMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCloseTabMouseDragged
        this.xScreenDrag = evt.getX();
        this.yScreenDrag = evt.getY();
        
        this.setLocation( this.getLocation().x+xScreenDrag-xOnJFrameMove, this.getLocation().y+yScreenDrag-yOnJFrameMove );
    }//GEN-LAST:event_panelCloseTabMouseDragged

    private void panelCloseTabMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCloseTabMouseMoved
        this.xOnJFrameMove = evt.getX();
        this.yOnJFrameMove = evt.getY();
    }//GEN-LAST:event_panelCloseTabMouseMoved

    private void btnConversorDivisasTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConversorDivisasTxtMouseClicked
        actualizarContentPane( this.panelConversor, this.conversorDivisas );
    }//GEN-LAST:event_btnConversorDivisasTxtMouseClicked

    private void btnConversorTemperaturaTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConversorTemperaturaTxtMouseEntered
        this.btnConversorContainer1.setBackground( new Color(140, 156, 140) );
        this.btnConversorTemperaturaTxt.setForeground( Color.white );
    }//GEN-LAST:event_btnConversorTemperaturaTxtMouseEntered

    private void btnConversorTemperaturaTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConversorTemperaturaTxtMouseExited
        this.btnConversorContainer1.setBackground( new Color(131, 140, 155) );
        this.btnConversorTemperaturaTxt.setForeground( new Color(185,172,140) );
    }//GEN-LAST:event_btnConversorTemperaturaTxtMouseExited

    private void btnConversorTemperaturaTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConversorTemperaturaTxtMouseClicked
        actualizarContentPane( this.panelConversor, this.conversorDeOtraCosa );
    }//GEN-LAST:event_btnConversorTemperaturaTxtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgIndex;
    private javax.swing.JPanel botonera;
    private javax.swing.JPanel btnConversorContainer;
    private javax.swing.JPanel btnConversorContainer1;
    private javax.swing.JLabel btnConversorDivisasTxt;
    private javax.swing.JLabel btnConversorTemperaturaTxt;
    private javax.swing.JPanel btnExitContainer;
    private javax.swing.JLabel btnExitTxt;
    private javax.swing.JPanel footerContainer;
    private javax.swing.JLabel footerTxt;
    private javax.swing.JPanel panelCloseTab;
    private javax.swing.JPanel panelConversor;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelOptions;
    private javax.swing.JLabel titleTxt;
    // End of variables declaration//GEN-END:variables
}
