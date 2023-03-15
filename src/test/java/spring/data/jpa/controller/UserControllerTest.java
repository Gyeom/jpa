package spring.data.jpa.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import spring.data.jpa.user.model.dto.UserUpdateRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static spring.data.jpa.fixture.Fixture.createUserUpdateRequest;

class UserControllerTest extends BaseControllerTest {

    @Test
    void findUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    void findUserWithOrders() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    void findAllUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
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




