package ua.help.agro.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ua.help.agro.core.domain.PlantType;
import ua.help.agro.core.domain.Report;
import ua.help.agro.core.service.ReportService;

@SpringBootApplication
public class AgroHelpCoreApplication {

	@Autowired
	private ReportService reportService;

	public static void main(String[] args) {
		SpringApplication.run(AgroHelpCoreApplication.class, args);
	}

	@Component
	public class AddSomeData implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			reportService.save(new Report(PlantType.BUCKWHEAT, 12, 15, 20, 25, 30, "#123456", 1, 1, 1, 1, false));
			reportService.save(new Report(PlantType.RICE, 13, 15, 20, 25, 30, "#11", 1, 1, 1, 1, false));
			reportService.save(new Report(PlantType.WHEAT, 14, 15, 20, 25, 30, "#1213456", 1, 1, 1, 1, true));
			reportService.save(new Report(PlantType.RICE, 15, 15, 20, 25, 30, "#12312456", 1, 1, 1, 1, false));
			reportService.save(new Report(PlantType.BUCKWHEAT, 16, 15, 20, 25, 30, "#123563456", 1, 1, 1, 1, false));
			reportService.save(new Report(PlantType.WHEAT, 17, 15, 20, 25, 30, "#10023456", 1, 1, 1, 1, false));
		}
	}
}