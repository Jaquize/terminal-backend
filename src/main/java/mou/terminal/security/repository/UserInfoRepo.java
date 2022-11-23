package mou.terminal.security.repository;

import mou.terminal.web.domain.mysql.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<User,Integer> {

    User findByUserId(String userId);
}
