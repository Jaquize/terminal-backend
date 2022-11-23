package mou.terminal.web.domain.mysql.user;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "id", nullable = false )
    private int id;

    @Column(name = "userId", nullable = false )
    private String userId;

    @Column(name = "email", nullable = false )
    private String email;

    @Column(name = "emailVerified", nullable = false )
    private String emamilVerified;

    @Column(name = "profileImageURL", nullable = false )
    private String profileImageURL;

    @Column(name = "roleType", nullable = false )
    private String roleType;

    @Column(name = "createDateTime", nullable = false )
    private LocalDateTime createDate;

    @Column(name = "modifyDateTime", nullable = false )
    private LocalDateTime modifyDate;

}
