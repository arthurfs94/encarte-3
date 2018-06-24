package com.br.encarte.app.service;

import com.br.encarte.app.entity.Encarte;
import com.br.encarte.app.entity.Market;
import com.br.encarte.app.repository.EncarteRepository;
import com.br.encarte.app.repository.MarketRepository;
import com.br.encarte.app.service.inter.MarketServiceAO;
import com.br.encarte.app.specification.EncarteSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arthur on 20/05/17.
 */
@Service
public class MarketService implements MarketServiceAO {

    private final MarketRepository marketRepository;
    
    @Autowired
    private EncarteRepository encarteRepository;
    
    @Autowired
    private ProductService productService;

    @Autowired
    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;

    }

    @Override
	public void save(Market market) {
        this.marketRepository.save(market);
    }


    @Override
	public void delete(Long id) {
        this.marketRepository.delete(id);
    }


    @Override
	public void update(Market market) {
        this.marketRepository.save(market);
    }


    @Override
	public List<Market> listAll() {
        return (List<Market>) this.marketRepository.findAll();
    }


    @Override
	public Market findById(Long id) {
        return this.marketRepository.findOne(id);
    }

	public Object montarListaEncarte(Long idMercado) {
		
		Specifications<Encarte> where = Specifications.where(EncarteSpecification.marketId(idMercado));
    	List<Encarte> encartes = encarteRepository.findAll(where);
		
		String  str = "";
		
		for (int i = 0; i < encartes.size(); i++) {

			if (i % 3 == 0) {
				str += "<div class='row'>";
			}
			str += "<div class='col-sm-4' onclick='window.location=\"" + idMercado + "/encarte/" + encartes.get(i).getId()  +  "\"')>";

			str += "<dl>";
			str += "</dd>";
			
			str += "<img class='card-img-top' src='" + encartes.get(i).getPicture()
					+ "' alt='Card image' style='width:60%'>";

			str += "<dl>";
			str += "</dd>";
			
			str += "<strong>Nome do Encarte: </strong>" + encartes.get(i).getName();
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Status: </strong>" + encartes.get(i).getStatus();
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Descrição do Encarte: </strong>"
					+ encartes.get(i).getDescription();
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Data de Validade: </strong> " + encartes.get(i).getData();
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Id do Encarte: </strong> " + encartes.get(i).getId();
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Categoria: </strong> " + encartes.get(i).getType();
			
			str += "<dl>";
			str += "</dd>";

			str += "<dl>";
			str += "</dl>";

			str += "</div>";

			if (i % 3 == 2) {
				str += "</div>";
			}

		}
		
		return str;
	}

	public Object montarListaProducts(Long idMarket) {
		return productService.montarListaMaketProduto(idMarket);
	}
}
