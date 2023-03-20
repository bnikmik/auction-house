package com.example.auctionhouse.service;

import com.example.auctionhouse.dto.Bid;
import com.example.auctionhouse.model.BidModel;
import com.example.auctionhouse.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class BidService {
    private final MappingUtils mappingUtils;
    private final BidRepository bidRepository;
    private final LotService lotService;

    @Autowired
    public BidService(MappingUtils mappingUtils, BidRepository bidRepository, LotService lotService) {
        this.mappingUtils = mappingUtils;
        this.bidRepository = bidRepository;
        this.lotService = lotService;
    }

    public Bid createBid(Long lotId,Bid bid) {
        BidModel bidModel = mappingUtils.mapFromBidDTO(bid);
        bidModel.setBidDate(LocalDateTime.now());
        bidModel.setLotModel(mappingUtils.mapFromFullLotDTO(lotService.findFullLot(lotId)));
        bidRepository.save(bidModel);
        return mappingUtils.mapToBidDTO(bidModel);
    }
}
