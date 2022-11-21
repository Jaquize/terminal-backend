package mou.terminal.rdbmsRepository;

import mou.terminal.rdbmsDomain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<User,Integer> {

    User findByUserId(String userId);
}
