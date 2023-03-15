package spring.data.jpa.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class OrderControllerTest extends BaseControllerTest {

    @Test
    void findOrder() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    void saveOrders() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/orders/test/bulk/insert")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    void updateOrders() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/orders/test/bulk/insert")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
}




