package pl.akademiakodu.toDo;
// klasa, Task.java
public class Task {

    // co zawiera zadanie:
    private String name;

    private String description;

    private boolean isFinished;

    // konstuktor 2 argumentowy
    // konstruktor tworzy obiekt konkretnej klasy
    public Task(String name, String description) {
        this.name = name; // this.name wskazuje na name, który jest u góry
        this.description = description;
        // this wskazuje na obiekt w którym jesteśmy
    }
    // Task task = new Task("posprzątaj","dokładnie");
    // wywoływany konstruktor 2-argumentowy

    // Task task = new Task("zmywaj");
    // błąd kompilacji, nie mam konstrukotra 1 argumentowy


    // konstruktor 3 argumentowy
    public Task(String name, String description, boolean isFinished) {
        this(name,description); // wywołaj konstruktor 2 argumentowy
        this.isFinished = isFinished;
    }
    // Task task = new Task("posprzątaj","dokładnie",true);
    // wywoływany konstruktor 3-argumentowy

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


    // Override to jest informacja dla kompilatora
    // i dla innego programisty
    // ze nadpisujemy metode w tym przypadku z klasy Object
    // ponieważ każda klasa dziedzczy po Object jeśli nie dziedczy
    // po żadnej klasie
    @Override
    public String toString() {
        return getName()+" "+getDescription()+
                (isFinished ?  " skończone" : " nieskończone");
        // ? : skrócona składnia ifa
        // ? - if , : oznacza else
        /*
            linijka isFinished oznacza to samo co
            isFinished == true
         */


    }
}
