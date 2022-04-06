package mapper;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import data.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Mybatis_Plus实现删除操作
 * Package(包名): mapper
 * Class(测试类名): StudentMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/6
 * Time(创建时间)： 14:00
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class StudentMapperTest
{

    /**
     * 根据ID删除
     * deleteById
     *
     * @throws IOException
     */
    @Test
    public void delete1() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int i = studentMapper.deleteById(202012341069L);
        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * columnMap 条件，删除记录
     * deleteByMap
     *
     * @throws IOException
     */
    @Test
    public void delete2() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("student_no", 202012341068L);
        map.put("sex", "女");
        int i = studentMapper.deleteByMap(map);
        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * columnMap 条件，删除记录
     * deleteByMap
     *
     * @throws IOException
     */
    @Test
    public void delete3() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("student_no", 202012341068L);
        map.put("sex", "男");
        int i = studentMapper.deleteByMap(map);
        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * columnMap 条件，删除记录
     * deleteByMap
     *
     * @throws IOException
     */
    @Test
    public void delete4() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        //QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        //queryWrapper.eq("student_no", 202012341067L);
        ////queryWrapper.eq("address","美国");
        //queryWrapper.eq("address", "中国");

        Student student = new Student();
        student.setStudent_no(202012341066L);
        student.setAddress("美国");
        student.setAddress("中国");
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>(student);

        int i = studentMapper.delete(queryWrapper);
        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 根据ID或实体 批量删除
     * deleteBatchIds
     *
     * @throws IOException
     */
    @Test
    public void delete5() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);


        List<Long> list = new ArrayList<>();
        list.add(202012341065L);
        list.add(202012341064L);
        list.add(202012341063L);

        int i = studentMapper.deleteBatchIds(list);
        System.out.println(i);

//        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 根据ID或实体 批量删除
     * deleteBatchIds
     *
     * @throws IOException
     */
    @Test
    public void delete6() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);


//        List<Long> list = new ArrayList<>();
//        list.add(202012341065L);
//        list.add(202012341064L);
//        list.add(202012341063L);

        int i = studentMapper.deleteBatchIds(Arrays.asList(202012341065L, 202012341064L, 202012341063L));
        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();

    }
}