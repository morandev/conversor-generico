package com.morandev.alura.conversoruniversal.utils;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 
 *  Representa una clase utilitaria. Dispuesta a ofrecer sus metodos a cualquier clase que la necesite.
 * 
 * @author yusri
 */
public class GsonHelper {
        
    private final Gson g = new Gson();
    private final Dotenv dot = Dotenv.load();
    
    private final String host = "https://api.apilayer.com/exchangerates_data/convert?";
    private String apikey;
    
    /**
     * 
     *  Realiza una peticion HTTP, utilizando "Unirest", contra la api de exchangerates. Esta API solicita datos para responder con informacion, estos datos
     *  son: de_divisa divisa de la cual partimos, a_divisa divisa a la cual queremos convertir y monto, que nada mas y nada menos, es 
     *  cantidad a convertir
     * 
     *  
     * 
     * @param de_divisa
     * @param a_divisa
     * @param monto
     * @return 
     */
    public Double makeExchangeRequest( String de_divisa, String a_divisa, double monto ) {
        double rate = 0.0;
        
        try {

            apikey = dot.get("EXCHANGE_RATE_KEY");

            String params = "to=" + a_divisa + "&from=" + de_divisa + "&amount=" + monto + "&apikey=" + apikey;
            
            CompletableFuture< Future< HttpResponse<String> > > cfr = CompletableFuture.supplyAsync(()-> Unirest.get( host + params ).asStringAsync() );
            Future< HttpResponse<String> > futureResponse = cfr.join();
            
            Map< String, Object > conversionObj = toStringAndObjectMap( futureResponse.get().getBody() );                                    
            conversionObj                       = toStringAndObjectMap( conversionObj.get("info").toString() );
            rate                                = Double.valueOf( conversionObj.get("rate").toString() );
            
            return rate;
            
        } catch (InterruptedException ex) {
            throw new RuntimeException("GsonHelper: se interrumpio la conexion con la exchange api: " + ex.getMessage() );
        } catch (ExecutionException ex) {
            throw new RuntimeException("GsonHelper: se interrumpio la ejecucion hacia la exchange api: " + ex.getMessage() );
        }

    }
    
    /**
     * 
     * Lee un Reader y transforma sus datos internos en un mapa con clave de tipo String y valor de tipo Double
     * 
     * @param in
     * @return 
     */
    public Map< String, Double > toStringAndDoubleMap(Reader in) {
        
        Map< String, Double > product = g.fromJson( g.newJsonReader( in ), HashMap.class );
        
        return product;
    
    }
    
    /**
     * 
     * Lee un String con formato de objeto json o array json y transforma sus datos internos en un mapa con clave de tipo String y valor de tipo Object,
     * ya que ciertamente, las claves podrian contener cualquier tipo de dato primitivo
     * 
     * @param entry
     * @return 
     */
    public Map< String, Object > toStringAndObjectMap(String entry) {
        
        Map< String, Object > product = g.fromJson( entry, HashMap.class );
        
        return product;
    }
    
    /**
     * 
     * Lee un Reader y transforma sus datos internos en un mapa con clave y valor de tipo String
     * 
     * @param in
     * @return 
     */
    public Map< String, String > toStringMap(Reader in) {
        
        Map< String, String > product = g.fromJson( g.newJsonReader( in ), HashMap.class );
        
        return product;
    }
    
    /**
     *  Formatear un objeto a notacion json string. Esto es por ejm: 
     *                                                              {
     *                                                                  "nombre":"Juan",
     *                                                                  "apellido":"Perez"
     *                                                              }
     * 
     * @param obj
     * @return 
     */
    public String toJsonString(Object obj) {
        String jsonStr = g.toJson( obj );
        
        return jsonStr;
    }
    
}
