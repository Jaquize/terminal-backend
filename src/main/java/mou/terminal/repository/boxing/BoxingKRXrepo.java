package mou.terminal.repository.boxing;

import mou.terminal.domain.boxing.Boxing;
import mou.terminal.domain.boxing.BoxingKRX;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BoxingKRXrepo extends MongoRepository<BoxingKRX,String> {

    List<Boxing> findByStatusAndStatusDateAndRegDateGreaterThanEqual(int status, Date statusDate , Date regDate);
    List<Boxing> findByBoxingLessThanEqualAndStatusAndRegDateGreaterThanEqual(int boxing, int status, Date regDate);
    List<Boxing> findByBoxingAndRegDateGreaterThanEqual(int boxing, Date regDate);

}




