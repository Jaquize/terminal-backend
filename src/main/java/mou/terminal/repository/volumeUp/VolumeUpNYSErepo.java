package mou.terminal.repository.volumeUp;

import mou.terminal.domain.volumeUp.VolumeUp;
import mou.terminal.domain.volumeUp.VolumeUpNYSE;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface VolumeUpNYSErepo extends MongoRepository<VolumeUpNYSE,String> {
    List<VolumeUp> findByregDate(Date regDate);
}
