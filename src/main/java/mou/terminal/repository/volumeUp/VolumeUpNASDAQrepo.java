package mou.terminal.repository.volumeUp;

import mou.terminal.domain.volumeUp.VolumeUp;
import mou.terminal.domain.volumeUp.VolumeUpNASDAQ;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface VolumeUpNASDAQrepo extends MongoRepository<VolumeUpNASDAQ,String> {
    List<VolumeUp> findByregDate(Date regDate);
}
