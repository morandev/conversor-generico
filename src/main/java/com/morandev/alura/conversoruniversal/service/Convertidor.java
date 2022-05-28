package com.morandev.alura.conversoruniversal.service;

public abstract class Convertidor {
    
    public abstract java.math.BigDecimal convertir( String desde, String hacia, double cantidad );
    
}
