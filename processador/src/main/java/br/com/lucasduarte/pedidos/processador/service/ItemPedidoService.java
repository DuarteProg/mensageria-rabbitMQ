package br.com.lucasduarte.pedidos.processador.service;

import br.com.lucasduarte.pedidos.processador.entity.ItemPedido;
import br.com.lucasduarte.pedidos.processador.entity.Pedido;
import br.com.lucasduarte.pedidos.processador.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedido> save(List<ItemPedido> itens) {
        return itemPedidoRepository.saveAll(itens);
    }

    public void save(ItemPedido item) {
        itemPedidoRepository.save(item);
    }

    public void updateItemPedido(List<ItemPedido> itemPedidos, Pedido pedido) {
        itemPedidos.forEach(item -> {
            item.setPedido(pedido);
            this.save(item);
        });
    }
}
