package br.com.lucasduarte.pedidos.processador.service;

import br.com.lucasduarte.pedidos.processador.entity.ItemPedido;
import br.com.lucasduarte.pedidos.processador.entity.Pedido;
import br.com.lucasduarte.pedidos.processador.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);
    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    private final ItemPedidoService itemPedidoService;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService, ItemPedidoService itemPedidoService) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.itemPedidoService = itemPedidoService;
    }

    public void save(Pedido pedido) {

        // produtos foram salvos
        produtoService.save(pedido.getItens());

        // itensPedidos foram salvos
        List<ItemPedido> itemPedidos = itemPedidoService.save(pedido.getItens());

        // pedidos foram salvos
        pedidoRepository.save(pedido);

        itemPedidoService.updateItemPedido(itemPedidos, pedido);

        logger.info("Pedido salvo: {}", pedido.toString());
    }
}
