import com.itxzy.bean.Student;
import com.itxzy.mapper.IStudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class task1Test{

    @Autowired
    private IStudentMapper iStudentMapper;

    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /**
     * 增加
     */
    @Test
    public void insertStudent(){
        Long startTs = System.currentTimeMillis();//获取当前时间戳

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020,5,8);//获取指定时间点

        Student student = new Student();
        student.setCreate_at(startTs);
        student.setName("乔兆年");
        student.setQq("1589690721");
        student.setType("JAVA");
        student.setCity("郑州");
        student.setEnter_at(calendar.getTimeInMillis());
        student.setSchool("河南理工");
        student.setOnline_id(6569);
        student.setLink("http://www.jnshu.com/school/39787/daily?page=1&orderBy=3&sort=1");
        student.setDesire("加油");
        student.setBro("周自辉");
        student.setUpdate_at(startTs);
        student.setKnow_from("知乎");
        iStudentMapper.insertStudent(student);
        System.out.println("已经增加数据");
    }

    /**
     * 删除
     */
    @Test
    public void deleteStudent(){
        iStudentMapper.deleteStudent(3);
        System.out.println("已经删除数据");
    }

    /**
     * 修改
     */
    @Test
    public void updateStudent(){
        Long startTs = System.currentTimeMillis();//获取当前时间戳
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019,5,8);

        Student student = iStudentMapper.findStudentById(4);
        student.setCreate_at(startTs);
        student.setName("wang");
        student.setQq("123");
        student.setType("d");
        student.setCity("zhe");
        student.setEnter_at(calendar.getTimeInMillis());
        student.setSchool("df");
        student.setOnline_id(24);
        student.setLink("www.");
        student.setDesire("gdk");
        student.setBro("qas");
        student.setUpdate_at(startTs);
        student.setKnow_from("wang");
        iStudentMapper.updateStudent(student);
        System.out.println("数据已经修改");
    }

    /**
     * 通过名字模糊查找
     */
    @Test
    public void findStudentByName(){
        List<Student> students = iStudentMapper.findStudentByName("%乔%");
        for(Student student:students){
            System.out.println(students);
        }
    }

    /**
     * 通过id查找
     */
    @Test
    public void findStudentById(){
        Student student = iStudentMapper.findStudentById(1);
        System.out.println(student);
    }

}