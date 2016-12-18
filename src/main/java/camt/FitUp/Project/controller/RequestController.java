package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.Request;
import camt.FitUp.Project.service.RequestService;
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
public class RequestController {

    @Autowired
    RequestService requestService;

    @RequestMapping(value = "addRequest", method = RequestMethod.POST)
    public Request addRequest(@RequestBody Request request, BindingResult bindingResult) {
        return requestService.addRequest(request);
    }

    @RequestMapping(value = "requestList", method = RequestMethod.GET)
    public List<Request> requestList() {
        return requestService.requestList();
    }

    @RequestMapping(value = "getRequest/{id}", method = RequestMethod.GET)
    public Request getRequest(@PathVariable("id") Long id) {
        return requestService.getRequest(id);
    }

    @RequestMapping(value = "getRequest/{id}", method = RequestMethod.DELETE)
    public Request deletePassSet(@PathVariable("id") Long id) {
        return requestService.deletePassSet(id);
    }
}
