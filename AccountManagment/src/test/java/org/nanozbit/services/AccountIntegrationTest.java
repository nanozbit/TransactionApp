package org.nanozbit.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"clientId\":1,\"accountNumber\":\"1234567890\",\"accountType\":\"Ahorros\",\"initialBalance\":1000.5,\"status\":true}"))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    public void getAccounts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/account")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }
}
