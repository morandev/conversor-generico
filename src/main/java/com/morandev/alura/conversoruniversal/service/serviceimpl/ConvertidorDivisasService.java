package com.morandev.alura.conversoruniversal.service.serviceimpl;

import com.morandev.alura.conversoruniversal.flyweight.BusquedaFactory;
import com.morandev.alura.conversoruniversal.service.Convertidor;
import java.math.BigDecimal;

public class ConvertidorDivisasService implements Convertidor {
    private BusquedaFactory clienteExchangeApi = new BusquedaFactory();

    @Override
    public BigDecimal convertir(String desde, String hacia, double cantidad) {
        BigDecimal resultado = new java.math.BigDecimal(0.0);

        System.out.println("Bro aca llego esto: \n");
        System.out.println( " desde " + desde + " hacia " + hacia + " cantidad " + cantidad);

        resultado = clienteExchangeApi.ConvertirDivisa(desde, hacia, cantidad);


        return resultado;
    }
    
}
