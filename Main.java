import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpServer;

import Spells.Spell;

public class Main {
    
    public static void main(String[] args) throws IOException{
        DataStore store = DataStore.getInstance();
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/spells", (exchange -> {
            if("GET".equals(exchange.getRequestMethod())){
                Map<String, String> query = queryToMap(exchange.getRequestURI().getQuery());
                if(!query.containsKey("id")){
                    exchange.sendResponseHeaders(406, -1);
                    return;
                }
                Spell spell = store.getSpell(Integer.parseInt(query.get("id")));
                if(spell == null){
                    exchange.sendResponseHeaders(404, -1);
                    return;
                }
                String response = spell.toJSON();
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(response.getBytes());
                output.flush();
            }else{
                exchange.sendResponseHeaders(405, -1);
            }
            exchange.close();
        }));

        server.setExecutor(null);
        server.start();
    }

    public static Map<String, String> queryToMap(String query){
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length>1) result.put(pair[0], pair[1]);
            else result.put(pair[0], "");
        }
        return result;
      }
}
