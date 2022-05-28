package com.morandev.alura.conversoruniversal.service.serviceimpl;

import java.io.IOException;
import java.util.Map;

public class PersistirDataService {
    
    private static String dbFileName = "db.json";
    
    public static boolean persistirDatos( Map< String, Double> data ) {
        
        boolean out = false;
        
        if( data == null )
            return out;
        
        try {
            out = JsonFileHelperService.persistirData( data );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
        
        return out;
    }
    
}
