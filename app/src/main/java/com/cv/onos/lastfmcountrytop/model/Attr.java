package com.cv.onos.lastfmcountrytop.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by onos on 09.11.17.
 */

public class Attr {

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("perPage")
    @Expose
    private String perPage;
    @SerializedName("totalPages")
    @Expose
    private String totalPages;
    @SerializedName("total")
    @Expose
    private String total;

    public String getCountry() {
        return country;
    }

    public String getPage() {
        return page;
    }

    public String getPerPage() {
        return perPage;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public String getTotal() {
        return total;
    }
}
