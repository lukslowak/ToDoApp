package pl.akademiakodu.toDo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StaticDao implements TaskDao {

    private static List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }


    @Override   // false
    public List<Task> findByStatus(boolean finished) {
//        List<Task> scores = new ArrayList<>();
//        for ( Task task: tasks){
//            if ( task.isFinished() == finished)
//                scores.add(task);
//        }
//        return scores;
        return  tasks.stream().filter(task-> task.isFinished() ==finished)
                .collect(Collectors.toList());

    }


}
