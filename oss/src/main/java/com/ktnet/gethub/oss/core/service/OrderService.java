package com.ktnet.gethub.oss.core.service;

import com.ktnet.gethub.oss.core.domain.dao.Delivery;
import com.ktnet.gethub.oss.core.domain.dao.Member;
import com.ktnet.gethub.oss.core.domain.dao.Order;
import com.ktnet.gethub.oss.core.domain.dao.OrderItem;
import com.ktnet.gethub.oss.core.domain.dao.item.Item;
import com.ktnet.gethub.oss.core.domain.repository.ItemRepository;
import com.ktnet.gethub.oss.core.domain.repository.MemberRepository;
import com.ktnet.gethub.oss.core.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        // 주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        // 주문 저장
        orderRepository.save(order);
        /*
            CascadeType.ALL 이 걸려있으면, 하나만 저장해도 OrderItem, Delivery 모두 저장이 된다.
         */

        return order.getId();
    }

    /**
     * 주문취소
     */
    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId); // 엔티티 조회
        order.cancel(); // 주문취소
    }


    // 검색
//    public List<Order> search(OrderSearch orderSearch) {
//        return orderRepository.findAll(orderSearch);
//    }

}
