package kr.ac.jbnu.hj.wsd_project2.service;

import kr.ac.jbnu.hj.wsd_project2.entity.User;
import kr.ac.jbnu.hj.wsd_project2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 2) 사용자 등록
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // 4) 특정 사용자 조회
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    // 6) 사용자 이름 변경
    public User updateUserName(Long id, String name) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        user.setName(name);
        return userRepository.save(user);
    }

    // 8) 사용자 탈퇴 (논리삭제)
    public void softDeleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        user.setDeleted(true);
        userRepository.save(user);
    }
}
