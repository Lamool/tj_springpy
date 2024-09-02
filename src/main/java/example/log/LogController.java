package example.log;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Log4j2
public class LogController {
    @Autowired private LogService logService;

    @GetMapping("")
    public void log() {
        // 1.
        log.info("LogController info log");
        // 2.
        log.debug("LogController debug log");
        // 3.
        log.warn("LogController warn log");
        // 4.
        log.error("LogController error log");

        logService.log();
    }

}
