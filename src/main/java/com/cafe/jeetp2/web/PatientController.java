package com.cafe.jeetp2.web;

import com.cafe.jeetp2.entities.Patient;
import com.cafe.jeetp2.repos.PatientRepository;
import com.cafe.jeetp2.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@Controller
public class PatientController {

    private PatientService patientService;
    private PatientRepository patientRepository;

    @GetMapping("/")
    public String home(){
        return "redirect:/patients";
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String fetchAllPatients(Model model,
                                   @RequestParam(defaultValue = "5") int size,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "") String kw){
        Page<Patient> all = patientService.findPatientsByKw(kw, PageRequest.of(page, size));
        List<Patient> list = all.get().toList();
        int[] totalPages =new int[all.getTotalPages()];
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("data", list);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("kw", kw);
        return "view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){
        patientService.deletePatient(id);
        return "redirect:/patients";
    }

    @GetMapping("/patientForm")
    public String newPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "patientForm";
    }

    @PostMapping("/savePatient")
    public String savePatient(Patient patient, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "patientForm";
        }
        patientService.updatePatient(patient);
        return "redirect:/patients";
    }
    @GetMapping("/editPatient")
    public String editPatient(Model model, @RequestParam(name = "id") Long id){
        Patient patient=patientService.getPatient(id);
        model.addAttribute("patient",patient);
        return "editPatient";
    }
}
