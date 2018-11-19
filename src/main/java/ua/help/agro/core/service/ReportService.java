package ua.help.agro.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.Report;
import ua.help.agro.core.repository.ReportRepository;

import java.util.List;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void save(Report report) {
        reportRepository.save(report);
    }

    public List<Report> findAll() {
        return (List<Report>) reportRepository.findAll();
    }

    public List<Report> findNonApproved() {
        return reportRepository.findAllByIsAcceptedFalse();
    }
}
