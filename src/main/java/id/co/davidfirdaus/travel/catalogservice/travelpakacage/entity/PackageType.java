package id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity;

public enum PackageType {
    TOUR("TOUR", "Tour across the country."),
    TRAVEL("TRAVEL", "Travel to several destination."),
    EVENT("EVENT", "One oevent or more");

    private final String code;
    private final String description;

    PackageType(String code, String description) {
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
