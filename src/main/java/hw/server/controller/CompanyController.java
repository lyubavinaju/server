package hw.server.controller;

import hw.server.model.Company;
import hw.server.storage.Storage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
public class CompanyController {
    @RequestMapping("/add/{name}")
    public String addCompany(@PathVariable String name) {
        if (Storage.addCompany(new Company(name))) {
            return "Company " + name + " added.";
        }
        return "Company with name " + name + " already exists.";
    }

    @RequestMapping("/get/{name}")
    public Company getCompany(@PathVariable String name) {
        return Storage.getCompany(name);
    }
}
