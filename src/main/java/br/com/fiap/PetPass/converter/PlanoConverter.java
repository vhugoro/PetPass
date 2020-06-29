package br.com.fiap.PetPass.converter;

import br.com.fiap.PetPass.dto.PlanoDTO;
import br.com.fiap.PetPass.entity.Plano;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanoConverter {

    public PlanoDTO toDTO(Plano inPlano) {
        if (inPlano == null) {
            return null;
        }

        return new PlanoDTO(inPlano);
    }

    public List<PlanoDTO> toListDTO(List<Plano> inPlanos) {
        List<PlanoDTO> planos = new ArrayList();

        if (!inPlanos.isEmpty()) {
            planos.addAll(inPlanos.stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList()));
        }


        return planos;
    }

    public Plano toEntity(PlanoDTO inPlano) {

        if (inPlano == null) {
            return null;
        }

        Plano plano = new Plano();

        plano.setId(inPlano.getId());
        plano.setNome(inPlano.getNome());

        return plano;
    }

    public List<Plano> toListEntity(List<PlanoDTO> inPlanos) {
        List<Plano> planos = new ArrayList();

        if (!inPlanos.isEmpty()) {
            planos.addAll(inPlanos.stream()
                    .map(this::toEntity)
                    .collect(Collectors.toList()));
        }

        return planos;
    }
}