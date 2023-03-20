package com.example.auctionhouse.dto;

import com.example.auctionhouse.model.Status;
import lombok.Data;

@Data
public class FullLot {
    private Long id;
    private Status status;
    private String title;
    private String description;
    private Integer startPrice;
    private Integer bidPrice;
    private Integer currentPrice;
    private Bid lastBid;
}


