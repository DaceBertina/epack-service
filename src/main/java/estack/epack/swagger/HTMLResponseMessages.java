package estack.epack.swagger;

public class HTMLResponseMessages {

    public static final String HTTP_200 = "Request successful. Example data can be seen below.";
    public static final String HTTP_201 = "Successful request saves posted data. Example data can be seen below.";
    public static final String HTTP_204 = "Successful request deletes requested data.";
    public static final String HTTP_400 = "Unsuccessful request. Fields have incorrect values or there are missing fields.";
    public static final String HTTP_404 = "Unsuccessful request. Requested resource has not been found.";
    public static final String HTTP_409 = "Unsuccessful request. Passed data is conflicting with already existent data.";
    public static final String HTTP_500 = "Unsuccessful request. Internal server error.";
}
