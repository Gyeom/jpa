package spring.data.jpa.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.data.jpa.user.model.dto.UserCreateRequest;
import spring.data.jpa.user.model.dto.UserOrderRetrieveResponse;
import spring.data.jpa.user.model.dto.UserRetrieveResponse;
import spring.data.jpa.user.model.dto.UserUpdateRequest;
import spring.data.jpa.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserRetrieveResponse findUser(@PathVariable final Long userId) {
        return userService.findUser(userId);
    }

    @GetMapping
    public List<UserRetrieveResponse> findAllUser() {
        return userService.findAllUser();
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserCreateRequest userRequest) {
        userService.createUser(userRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/orders")
    public List<UserOrderRetrieveResponse> findUserWithOrders(@PathVariable final Long userId) {
        return userService.findUserWithOrders(userId);
    }

    @PutMapping("/{userId}")
    public UserRetrieveResponse updateUser(@PathVariable final Long userId,
                                                @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }
}
