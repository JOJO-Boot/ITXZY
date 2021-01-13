import com.dao.TbstudentMapper;
import com.pojo.Tbstudent;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ServerApplicationContext.xml")

public class MysqlTest {

    static Logger logger = Logger.getLogger(MysqlTest.class);

    @Autowired
    private TbstudentMapper tbstudentMapper;


    /**
     * 增加
     */
    @Test
    public void add() {
        Long startTs = System.currentTimeMillis();//获取当前时间戳

        for (int i =1;i < 100;i++) {
            Tbstudent tbstudent = new Tbstudent();
            Calendar calendar = Calendar.getInstance();
            calendar.set(2020, 7, 22);//获取指定时间点
            tbstudent.setCreateat(startTs);
            tbstudent.setName("曹沫");
            tbstudent.setQq("1589690721");
            tbstudent.setType("JAVA");
            tbstudent.setCity("落魄山");
            tbstudent.setEnterat(calendar.getTimeInMillis());
            tbstudent.setSchool("剑气长城");
            tbstudent.setOnlineid(11);
            tbstudent.setLink("www.baidu.com");
            tbstudent.setDesire("山主");
            tbstudent.setBro("左右");
            tbstudent.setUpdateat(calendar.getTimeInMillis());
            tbstudent.setKnowfrom("书院");
            tbstudentMapper.insert(tbstudent);
            logger.info("添加一条数据");
        }
        logger.info("添加完毕");
    }
}
