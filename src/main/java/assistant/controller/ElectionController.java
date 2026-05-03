package assistant.controller;

import assistant.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ElectionController {

    @Autowired
    private ElectionService service;

    @GetMapping("/ask")
    public List<String> ask(@RequestParam String question) {
        return service.getAnswer(question);
    }

    @GetMapping("/timeline")
    public List<String> timeline() {
        return service.getTimeline();
    }

    @GetMapping("/eligibility")
    public List<String> eligibility() {
        return service.getEligibility();
    }

    @GetMapping("/help")
    public String help() {
        return "Ask about voting, timeline or eligibility";
    }
}