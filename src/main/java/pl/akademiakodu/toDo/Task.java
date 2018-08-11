package pl.akademiakodu.toDo;
// klasa, Task.java
public class Task {

    // co zawiera zadanie:

    private String name;

    private String description;

    private boolean isFinished;

    // konstuktor 2 argumentowy
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // konstruktor 3 argumentowy
    public Task(String name, String description, boolean isFinished) {
        this(name,description);
        this.isFinished = isFinished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }



    @Override
    public String toString() {
        return getName()+" "+getDescription()+
                (isFinished ?  " skończone" : " nieskończone");
    }
}
