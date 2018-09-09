package pl.akademiakodu.toDo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


// @Controller specjalny komentarz dla Springa
// mówimy, że ta klasa będzie odpowiedzialna za adresy URL
@Controller
public class TaskController {

    // zawiera pole taskDao
    // mamy do czyenia z polimorfizmem
    // po lewej stronie typ interfejsu po prawej obiekt klasy StaticDao
    private TaskDao taskDao = new StaticDao();

    /*
        @RequestParam to adnotacja, która w sposób
        "magiczny" zamiania parametry, które będą wysłane z formularza
        na zmienną w Javie

        @RequestParam String name - w formularzu musimy mieć:
        <input type="text" name="name">
        Po stronie Springa, Javy mamy już dostęp do zmiennej name

        @RequestParam(required=false) daje nam to ,że
        strona nam się nie wykrzaczy jeśli formularz nie wyśle danej zmiennej

     */


    // definicja URL /tasks z metodą HTTP POST
    @PostMapping("/tasks")
    public String create(@RequestParam String name,
                         @RequestParam String description,
                         @RequestParam(required = false) boolean finished,
                         ModelMap modelMap
                         ){
        Task task = new Task(name,description,finished);
        // stworzenie zmiennej task i skorzystania z konstruktora
        // 3 argumentowego

        // przekazanie zmiennej task do widoku html
        // po stronie htmla będzie widoczna zmienna task
        // której wartością jest obiekt
        modelMap.put("task",task);


        taskDao.addTask(task);
        // dodaje do naszej listy zadanie konkrente

        return "redirect:/tasks";
        // redirect = HTTP, przekierunkowanie
        // redirect jest zawsze związany z metodą HTTP get
        // redirect czyści parametry http
        // przejdź mi do ścieżki /tasks z metodą http get
    }

    // definicja URL /tasks z metodą HTTP GET
    @GetMapping("/tasks")
    public String index(ModelMap modelMap){
        modelMap.put("tasks",taskDao.findAll());
        // przekaż zmienną tasks do widoku
        // tasDao.findAll zwraca liste obiektów

        return "index";
        // zwróć mi plik index.html, który
        // musi się znajdować w resources/templates
    }

    @GetMapping("/finished")
    public String finished(ModelMap modelMap){
        modelMap.put("tasks",taskDao.findByStatus(true));
        // przekaż zmienną tasks do widoku
        // tasDao.findByStatus zwraca liste obiektów

        return "index";
    }

    @GetMapping("/unfinished")
    public String unfinished(ModelMap modelMap){
        modelMap.put("tasks",taskDao.findByStatus(false));
        return "index";
    }

    @GetMapping("/")
    public String add(){
        return "add";
    }

}
