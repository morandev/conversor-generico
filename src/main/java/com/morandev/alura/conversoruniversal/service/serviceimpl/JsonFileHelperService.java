package com.morandev.alura.conversoruniversal.service.serviceimpl;

import com.morandev.alura.conversoruniversal.helpers.GsonHelper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JsonFileHelperService {
    
    private final static GsonHelper gsonHelper = new GsonHelper();
    private final static String RUTA_POR_DEFECTO = "./src/main/java/com/morandev/alura/conversoruniversal/db/";
    
    
    public static Map< String, Double > leerDB( String fileName ) throws IOException {
        
        if ( fileName.isBlank() || fileName.isEmpty() || fileName == null )
            throw new RuntimeException( "fileName: " + fileName );
        
        Map< String, Double > dataParsed = null;
        
        try ( InputStream in = new FileInputStream( RUTA_POR_DEFECTO + fileName ) ) {

            // PROCESAR EL ARCHIVO : transforma los bytes en caracteres
            Reader reader = new InputStreamReader( in, StandardCharsets.UTF_8 );

            // LEER EL ARCHIVO : linea por linea
            BufferedReader buffReader = new BufferedReader( reader );
            
            dataParsed = gsonHelper.toStringAndDoubleMap( buffReader );
        }
                
        return dataParsed;
    }
    
    public static Map< String, Object > leerCurrencyData( String fileName ) throws IOException {
        
        if ( fileName.isBlank() || fileName.isEmpty() || fileName == null )
            throw new RuntimeException( "fileName: " + fileName );
        
        Map< String, Object > dataParsed = null;

        try ( InputStream in = new FileInputStream( RUTA_POR_DEFECTO + fileName ) ) {

            // PROCESAR EL ARCHIVO : transforma los bytes en caracteres
            Reader reader = new InputStreamReader( in, StandardCharsets.UTF_8 );

            // LEER EL ARCHIVO : linea por linea
            BufferedReader buffReader = new BufferedReader( reader );
            
            //dataParsed = gsonHelper.toJsonString( buffReader.lines().toArray() );
            
            dataParsed = gsonHelper.toStringAndObjectMap( buffReader );

        }
        
        return dataParsed;
    }
    
    public static boolean persistirData( Map< String, Double >  data ) throws IOException {

        boolean exito = false;
        String fileName = "db.json";

        // CODIGO MAS ESTANDARIZADO: menos lineas de codigo, file writer hace el trabajo por nosotros
        try (FileWriter writer = new FileWriter( RUTA_POR_DEFECTO + fileName )) {

            writer.write( gsonHelper.toJsonString( data ) );
            return !exito;

        }

    }
}
