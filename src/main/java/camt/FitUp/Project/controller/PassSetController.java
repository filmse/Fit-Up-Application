package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.FitUpInfo;
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
}
