package fr.treportelie.gestionnairedetransport.dto;

public class NumberUserDto {

    private String reference;
    private String nb;

    public NumberUserDto(String reference, String nb) {
        this.reference = reference;
        this.nb = nb;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNb() {
        return nb;
    }

    public void setNb(String nb) {
        this.nb = nb;
    }
}
