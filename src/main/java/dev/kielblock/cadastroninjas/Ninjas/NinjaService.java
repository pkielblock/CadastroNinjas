package dev.kielblock.cadastroninjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjaPorID(long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deletarNinja(long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaModel editarNinja(long id, NinjaModel ninjaAtualizado) {
        if (!ninjaRepository.existsById(id)) {
            return null;
        } else {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
    }
}
