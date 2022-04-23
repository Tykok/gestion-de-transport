package fr.treportelie.gestionnairedetransport.dto;


public class CourseDto {
    private String Client;
    private Integer NbCourse;
    private Integer Distance_total;

    public CourseDto(String client, Integer nbCourse, Integer distance_total) {
        Client = client;
        NbCourse = nbCourse;
        Distance_total = distance_total;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }

    public Integer getNbCourse() {
        return NbCourse;
    }

    public void setNbCourse(Integer nbCourse) {
        NbCourse = nbCourse;
    }

    public Integer getDistance_total() {
        return Distance_total;
    }

    public void setDistance_total(Integer distance_total) {
        Distance_total = distance_total;
    }
}
