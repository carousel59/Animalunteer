package org.techtown.animalunteer;

public class ShelterInform {
    String Shelter_name;
    private String Shelter_contact;
    private String Shelter_address;
    private String Shelter_sns;
    private double Shelter_lat;
    private double Shelter_lon;

    ShelterInform(){};

    public String getShelter_name() {
        return Shelter_name;
    }

    public void setShelter_name(String shelter_name) {
        Shelter_name = shelter_name;
    }

    public String getShelter_contact() {
        return Shelter_contact;
    }

    public void setShelter_contact(String shelter_contact) {
        Shelter_contact = shelter_contact;
    }

    public String getShelter_address() {
        return Shelter_address;
    }

    public void setShelter_address(String shelter_address) {
        Shelter_address = shelter_address;
    }

    public String getShelter_sns() {
        return Shelter_sns;
    }

    public void setShelter_sns(String shelter_sns) {
        Shelter_sns = shelter_sns;
    }

    public double getShelter_lat() {
        return Shelter_lat;
    }

    public void setShelter_lat(double shelter_lat) {
        Shelter_lat = shelter_lat;
    }

    public double getShelter_lon() {
        return Shelter_lon;
    }

    public void setShelter_lon(double shelter_lon) {
        Shelter_lon = shelter_lon;
    }
}
