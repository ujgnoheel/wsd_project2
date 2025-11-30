package kr.ac.jbnu.hj.wsd_project2.dto;

import kr.ac.jbnu.hj.wsd_project2.entity.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private Long id;
    private String name;
    private boolean deleted;

    public static UserResponse from(User user) {
        UserResponse res = new UserResponse();
        res.id = user.getId();
        res.name = user.getName();
        res.deleted = user.isDeleted();
        return res;
    }
}
