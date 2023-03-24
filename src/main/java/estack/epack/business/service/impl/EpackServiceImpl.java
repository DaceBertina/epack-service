package estack.epack.business.service.impl;

import estack.epack.business.mapper.EpackMapStruct;

import estack.epack.business.repository.EpackRepository;
import estack.epack.business.repository.model.EpackEntity;
import estack.epack.business.service.EpackService;
import estack.epack.domain.Epack;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class EpackServiceImpl implements EpackService {

    private final EpackRepository epackRepository;

    private final EpackMapStruct epackMapper;

    @Override
    public Epack createEpack(Epack epack) {

        EpackEntity epackEntity = epackRepository.save(epackMapper.epackDtoToEpackEntity(epack));
        log.info("New course added: {}", epack);

        return epackMapper.epackEntityToEpackDto(epackEntity);
    }

    @Override
    public Epack findEpackById(Long epackId) {
        Optional<EpackEntity> epackEntity = epackRepository.findById(epackId);
        if (epackEntity.isPresent()) {
            return epackMapper.epackEntityToEpackDto(epackEntity.get());
        } else {
            log.error("Exception {} is thrown. Epack with ID " + epackId + " does not exist.", HttpStatus.CONFLICT);
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Epack with ID " + epackId + " does not exist.");
        }
    }

    }
