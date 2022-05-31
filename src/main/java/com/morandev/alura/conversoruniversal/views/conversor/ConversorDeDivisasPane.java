package com.morandev.alura.conversoruniversal.views.conversor;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import com.morandev.alura.conversoruniversal.service.serviceimpl.ListarDataService;
import com.morandev.alura.conversoruniversal.service.serviceimpl.ConvertidorDivisasService;

public class ConversorDeDivisasPane extends javax.swing.JPanel {

    private final int MAX_INPUTS_DIGITS = 11;
    
    private ConvertidorDivisasService convertidor = new ConvertidorDivisasService();
    private boolean configOfComboBoxIsFinished = false;
    private Map< String, String > simbolos = new HashMap<>();
    
    BigDecimal finalAmount = new BigDecimal(0.0);
    
    private String divisaFrom = "";
    private String divisaTo = "";

    /**
     * 
     *  CONSTRUCTOR
     * 
     */
    public ConversorDeDivisasPane() {
        initComponents();
        init();
    }
    
    /**
    * Configuraciones iniciales del Panel
    */
    private void init() {
        setComboBoxesConfig();
        setInitialDivisas();
        setConfigOfComboBoxIsFinished( true );
        enabledSwitchInfo( false );
    }
    
    /**
     * 
     *  METODO DE CONFIGURACION: debera ser utilizado una sola vez
     * 
     */
    private void setComboBoxesConfig() {
        
        //llenar simbolos con nombre de divisas y sus abreviaciones
        simbolos = ListarDataService.listarSimbolos();

        // divisas abreviaciones
        ArrayList< String > divisasAbbr = new ArrayList<>( simbolos.keySet() );

        //ordenamos abreviaciones
        Collections.sort( divisasAbbr );

        this.cmbDivisa.removeAllItems();
        this.cmbDivisa1.removeAllItems();

        // Los valores insertados en cada combo box
        // presentan un espacio al inicio y al final
        // antes de usar estos valores, utilizar el metodo String.trim()
        divisasAbbr.forEach( divAbbr -> {
                this.cmbDivisa.addItem("  " + divAbbr + " ");
                this.cmbDivisa1.addItem("  " + divAbbr + " ");
        });
        
        this.cmbDivisa.setSelectedIndex(1);
        this.cmbDivisa1.setSelectedIndex(1);
    }
    
    /**
     * 
     *  METODO DE CONFIGURACION: debera ser utilizado una sola vez
     * 
     */
    private void setInitialDivisas() {
        setDivisaFrom( this.cmbDivisa );
        setDivisaTo( this.cmbDivisa1 );
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
        
        return valueSelected;
    }
    
    private String getDivisaName( String divisaKey ) {
        
        String divisaName = this.simbolos.get( divisaKey );

        return divisaName;
    }
    
    private void convertAndPrintInputData(JTextField input) {
        
        String userInputStr = input.getText();
        String userInputConvertedStr = "";
        String divisaToName = getDivisaName( divisaTo );
        String divisaFromName = getDivisaName( divisaFrom );
                
        if( userInputStr.isBlank() || userInputStr.isEmpty() )
            userInputStr = "1";
        
        // input a big decimal
        java.math.BigDecimal finalValidInput = new java.math.BigDecimal( userInputStr );

        convertDivise( divisaFrom, divisaTo, finalValidInput );
        
        // Descriciones con formato de $ price
        userInputStr = formatToPrice( finalValidInput );
        userInputConvertedStr = formatToPrice( finalAmount );
        
        String finalAmountStr = finalAmount.toString();
        
        // si los datos vienen desde el primer input
        if( Objects.equals( input , this.userInput ) ) {
            
            this.userInput1.setText( finalAmountStr );
            updateFirstDescription( userInputStr, divisaFromName );
            updateSecondDescription( userInputConvertedStr, divisaToName );
            
        } else {
            this.userInput.setText( finalAmountStr );
            updateFirstDescription( userInputConvertedStr, divisaToName );
            updateSecondDescription( userInputStr, divisaFromName );
        }
        
    }
    
    /**
     *  Da formato a un objeto BigDecimal que representa un monto a este formato String: $ ##.###,##
     * 
     * @param amountI monto
     * @return String
     */
    private String formatToPrice( java.math.BigDecimal amount ) {

        // Representacion de cadena que incluye signo $
        String amountFormatted = NumberFormat.getCurrencyInstance().format( amount );
        
        return amountFormatted;
    }
    
    private void updateDescription( String amountFormatted, String divisaName, JLabel label ) {
        String desc = "<html><p>" + amountFormatted + " " + divisaName;
        label.setText( desc );
    }
    
    private void updateFirstDescription( String amountFormatted, String divisaName ) {
        updateDescription( amountFormatted, divisaName, this.divisaNameTxt );
    }
    
    private void updateSecondDescription( String amountFormatted, String divisaName ) {
        updateDescription( amountFormatted, divisaName, this.divisaNameTxt1 );
    }
    
    private void convertDivise( String divisaFromName, String divisaToName, java.math.BigDecimal amount ) {
       
        java.math.BigDecimal amountConverted = new java.math.BigDecimal(0);
        
        try {
            
            amountConverted = this.convertidor.convertir( divisaFromName, divisaToName, amount.doubleValue() );
            
        } catch ( Exception e ) {
            
            throw new RuntimeException("converDivise: no pudo completar la conversion: " + e.getMessage() );
            
        }
        
        this.finalAmount = amountConverted;
    }
    
    private void doSwitch() {
        doItemSwich( this.cmbDivisa, this.cmbDivisa1 ); 
        doInputSwich( this.userInput, this.userInput1 );
        doDescriptionSwitch( this.divisaNameTxt, this.divisaNameTxt1 );
    }
    
    /**
     * 
     *  Intercambia los items seleccionados de ambos comboBoxes
     * 
     */
    private void doItemSwich(JComboBox<String> cmb1, JComboBox<String> cmb2) {
        
        // Prevencion de que los eventos ejecuten una conversion innecesaria 
        setConfigOfComboBoxIsFinished(false);
        
        int indexCombo1 = cmb1.getSelectedIndex();
        int indexCombo2 = cmb2.getSelectedIndex();
        
        cmb1.setSelectedIndex( indexCombo2 );
        cmb2.setSelectedIndex( indexCombo1 );
        // Prevencion finalizada
        setConfigOfComboBoxIsFinished(true);
    }
    
    /**
     * 
     *  Intercambia los valores de ambos inputs
     * 
     */
    private void doInputSwich(JTextField field1, JTextField field2) {
        
        String input1Str = field1.getText();
        String input2Str = field2.getText();
        
        field1.setText( input2Str );
        field2.setText( input1Str );
        
    }
    
    /**
     * 
     *  Intercambia la descripcion de ambas etiquetas
     * 
     */
    private void doDescriptionSwitch(JLabel desc1, JLabel desc2) {
        
        String descStr = desc1.getText();
        String desc2Str = desc2.getText();
        
        desc1.setText( desc2Str );
        desc2.setText( descStr );
        
    }
    
    private void enabledSwitchInfo(boolean enabled) {
        this.userSwichInfoContainer.setVisible( enabled );
    }
    
    private void setConfigOfComboBoxIsFinished(boolean enabled) {
        this.configOfComboBoxIsFinished = enabled;
    }
    
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgContainer = new javax.swing.JPanel();
        converterContainer = new javax.swing.JPanel();
        userInput = new javax.swing.JTextField();
        divisaNameContainer = new javax.swing.JPanel();
        divisaNameTxt = new javax.swing.JLabel();
        cmbDivisa = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        separador2 = new javax.swing.JSeparator();
        converterContainer1 = new javax.swing.JPanel();
        userInput1 = new javax.swing.JTextField();
        separador1 = new javax.swing.JSeparator();
        divisaNameContainer1 = new javax.swing.JPanel();
        divisaNameTxt1 = new javax.swing.JLabel();
        cmbDivisa1 = new javax.swing.JComboBox<>();
        userSwichInfoContainer = new javax.swing.JPanel();
        switchInfoTxt = new javax.swing.JLabel();
        iconInfoContainer = new javax.swing.JPanel();
        userSwichInfoIcon = new javax.swing.JLabel();
        exchangeStatusBar = new javax.swing.JProgressBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        bgContainer.setBackground(new java.awt.Color(212, 241, 244));
        bgContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        converterContainer.setBackground(new java.awt.Color(201, 123, 95));

        userInput.setBackground(new java.awt.Color(201, 123, 95));
        userInput.setFont(new java.awt.Font("Verdana", 1, 34)); // NOI18N
        userInput.setForeground(new java.awt.Color(255, 255, 255));
        userInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        userInput.setToolTipText("");
        userInput.setBorder(null);
        userInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userInputFocusLost(evt);
            }
        });
        userInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userInputKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userInputKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userInputKeyTyped(evt);
            }
        });

        divisaNameContainer.setBackground(new java.awt.Color(201, 123, 95));

        divisaNameTxt.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        divisaNameTxt.setForeground(new java.awt.Color(255, 255, 255));
        divisaNameTxt.setText("$ ##### Peso argentino");

        javax.swing.GroupLayout divisaNameContainerLayout = new javax.swing.GroupLayout(divisaNameContainer);
        divisaNameContainer.setLayout(divisaNameContainerLayout);
        divisaNameContainerLayout.setHorizontalGroup(
            divisaNameContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(divisaNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        divisaNameContainerLayout.setVerticalGroup(
            divisaNameContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(divisaNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        cmbDivisa.setBackground(new java.awt.Color(201, 123, 95));
        cmbDivisa.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cmbDivisa.setForeground(new java.awt.Color(255, 255, 255));
        cmbDivisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD" }));
        cmbDivisa.setAutoscrolls(true);
        cmbDivisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbDivisa.setFocusable(false);
        cmbDivisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDivisaItemStateChanged(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        separador2.setBackground(new java.awt.Color(255, 255, 255));
        separador2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout converterContainerLayout = new javax.swing.GroupLayout(converterContainer);
        converterContainer.setLayout(converterContainerLayout);
        converterContainerLayout.setHorizontalGroup(
            converterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(converterContainerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(converterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(converterContainerLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(converterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(converterContainerLayout.createSequentialGroup()
                                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, converterContainerLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(divisaNameContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        converterContainerLayout.setVerticalGroup(
            converterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(converterContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(divisaNameContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(converterContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1424, 1424, 1424))
        );

        bgContainer.add(converterContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 220));

        converterContainer1.setBackground(new java.awt.Color(245, 244, 246));
        converterContainer1.setForeground(new java.awt.Color(245, 244, 246));

        userInput1.setBackground(new java.awt.Color(245, 244, 246));
        userInput1.setFont(new java.awt.Font("Verdana", 1, 34)); // NOI18N
        userInput1.setForeground(new java.awt.Color(116, 116, 116));
        userInput1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        userInput1.setToolTipText("");
        userInput1.setBorder(null);
        userInput1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userInput1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userInput1FocusLost(evt);
            }
        });
        userInput1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userInput1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userInput1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userInput1KeyTyped(evt);
            }
        });

        separador1.setBackground(new java.awt.Color(116, 116, 116));
        separador1.setForeground(new java.awt.Color(116, 116, 116));

        divisaNameContainer1.setBackground(new java.awt.Color(245, 244, 246));
        divisaNameContainer1.setForeground(new java.awt.Color(245, 244, 246));

        divisaNameTxt1.setBackground(new java.awt.Color(251, 223, 171));
        divisaNameTxt1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        divisaNameTxt1.setForeground(new java.awt.Color(116, 116, 116));
        divisaNameTxt1.setText("$ ##### Peso argentino");

        javax.swing.GroupLayout divisaNameContainer1Layout = new javax.swing.GroupLayout(divisaNameContainer1);
        divisaNameContainer1.setLayout(divisaNameContainer1Layout);
        divisaNameContainer1Layout.setHorizontalGroup(
            divisaNameContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(divisaNameTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        divisaNameContainer1Layout.setVerticalGroup(
            divisaNameContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(divisaNameTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        cmbDivisa1.setBackground(new java.awt.Color(245, 244, 246));
        cmbDivisa1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        cmbDivisa1.setForeground(new java.awt.Color(116, 116, 116));
        cmbDivisa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD" }));
        cmbDivisa1.setAutoscrolls(true);
        cmbDivisa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbDivisa1.setFocusable(false);
        cmbDivisa1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDivisa1ItemStateChanged(evt);
            }
        });

        userSwichInfoContainer.setBackground(new java.awt.Color(245, 244, 246));
        userSwichInfoContainer.setForeground(new java.awt.Color(245, 244, 246));

        switchInfoTxt.setBackground(new java.awt.Color(245, 244, 246));
        switchInfoTxt.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        switchInfoTxt.setForeground(new java.awt.Color(116, 116, 116));
        switchInfoTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        switchInfoTxt.setText("presione ENTER para intercambiar valores");

        iconInfoContainer.setBackground(new java.awt.Color(245, 244, 246));
        iconInfoContainer.setForeground(new java.awt.Color(251, 223, 171));

        userSwichInfoIcon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        userSwichInfoIcon.setForeground(new java.awt.Color(255, 255, 255));
        userSwichInfoIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userSwichInfoIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/morandev/alura/images/info.png"))); // NOI18N

        javax.swing.GroupLayout iconInfoContainerLayout = new javax.swing.GroupLayout(iconInfoContainer);
        iconInfoContainer.setLayout(iconInfoContainerLayout);
        iconInfoContainerLayout.setHorizontalGroup(
            iconInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iconInfoContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(userSwichInfoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        iconInfoContainerLayout.setVerticalGroup(
            iconInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iconInfoContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(userSwichInfoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout userSwichInfoContainerLayout = new javax.swing.GroupLayout(userSwichInfoContainer);
        userSwichInfoContainer.setLayout(userSwichInfoContainerLayout);
        userSwichInfoContainerLayout.setHorizontalGroup(
            userSwichInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSwichInfoContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconInfoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(switchInfoTxt)
                .addGap(106, 106, 106))
        );
        userSwichInfoContainerLayout.setVerticalGroup(
            userSwichInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(switchInfoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iconInfoContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        exchangeStatusBar.setBackground(new java.awt.Color(107, 125, 137));
        exchangeStatusBar.setForeground(new java.awt.Color(107, 125, 137));
        exchangeStatusBar.setBorder(null);

        javax.swing.GroupLayout converterContainer1Layout = new javax.swing.GroupLayout(converterContainer1);
        converterContainer1.setLayout(converterContainer1Layout);
        converterContainer1Layout.setHorizontalGroup(
            converterContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exchangeStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, converterContainer1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(converterContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(divisaNameContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(converterContainer1Layout.createSequentialGroup()
                        .addComponent(userInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDivisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(converterContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(userSwichInfoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(separador1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        converterContainer1Layout.setVerticalGroup(
            converterContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(converterContainer1Layout.createSequentialGroup()
                .addComponent(exchangeStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(divisaNameContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(converterContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbDivisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(userSwichInfoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        bgContainer.add(converterContainer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 690, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bgContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bgContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInputFocusGained
        enabledSwitchInfo( true );
    }//GEN-LAST:event_userInputFocusGained

    private void userInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInputKeyReleased

        if( userInput.getText().isEmpty() ) {
            userInput1.setText("");
            return;
        }
        
        if( !(evt.getKeyCode() == KeyEvent.VK_ENTER) ) {
            SwingWorker<BigDecimal, Void> worker = new SwingWorker<BigDecimal, Void>() {

                @Override
                protected BigDecimal doInBackground() throws Exception {
                    convertAndPrintInputData( userInput );

                    return finalAmount;
                }

            };

            worker.execute();
        }
    }//GEN-LAST:event_userInputKeyReleased

    private void userInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInputKeyTyped

        if ( !Character.isDigit( evt.getKeyChar() ) ) {
            evt.consume();
        }

    }//GEN-LAST:event_userInputKeyTyped

    private void userInput1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInput1FocusGained
        enabledSwitchInfo( true );
    }//GEN-LAST:event_userInput1FocusGained

    private void userInput1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInput1KeyReleased
        
        if( userInput1.getText().isEmpty() ) {
            userInput.setText("");            
            return;
        }

        if( !(evt.getKeyCode() == KeyEvent.VK_ENTER) ) {
                        
            SwingWorker<BigDecimal, Void> worker = new SwingWorker<BigDecimal, Void>() {
                
                @Override
                protected BigDecimal doInBackground() throws Exception {
                    convertAndPrintInputData( userInput1 );
                    
                    return finalAmount;
                }

            };
            
            worker.execute();
        }
    }//GEN-LAST:event_userInput1KeyReleased

    private void userInput1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInput1KeyTyped

        if ( !Character.isDigit( evt.getKeyChar() ) ) {
            evt.consume();
        }
        
    }//GEN-LAST:event_userInput1KeyTyped

    private void cmbDivisa1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDivisa1ItemStateChanged
        
        if( evt.getStateChange() == 1 ) {
            setDivisaTo( cmbDivisa1 );
            if ( configOfComboBoxIsFinished  ) {
                            
                SwingWorker<BigDecimal, Void> worker = new SwingWorker<BigDecimal, Void>() {

                    @Override
                    protected BigDecimal doInBackground() throws Exception {
                        convertAndPrintInputData( userInput1 );

                        return finalAmount;
                    }

                };
                
                worker.execute();
            }
                
        }                            
        
    }//GEN-LAST:event_cmbDivisa1ItemStateChanged

    private void cmbDivisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDivisaItemStateChanged
        
        if( evt.getStateChange() == 1 ) {
            setDivisaFrom( cmbDivisa );
            if ( configOfComboBoxIsFinished  ) {
                            
                SwingWorker<BigDecimal, Void> worker = new SwingWorker<BigDecimal, Void>() {

                    @Override
                    protected BigDecimal doInBackground() throws Exception {
                        convertAndPrintInputData( userInput );

                        return finalAmount;
                    }

                };
                
                worker.execute();
            }
        }     
        
    }//GEN-LAST:event_cmbDivisaItemStateChanged

    private void userInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInputKeyPressed

        if ( userInput.getText().length() >= MAX_INPUTS_DIGITS )
            userInput.setText("");
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            doSwitch();
        }
        
    }//GEN-LAST:event_userInputKeyPressed

    private void userInput1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInput1KeyPressed
        if ( userInput1.getText().length() >= MAX_INPUTS_DIGITS )
            userInput1.setText("");
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            doSwitch();
        }
    }//GEN-LAST:event_userInput1KeyPressed

    private void userInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInputFocusLost
        enabledSwitchInfo( false );
    }//GEN-LAST:event_userInputFocusLost

    private void userInput1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userInput1FocusLost
        enabledSwitchInfo( false );
    }//GEN-LAST:event_userInput1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgContainer;
    private javax.swing.JComboBox<String> cmbDivisa;
    private javax.swing.JComboBox<String> cmbDivisa1;
    private javax.swing.JPanel converterContainer;
    private javax.swing.JPanel converterContainer1;
    private javax.swing.JPanel divisaNameContainer;
    private javax.swing.JPanel divisaNameContainer1;
    private javax.swing.JLabel divisaNameTxt;
    private javax.swing.JLabel divisaNameTxt1;
    private javax.swing.JProgressBar exchangeStatusBar;
    private javax.swing.JPanel iconInfoContainer;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador2;
    private javax.swing.JLabel switchInfoTxt;
    private javax.swing.JTextField userInput;
    private javax.swing.JTextField userInput1;
    private javax.swing.JPanel userSwichInfoContainer;
    private javax.swing.JLabel userSwichInfoIcon;
    // End of variables declaration//GEN-END:variables

}
