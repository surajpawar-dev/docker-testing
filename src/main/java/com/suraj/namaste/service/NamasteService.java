package com.suraj.namaste.service;

import com.suraj.namaste.entity.NamasteEntity;
import com.suraj.namaste.repository.NamasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NamasteService {

    private final NamasteRepository namasteRepository;

    @Autowired
    public NamasteService(NamasteRepository namasteRepository) {
        this.namasteRepository = namasteRepository;
    }

    public List<NamasteEntity> getAllNamastes() {
        return namasteRepository.findAll();
    }

    public Optional<NamasteEntity> getNamasteById(Long id) {
        return namasteRepository.findById(id);
    }

    public NamasteEntity createNamaste(NamasteEntity namasteEntity) {
        return namasteRepository.save(namasteEntity);
    }

    @Transactional
    public Optional<NamasteEntity> updateNamaste(Long id, NamasteEntity namasteEntity) {
        return namasteRepository.findById(id)
                .map(existingEntity -> {
                    existingEntity.setMessage(namasteEntity.getMessage());
                    existingEntity.setAuthor(namasteEntity.getAuthor());
                    return namasteRepository.save(existingEntity);
                });
    }

    public boolean deleteNamaste(Long id) {
        if (namasteRepository.existsById(id)) {
            namasteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}