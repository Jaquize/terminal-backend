package mou.terminal.repository.breakLow;

import mou.terminal.domain.breakLow.BreakLow;
import mou.terminal.domain.breakLow.BreakLowKRX;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BreakLowKRXrepo extends MongoRepository<BreakLowKRX,String> {

    List<BreakLow> findBystatusDate(Date statusDate);
}
