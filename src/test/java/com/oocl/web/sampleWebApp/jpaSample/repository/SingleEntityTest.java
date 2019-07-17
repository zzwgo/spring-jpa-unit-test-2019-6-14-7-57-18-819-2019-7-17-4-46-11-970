package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.Exception.MyException;
import com.oocl.web.sampleWebApp.jpaSample.entity.SingleEntity;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SingleEntityTest {

    @Autowired
    private SingleEntityRepository repository;

    @Test
    public void should_return_size_when_add_a_entity(){
        SingleEntity singleEntity=new SingleEntity();
        singleEntity.setName("zhangaa");


        repository.save(singleEntity);
        List<SingleEntity> singleEntities= (List<SingleEntity>) repository.findAll();

        assertEquals(1,singleEntities.size());
    }

    @Test
    public void should_throw_exception_when_add_name_biggner_than_64_size() throws Exception {
        SingleEntity singleEntity=new SingleEntity();
        singleEntity.setName("zhangzhangaaaaaazhangaaaaaaaaaaaazhangaaaaaazhangaaaaaazhangaaaaaazhangaaaaaazhangaaaaaazhangaaaaaa");

        MyException myException=assertThrows(MyException.class,()->{
            if(singleEntity.getName().length()>64){
                throw new MyException("length should less than 64 ");
            }
            repository.save(singleEntity);
        });

        assertEquals("length should less than 64 ",myException.getMessage());
    }

}
