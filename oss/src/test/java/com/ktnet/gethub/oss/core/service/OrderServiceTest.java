package com.ktnet.gethub.oss.core.service;

import com.ktnet.gethub.oss.core.domain.dao.Address;
import com.ktnet.gethub.oss.core.domain.dao.Member;
import com.ktnet.gethub.oss.core.domain.dao.Order;
import com.ktnet.gethub.oss.core.domain.dao.OrderStatus;
import com.ktnet.gethub.oss.core.domain.dao.item.Book;
import com.ktnet.gethub.oss.core.domain.dao.item.Item;
import com.ktnet.gethub.oss.core.domain.repository.OrderRepository;
import com.ktnet.gethub.oss.exception.NotEnoughStockException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired EntityManager em;
    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception {
        // given
        Member member = new Member("회원1");
        member.setAddress(new Address("판교", "판교로", "13493"));
        em.persist(member);

        Item book = new Book();
        book.setName("시골 JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        int orderCount = 2;

        // when
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        // then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, getOrder.getStatus(), "상품 주문시 상태는 ORDER");
        assertEquals(1, getOrder.getOrderItems().size(), "주문한 상품 종류 수가 정확해야 한다.");
        assertEquals(10000 * orderCount, getOrder.getTotalPrice(), "가문 가격은 가격 * 수량이다.");
        assertEquals(8, book.getStockQuantity(), "주문한 만큼 주문 수량이 줄어야 한다.");

    }

    @Test
    public void 주문취소() throws Exception {
        // given
        Member member = new Member("회원1");
        member.setAddress(new Address("판교", "판교로", "13493"));
        em.persist(member);

        Item book = new Book();
        book.setName("시골 JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        // when
        orderService.cancelOrder(orderId);

        // then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.CANCEL, getOrder.getStatus(), "주문 취소시 상태는 CANCEL 이다.");
        assertEquals(10, book.getStockQuantity(), "주문을 취소한 상품은 그 만큼 재고가 증가해야 한다.");
    }

    @Test
    public void 주문상품_재고수량초과() throws Exception {
        // given
        Member member = new Member("회원1");
        member.setAddress(new Address("판교", "판교로", "13493"));
        em.persist(member);

        Item book = new Book();
        book.setName("시골 JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        int orderCount = 11;

        // when
//        orderService.order(member.getId(), item.getId(), orderCount);

        // then
        Assertions.assertThrows(NotEnoughStockException.class, () -> {
            orderService.order(member.getId(), book.getId(), orderCount);
        });
    }

}