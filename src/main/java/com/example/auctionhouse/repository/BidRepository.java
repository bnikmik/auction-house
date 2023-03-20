package com.example.auctionhouse.repository;

import com.example.auctionhouse.model.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<BidModel,Long> {

}
