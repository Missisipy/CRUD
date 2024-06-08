import java.util.Scanner;

public class Speciality {

    String speciality;
    Status status;
    Scanner scanner = new Scanner(System.in);

    protected Speciality () {

        System.out.println("Введите свою специальность:");

        this.speciality = scanner.next();

        this.status = Status.ACTIVE;
    }

    public String getSpeciality () {
        return speciality;
    }

    public void setSpeciality (String speciality) {
        this.speciality = speciality;
    }

    public String getStatus () {
        return status.name();
    }

    public void setStatus (Status status) {
        this.status = status;
    }
    public boolean deleteSpeciality () {

        if (getStatus() != Status.ACTIVE.name()) return false;

        setStatus(Status.DELETED);

        return true;
    }
}
