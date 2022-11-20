package mou.terminal.rdbmsDomain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Builder
@Entity
@Table(name = "portfolioContent")
public class PortfolioContent {

    @OneToOne
    @JoinColumn(name = "portFolioId", referencedColumnName = "id")
    private Portfolio portfolio;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "portFolioId", insertable=false, updatable=false)
    private int portFolioId;

    @Id
    @Column(name = "ref", nullable = false)
    private String ref;

}
