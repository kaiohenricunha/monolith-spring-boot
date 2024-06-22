package com.example.monolithspringboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        String departmentJson = "{ \"name\": \"HR\" }";

        mockMvc.perform(post("/api/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(departmentJson)
                .header("Authorization", "Basic YWRtaW46YWRtaW5QYXNz")) // admin:adminPass encoded in Base64
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateEmployee() throws Exception {
        String employeeJson = "{ \"name\": \"John Doe\", \"address\": \"123 Main St\", \"telephone\": \"1234567890\", \"email\": \"johndoe@example.com\", \"dateOfBirth\": \"1990-01-01\", \"department\": { \"id\": 1 } }";

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeJson)
                .header("Authorization", "Basic YWRtaW46YWRtaW5QYXNz")) // admin:adminPass encoded in Base64
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        mockMvc.perform(get("/api/employees")
                .header("Authorization", "Basic YWRtaW46YWRtaW5QYXNz")) // admin:adminPass encoded in Base64
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
