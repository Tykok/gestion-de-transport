package fr.treportelie.gestionnairedetransport.dto;

public class NumberUserDto {

    private Integer Clients;
    private Integer Motards;
    private Integer Chauffeur;

    public NumberUserDto(Integer clients, Integer motards, Integer chauffeur) {
        Clients = clients;
        Motards = motards;
        Chauffeur = chauffeur;
    }

    public NumberUserDto() {
        Clients = 0;
        Motards = 0;
        Chauffeur = 0;
    }

    public Integer getClients() {
        return Clients;
    }

    public void setClients(Integer clients) {
        Clients = clients;
    }

    public Integer getMotards() {
        return Motards;
    }

    public void setMotards(Integer motards) {
        Motards = motards;
    }

    public Integer getChauffeur() {
        return Chauffeur;
    }

    public void setChauffeur(Integer chauffeur) {
        Chauffeur = chauffeur;
    }
}
