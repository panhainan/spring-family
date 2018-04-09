package site.sixteen.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import site.sixteen.config.RootConfig;
import site.sixteen.entity.User;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindById() {
        long id = 2;
        User user = userRepository.findOne(id);
        log.info("{}", user);
    }
    @Test
    public  void testFindByNameIgnoringCase(){
        log.info("{}",userRepository.findByNameIgnoringCase("tom"));
    }

    @Test
    public void testFindAllByEmailLike() {
        log.info("{}",userRepository.findAllByEmailLike("%@gmail.com"));
    }

    @Test
    public void testFindAllGmailUsers() {
        log.info("{}",userRepository.findAllGmailUsers());
    }
    @Test
    public void testUpdateUserGloryByTopicPraise(){
        log.info("result:{}",userRepository.updateUserGloryByTopicPraise());
    }
}
