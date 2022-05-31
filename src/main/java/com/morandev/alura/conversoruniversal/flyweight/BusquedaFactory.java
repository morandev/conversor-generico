package com.morandev.alura.conversoruniversal.flyweight;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.morandev.alura.conversoruniversal.utils.GsonHelper;
import com.morandev.alura.conversoruniversal.service.serviceimpl.ListarDataService;
import com.morandev.alura.conversoruniversal.service.serviceimpl.PersistirDataService;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 *  Esta clase representa el patron flyweight y se encarga de darle al cliente el resultado de su conversion
 * 
 * @author morandev
 */
public class BusquedaFactory {
    
    private LocalDate actualDate;
    private final GsonHelper gsonHelper = new GsonHelper();
    
    private Map< String, Double > pool = null;
    
    /**
     *   CONSTRUCTOR
     */
    public BusquedaFactory() {

        pool = ListarDataService.leerDB();

        if( pool == null)
            pool = new HashMap<>();
        
    }

    /**
     * 
     *  Convierte los inputs del usuario
     * 
     * @param de_divisa
     * @param a_divisa
     * @param monto
     * @return 
     */
    public BigDecimal ConvertirDivisa( String de_divisa, String a_divisa, double monto ) {
        
        if( de_divisa == null || a_divisa == null )
            throw new NullPointerException();
        
        actualDate = LocalDate.now();
        
        //KEYS TO MAP
        String key = "de:" + de_divisa + "a:" + a_divisa + "fecha:" + actualDate.toString();
        String switchKey = "de:" + a_divisa + "a:" + de_divisa + "fecha:" + actualDate.toString();
        
        BigDecimal amount = new BigDecimal( monto );
        
        // Ya poseemos los datos
        if( !pool.isEmpty() ) {
            
            if( pool.containsKey( key ) ) {
                //  Buscamos en la piscina
                BigDecimal rateFromPool = BigDecimal.valueOf( pool.get( key ) );
                // Convertimos
                amount = amount.multiply( rateFromPool );
                // Redondeo
                amount = amount.setScale( 1, RoundingMode.UP );
                return amount;
            }
            
        }
        // No poseemos los datos
        
        //HTTP REQUEST
        double rate = gsonHelper.makeExchangeRequest( de_divisa , a_divisa, monto );
        
        /*
            RATES DATA
        */
        BigDecimal rateBD = new BigDecimal( rate );
        BigDecimal rateSwitchDB = new BigDecimal( 1 );
        
        double rateSwitch = rateSwitchDB.doubleValue() / rateBD.doubleValue();
        rateSwitchDB = new BigDecimal( rateSwitch );
        /*
            ENDS RATES DATA
        */
        
        
        // Actualizamos y Persistimos
        pool.put( key , rateBD.doubleValue() );
        pool.put( switchKey , rateSwitchDB.doubleValue() );
        PersistirDataService.persistirDatos( pool );
        
        amount = amount.multiply( rateBD );
        // Redondeo
        amount = amount.setScale( 1, RoundingMode.UP );
        return amount;
    }
    
}
