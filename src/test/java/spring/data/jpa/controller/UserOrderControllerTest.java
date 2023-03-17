package spring.data.jpa.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import spring.data.jpa.user.model.dto.UserUpdateRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static spring.data.jpa.fixture.Fixture.createUserCreateRequest;
import static spring.data.jpa.fixture.Fixture.createUserUpdateRequest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserOrderControllerTest extends BaseControllerTest {

    @Test
    @Order(1)
    void createUser() throws Exception {
        String content = objectMapper.writeValueAsString(createUserCreateRequest("daegyeom.kim", "daegyeom.kim@naver.com"));
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @Order(2)
    void saveOrders() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/orders/test/bulk/insert")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @Order(3)
    void findUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @Order(4)
    void findAllUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @Order(5)
    void findUserWithOrders() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }


    @Test
    @Order(6)
    void updateUser() throws Exception {
        UserUpdateRequest userUpdateRequest = createUserUpdateRequest("sangwon.yun", "sangwon.yun@naver.com");
        String content = objectMapper.writeValueAsString(userUpdateRequest);
        mockMvc.perform(MockMvcRequestBuilders.put("/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
}




