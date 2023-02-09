package org.unibl.etf.ip.shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.models.entities.Log;
import org.unibl.etf.ip.shop.repositories.LogRepository;
import org.unibl.etf.ip.shop.services.ILogService;

@Service
@Transactional
public class LogService implements ILogService {

    private final LogRepository logRepository;

    public LogService(LogRepository repository) {
        this.logRepository = repository;
    }

    @Override
    public void log(Log log) {
        logRepository.save(log);
    }
}
