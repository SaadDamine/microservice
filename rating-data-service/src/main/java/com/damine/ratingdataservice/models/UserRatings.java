package com.damine.ratingdataservice.models;

import java.util.List;

public class UserRatings {

    private List<Rating> userRatings;

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUseRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }
}
