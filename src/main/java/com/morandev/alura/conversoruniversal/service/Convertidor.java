package com.morandev.alura.conversoruniversal.service;

/**
 * 
 *  Representa a las entidades que tienen la habilidad para convertir datos de los usuarios en informacion
 * 
 * @author morandev
 */
public interface  Convertidor {
    
    public abstract java.math.BigDecimal convertir( String desde, String hacia, double cantidad );
    
}
