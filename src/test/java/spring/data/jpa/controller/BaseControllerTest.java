package spring.data.jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import spring.data.jpa.order.model.dto.OrderCreateRequest;
import spring.data.jpa.user.model.dto.UserCreateRequest;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static spring.data.jpa.fixture.Fixture.createOrderCreateRequest;
import static spring.data.jpa.fixture.Fixture.createUserCreateRequest;

@SpringBootTest
@AutoConfigureMockMvc
class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeEach
    void setup() throws Exception {
        createUser(createUserCreateRequest("daegyeom.kim", "daegyeom.kim@naver.com"));
        createUser(createUserCreateRequest("semi.park", "semi.park@naver.com"));
        createOrder(createOrderCreateRequest("사과", BigDecimal.valueOf(1000)));
        createOrder(createOrderCreateRequest("바나나", BigDecimal.valueOf(1000)));
        createOrder(createOrderCreateRequest("파인애플", BigDecimal.valueOf(1000)));
        createOrder(createOrderCreateRequest("자두", BigDecimal.valueOf(1000)));
        createOrder(createOrderCreateRequest("복숭아", BigDecimal.valueOf(1000)));
    }

    private void createUser(UserCreateRequest userCreateRequest) throws Exception {
        String content = objectMapper.writeValueAsString(userCreateRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    private void createOrder(OrderCreateRequest orderCreateRequest) throws Exception {
        String content = objectMapper.writeValueAsString(orderCreateRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
}




