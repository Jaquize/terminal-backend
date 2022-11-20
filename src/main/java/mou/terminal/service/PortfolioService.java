package mou.terminal.service;

import mou.terminal.rdbmsDomain.Portfolio;
import mou.terminal.rdbmsDomain.PortfolioContent;
import mou.terminal.rdbmsRepository.PortfolioChangeRecordRepo;
import mou.terminal.rdbmsRepository.PortfolioContentRepo;
import mou.terminal.rdbmsRepository.PortfolioRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PortfolioService {

    private final PortfolioRepo portfolioRepo;
    private final PortfolioContentRepo portfolioContentRepo;
//    private final PortfolioChangeRecordRepo portfolioChangeRecordRepo;

    PortfolioService(PortfolioRepo portfolioRepo, PortfolioContentRepo portfolioContentRepo){
        this.portfolioRepo = portfolioRepo;
        this.portfolioContentRepo = portfolioContentRepo;
//        this.portfolioChangeRecordRepo = portfolioChangeRecordRepo;
    }

    public List<Portfolio> findAllPortList(){
        return this.portfolioRepo.findAll();
    }

//    public Portfolio findPortTitleById(int id) {return this.portfolioRepo.findById(id);}

    public void deleteByPortId(int id){

//        PortfolioContent portfolioContent = this.findPortbyPortFolioId(id);
//
//        portfolioRepo.deleteById(id);
//        portfolioContentRepo.deleteById("o");
//
//        insert portfoliorecord

    }

    public PortfolioContent findPort(int id){
        return this.portfolioContentRepo.findByPortFolioId(id);
    }

    public void addPort() {

        Portfolio tes = new Portfolio();
        tes.setTitle("현대차");
        tes.setRegDate(new Date("2022-11-19"));
        tes.setType("유형");

        PortfolioContent portfolioContent1 = PortfolioContent.builder()
                .content("zzz")
                .portfolio(tes)
                .ref("zzz")
                .build();

        this.portfolioContentRepo.save(portfolioContent1);

    }

    public void updatePort() {

//        update portfolio업
//        update portfolio content

//        insert portfoliorecord
    }

    public void backupRecord(int id) {
        // id 기준으로 포트폴리오 백

        PortfolioContent portfolioContent = this.portfolioContentRepo.findByPortFolioId(id);



        //insert portfolio


    }
}
