package id.co.davidfirdaus.travel.catalogservice.destinations.entity;

public enum Country {
    INA("IDN", "Indonesia"),
    MAS("MAS", "Malaysia"),
    THA("THA", "Thailand"),
    SIN("SIN", "Singapore"),
    CHN("CHN", "China"),
    HKG("HKG", "Hongkong"),
    JPN("JPN", "Japan");

    private final String code;
    private final String description;

    Country(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
