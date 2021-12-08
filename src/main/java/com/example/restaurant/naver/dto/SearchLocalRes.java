package com.example.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchLocalRes {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;

    private List<SearchLocalItems> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchLocalItems {
        private String title;
        private String link;
        private String category;
        private String description;
        private String telephone;
        private String address;
        private String roadAddress;
        private int mapx;
        private int mapy;
    }
}
