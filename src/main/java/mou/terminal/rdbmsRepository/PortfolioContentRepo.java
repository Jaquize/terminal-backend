package mou.terminal.rdbmsRepository;


import mou.terminal.rdbmsDomain.PortfolioContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PortfolioContentRepo extends JpaRepository<PortfolioContent,String> {

    @Query(value = "select * from portfolioContent where portFolioId = ?1",nativeQuery = true)
    PortfolioContent findByPortFolioId(int id);

}