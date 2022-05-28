package com.morandev.alura.conversoruniversal.helpers;

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

public class GsonHelper {
        
    private final Gson g = new Gson();
    private final Dotenv dot = Dotenv.load();
    
    private final String host = "https://api.apilayer.com/exchangerates_data/convert?";
    private String apikey;
    
    public Double makeExchangeRequest( String de_divisa, String a_divisa, double monto ) {
            
            double rate = 0.0;

            apikey = dot.get("EXCHANGE_RATE_KEY");

            String params = "to=" + a_divisa + "&from=" + de_divisa + "&amount=" + monto + "&apikey=" + apikey;
            
            try {

                CompletableFuture< Future< HttpResponse<String> > > cf = CompletableFuture.supplyAsync(()-> Unirest.get( host + params ).asStringAsync() );
                
                Map< String, Object > conversionObj = toStringAndObjectMap( cf.get().get().getBody() );
                conversionObj                       = toStringAndObjectMap( conversionObj.get("info").toString() );
                rate                                = Double.valueOf( conversionObj.get("rate").toString() );
                
            } catch (InterruptedException ex) {
                throw new RuntimeException( ex );
            } catch (ExecutionException ex) {
                throw new RuntimeException( ex );
            }
            
            return rate;
    }
    
    public Map< String, Double > toStringAndDoubleMap(Reader in) {
        
        System.out.println(" Creo que encontre el problem ");
        Map< String, Double > product = g.fromJson( g.newJsonReader( in ), HashMap.class );
        
        return product;
    }
    
    public Map< String, Object > toStringAndObjectMap(String entry) {
        
        Map< String, Object > product = g.fromJson( entry, HashMap.class );
        
        return product;
    }
    
    public Map< String, Object > toStringAndObjectMap(Reader in) {
        
        Map< String, Object > product = g.fromJson( g.newJsonReader( in ), HashMap.class );
        
        return product;
    }
    
    public String toJsonString(Object obj) {
        String jsonStr = g.toJson( obj );
        
        return jsonStr;
    }
   
    
}
