package model.plane;

import entity.ExperimentalPlaneClassification;
import entity.ExperimentalPlaneType;

public class ExperimentalPlane extends Plane {

    private ExperimentalPlaneType experimentalPlaneType;
    private ExperimentalPlaneClassification experimentalPlaneClassification;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalPlaneType experimentalPlaneType,
                             ExperimentalPlaneClassification experimentalPlaneClassification) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalPlaneType = experimentalPlaneType;
        this.experimentalPlaneClassification = experimentalPlaneClassification;
    }

    public ExperimentalPlaneClassification getExperimentalPlaneClassification(){
        return experimentalPlaneClassification;
    }

    public void setClassificationLevel(ExperimentalPlaneClassification experimentalPlaneClassification){
        this.experimentalPlaneClassification = experimentalPlaneClassification;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }
}
