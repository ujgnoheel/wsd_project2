package kr.ac.jbnu.hj.wsd_project2.controller;

import kr.ac.jbnu.hj.wsd_project2.dto.UserRequest;
import kr.ac.jbnu.hj.wsd_project2.dto.UserResponse;
import kr.ac.jbnu.hj.wsd_project2.entity.User;
import kr.ac.jbnu.hj.wsd_project2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 2) 사용자 등록
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        User user = new User();
        user.setName(request.getName());

        User saved = userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.from(saved));
    }

    // 4) 특정 사용자 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(UserResponse.from(user));
    }

    // 6) 사용자 이름 변경
    @PutMapping("/{id}/name")
    public ResponseEntity<UserResponse> updateUserName(
            @PathVariable Long id,
            @RequestBody UserRequest request
    ) {
        User updated = userService.updateUserName(id, request.getName());
        return ResponseEntity.ok(UserResponse.from(updated));
    }

    // 8) 사용자 탈퇴 (논리 삭제)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.softDeleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
