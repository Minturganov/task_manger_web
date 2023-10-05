package com.example.task_manger_web.Controller;


import com.example.task_manger_web.DTO.TaskDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {
    private List<TaskDTO> taskDTOList = new LinkedList<>();

    @GetMapping("")
    public String task() {
        return "index";
    }

    @GetMapping("/taskList")
    public String getList(Model model) {
        model.addAttribute("taskList", taskDTOList);
        return "tasklist";
    }

    @PostMapping("/add")
    public String getList(@ModelAttribute TaskDTO dto , Model model) {
        dto.setId(UUID.randomUUID().toString());
        taskDTOList.add(dto);

        model.addAttribute("taskList", taskDTOList);
        return "redirect:/task";
    }

    @GetMapping("/addTask")
    public String addTask(Model model){
        model.addAttribute("isEdit",false);
        return "add_task";
    }


    @GetMapping("/goToEdit/{id}")
    public String goToEdit(@PathVariable("id") String id, Model  model){
        Optional<TaskDTO> optional = taskDTOList.stream().filter(t -> t.getId().equals(id)).findAny();
        if (optional.isEmpty()){
            return "redirect:/task";
        }
        model.addAttribute("tasks",optional.get());
        model.addAttribute("isEdit",true);
        return "add_task";
    }




    @GetMapping("/edit")
    public String editTask(){
        return "edit";

    }    @GetMapping("/del")
    public String delTask(){
        return "delete";
    }
}
