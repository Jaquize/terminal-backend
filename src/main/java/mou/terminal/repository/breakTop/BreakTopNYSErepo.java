package mou.terminal.repository.breakTop;

import mou.terminal.domain.breakTop.BreakTop;
import mou.terminal.domain.breakTop.BreakTopNASDAQ;
import mou.terminal.domain.breakTop.BreakTopNYSE;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BreakTopNYSErepo extends MongoRepository<BreakTopNYSE,String> {
    List<BreakTop> findBytypeAndStatusDate(int type, Date statusDate);
}
