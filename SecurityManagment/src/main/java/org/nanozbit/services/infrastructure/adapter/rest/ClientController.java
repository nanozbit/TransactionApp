package org.nanozbit.services.infrastructure.adapter.rest;

import org.nanozbit.services.application.service.Client.ClientService;
import org.nanozbit.services.infrastructure.adapter.rest.modelView.ClientModelView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModelView> getClient(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.clientService.getClient(id), HttpStatus.OK);


    }

    @GetMapping()
    public ResponseEntity<Iterable<ClientModelView>> getClients() {
        var client = this.clientService.getClients();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping
    public ClientModelView createClient(@RequestBody ClientModelView client) {
        return this.clientService.saveClient(client);
    }

    @PutMapping("/{id}")
    public ClientModelView updateClient(@PathVariable("id") Long id, @RequestBody ClientModelView client) {
        return this.clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteClient(@PathVariable("id") Long id) {

        this.clientService.deleteClient(id);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
