//package com.project.clubmembership.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project.clubmembership.entity.Budget;
//import com.project.clubmembership.entity.Club;
//
//import com.project.clubmembership.entity.converter.BudgetConverter;
//
//import com.project.clubmembership.entity.dto.BudgetResponse;
//
//import com.project.clubmembership.service.BudgetService;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//
//import org.springframework.test.web.servlet.MockMvc;
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(BudgetController.class)
//public class BudgetControllerTest {
//
//    @MockBean
//    private BudgetService budgetService;
//
//    @MockBean
//    private BudgetConverter budgetConverter;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Test
//    public void testCreateBrand_whenCustomerRequestIsExistAndValid_shouldReturnCustomerDto() throws Exception {
//        int budgetId = 1;
//        Budget budget = new Budget
//                (
//                        1, 1.23, new Club(1, "pompa")
//                );
//
//        BudgetResponse budgetResponse = new BudgetResponse(1, 1.23);
//
//
//        Mockito.when(budgetService.getById(budgetId)).thenReturn(budget);
//        Mockito.when(budgetConverter.convert(budget)).thenReturn(budgetResponse);
//
//        this.mockMvc.perform(get("/budget/" + budgetId))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(budgetId))
//                .andExpect(jsonPath("$.amount").value(1.23));
//
//
//        Mockito.verify(budgetService).getById(budgetId);
//        Mockito.verify(budgetConverter).convert(budget);
//    }
//}