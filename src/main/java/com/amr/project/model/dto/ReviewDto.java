package com.amr.project.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private String text;
    private int rating;
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private Long itemId;
    private String itemName;
    private Long shopId;
    private String shopName;
    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;

}
