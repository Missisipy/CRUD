
public class Skill {

    private String skill;
    private Status status;

    protected Skill (String skill) {

        this.skill = skill;

        status = Status.ACTIVE;
    }

    public String getSkill () {
        return skill;
    }

    public void setSkill (String skill) {
        this.skill = skill;
    }

    public String getStatus () {
        return status.name();
    }

    public void setStatus (Status status) {
        this.status = status;
    }

    public boolean deleteSkill () {

        if (getStatus() != Status.ACTIVE.name()) return false;

        setStatus(Status.DELETED);

        return true;
    }
}
