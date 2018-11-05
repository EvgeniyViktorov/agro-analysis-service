package ua.help.agro.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.Report;
import ua.help.agro.core.repository.ReportRepository;

@Service
public class ReportService {

    private ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void save(Report report) {
        reportRepository.save(report);
    }
}
