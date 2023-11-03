package com.base.jsonusers;


public class UserInfo {
    private String name;
    private AddressInfo address;
    private CompanyInfo company;

    public String getName() {
        return name;
    }

    public AddressInfo getAddress() {
        return address;
    }

    public CompanyInfo getCompany() {
        return company;
    }

    public static class AddressInfo {
        private String city;
        private GeoInfo geo;

        public String getCity() {
            return city;
        }

        public GeoInfo getGeo() {
            return geo;
        }
    }

    public static class GeoInfo {
        private String lat;
        private String lng;

        public String getLat() {
            return lat;
        }

        public String getLng() {
            return lng;
        }
    }

    public static class CompanyInfo {
        private String name;

        public String getName() {
            return name;
        }
    }
}

