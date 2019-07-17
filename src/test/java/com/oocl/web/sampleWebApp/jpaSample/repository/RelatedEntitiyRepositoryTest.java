package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.RelatedEntity;
import com.oocl.web.sampleWebApp.jpaSample.entity.SingleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RelatedEntitiyRepositoryTest {
    @Autowired
    private RelatedEntityRepository relatedEntityRepository;

    @Test
    public void should_save_SingleEntity_when_save_RelatedEntity(){
        SingleEntity singleEntity=new SingleEntity();
        RelatedEntity relatedEntity=new RelatedEntity();
        singleEntity.setName("a");
        relatedEntity.setName("b");
        relatedEntity.setSingleEntity(singleEntity);
        RelatedEntity result=relatedEntityRepository.save(relatedEntity);
        assertEquals("b",result.getName());
        assertEquals("a",result.getSingleEntity().getName());
    }

    @Test
    public void should_throw_exception_when_save_RelatedEntity_without_SingleEntity(){
        RelatedEntity relatedEntity=new RelatedEntity();
        relatedEntity.setName("b");
        relatedEntityRepository.save(relatedEntity);
        assertThrows(Exception.class,()->{
            relatedEntityRepository.findAll();
        });
    }
}
