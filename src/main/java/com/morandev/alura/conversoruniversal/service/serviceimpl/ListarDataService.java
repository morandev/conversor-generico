package com.morandev.alura.conversoruniversal.service.serviceimpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ListarDataService {
    
    private static String simbolosFileName = "simbolos.json";
    private static String databaseFileName = "db.json";
    
    public static Map< String, String > listarSimbolos() {
        
        Map< String, String > out = null;
        
        try {
            
            out = JsonFileHelperService.leerCurrencyData( simbolosFileName );
            
        } catch( IOException e ) {
            throw new RuntimeException( e );
        }
        
        return out;
        
    }
    
    public static Map< String, Double > leerDB() {
        
        Map< String, Double > out = new HashMap<>();
        
        try {
            
            out = JsonFileHelperService.leerDB( databaseFileName );
            
        } catch( IOException e ) {
            throw new RuntimeException( e );
        }
        
        return out;
        
    }
    
    
}
