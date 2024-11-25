package br.com.lucasduarte.pedidos.processador.repository;

import br.com.lucasduarte.pedidos.processador.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
