package com.suprem.capulan.service;

import com.suprem.capulan.model.location.Terminal;
import com.suprem.capulan.model.location.TerminalDto;
import com.suprem.capulan.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalService {
    private final TerminalRepository terminalRepository;

    @Autowired
    public TerminalService(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    public Boolean save(Terminal terminal) {
        return terminalRepository.insert(terminal.getNome(), terminal.getRegion().name()) == 1;
    }

    public Optional<Terminal> findTerminal(Integer id) {
        return terminalRepository.findById(id);
    }

    public List<TerminalDto> findAll() {
        return terminalRepository.findAll()
                .stream()
                .map(TerminalDto::new)
                .toList();
    }
}
