package com.morandev.alura.conversoruniversal.service.serviceimpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 *  Representa el servicio de listado o consulta de datos persistidos
 * 
 * @author morandev
 */
public class ListarDataService {
    
    private static String simbolosFileName = "simbolos.json";
    private static String databaseFileName = "db.json";
    
    /**
     * 
     * Devuelve un mapa con todas las divisas soportadas. La clave es la abreviacion de la divisa y
     * el valor es el nombre completo.
     * 
     * @return 
     */
    public static Map< String, String > listarSimbolos() {
        
        Map< String, String > out = null;
        
        try {
            
            out = JsonFileHelperService.leerCurrencyData( simbolosFileName );
            
        } catch( IOException e ) {
            throw new RuntimeException( "No se pudo listar simbolos: " + e.getMessage() );
        }
        
        return out;
        
    }
    
    /**
     * 
     * Devuelve los datos persistidos del usuario o de la aplicacion.
     * 
     * @return 
     */
    public static Map< String, Double > leerDB() {
        
        Map< String, Double > out = new HashMap<>();
        
        try {
            
            out = JsonFileHelperService.leerDB( databaseFileName );
            
        } catch( IOException e ) {
            throw new RuntimeException( "No se pudo leer la base de datos: " + e.getMessage() );
        }
        
        return out;
        
    }
    
    
}
