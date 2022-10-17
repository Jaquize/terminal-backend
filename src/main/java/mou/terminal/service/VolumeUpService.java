package mou.terminal.service;

import mou.terminal.domain.volumeUp.VolumeUp;
import mou.terminal.repository.volumeUp.VolumeUpKRXrepo;
import mou.terminal.repository.volumeUp.VolumeUpNASDAQrepo;
import mou.terminal.repository.volumeUp.VolumeUpNYSErepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VolumeUpService {

    @Autowired
    VolumeUpKRXrepo volumeUpKRXrepo;
    @Autowired
    VolumeUpNASDAQrepo volumeUpNASDAQrepo;
    @Autowired
    VolumeUpNYSErepo volumeUpNYSErepo;

    public List<VolumeUp> volumeUpFindAll(String type, Date regDate) {

        if(type.equals("krx")){
            return volumeUpKRXrepo.findByregDate(regDate);
        }
        else if(type.equals("nasdaq")){
            return volumeUpNASDAQrepo.findByregDate(regDate);
        }
        else if(type.equals("nyse")){
            return volumeUpNYSErepo.findByregDate(regDate);
        }

        return null;
    }

}
