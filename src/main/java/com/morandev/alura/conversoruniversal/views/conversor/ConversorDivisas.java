package com.morandev.alura.conversoruniversal.views.conversor;

import java.text.NumberFormat;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import java.util.stream.Collectors;
import java.util.*;

import com.morandev.alura.conversoruniversal.service.serviceimpl.ConvertidorDivisasService;
import com.morandev.alura.conversoruniversal.service.serviceimpl.DemoHiloService;
import com.morandev.alura.conversoruniversal.service.serviceimpl.ListarDataService;
import java.math.RoundingMode;

public class ConversorDivisas extends javax.swing.JPanel {
    
    private ConvertidorDivisasService convertidor = new ConvertidorDivisasService();
    private Map< String, String > simbolos = new HashMap<>();
    
    private String divisaFrom = "";
    private String divisaTo = "";
    // DEFAULT_DIVISA: deberia contener solo 3 letras, estar en mayusculas,
    // y estar contenida la variable simbolos
    // ARS = peso argentino
    private final String DEFAULT_DIVISA = "ARS"; 
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
        enabledInputs( true );
        toggleVisible( descTxt );
        setComboBoxesConfig();
        
        // TODO: HILOS!!!
        hiloService = new DemoHiloService();
        hiloService.setBar( pBar );
        hiloService.start();
        
        setInitialDivisas();
    }
    
    /**
     * 
     *  METODO DE CONFIGURACION: debera ser utilizado una sola vez
     * 
     */
    private void setComboBoxesConfig() {
        
        //llenar simbolos con nombre de divisas y sus abreviaciones
        simbolos = ListarDataService.listarSimbolos();

        //separamos nombres de abreviaciones
        ArrayList< String > divisasSimbolos = new ArrayList<>( simbolos.keySet() );
        ArrayList< String > divisasNames = new ArrayList<>( simbolos.values() );

        //ordenamos nombres y abreviaciones
        Collections.sort( divisasNames );
        Collections.sort( divisasSimbolos );

        this.cmbDivisa.removeAllItems();
        this.cmbDivisa2.removeAllItems();

        // Los valores insertados en cada combo box
        // presentan un espacio al inicio y al final
        // antes de usar estos valores, utilizar el metodo String.trim()
        divisasNames.forEach( name -> {
                this.cmbDivisa.addItem("  " + name + " ");
                this.cmbDivisa2.addItem("  " + name + " ");
        });
        
        this.cmbDivisa.setSelectedIndex(0);
        this.cmbDivisa2.setSelectedIndex(0);
    }
    
    private String getDivisaKey( String divisaName ) {
        
        Set divisasKeys;
        
         divisasKeys = this.simbolos
                                .entrySet()
                                .stream()
                                .filter(entry -> Objects.equals( entry.getValue(), divisaName ))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toSet());
        
        String divisaKey = (String) divisasKeys.stream().toList().get(0);

        System.out.println("Yo saque de simbolos esta key: " + divisaKey );
        
        return divisaKey;
    }
    
    private void updateDescription(java.math.BigDecimal amountI, java.math.BigDecimal amountF, String divisaFromName, String divisaToName ) {
        
        String initialAmountFormatted = formatBigDecimalAmount( amountI ); 
        String finalAmountFormatted = formatBigDecimalAmount( amountF ); 
        
        String desc = "<html><p>" + initialAmountFormatted + " " + divisaFromName + "<br><center> Equivale </center><br>" + finalAmountFormatted + " " + divisaToName + "</p></html>";
        
        this.descTxt.setText( desc );
    }
    
    /**
     *  Da formato a un objeto BigDecimal que representa un monto a este formato String: $ ##.###,##
     * 
     * @param amountI monto
     * @return String
     */
    private String formatBigDecimalAmount(java.math.BigDecimal amountI) {
        // Redondeo a dos decimales
        amountI = amountI.setScale( 2, RoundingMode.HALF_UP );
        // Representacion de cadena que incluye signo $
        String amountFormatted = NumberFormat.getCurrencyInstance().format( amountI );
        
        return amountFormatted;
    }
    
    private void toggleVisible(JComponent comp) {
        
        if( comp.isVisible() ) {
            comp.setVisible( false );
        } else {
            comp.setVisible( true );
        }
        
    }
    
    private java.math.BigDecimal convertDivise( String divisaFromName, String divisaToName, java.math.BigDecimal amount ) {
        
        System.out.println("el usuario quiere que: ");
        System.out.println("yo convierta de: " + divisaFromName);
        System.out.println("a: " + divisaToName);
        System.out.println("esta cantidad: " + amount.doubleValue());
        
        java.math.BigDecimal amountConverted = new java.math.BigDecimal(0);
        
        try {
            
            amountConverted = this.convertidor.convertir( divisaFromName, divisaToName, amount.doubleValue() );
            
        } catch ( Exception e ) {
            System.out.println( "Exploto che: " + e.getMessage() );
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
        
        System.out.println(" Esto me manda el usuario: " + input.getText() );
       
        if( input.getText().isBlank() || input.getText().isEmpty() )
            input.setText("1");
        
        java.math.BigDecimal finalValidInput = new java.math.BigDecimal( input.getText() );

        java.math.BigDecimal finalAmount = convertDivise(  divisaFrom, divisaTo, finalValidInput );

        //input data formatted and printed
        if( Objects.equals( input , this.userInput ) ) {
            userInput2.setText( formatBigDecimalAmount( finalAmount ) );
        } else {
            userInput.setText( formatBigDecimalAmount( finalAmount ) );
        }

        updateDescription( finalValidInput, finalAmount, divisaFrom, divisaTo );

        if( !this.descTxt.isVisible() ) {
             toggleVisible( descTxt );
        }
        
    }
    
     private void setInitialDivisas() {
         setDivisaFrom( this.cmbDivisa );
         setDivisaTo( this.cmbDivisa2 );
     }
    
    private void setDivisaFrom( JComboBox<String> cmbDivisa ) {
        this.divisaFrom = getDivisa( cmbDivisa );
    }
    
    private void setDivisaTo( JComboBox<String> cmbDivisa ) {
        this.divisaTo = getDivisa( cmbDivisa );
    }
     
    private String getDivisa( JComboBox<String> comboBoxDivisa ) {
        
        String valueSelected = (String) comboBoxDivisa.getSelectedItem();
        
        if( valueSelected == null || simbolos.containsValue( valueSelected ) ) 
            throw new RuntimeException("Ningun match de el elemento seleccionado del parametro comboBoxDivisa\n con divisas");
        
        //El valor seleccionado del comboBoxVista trae espacios agregados 
        valueSelected = valueSelected.trim();
        
        valueSelected = this.getDivisaKey( valueSelected );
        
        System.out.println( "Mira estoy en getDivisa y te voy a devolver esta divisa: " + valueSelected );
        return valueSelected;
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
        cmbDivisa2.setFocusable(false);
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
        cmbDivisa.setFocusable(false);
        cmbDivisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDivisaItemStateChanged(evt);
            }
        });
        panelConversor.add(cmbDivisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 320, 50));

        descTxt.setBackground(new java.awt.Color(212, 241, 244));
        descTxt.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        descTxt.setForeground(new java.awt.Color(65, 114, 159));
        descTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        descTxt.setText("<html><center><p><center>peso argentino</center><br><center>Es igual a dolar estadounidense</center></p></center></html>");
        panelConversor.add(descTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 500, 190));

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

    private void cmbDivisa2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDivisa2ItemStateChanged
        
        if( evt.getStateChange() == 1 ) {
            //!userInput2.getText().isEmpty(
            
            //inicio del programa
            if( userInput2.getText().equals("Ejm 1000") ) {
                setDivisaTo( cmbDivisa2 );
            } else {
            //el usuario interactua
                
                if ( userInput.getText().isEmpty() ) {
                    setDivisaFrom( cmbDivisa2 );
                    convertAndPrintInputData( userInput );
                    return;
                } 
                
                setDivisaTo( cmbDivisa2 );
                convertAndPrintInputData( userInput );
                
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
     *  Si este input gana el foco pero no tiene nada ingresado, se vacia
     * 
     * @param evt 
     */
    private void userInput2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInput2FocusGained
        if( userInput2.getText().equals("Ejm 1000") )
            userInput2.setText("");
    }//GEN-LAST:event_userInput2FocusGained

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
        
            if( userInput.getText().isEmpty() ) {
                userInput2.setText("");
                return;
            }
            
            if( !userInput.getText().isEmpty() || !userInput.getText().equals(ABORT)  )
                convertAndPrintInputData( userInput );
            
            if ( userInput.getText().length() >= 15 )
                userInput.setText("");
        
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
                
            if( userInput2.getText().isEmpty() ) {
                userInput.setText("");            
                return;
            }
            
            if( !userInput2.getText().isEmpty() )
                convertAndPrintInputData( userInput2 );
            
            if ( userInput2.getText().length() >= 15 )
                userInput2.setText("");
      
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
