package com.morandev.alura.conversoruniversal.service.serviceimpl;

import com.morandev.alura.conversoruniversal.flyweight.BusquedaFactory;
import com.morandev.alura.conversoruniversal.service.Convertidor;
import java.math.BigDecimal;

/**
 * 
 *  Representa el servicio de conversion de datos del usuario en informacion
 * 
 *  @author morandev
 *
 */
public class ConvertidorDivisasService implements Convertidor {
    private BusquedaFactory clienteExchangeApi = new BusquedaFactory();

    
    @Override
    public BigDecimal convertir(String desde, String hacia, double cantidad) {
        BigDecimal resultado = new java.math.BigDecimal(0.0);

        resultado = clienteExchangeApi.ConvertirDivisa(desde, hacia, cantidad);

        return resultado;
    }

    
}
