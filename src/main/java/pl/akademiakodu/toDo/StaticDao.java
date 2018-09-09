package pl.akademiakodu.toDo;

import java.util.ArrayList;
import java.util.List;

// jak robi implements TaskDao
// kładziemy kurs na TaskDao
// i wykonujemy skrót alt+enter

// implements oznacza, że implementujemy interfejs
// kilka interefjsów
// implements TaskDao, CrudRepository
// kilka interfejsów jest po przecinku

public class StaticDao implements TaskDao {

    // zmienna statyczna
    // taka sam dla wszystkich obiektów
    private static List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> findAll() {
        return tasks; // zwrócenie listy
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task); // dodanie do listy
    }


    @Override   // false
    public List<Task> findByStatus(boolean finished) {
        // deklarujemy zmienną, która ma Liste tasków
        List<Task> scores = new ArrayList<>();

        // foreach
        // dla każdego tasku z listy o nazwie tasks
        for ( Task task: tasks){
            // wykorzystanie gettera na pojedyńczym tasku
            // jeśli task isFinished() ma taką samą wartość
            // jak zmienna boolean finished
            if ( task.isFinished() == finished)
                scores.add(task); // dodaj do zmiennej scores
            // bieżącego taska
        }
        return scores;
        // nowa składnia przy użyć lambd
//        return  tasks.stream().filter(task-> task.isFinished() ==finished)
//                .collect(Collectors.toList());
    }


}
