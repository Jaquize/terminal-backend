package mou.terminal.repository.breakTop;

import mou.terminal.domain.breakTop.BreakTop;
import mou.terminal.domain.breakTop.BreakTopKRX;
import mou.terminal.domain.breakTop.BreakTopNASDAQ;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BreakTopNASDAQrepo extends MongoRepository<BreakTopNASDAQ,String> {
    List<BreakTop> findBytypeAndStatusDate(int type, Date statusDate);
}
