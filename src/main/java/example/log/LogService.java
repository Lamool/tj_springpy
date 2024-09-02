package example.log;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LogService {
    public void log(){
        // 1.
        log.info("LogController info log");
        // 2.
        log.debug("LogController debug log");
        // 3.
        log.warn("LogController warn log");
        // 4.
        log.error("LogController error log");

    }

}
