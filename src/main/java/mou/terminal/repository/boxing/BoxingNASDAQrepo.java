package mou.terminal.repository.boxing;

import mou.terminal.domain.boxing.Boxing;
import mou.terminal.domain.boxing.BoxingKRX;
import mou.terminal.domain.boxing.BoxingNASDAQ;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BoxingNASDAQrepo extends MongoRepository<BoxingNASDAQ,String> {

    List<Boxing> findByStatusAndStatusDateAndRegDateGreaterThanEqual(int status, Date statusDate , Date regDate);
    List<Boxing> findByBoxingLessThanEqualAndStatusAndRegDateGreaterThanEqual(int boxing, int status, Date regDate);
    List<Boxing> findByBoxingAndRegDateGreaterThanEqual(int boxing, Date regDate);

}
