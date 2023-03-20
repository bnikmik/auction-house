package com.example.auctionhouse.service;

import com.example.auctionhouse.dto.CreateLot;
import com.example.auctionhouse.dto.FullLot;
import com.example.auctionhouse.dto.Lot;
import com.example.auctionhouse.model.LotModel;
import com.example.auctionhouse.model.Status;
import com.example.auctionhouse.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LotService {
    private final MappingUtils mappingUtils;
    private final LotRepository lotRepository;

    @Autowired
    public LotService(MappingUtils mappingUtils, LotRepository lotRepository) {
        this.mappingUtils = mappingUtils;
        this.lotRepository = lotRepository;
    }

    public Lot createLot(CreateLot lot) {
        LotModel lotModel = mappingUtils.mapFromCreateLotDTO(lot);
        lotModel.setStatus(Status.CREATED);
        lotRepository.save(lotModel);
        return mappingUtils.mapToLotDTO(lotModel);
    }

    public FullLot findFullLot(Long lotId) {
        LotModel lotModel = lotRepository.findById(lotId).orElse(null);
        if (lotModel != null) {
            return mappingUtils.mapToFullLotDTO(lotModel);
        }
        return null;
    }

    public List<Lot> findLotModelsByStatus(Pageable pageable,Status status) {
        return lotRepository.findLotModelsByStatus(pageable,status).stream().map(mappingUtils::mapToLotDTO).collect(Collectors.toList());
    }

    public void startAuction(Long lotId) {
        LotModel lotModel = lotRepository.findById(lotId).orElse(null);
        lotModel.setStatus(Status.STARTED);
        lotRepository.save(lotModel);
    }

    public void stopAuction(Long lotId) {
        LotModel lotModel = lotRepository.findById(lotId).orElse(null);
        lotModel.setStatus(Status.STOPPED);
        lotRepository.save(lotModel);
    }



}
