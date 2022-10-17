package mou.terminal.repository.breakTop;

import mou.terminal.domain.breakTop.BreakTop;
import mou.terminal.domain.breakTop.BreakTopKRX;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BreakTopKRXrepo extends MongoRepository<BreakTopKRX,String> {
    List<BreakTop> findBytypeAndStatusDate(int type, Date statusDate);
}
