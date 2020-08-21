package com.ktnet.gethub.oss.core.service;

import com.ktnet.gethub.oss.core.domain.dao.item.Item;
import com.ktnet.gethub.oss.core.domain.repository.ItemRepository;
import com.ktnet.gethub.oss.core.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Repository 클래스로 위임만 하는 역할이 서비스라고 생각하면 된다!
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public Item findItem(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

}