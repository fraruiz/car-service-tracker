package ar.edu.ungs.carservicetracker.garages.domain;


import java.util.Objects;

public final class Garage {
    private final GarageId id;
    private final GarageName garageName;
    // Agregar Responsable del garage (admin?)
    // Agregar los autos que van a estar en el garage


    public Garage(GarageId id, GarageName garageName ) {
        this.id = id;
        this.garageName = garageName;
    }

    public static Garage create(String id, String Name) {
        GarageId GarageId = new GarageId(id);
        GarageName value = new GarageName(Name);


        return new Garage(GarageId, value);
    }

    public GarageId id() {
        return id;
    }

    public GarageName garageName() {
        return garageName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(id, garage.id)
                    && Objects.equals(garageName, garage.garageName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, garageName);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", Name='" + garageName + '\'' +

                '}';
    }
}
