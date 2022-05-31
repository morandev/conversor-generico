package com.morandev.alura.conversoruniversal.service.serviceimpl;

import java.io.IOException;
import java.util.Map;

/**
 * 
 *  Representa el servicio de guardar en archivos o de persistir informacion
 * 
 * @author morandev
 */
public class PersistirDataService {
    
    /**
     * 
     *  Persiste la data en archivo
     * 
     * @param data
     * @return boolean, true si los datos fueron persistidos correctamente
     */
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
