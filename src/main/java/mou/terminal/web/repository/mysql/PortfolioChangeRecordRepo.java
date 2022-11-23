package mou.terminal.web.repository.mysql;

import mou.terminal.web.domain.mysql.portFolio.PortfolioChangeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioChangeRecordRepo  extends JpaRepository<PortfolioChangeRecord,String>{

}
