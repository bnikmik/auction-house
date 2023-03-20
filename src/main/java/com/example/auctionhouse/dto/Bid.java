package com.example.auctionhouse.dto;

import com.example.auctionhouse.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Bid {
    @JsonView(View.Public.class)
    private LocalDateTime bidDate;
    @JsonView(View.Internal.class)
    private String bidderName;
}
