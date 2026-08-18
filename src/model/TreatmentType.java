package model;

public class TreatmentType {
    private int treatmentTypeId;
    private String typeName;
    private String description;
    private double fee;

    public int getTreatmentTypeId() { return treatmentTypeId; }
    public void setTreatmentTypeId(int treatmentTypeId) { this.treatmentTypeId = treatmentTypeId; }

    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }

    @Override
    public String toString() {
        return typeName;
    }
}
