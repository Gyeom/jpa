package spring.data.jpa.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.data.jpa.ResourceNotFoundException;
import spring.data.jpa.order.repository.UserJdbcRepository;
import spring.data.jpa.user.model.dto.UserUpdateRequest;
import spring.data.jpa.user.model.entity.User;
import spring.data.jpa.user.model.dto.UserCreateRequest;
import spring.data.jpa.user.model.dto.UserOrderRetrieveResponse;
import spring.data.jpa.user.model.dto.UserRetrieveResponse;
import spring.data.jpa.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserJdbcRepository userJdbcRepository;

    public UserRetrieveResponse findUser(final Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return UserRetrieveResponse.from(user);
    }

    public void createUser(final UserCreateRequest userRequest) {
        User user = userRequest.toEntity();
        userRepository.save(user);
    }

    public List<UserRetrieveResponse> findAllUser() {
        return userRepository.findAllFetchJoin()
                .stream()
                .map(UserRetrieveResponse::from)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<UserOrderRetrieveResponse> findUserWithOrders(final Long userId) {
        return userJdbcRepository.findUserWithOrders(userId);
    }

    public UserRetrieveResponse updateUser(final Long id, final UserUpdateRequest request) {
        User user = userRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        user.changeName(request.getName());
        user.changeEmail(request.getEmail());

        return UserRetrieveResponse.from(user);
    }
}
