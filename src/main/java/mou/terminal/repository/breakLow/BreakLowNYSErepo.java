package mou.terminal.repository.breakLow;

import mou.terminal.domain.breakLow.BreakLow;
import mou.terminal.domain.breakLow.BreakLowNASDAQ;
import mou.terminal.domain.breakLow.BreakLowNYSE;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BreakLowNYSErepo extends MongoRepository<BreakLowNYSE,String> {

    List<BreakLow> findBystatusDate(Date statusDate);
}
