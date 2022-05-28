package com.morandev.alura.conversoruniversal.views.conversor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


import com.morandev.alura.conversoruniversal.service.serviceimpl.ConvertidorDivisasService;
import com.morandev.alura.conversoruniversal.service.serviceimpl.DemoHiloService;
import com.morandev.alura.conversoruniversal.service.serviceimpl.ListarDataService;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class ConversorDivisas extends javax.swing.JPanel {
    
    private ConvertidorDivisasService convertidor = new ConvertidorDivisasService();
    private Map< String, Object > simbolos = new HashMap<>();
    
    private String divisaFrom = "";
    private String divisaTo = "";
    private DemoHiloService hiloService;
    
    /**
     * 
     *  CONSTRUCTOR
     * 
     */
    public ConversorDivisas() {
        initComponents();
        init();
    }
    
    /**
    * Configuraciones iniciales del Panel
    */
    private void init() {
        enabledInputs( false );
        toggleVisible( descTxt );
        fillComboBoxes();
        hiloService = new DemoHiloService();
        hiloService.setBar( pBar );
        hiloService.start();
    }
    
    private void fillComboBoxes() {
        ArrayList< String > divisasSimbolos = null;
        ArrayList< Object > divisasNames = null;
        List<String> strings = null;
        
        if( simbolos.isEmpty() ) {
            simbolos = ListarDataService.listarSimbolos();
            divisasSimbolos = new ArrayList<>( simbolos.keySet() );
            divisasNames = new ArrayList<>( simbolos.values() );
            
            strings = divisasNames.stream()
                                        .map(object -> Objects.toString(object, null))
                                        .collect( Collectors.toList());
            
            
            Collections.sort( strings );
            Collections.sort( divisasSimbolos );
        }

        this.cmbDivisa.removeAllItems();
        this.cmbDivisa2.removeAllItems();

        strings.forEach( value -> {
            this.cmbDivisa.addItem("  " + value + " ");
            this.cmbDivisa2.addItem("  " + value + " ");
        });
        
    }
    
    private Set<String> getDivisasKeys( Map< String, Object > map, String value ) {

        return map
                .entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
    
    private void updateDescription(java.math.BigDecimal amountI, java.math.BigDecimal amountF, String divisaFromName, String divisaToName ) {
        
        String initialAmountFormatted = NumberFormat.getCurrencyInstance().format( amountI );
        String finalAmountFormatted = NumberFormat.getCurrencyInstance().format( amountF );
        
        String desc = "<html><p>" + initialAmountFormatted + " " + divisaFromName + "<br><center> Equivale </center><br>" + finalAmountFormatted + " " + divisaToName + "</p></html>";
        
        this.descTxt.setText( desc );
    }
    
    private void toggleVisible(JComponent comp) {
        
        if( comp.isVisible() ) {
            comp.setVisible( false );
        } else {
            comp.setVisible( true );
        }
        
    }
    
    private java.math.BigDecimal convertDivise( String divisaFromName, String divisaToName, java.math.BigDecimal amount ) {
        
        java.math.BigDecimal amountConverted = new java.math.BigDecimal(0);
        
        try {
            
            amountConverted = this.convertidor.convertir( divisaFromName, divisaToName, amount.doubleValue() );
            
        } catch ( Exception e ) {
            System.out.println("aca exploto che!");
            System.out.println( e.getMessage() );
            e.printStackTrace();
            
        }
        
        return amountConverted;
    }
    
    private void enabledInputs( boolean enabled ) {
        
        this.userInput.setEnabled( enabled );
        this.userInput2.setEnabled( enabled );
            
    }
    
    private void convertAndPrintInputData(JTextField input) {
        
        System.out.println("Asi llego: " + input.getText());
        //prevenir para casos de inputs con mas de un punto decimal
        String inputValido = input.getText().replace(".", " ");
        System.out.println("Vergeada 1: " + inputValido);
        inputValido = inputValido.replace(" ", "");
        System.out.println("Vergeada 2: " + inputValido);

        
        if ( inputValido.contains(",") && input.getText().equals( inputValido ) ) {
            inputValido = inputValido.replace(",", ".");
        } else {
            inputValido = inputValido.replace(",", "");
        }
        
        
        System.out.println("quedo asi la verga: " + inputValido );

//        
//        //input data
//        double initialAmount = Double.valueOf( inputValido );
//        System.out.println( "Converti en esto " + initialAmount );
       
        java.math.BigDecimal finalValidInput = new java.math.BigDecimal( inputValido );

        //input data converted
        java.math.BigDecimal finalAmount = convertDivise(  divisaFrom, divisaTo, finalValidInput );
        //input data converted
        String finalAmountFormatted = String.format( "%,.2f", finalAmount.doubleValue() );    // ex: 1,234,567,890.12

        //input data formatted and printed
        if( Objects.equals( input , this.userInput ) ) {
            userInput2.setText( String.valueOf( finalAmountFormatted ) );
        } else {
            userInput.setText( String.valueOf( finalAmountFormatted ) );
        }

        updateDescription( finalValidInput, finalAmount, divisaFrom, divisaTo);

        if( !this.descTxt.isVisible() ) {
             toggleVisible( descTxt );
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConversor = new javax.swing.JPanel();
        cmbDivisa2 = new javax.swing.JComboBox<>();
        userInput = new javax.swing.JTextField();
        cmbDivisa = new javax.swing.JComboBox<>();
        descTxt = new javax.swing.JLabel();
        headerTitleTxt = new javax.swing.JLabel();
        userInput2 = new javax.swing.JTextField();
        pBar = new javax.swing.JProgressBar();

        panelConversor.setBackground(new java.awt.Color(212, 241, 244));
        panelConversor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbDivisa2.setBackground(new java.awt.Color(212, 241, 244));
        cmbDivisa2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cmbDivisa2.setForeground(new java.awt.Color(39, 68, 114));
        cmbDivisa2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- select your divise" }));
        cmbDivisa2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbDivisa2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDivisa2ItemStateChanged(evt);
            }
        });
        panelConversor.add(cmbDivisa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 320, 50));

        userInput.setBackground(new java.awt.Color(39, 68, 114));
        userInput.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        userInput.setForeground(new java.awt.Color(212, 241, 244));
        userInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userInput.setText("Ejm 1000");
        userInput.setToolTipText("");
        userInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userInputFocusLost(evt);
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
        panelConversor.add(userInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 227, 50));

        cmbDivisa.setBackground(new java.awt.Color(212, 241, 244));
        cmbDivisa.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cmbDivisa.setForeground(new java.awt.Color(39, 68, 114));
        cmbDivisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- select your divise" }));
        cmbDivisa.setAutoscrolls(true);
        cmbDivisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbDivisa.setDoubleBuffered(true);
        cmbDivisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDivisaItemStateChanged(evt);
            }
        });
        panelConversor.add(cmbDivisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 320, 50));

        descTxt.setBackground(new java.awt.Color(212, 241, 244));
        descTxt.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        descTxt.setForeground(new java.awt.Color(65, 114, 159));
        descTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descTxt.setText("<html><center><p><center>peso argentino</center><br><center>Es igual a dolar estadounidense</center></p></center></html>");
        panelConversor.add(descTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 90, 500, 150));

        headerTitleTxt.setBackground(new java.awt.Color(212, 241, 244));
        headerTitleTxt.setFont(new java.awt.Font("Consolas", 1, 40)); // NOI18N
        headerTitleTxt.setForeground(new java.awt.Color(131, 140, 155));
        headerTitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitleTxt.setText("Conversor de Divisas");
        panelConversor.add(headerTitleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 107));

        userInput2.setBackground(new java.awt.Color(39, 68, 114));
        userInput2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        userInput2.setForeground(new java.awt.Color(212, 241, 244));
        userInput2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userInput2.setText("Ejm 1000");
        userInput2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userInput2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userInput2FocusLost(evt);
            }
        });
        userInput2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userInput2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userInput2KeyTyped(evt);
            }
        });
        panelConversor.add(userInput2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 227, 50));

        pBar.setBackground(new java.awt.Color(212, 241, 244));
        pBar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        pBar.setForeground(new java.awt.Color(39, 68, 114));
        panelConversor.add(pBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 690, 20));

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

    private void cmbDivisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDivisaItemStateChanged
        
        if( evt.getStateChange() == 1 ) {

            String valueSelected = (String) this.cmbDivisa.getSelectedItem(); 
            String keySelected = "";

            valueSelected = valueSelected.trim();

            if( simbolos.containsValue( valueSelected ) ) {

                keySelected = getDivisasKeys( simbolos, valueSelected ).stream().toList().get(0);
                this.divisaFrom = keySelected;

                if( !divisaTo.isEmpty() ) this.enabledInputs( true );
                if( !userInput2.getText().equals("Ejm 1000") ) convertAndPrintInputData( userInput );
            }
            
        }
        
    }//GEN-LAST:event_cmbDivisaItemStateChanged

    private void cmbDivisa2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDivisa2ItemStateChanged
        
        if( evt.getStateChange() == 1 ) {
            
            
            String valueSelected = (String) this.cmbDivisa2.getSelectedItem();
            String keySelected = "";

            valueSelected = valueSelected.trim();

            if( simbolos.containsValue( valueSelected ) ) {

                keySelected = getDivisasKeys( simbolos, valueSelected ).stream().toList().get(0);
                 this.divisaTo = keySelected;

                 if( !divisaFrom.isEmpty() ) this.enabledInputs( true );
                 if( !userInput.getText().equals("Ejm 1000") ) convertAndPrintInputData( userInput2 );
            }
            
        }
    }//GEN-LAST:event_cmbDivisa2ItemStateChanged

    /**
     *  Si este input gana el foco pero no tiene nada ingresado, se vacia
     * 
     * @param evt 
     */
    private void userInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInputFocusGained
        if( userInput.getText().equals("Ejm 1000") )
            userInput.setText("");
    }//GEN-LAST:event_userInputFocusGained

    /**
     *  Si este input pierde el foco mientras estaba vacio, le ingresamos texto por defecto
     * 
     * @param evt 
     */
    private void userInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInputFocusLost
        if( userInput.getText().isBlank() || userInput.getText().isEmpty() )
            userInput.setText("Ejm 1000");
    }//GEN-LAST:event_userInputFocusLost
   
    /**
     *  Si este input gana el foco pero no tiene nada ingresado, se vacia
     * 
     * @param evt 
     */
    private void userInput2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInput2FocusGained
        if( userInput2.getText().equals("Ejm 1000") )
            userInput2.setText("");
    }//GEN-LAST:event_userInput2FocusGained

    /**
     *  Si este input pierde el foco mientras estaba vacio, le ingresamos texto por defecto
     * 
     * @param evt 
     */
    private void userInput2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInput2FocusLost
        if( userInput2.getText().isBlank() || userInput2.getText().isEmpty() )
            userInput2.setText("Ejm 1000");
    }//GEN-LAST:event_userInput2FocusLost

    /**
     *  Si no es un digito lo que el usuario ingresa, lo consumimos
     * 
     * @param evt 
     */
    private void userInput2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInput2KeyTyped
        
        if ( !Character.isDigit( evt.getKeyChar() ) ) {
            evt.consume();
        }
      
    }//GEN-LAST:event_userInput2KeyTyped
    
    /**
     *  Si obtenemos de las variables divisaFrom y divisaTo valores, teniendo disponible ademas 
     *  un input valido de parte del usuario, podemos utilizar el metodo convertAndPrintInputData()
     * 
     * @param evt 
     */
    private void userInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInputKeyReleased
        
//            if( userInput.getText().isEmpty() )
//                userInput2.setText("");
            
            
            if( !divisaFrom.isEmpty() && !divisaTo.isEmpty() && !userInput.getText().isEmpty() )
                convertAndPrintInputData( userInput );
        
    }//GEN-LAST:event_userInputKeyReleased
    
    /**
     *  Si no es un digito lo que el usuario ingresa, lo consumimos
     * 
     * @param evt 
     */
    private void userInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInputKeyTyped
        
        if ( !Character.isDigit( evt.getKeyChar() ) ) {
            evt.consume();
        }
        
    }//GEN-LAST:event_userInputKeyTyped
    
    /**
     *  Si obtenemos de las variables divisaFrom y divisaTo valores, teniendo disponible ademas 
     *  un input valido de parte del usuario, podemos utilizar el metodo convertAndPrintInputData()
     * 
     * @param evt 
     */
    private void userInput2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInput2KeyReleased
                
//            if( userInput2.getText().isEmpty() )
//                userInput.setText("");
            
            
            if( !divisaFrom.isEmpty() && !divisaTo.isEmpty() && !userInput2.getText().isEmpty() )
                convertAndPrintInputData( userInput2 );
      
    }//GEN-LAST:event_userInput2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbDivisa;
    private javax.swing.JComboBox<String> cmbDivisa2;
    private javax.swing.JLabel descTxt;
    private javax.swing.JLabel headerTitleTxt;
    private javax.swing.JProgressBar pBar;
    private javax.swing.JPanel panelConversor;
    private javax.swing.JTextField userInput;
    private javax.swing.JTextField userInput2;
    // End of variables declaration//GEN-END:variables
}
