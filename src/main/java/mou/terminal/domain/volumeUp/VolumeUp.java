package mou.terminal.domain.volumeUp;

import lombok.Getter;
import lombok.Setter;
import mou.terminal.domain.SuperCondition;
import org.springframework.data.mongodb.core.mapping.Field;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class VolumeUp extends SuperCondition {

    private String symbol;
    private int times;
    private Date regDate;

    public String getRegDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(regDate);
    }

}
