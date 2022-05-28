package com.morandev.alura.conversoruniversal.flyweight;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.morandev.alura.conversoruniversal.helpers.GsonHelper;
import com.morandev.alura.conversoruniversal.service.serviceimpl.ListarDataService;
import com.morandev.alura.conversoruniversal.service.serviceimpl.PersistirDataService;
import java.math.BigDecimal;

public class BusquedaFactory {
    
    private LocalDate actualDate;
    private final GsonHelper gsonHelper = new GsonHelper();
    
    private Map< String, Double > pool = null;
    
    public BusquedaFactory() {

        pool = ListarDataService.leerDB();

        if( pool == null)
            pool = new HashMap<>();
        
    }

    public BigDecimal ConvertirDivisa( String de_divisa, String a_divisa, double monto ) {
        
        if( de_divisa == null || a_divisa == null )
            throw new NullPointerException();
        
        actualDate = LocalDate.now();
        
        //KEY TO MAP
        String key = "de:" + de_divisa + "a:" + a_divisa + "fecha:" + actualDate.toString();
        
        BigDecimal amount = BigDecimal.valueOf( monto );
        
        if( !pool.isEmpty() ) {
            
            if( pool.containsKey( key ) ) {
                //KEY VALUE FROM POOL
                BigDecimal rateFromPool = BigDecimal.valueOf( pool.get( key ) );
                System.out.println("reutilize jeje");
                
                return rateFromPool.multiply( amount );
            }
            
        }
        
        double rate = gsonHelper.makeExchangeRequest( de_divisa , a_divisa, monto );
        
        //UPDATE RESULT AND SAVE POOL
        pool.put( key , rate );
        
        PersistirDataService.persistirDatos( pool );
        BigDecimal rateBD = BigDecimal.valueOf( rate );
        
        System.out.println("tuve que crear"); 
        
        return amount.multiply( rateBD );
    }
    
}
