package com.example.auctionhouse.repository;

import com.example.auctionhouse.model.LotModel;
import com.example.auctionhouse.model.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotRepository extends JpaRepository<LotModel, Long> {
    List<LotModel> findLotModelsByStatus(Pageable pageable, Status status);

    List<LotModel> findBy();
}
