import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lesson {
    private String name;
    private Set<Lesson> preRequisites = new HashSet<>();
    private Set<Lesson> coRequisites = new HashSet<>();

    public Lesson(){}
    public Lesson(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lesson> getPreRequisites() {
        return preRequisites;
    }

    public void setPreRequisites(Set<Lesson> preRequisites) {
        this.preRequisites = preRequisites;
    }

    public Set<Lesson> getCoRequisites() {
        return coRequisites;
    }

    public void setCoRequisites(Set<Lesson> coRequisites) {
        this.coRequisites = coRequisites;
    }

    public Lesson addAllPreRequisite(Set<Lesson> preRequisites){
        this.preRequisites.addAll(preRequisites);
        return this;
    }

    public Lesson addAllCoRequisite(Set<Lesson> coRequisites){
        this.coRequisites.addAll(coRequisites);
        return this;
    }
     public Lesson removeCoRequisite(Lesson coRequisite){
        this.coRequisites.remove(coRequisite);
        return this;
     }
}
