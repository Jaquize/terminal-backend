package mou.terminal.repository.volumeUp;

import mou.terminal.domain.volumeUp.VolumeUp;
import mou.terminal.domain.volumeUp.VolumeUpKRX;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface VolumeUpKRXrepo extends MongoRepository<VolumeUpKRX,String> {
    List<VolumeUp> findByregDate(Date regDate);
}
