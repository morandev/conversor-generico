package com.morandev.alura.conversoruniversal.service;

public interface  Convertidor {
    
    public abstract java.math.BigDecimal convertir( String desde, String hacia, double cantidad );
    
}
