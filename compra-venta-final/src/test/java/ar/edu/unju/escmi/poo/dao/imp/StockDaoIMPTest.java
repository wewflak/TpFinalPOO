package ar.edu.unju.escmi.poo.dao.imp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Stock;

class StockDaoIMPTest {


    private StockDaoIMP StockService = new StockDaoIMP();
	
    List<Stock> getStock(){
    	return StockService.mostrarStocks();
    }
	@Test
	void testAgregarStock() {
		List<Stock> test = new ArrayList<>();
		getStock().forEach(stock-> {
            try {
            	StockService.agregarStock(stock);
            	test.add(stock);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        assertNotNull(test);
	}

	@Test
	boolean testBuscarStock() {
		return StockService.buscarStock(1L)== getStock().get(1);
	}
	@Test
	boolean testBuscarStockPorProducto() {
		return StockService.buscarStockPorProducto(1L)==getStock().get(1);
	}

}
