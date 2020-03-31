package pro3.attandance.model;

public class AssignData {

    private int attendeeid;

    private int trainingid;


    public AssignData(int attendeeid, int trainingid) {
        this.attendeeid = attendeeid;
        this.trainingid = trainingid;
    }

    public int getAttendeeid() {
        return attendeeid;
    }

    public void setAttendeeid(int attendeeid) {
        this.attendeeid = attendeeid;
    }

    public int getTrainingid() {
        return trainingid;
    }

    public void setTrainingid(int trainingid) {
        this.trainingid = trainingid;
    }
}
