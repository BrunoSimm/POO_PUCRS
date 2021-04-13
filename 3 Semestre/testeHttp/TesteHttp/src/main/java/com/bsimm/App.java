package com.bsimm;

//java -jar target\TesteHttp-1.0-SNAPSHOT.jar


import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;


import com.bsimm.models.Root;
import com.fasterxml.jackson.databind.ObjectMapper;



public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {

        System.out.println( "Hello World!" );

        //se comporta como um contêiner para informações de configuração comuns a várias solicitações
        HttpClient client = HttpClient.newHttpClient();

        //representa a solicitação a ser enviada por meio do HttpClient
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.iporto.com.br/api/panel/send/history?start_at=2021-03-28&end_at=2021-03-30&page=1"))
            .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjlkNTNjN2U4NWU1MTgyZmNiNmEzMjQ2OWEzNDY0MzJmNjE1Zjk0ZGMzNzA2MWZmNmI3NjRlYTAxMDY2NjJjNjY0ZTNmNTI0NTMwZjk0MDRhIn0.eyJhdWQiOiIxIiwianRpIjoiOWQ1M2M3ZTg1ZTUxODJmY2I2YTMyNDY5YTM0NjQzMmY2MTVmOTRkYzM3MDYxZmY2Yjc2NGVhMDEwNjY2MmM2NjRlM2Y1MjQ1MzBmOTQwNGEiLCJpYXQiOjE2MTcwMjM3NzAsIm5iZiI6MTYxNzAyMzc3MCwiZXhwIjoxNzc0NzkwMTcwLCJzdWIiOiIxMzA2Iiwic2NvcGVzIjpbImFjY2Vzcy1hY2NvdW50LWZ1bGwiXX0.gDR1uFUd2R7bTdFipuphUG3YVv_It5bexSpt3zVy1nAN0xHMROsHfdG3TdmPUbxWTI-unbRgpaWTr9kgIESfvq6riaTyLZaDBACMHX8AHjBrOMyqIjR4nNwBon01OuzFfSJ6-IH9LjIwqK1WncEoi4uq8Jn7Cttarpt4OJwR4Zo5CVmBEY_fPmBW2S2Wss1jHOXCOUHdfcKsM0WiwivGjvcXcXRsKCb_IvrB9JbzGohTQ0CFweaoEmSft7iS8Mml3gOr8xX3NLFKaj3nXzSKnaPMR3Vz8KRy9_-MLs18X7nqnhoZwYkMFO-4d493-XxAS7PpYB7wdqRTOhL9bBIx3SWEU0NpOxAtkry-bizF0Uz7Gsgs0hbMa7FdHVjj8G_ediYs08ilLmgiwRz3RJXTn-gQW-9XEqGczMcbMf0g7MVt8_rSP906QSUKlCkT47IJFW1uaInKVoxfwjsCkSFweyONFpAhGecKA9A3l-n8kOw6ALC1UQZddChmaR77GyXSyIgqqJf0mrmAlO0ZaCCsxsgwThxLenhq5NSrEEyQ59Z8b7LYmZP0RIgCCgnlIgALRR69HTjCzvVHdFSslKUp1f3cYMAq1O9ju-Wn2dZVKNHFbjblhlUkX3M7rfknSTmlfonm4FaVsA9KOqkC5lWZBZHMusXuOEdoq8xT7pglIV0")
            //.headers("key1", "value1", "key2", "value2")
            //.header("key1", "value1")
            //.header("key2", "value2")
            //.timeout(Duration.of(10, SECONDS))
            .GET()
            .build();

        //HttpResponse - representa o resultado de uma chamada HttpRequest    
        /*
        client.sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println)
            .join(); 
        */
        //Sync
        HttpResponse<String> response = HttpClient.newBuilder()
            .build()
            .send(request, BodyHandlers.ofString());
    
        ObjectMapper om = new ObjectMapper();
        Root root = om.readValue(response.body(), Root.class);
        System.out.println(root);
        
       /*
        //Async
        CompletableFuture<HttpResponse<String>> response2 = HttpClient.newBuilder()
            .build()
            .sendAsync(request, BodyHandlers.ofString());
        System.out.println("\n\n2 ==> "+response2);*/
    }
}
