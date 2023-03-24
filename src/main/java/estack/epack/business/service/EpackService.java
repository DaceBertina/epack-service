package estack.epack.business.service;

import estack.epack.domain.Epack;

public interface EpackService {

    Epack createEpack(Epack epack);

    Epack findEpackById(Long epackId);
}
