package mou.terminal.rdbmsRepository;

import mou.terminal.rdbmsDomain.PortfolioChangeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioChangeRecordRepo  extends JpaRepository<PortfolioChangeRecord,String>{

}
