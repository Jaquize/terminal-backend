package mou.terminal.rdbmsDomain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "portfolio")
@Getter
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "type", nullable = false)
    private String type;

//    @Column(name = "content", nullable = false)
//    private String content;

//    @Column(name = "ref", nullable = false)
//    private String ref;

    @Access(AccessType.PROPERTY)
    @Temporal(TemporalType.DATE)
    @Column(name = "regDate", nullable = false)
    private LocalDate regDate;

//    @OneToOne
//    @JoinColumn(name = "id")
//    private PortfolioContent portpolioContent;

}
