package pl.akademiakodu.toDo;


import java.util.List;


// definicja interfejsu o nazwie TaskDao

public interface TaskDao {

   // w interfejsie mamy metody bez implemtacji, widać?
   List<Task> findAll();
   // to analogicznie moglibyśmy napisać:
   // public abstract List<Task> findAll();

   // standardowo wszystkie metody jak nie napiszemy
   // są publiczne i abstrakcyjnie
   void addTask(Task task);
   List<Task> findByStatus(boolean finished);
}
