package com.test.sri.intelltest2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Srikanth
 */

public class JsonData {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("fromcentral")
    @Expose
    private fromcentral fromcentral;

    @SerializedName("location")
    @Expose
    private location location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonData.fromcentral getFromcentral() {
        return fromcentral;
    }

    public void setFromcentral(JsonData.fromcentral fromcentral) {
        this.fromcentral = fromcentral;
    }

    public JsonData.location getLocation() {
        return location;
    }

    public void setLocation(JsonData.location location) {
        this.location = location;
    }

    public class fromcentral
    {


        @SerializedName("car")
        @Expose
        private String car;

        @SerializedName("train")
        @Expose
        private String train;
        public String getCar() {
            return car;
        }

        public void setCar(String car) {
            this.car = car;
        }

        public String getTrain() {
            return train;
        }

        public void setTrain(String train) {
            this.train = train;
        }

    }
    public class location
    {
        @SerializedName("latitude")
        @Expose
        private double latitude;

        @SerializedName("longitude")
        @Expose
        private double longitude;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }


}

