import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Developer implements DeveloperRepository {

    private final long idValue;
    private String firstName;
    private String lastName;
    private List<Skill> skills = new ArrayList<>();
    private Speciality speciality;
    private Status status;

    Developer () {

        this.idValue = createDeveloperID();

        System.out.println("Введите Ваше имя:");

        this.firstName = new Scanner(System.in).next();

        System.out.println("Введите Вашу фамилию:");

        this.lastName = new Scanner(System.in).next();

        System.out.println("Перечислите Ваши навыки\nПо завершению передайте консоли \"stop\":");

        String str = "";

        while (!(str.equals("stop"))) {

            str = new Scanner(System.in).next();

            if (!str.equals("stop")) skills.add(new Skill(str));
        }

        this.speciality = new Speciality();

        status = Status.ACTIVE;
    }

    public long getID () {
        return idValue;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getSkills () {

        GsonBuilder builder = new GsonBuilder();

        return builder.registerTypeAdapter(Skill.class, new CustomConverterImpl()).create().toJson(skills);
    }

    public void setSkills (List<Skill> skills) {
        this.skills = skills;
    }

    public String getSpeciality () {

        return speciality.getSpeciality();
    }

    public void setSpeciality (Speciality speciality) {
        this.speciality = speciality;
    }

    public String getStatus () {
        return status.name();
    }


    public void setStatus (Status status) {
        this.status = status;
    }

    public boolean deleteDeveloper () {

        if (getStatus() != Status.ACTIVE.name()) return false;

        setStatus(Status.DELETED);

        return true;
    }
}