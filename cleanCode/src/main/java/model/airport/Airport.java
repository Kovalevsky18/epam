package model.airport;


import entity.MilitaryPlaneType;
import model.plane.ExperimentalPlane;
import model.plane.MilitaryPlane;
import model.plane.PassengerPlane;
import model.plane.Plane;

import java.util.*;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();

        for (Plane passengerPlane : this.planes) {
            if (passengerPlane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) passengerPlane);
            }
        }
        return passengerPlanes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane militaryPlane : this.planes) {
            if (militaryPlane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) militaryPlane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        PassengerPlane planeWithMaxCapacity = getPassengerPlanes().get(0);

        for (PassengerPlane passengerPlane : getPassengerPlanes()) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();

        for (MilitaryPlane militaryPlane : getMilitaryPlanes()) {
            if (militaryPlane.getMilitaryPlaneType() == MilitaryPlaneType.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();

        for (MilitaryPlane militaryPlane : getMilitaryPlanes()) {
            if (militaryPlane.getMilitaryPlaneType() == MilitaryPlaneType.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();

        for (Plane experimentalPlane : this.planes) {
            if (experimentalPlane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) experimentalPlane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
       planes.sort(new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxFlightDistance() - secondPlane.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxLoadCapacity() - secondPlane.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxLoadCapacity() - secondPlane.getMaxLoadCapacity();
            }
        });
        return this;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
