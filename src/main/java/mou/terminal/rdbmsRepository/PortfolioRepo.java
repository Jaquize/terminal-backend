package mou.terminal.rdbmsRepository;

import mou.terminal.rdbmsDomain.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepo extends JpaRepository<Portfolio,Integer> {

    Portfolio findById(int id);

}
