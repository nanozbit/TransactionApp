package org.nanozbit.services.infrastructure.adapter.httpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.nanozbit.services.infrastructure.config.ClientProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ClientRestService implements ClientHttpClient {


    private final ClientProperties clientProperties;

    ClientRestService(ClientProperties clientProperties) {
        this.clientProperties = clientProperties;
    }

    @Override
    public ClientModel getClient(long id) {

        HttpClient client = HttpClient.newHttpClient();
        String url = clientProperties.getUrl() + "/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper()
                    .findAndRegisterModules()
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            return mapper.readValue(response.body(), ClientModel.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
