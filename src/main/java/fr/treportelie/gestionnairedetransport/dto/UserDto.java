package fr.treportelie.gestionnairedetransport.dto;

public class UserDto {
    private String Type;
    private String DisplayName;
    private Integer Age;
    private Integer NbJourActif;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Integer getNbJourActif() {
        return NbJourActif;
    }

    public void setNbJourActif(Integer nbJourActif) {
        NbJourActif = nbJourActif;
    }
}
