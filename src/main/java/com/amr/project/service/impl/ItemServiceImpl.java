package com.amr.project.service.impl;

import com.amr.project.dao.impl.ItemDaoImpl;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Mail;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.email.EmailSenderService;
import com.amr.project.util.TrackedEmailItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl extends ReadWriteServiceImpl<Item, Long> implements ItemService {

    private final ItemDaoImpl itemDao;

    private final TrackedEmailItem trackedEmailItem;

    private final EmailSenderService emailSenderService;

    @Autowired
    protected ItemServiceImpl(ItemDaoImpl itemDao, EmailSenderService emailSenderService, TrackedEmailItem trackedEmailItem) {
        super(itemDao);
        this.itemDao = itemDao;
        this.emailSenderService = emailSenderService;
        this.trackedEmailItem = trackedEmailItem;
    }

    @Override
    @Transactional
    public List<Item> getUnmoderatedItems() {
        return itemDao.getUnmoderatedItems();
    }

    @Override
    @Transactional
    public List<Item> getModeratedItems() {
        return itemDao.getModeratedItems();
    }

    @Override
    @Transactional
    public Item getItemName(String nameItem) {
        return itemDao.getItemName(nameItem);
    }

    @Override
    @Transactional
    public void update(Item item) {
        Mail mail = trackedEmailItem.trackedEmailItemUpdateDelete(item);
        if (mail.getMessage() != null)
            emailSenderService.sendSimpleEmail(mail);
        itemDao.update(item);
    }

    @Override
    @Transactional
    public void persist(Item item) {
        emailSenderService.sendSimpleEmail(trackedEmailItem.trackedEmailItemPersist(item));
        itemDao.persist(item);
    }
}
