package com.morandev.alura.conversoruniversal.service.serviceimpl;

import com.morandev.alura.conversoruniversal.utils.GsonHelper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 
 *  Representa el servicio de interaccion con archivos. En especial archivos .json, que son utilizados
 *  en esta apliacion
 * 
 * @author morandev
 */
public class JsonFileHelperService {
    
    private final static GsonHelper gsonHelper = new GsonHelper();
    private final static String RUTA_POR_DEFECTO = "./src/main/java/com/morandev/alura/conversoruniversal/db/";
    
    /**
     * 
     *  Lee la data el archivo db.json. Este archivo representa la base de datos y contiene la informacion del
     *  usuario o de la aplicacion.
     * 
     * @param fileName
     * @return
     * @throws IOException 
     */
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
    
    /**
     *  Lee la data del archivo simbolos.json. Este archivo contiene los nombres de las divisas y sus abreviaciones.
     * 
     * @param fileName
     * @return
     * @throws IOException 
     */
    public static Map< String, String > leerCurrencyData( String fileName ) throws IOException {
        
        if ( fileName.isBlank() || fileName.isEmpty() || fileName == null )
            throw new RuntimeException( "fileName: " + fileName + "\nse esperaba filenName = simbolos.json" );
        
        Map< String, String > dataParsed = null;

        try ( InputStream in = new FileInputStream( RUTA_POR_DEFECTO + fileName ) ) {

            // PROCESAR EL ARCHIVO : transforma los bytes en caracteres
            Reader reader = new InputStreamReader( in, StandardCharsets.UTF_8 );

            // LEER EL ARCHIVO : linea por linea
            BufferedReader buffReader = new BufferedReader( reader );
            
            //dataParsed = gsonHelper.toJsonString( buffReader.lines().toArray() );
            
            dataParsed = gsonHelper.toStringMap( buffReader );

        }
        
        return dataParsed;
    }
    
    /**
     * 
     *  Persiste la data en archivo. Por defecto en this.RUTA_POR_DEFECTO
     * 
     * @param data
     * @return boolean, true si la data fue persistida con exito
     * @throws IOException 
     */
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
