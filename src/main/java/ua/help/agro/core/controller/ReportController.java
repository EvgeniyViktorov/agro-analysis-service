package ua.help.agro.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.help.agro.core.domain.Report;
import ua.help.agro.core.service.ReportService;

import java.util.List;

@RestController
public class ReportController {

    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(value = "reports/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Report>> getAllReports() {
        return new ResponseEntity<>(reportService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "reports/pending", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Report>> getPending() {
        return new ResponseEntity<>(reportService.findNonApproved(), HttpStatus.OK);
    }

    @PostMapping(value = "report/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Report> add(@RequestBody Report report) {
        reportService.save(report);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}