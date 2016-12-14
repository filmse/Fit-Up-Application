package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.PassSet;
import camt.FitUp.Project.service.PassSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Film on 5/11/2559.
 */

@CrossOrigin
@RestController
@RequestMapping("/")
public class PassSetController {

    @Autowired
    PassSetService passSetService;

    @RequestMapping(value = "passSet", method = RequestMethod.POST)
    public PassSet passSet(@RequestBody PassSet passSet, BindingResult bindingResult) {
        return passSetService.passSet(passSet);
    }

    @RequestMapping(value = "passSetList", method = RequestMethod.GET)
    public List<PassSet> passSetList() {
        return passSetService.passSetList();
    }

    @RequestMapping(value = "passSet/{id}", method = RequestMethod.GET)
    public PassSet getPassSet(@PathVariable("id") Long id) {
        return passSetService.getPassSet(id);
    }

    @RequestMapping(value = "passSet/{id}", method = RequestMethod.DELETE)
    public PassSet deletePassSet(@PathVariable("id") Long id) {
        return passSetService.deletePassSet(id);
    }
}
