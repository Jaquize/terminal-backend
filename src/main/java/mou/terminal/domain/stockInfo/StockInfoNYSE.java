package mou.terminal.domain.stockInfo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Getter
@Setter
@Document(collection = "nyseInfo")
public class StockInfoNYSE extends StockInfo{

}
